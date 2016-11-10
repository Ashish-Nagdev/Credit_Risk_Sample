package com.sherpa.ml.algorithm

import org.apache.spark.ml.classification.RandomForestClassificationModel
import org.apache.spark.ml.evaluation.BinaryClassificationEvaluator
import org.apache.spark.sql.DataFrame

/**
  * Created by Ashish Nagdev on 11/10/16.
  */
object BinaryClassification {

  val evaluator = new BinaryClassificationEvaluator().setLabelCol("label")
  def generatePredictions(testData:DataFrame ,model: RandomForestClassificationModel ):DataFrame = {

    val predictions = model.transform(testData)
    model.toDebugString
    return predictions

  }

  def calcAccuracy(predictions:DataFrame):Double={
    evaluator.evaluate(predictions)
  }

}
