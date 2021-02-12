package edu.towson.cosc435.king.tipcalculator


//Used the following link as a reference to further understand the use of an enum class
//https://kotlinlang.org/docs/reference/enum-classes.html
enum class Tip(var tip_val: Double){
    Ten(1.10), Twenty(1.20), Thirty(1.30)
}
fun calcTip(input: Double, calcTip: Tip): Double {
    var res = 0.0
    if (calcTip.tip_val == 1.10){
        res = input * calcTip.tip_val
    }
    if (calcTip.tip_val == 1.20){
        res = input * calcTip.tip_val
    }
    if (calcTip.tip_val == 1.30){
        res = input * calcTip.tip_val
    }
    return res
}