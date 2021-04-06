package com.codart.building_calculator.calculations

import kotlin.math.floor

object Round {
    fun round(v: Double): Any{
        val res=floor(v*1000.0) /1000.0
        return if(isWhole(res))
            res.toInt()
        else
            res

    }
    private fun isWhole(value: Double):Boolean {
        return value - value.toInt() == 0.0
    }
}