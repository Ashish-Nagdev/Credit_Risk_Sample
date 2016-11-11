package com.sherpa.ml.algorithm

import org.apache.spark.ml.classification.{RandomForestClassificationModel, RandomForestClassifier}
import org.apache.spark.ml.evaluation.BinaryClassificationEvaluator
import org.apache.spark.sql.DataFrame

/**
  * Created by Ashish Nagdev on 11/10/16.
  */
object RandomForestClassification {

  def generatelassifierModel(maxDepth: Int, numTrees: Int, seed: Int): RandomForestClassifier = {
    new RandomForestClassifier().setImpurity("gini").setMaxDepth(maxDepth).setNumTrees(numTrees).setFeatureSubsetStrategy("auto").setSeed(seed)

  }

  def trainClassifierModel(classifier: RandomForestClassifier, trainingData: DataFrame): RandomForestClassificationModel = {
    classifier.fit(trainingData)
  }

}
