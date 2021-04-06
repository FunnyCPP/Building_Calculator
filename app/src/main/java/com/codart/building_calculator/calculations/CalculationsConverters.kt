package com.codart.building_calculator.calculations

object CalculationsConverters {
    // Цельсии в Фаренгейты
    fun CtoF(a: Double): Any = Round.round(a*1.8+32)

    fun FtoC(a: Double): Any = Round.round((a-32)/1.8)

    // Сантиметры в дюймы
    fun SmtoD(a: Double): Any = Round.round(a*0.3937)

    fun DtoSm(a: Double): Any = Round.round(a/0.3937)

    // Метры в Футы
    fun MtoF(a: Double): Any = Round.round(a*3.2808)

    fun FtoM(a: Double): Any = Round.round(a/3.2808)

    // Метры в Ярды
    fun MtoYards(a: Double): Any = Round.round(a*1.0936)

    fun YardstoM(a: Double): Any = Round.round(a/1.0936)

    // Ки)лограммы в Фунты
    fun KgtoFunts(a: Double): Any = Round.round(a/0.4535923745)

    fun FuntstoKg(a: Double): Any = Round.round(a*0.4535923745)

    // Грамы в Фунты
    fun GtoFunts(a: Double): Any = Round.round(a*0.0022)

    fun FuntstoG(a: Double): Any = Round.round(a/0.0022)

    // Грамы в Унции
    fun GtoOunces(a: Double): Any = Round.round(a*0.035274)

    fun OuncestoG(a: Double): Any = Round.round(a/0.035274)

    // Джоули  в Килокалории
    fun JtoKcal(a: Double): Any = Round.round(a*0.2388458966/1000)

    fun KcaltoJ(a: Double): Any = Round.round(a/0.2388458966*1000)

    // Джоули в Киловаты за час
    fun JtoKvatt_H(a: Double): Any = Round.round(a/1000/3600)

    fun KvatttoJ(a: Double): Any = Round.round(a*1000*3600)

    //) Литры в пинты
    fun LtoPints(a: Double): Any = Round.round(a/0.47)

    fun PintstoL(a: Double): Any = Round.round(a*0.47)

    // Литр)ы в галоны
    fun LtoGallons(a: Double): Any = Round.round(a/3.785411784)

    fun GallonstoL(a: Double): Any = Round.round(a*3.785411784)//
    // Мега паскали кГс на см2
    fun MpatoKg(a: Double): Any = Round.round(a*10.197162)

    fun KgtoMpa(a: Double): Any = Round.round(a/10.197162)

    //) Мега паскали в фунты на дюйм2
    fun MpatoFunts(a: Double): Any = Round.round(a*145.037735)

    fun FuntstoMpa(a: Double): Any = Round.round(a/145.037735)
}