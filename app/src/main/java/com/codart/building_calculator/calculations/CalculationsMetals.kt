package com.codart.building_calculator.calculations

import kotlin.math.PI
import kotlin.math.floor

object CalculationsMetals {
    val metalsArray = arrayOf("Сталь","Чугун","Алюминий","Бронза","Латунь","Магний",
            "Медь","Никель","Олово","Свинец","Титан","Цинк","Дуралюминий","Хром","Нержавеющая сталь")
    val metalsDensities = arrayListOf<Int>(7800,7000,2700,8100,8500,1700,8900,8900,7300,11340,4550,7100,2800,7190,7950)

    fun calculateSofPipe(a: Double,b: Double,s: Double): Double=(2*a*s)+((b-2*s)*s*2)

    fun calculateSofPipe(a: Double,b: Double): Double = (PI*(a/2.0)*(a/2.0))-(PI*((a/2.0)-b)*((a/2.0)-b))

    fun calculateSofCorner(a: Double,b: Double, c: Double): Double = (a*c)+(b-c)*c

    fun calculateSofChannel(a: Double,b: Double, c: Double): Double = 2*(a*c)+(b-2*c)*c

    fun calculateSofBeam(a: Double,b: Double, c: Double, d: Double): Double = (a*c)+(b-c)*d*2

    fun calculateSofRectangle(a: Double, b: Double): Double = a*b

    fun calculateSofCircle(a: Double): Double = a*a*PI/4

    fun calculateVofPipe(a: Double,b: Double,s: Double,l: Double): Double = calculateSofPipe(a,b,s)*l

    fun calculateVofPipe(a: Double,b: Double,l: Double): Double = calculateSofPipe(a,b)*l

    fun calculateVofCorner(a: Double,b: Double, c: Double,l: Double): Double = calculateSofCorner(a,b,c)*l

    fun calculateVofChannel(a: Double,b: Double, c: Double,l: Double): Double = calculateSofChannel(a,b,c) *l

    fun calculateVofBeam(a: Double,b: Double, c: Double, d: Double,l: Double): Double = calculateSofBeam(a,b,c,d)*l

    fun calculateV(s: Double, l: Double): Double = s*l

    fun calculateM(position: Int, s: Double, l: Double): Double = s*l* metalsDensities[position]

    fun calculateL(m: Double, position: Int, s:Double): Double = m/metalsDensities[position]/s

    fun calculateM(l: Double, ro: Double): Double = l*ro

    fun calculateL(m: Double, ro: Double): Double = m/ro

    fun calculatePrice( p: Double, m:  Double): Double = p*m

    fun round(value: Double): Double = floor(value*10000.0) /10000.0
}