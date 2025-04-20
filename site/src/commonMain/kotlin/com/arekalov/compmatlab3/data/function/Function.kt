package com.arekalov.compmatlab3.data.function

import com.arekalov.compmatlab3.data.integration.IntegrationMethod
import com.arekalov.compmatlab3.data.model.IntegrationResult
import com.arekalov.compmatlab3.data.model.IterationResult
import kotlin.math.abs

// Sealed класс для представления различных функций
sealed class Function(
    val name: String,
    val lowerBound: Double,
    val upperBound: Double
) {
    // Вычисление значения функции в точке
    abstract fun calculate(x: Double): Double

    // Вычисление точного значения интеграла (если известно)
    abstract fun exactIntegral(a: Double = lowerBound, b: Double = upperBound): Double

    // Метод для вычисления интеграла методом левых прямоугольников
    private fun leftRectangle(n: Int, a: Double, b: Double): Double {
        val h = (b - a) / n
        var sum = 0.0
        for (i in 0 until n) {
            val x = a + i * h
            sum += calculate(x)
        }
        return h * sum
    }

    // Метод для вычисления интеграла методом правых прямоугольников
    private fun rightRectangle(n: Int, a: Double, b: Double): Double {
        val h = (b - a) / n
        var sum = 0.0
        for (i in 1..n) {
            val x = a + i * h
            sum += calculate(x)
        }
        return h * sum
    }

    // Метод для вычисления интеграла методом средних прямоугольников
    private fun middleRectangle(n: Int, a: Double, b: Double): Double {
        val h = (b - a) / n
        var sum = 0.0
        for (i in 0 until n) {
            val x = a + (i + 0.5) * h
            sum += calculate(x)
        }
        return h * sum
    }

    // Метод для вычисления интеграла методом трапеций
    private fun trapezoid(n: Int, a: Double, b: Double): Double {
        val h = (b - a) / n
        var sum = (calculate(a) + calculate(b)) / 2
        for (i in 1 until n) {
            val x = a + i * h
            sum += calculate(x)
        }
        return h * sum
    }

    // Метод для вычисления интеграла методом Симпсона
    private fun simpson(n: Int, a: Double, b: Double): Double {
        val h = (b - a) / n
        var sum = calculate(a) + calculate(b)
        var evenSum = 0.0
        var oddSum = 0.0

        for (i in 1 until n) {
            val x = a + i * h
            if (i % 2 == 0) {
                evenSum += calculate(x)
            } else {
                oddSum += calculate(x)
            }
        }

        return (h / 3) * (sum + 2 * evenSum + 4 * oddSum)
    }

    // Метод для вычисления интеграла с заданной точностью по правилу Рунге
    fun calculateWithPrecision(
        method: IntegrationMethod,
        epsilon: Double,
        a: Double = lowerBound,
        b: Double = upperBound,
        initialN: Int = 4
    ): IntegrationResult {
        var n = initialN
        var prevResult = 0.0
        var currentResult: Double
        val iterationResults = mutableListOf<IterationResult>()
        val exactValue = exactIntegral(a, b)

        do {
            prevResult = when (method) {
                IntegrationMethod.LEFT_RECTANGLE -> leftRectangle(n, a, b)
                IntegrationMethod.RIGHT_RECTANGLE -> rightRectangle(n, a, b)
                IntegrationMethod.MIDDLE_RECTANGLE -> middleRectangle(n, a, b)
                IntegrationMethod.TRAPEZOID -> trapezoid(n, a, b)
                IntegrationMethod.SIMPSON -> simpson(n, a, b)
            }

            n *= 2

            currentResult = when (method) {
                IntegrationMethod.LEFT_RECTANGLE -> leftRectangle(n, a, b)
                IntegrationMethod.RIGHT_RECTANGLE -> rightRectangle(n, a, b)
                IntegrationMethod.MIDDLE_RECTANGLE -> middleRectangle(n, a, b)
                IntegrationMethod.TRAPEZOID -> trapezoid(n, a, b)
                IntegrationMethod.SIMPSON -> simpson(n, a, b)
            }

            // Сохраняем результат итерации
            iterationResults.add(
                IterationResult(
                    n = n,
                    value = currentResult,
                    error = abs(currentResult - exactValue)
                )
            )

        } while (abs(currentResult - prevResult) > epsilon && iterationResults.size < 20)

        return IntegrationResult(
            finalValue = currentResult,
            exactValue = exactValue,
            iterations = iterationResults,
            totalIterations = iterationResults.size,
            finalError = abs(currentResult - exactValue),
            method = method.name
        )
    }
}
