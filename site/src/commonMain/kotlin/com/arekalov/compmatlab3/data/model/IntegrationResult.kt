package com.arekalov.compmatlab3.data.model

// Результат одной итерации
data class IterationResult(
    val n: Int, // количество разбиений
    val value: Double, // значение интеграла
    val error: Double, // погрешность на данной итерации
    val convergenceInfo: String = "" // информация о сходимости
)

// Общий результат интегрирования
data class IntegrationResult(
    val finalValue: Double, // окончательное значение интеграла
    val exactValue: Double, // точное значение интеграла
    val iterations: List<IterationResult>, // результаты по итерациям
    val totalIterations: Int, // общее количество итераций
    val finalError: Double, // окончательная погрешность
    val method: String, // название метода
    val convergenceDetails: String = "" // детали сходимости
)
