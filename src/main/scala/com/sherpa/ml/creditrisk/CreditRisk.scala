package com.sherpa.ml.creditrisk

import org.apache.spark.sql._
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.tuning.{ParamGridBuilder, CrossValidator}
import org.apache.spark.ml.{Pipeline, PipelineStage}

import com.sherpa.ml.algorithm.RegressionMetricsGenerator._
import com.sherpa.ml.algorithm.BinaryClassification._
import com.sherpa.ml.algorithm.RandomForestClassification._
import com.sherpa.ml.creditrisk.CreditRisk._

/**
  * Created by Ashish Nagdev on 11/10/16.
  */
class CreditRisk(creditDF: DataFrame) {

  val assembler = new VectorAssembler().setInputCols(featureCols).setOutputCol("features")
  val df2 = assembler.transform(creditDF)
  df2.show

  val labelIndexer = new StringIndexer().setInputCol("creditability").setOutputCol("label")
  val df3 = labelIndexer.fit(df2).transform(df2)
  df3.show

  val Array(trainingData, testData) = df3.randomSplit(Array(0.7, 0.3), splitSeed)

  val classifier = generatelassifierModel(maximumDepth, numTrees, splitSeed)
  val model = trainClassifierModel(classifier, trainingData)
  val predictions = generatePredictions(testData, model)
  val accuracy = calcAccuracy(predictions)
  println("Accuracy before pipeline fitting: " + accuracy)

  val rm = regressionMetrics(predictions)
  println("MSE: " + rm.meanSquaredError)
  println("MAE: " + rm.meanAbsoluteError)
  println("RMSE Squared: " + rm.rootMeanSquaredError)
  println("R Squared: " + rm.r2)
  println("Explained Variance: " + rm.explainedVariance + "\n")

  val paramGrid = new ParamGridBuilder()
    .addGrid(classifier.maxBins, Array(25, 31))
    .addGrid(classifier.maxDepth, Array(5, 10))
    .addGrid(classifier.numTrees, Array(20, 60))
    .addGrid(classifier.impurity, Array("entropy", "gini"))
    .build()

  val steps: Array[PipelineStage] = Array(classifier)
  val pipeline = new Pipeline().setStages(steps)

  val cv = new CrossValidator()
    .setEstimator(pipeline)
    .setEvaluator(evaluator)
    .setEstimatorParamMaps(paramGrid)
    .setNumFolds(10)

  val pipelineFittedModel = cv.fit(trainingData)

  val predictions2 = pipelineFittedModel.transform(testData)
  val accuracy2 = evaluator.evaluate(predictions2)
  println("Accuracy after pipeline fitting: " + accuracy2)

  println(pipelineFittedModel.bestModel.asInstanceOf[org.apache.spark.ml.PipelineModel].stages(0))

  pipelineFittedModel
    .bestModel.asInstanceOf[org.apache.spark.ml.PipelineModel]
    .stages(0)
    .extractParamMap

  val rm2 = regressionMetrics(predictions2)

  println("MSE: " + rm2.meanSquaredError)
  println("MAE: " + rm2.meanAbsoluteError)
  println("RMSE Squared: " + rm2.rootMeanSquaredError)
  println("R Squared: " + rm2.r2)
  println("Explained Variance: " + rm2.explainedVariance + "\n")

}

object CreditRisk {

  val featureCols = Array("balance", "duration", "history", "purpose", "amount",
    "savings", "employment", "instPercent", "sexMarried", "guarantors",
    "residenceDuration", "assets", "age", "concCredit", "apartment",
    "credits", "occupation", "dependents", "hasPhone", "foreign")

  val splitSeed = 5043
  val maximumDepth = 3
  val numTrees = 20

}
