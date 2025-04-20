package com.arekalov.compmatlab3.data.function

import kotlin.math.pow

// Конкретные реализации функций
class Function1 : Function(
    name = "∫(x³ - 3x² + 7x - 10)dx",
    lowerBound = 2.0,
    upperBound = 4.0
) {
    override fun calculate(x: Double): Double = 
        x.pow(3) - 3 * x.pow(2) + 7 * x - 10

    override fun exactIntegral(): Double {
        fun antiderivative(x: Double): Double =
            x.pow(4) / 4 - x.pow(3) + 7 * x.pow(2) / 2 - 10 * x
        
        return antiderivative(upperBound) - antiderivative(lowerBound)
    }
}

class Function2 : Function(
    name = "∫(2x³ - 9x² - 7x + 11)dx",
    lowerBound = 1.0,
    upperBound = 3.0
) {
    override fun calculate(x: Double): Double = 
        2 * x.pow(3) - 9 * x.pow(2) - 7 * x + 11

    override fun exactIntegral(): Double {
        fun antiderivative(x: Double): Double =
            x.pow(4) / 2 - 3 * x.pow(3) - 7 * x.pow(2) / 2 + 11 * x
        
        return antiderivative(upperBound) - antiderivative(lowerBound)
    }
}

class Function3 : Function(
    name = "∫(x³ + 2x² - 3x - 12)dx",
    lowerBound = 1.0,
    upperBound = 2.0
) {
    override fun calculate(x: Double): Double = 
        x.pow(3) + 2 * x.pow(2) - 3 * x - 12

    override fun exactIntegral(): Double {
        fun antiderivative(x: Double): Double =
            x.pow(4) / 4 + 2 * x.pow(3) / 3 - 3 * x.pow(2) / 2 - 12 * x
        
        return antiderivative(upperBound) - antiderivative(lowerBound)
    }
}

class Function4 : Function(
    name = "∫(-2x³ - 5x² + 7x - 13)dx",
    lowerBound = 1.0,
    upperBound = 3.0
) {
    override fun calculate(x: Double): Double = 
        -2 * x.pow(3) - 5 * x.pow(2) + 7 * x - 13

    override fun exactIntegral(): Double {
        fun antiderivative(x: Double): Double =
            -x.pow(4) / 2 - 5 * x.pow(3) / 3 + 7 * x.pow(2) / 2 - 13 * x
        
        return antiderivative(upperBound) - antiderivative(lowerBound)
    }
}

// Список доступных функций
object Functions {
    val availableFunctions = listOf(
        Function1(),
        Function2(),
        Function3(),
        Function4()
    )
}
