package com.sherpa.ml.creditrisk

/**
  * Created by Ashish Nagdev on 11/10/16.
  */

//Creating Credit class for data:
//
//1,1,18,4,2,1049,1,2,4,2,1,4,2,21,3,1,1,3,1,1,1

/*                 creditability - 1,
                   balance - 1,
                   duration - 18,
                   history - 4,
                   purpose - 2,
                   amount - 1049,
                   savings - 1,
                   employment - 2,
                   instPercent - 4,
                   sexMarried - 2,
                   guarantors - 1,
                   residenceDuration - 4,
                   assets - 2,
                   age - 21,
                   concCredit - 3,
                   apartment - 1,
                   credits - 1,
                   occupation - 3,
                   dependents - 1,
                   hasPhone - 1,
                   foreign - 1
*/

case class Credit(
                   creditability: Double,
                   balance: Double,
                   duration: Double,
                   history: Double,
                   purpose: Double,
                   amount: Double,
                   savings: Double,
                   employment: Double,
                   instPercent: Double,
                   sexMarried: Double,
                   guarantors: Double,
                   residenceDuration: Double,
                   assets: Double,
                   age: Double,
                   concCredit: Double,
                   apartment: Double,
                   credits: Double,
                   occupation: Double,
                   dependents: Double,
                   hasPhone: Double,
                   foreign: Double
                 )
