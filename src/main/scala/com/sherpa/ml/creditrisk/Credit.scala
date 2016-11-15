package com.sherpa.ml.creditrisk

/**
  * Created by Ashish Nagdev on 11/10/16.
  */

//Creating Credit class for data:
//
//1,1,18,4,2,1049,1,2,4,2,1,4,2,21,3,1,1,3,1,1,1

case class Credit(
                   creditability: Double,
                   balance: Double, duration: Double, history: Double, purpose: Double, amount: Double,
                   savings: Double, employment: Double, instPercent: Double, sexMarried: Double, guarantors: Double,
                   residenceDuration: Double, assets: Double, age: Double, concCredit: Double, apartment: Double,
                   credits: Double, occupation: Double, dependents: Double, hasPhone: Double, foreign: Double
                 )
