package com.sherpa.ml.algorithm

import org.apache.spark.mllib.evaluation.RegressionMetrics
import org.apache.spark.sql.DataFrame

/**
  * Created by Ashish Nagdev on 11/10/16.
  */
object RegressionMetricsGenerator {

  def regressionMetrics(predictions: DataFrame) = {
    val rm = new RegressionMetrics(
      predictions.select("prediction", "label").rdd.map(x =>
        (x(0).asInstanceOf[Double], x(1).asInstanceOf[Double]))
    )
    rm
  }

}
