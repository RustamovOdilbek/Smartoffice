package com.burgutsoft.smartoffice.utils

import java.text.SimpleDateFormat

fun changeDateFormat(strDate:String):String {
    return SimpleDateFormat("dd MMM yyyy").format(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate))
}

fun changeTimeFormat(strDate:String):String {
    return SimpleDateFormat("HH:mm").format(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate))
}

fun temp(temp: String): String{
    var res = ""
    if(temp != "0" && temp.substring(0, 1) != "-"){
        res = "+${temp}"
    }else{
        res = temp
    }
    return res
}

fun tempBool(temp: String): Boolean{
    if(temp != "0" && temp.substring(0, 1) != "-"){
       return true
    }
    return false
}