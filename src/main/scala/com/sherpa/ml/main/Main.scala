package com.sherpa.ml.main

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import com.sherpa.ml.creditrisk.CreditParser._
import com.sherpa.ml.creditrisk._

/**
  * Created by Ashish Nagdev on 11/10/16.
  */
object Main {
  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("CreditAnalysis").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext._
    import sqlContext.implicits._

    val creditDF = parseRDD(sc.textFile("credit.csv")).map(parseCredit).toDF().cache()
    creditDF.registerTempTable("credit")
    creditDF.printSchema

    creditDF.show
    sqlContext.sql("SELECT creditability, avg(balance) as avgbalance, avg(amount) as avgamt, avg(duration) as avgdur  FROM credit GROUP BY creditability ").show

    creditDF.describe("balance").show
    creditDF.groupBy("creditability").avg("balance").show
    new CreditRisk(creditDF)
  }

}
