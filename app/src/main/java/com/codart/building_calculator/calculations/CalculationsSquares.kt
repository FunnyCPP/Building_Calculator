package com.codart.building_calculator.calculations

import java.lang.Math.pow
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.sqrt

object CalculationsSquares {
    fun calculateSofCircle(d: Double): Double=CalculationsMetals.round(PI*d*d/4)

    fun calculatePofCircle(d: Double): Double=CalculationsMetals.round(PI*d)

    fun calculateSofSquare(a: Double): Double=CalculationsMetals.round(a*a)

    fun calculatePofSquare(a: Double): Double=CalculationsMetals.round(a*4)

    fun calculateSofRectangle(a: Double,b: Double): Double=CalculationsMetals.round(a*b)

    fun calculatePofRectangle(a: Double, b: Double): Double=CalculationsMetals.round((a+b)*2)

    fun calculateSofTriangle(a: Double,b: Double, c: Double): Double= CalculationsMetals.round(sqrt(((a+b+c)/2-a)*((a+b+c)/2-b)*((a+b+c)/2-c)))

    fun calculatePofTriangle(a: Double, b: Double,c: Double): Double=CalculationsMetals.round(a+b+c)

    fun calculateSofTrapezoid1(a: Double,b: Double, c: Double): Double= CalculationsMetals.round(a*(b+c)/2)

    fun calculatePofTrapezoid1(a: Double, b: Double,c: Double): Double= CalculationsMetals.round(sqrt(abs((b-c)/2)*abs((b-c)/2)+a*a)*2+b+c)

    fun calculateSofTrapezoid2(a: Double,b: Double, c: Double): Double= CalculationsMetals.round(b*(a+c)/2)

    fun calculatePofTrapezoid2(a: Double, b: Double,c: Double): Double=CalculationsMetals.round( sqrt(abs((a-c)/2)*abs((a-c)/2)+b*b)+b+c+a)

    fun calculateSofRectangle2(a: Double,b: Double, c: Double, d: Double): Double= CalculationsMetals.round(c*d-((c-a)*(d-b)/2))

    fun calculatePofRectangle2(a: Double, b: Double,c: Double, d: Double): Double= CalculationsMetals.round(a+b+c+d+sqrt(pow((c-a),2.0)+pow((d-b),2.0)))

    fun calculateSofRectangle3(a: Double,b: Double, c: Double): Double=CalculationsMetals.round( b*c+PI*a*c/4)

    fun calculatePofRectangle3(a: Double, b: Double,c: Double): Double= CalculationsMetals.round(b+c+b+(PI*(a+c/2))/2)

    fun calculateSofCircle2(a: Double,b: Double): Double= CalculationsMetals.round(PI*a*b/4)

    fun calculatePofCircle2(a: Double, b: Double): Double= CalculationsMetals.round(PI*(a+b/2/2))

    fun calculateSofRectangle4(a: Double,b: Double, c: Double, d: Double): Double=CalculationsMetals.round( c*d+ calculateSofTriangle(a,b,d))

    fun calculatePofRectangle4(a: Double, b: Double,c: Double, d: Double): Double=CalculationsMetals.round(c+d+c+a+b)

    fun calculateSofRectangle5(a: Double,b: Double, c: Double, d: Double): Double= CalculationsMetals.round(d*c+ calculateSofTrapezoid1(b-d,a,c))

    fun calculatePofRectangle5(a: Double, b: Double,c: Double, d: Double): Double=CalculationsMetals.round( c+d+d+ calculatePofTrapezoid1(b-d,a,c)-c)

    fun calculateSofCorner(a: Double,b: Double, c: Double, d: Double): Double=CalculationsMetals.round( c*d-(c-a)*(d-b))

    fun calculatePofCorner(a: Double, b: Double,c: Double, d: Double): Double=CalculationsMetals.round((d+c)*2)

    fun calculateSofRectangle6(a: Double,b: Double, c: Double, d: Double): Double=CalculationsMetals.round( c*d+a*b)

    fun calculatePofRectangle6(a: Double, b: Double,c: Double, d: Double): Double= CalculationsMetals.round(d+c+c+d+b+b)

    fun calculateSofChannel(a: Double,b: Double, c: Double, d: Double, e:Double): Double = CalculationsMetals.round((d-a)/2*(e+c)+(d-a)/2*(c+e))

    fun calculatePofChannel(a: Double, b: Double,c: Double, d: Double, e: Double): Double= CalculationsMetals.round(d+d+b+c+b+c)
}