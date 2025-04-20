package com.arekalov.compmatlab3.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.arekalov.compmatlab3.data.function.Functions
import com.arekalov.compmatlab3.data.integration.IntegrationMethod
import com.arekalov.compmatlab3.data.model.IntegrationResult

class IntegrationViewModel {
    var selectedFunction by mutableStateOf(Functions.availableFunctions.first())
    var selectedMethod by mutableStateOf(IntegrationMethod.LEFT_RECTANGLE)
    var epsilon by mutableStateOf("0.001")
    var error by mutableStateOf<String?>(null)
    var result by mutableStateOf<IntegrationResult?>(null)
    var lowerBound by mutableStateOf(selectedFunction.lowerBound.toString())
    var upperBound by mutableStateOf(selectedFunction.upperBound.toString())

    fun calculate() {
        try {
            val epsilonValue = epsilon.toDoubleOrNull()
            if (epsilonValue == null || epsilonValue <= 0) {
                error = "Точность должна быть положительным числом"
                return
            }

            val lower = lowerBound.toDoubleOrNull()
            val upper = upperBound.toDoubleOrNull()
            
            if (lower == null || upper == null) {
                error = "Пределы интегрирования должны быть числами"
                return
            }
            
            if (lower >= upper) {
                error = "Нижний предел должен быть меньше верхнего"
                return
            }

            result = selectedFunction.calculateWithPrecision(
                method = selectedMethod,
                epsilon = epsilonValue,
                a = lower,
                b = upper
            )
            error = null
        } catch (e: Exception) {
            error = "Ошибка вычисления: ${e.message}"
            result = null
        }
    }

    fun selectFunction(index: Int) {
        if (index in Functions.availableFunctions.indices) {
            selectedFunction = Functions.availableFunctions[index]
            lowerBound = selectedFunction.lowerBound.toString()
            upperBound = selectedFunction.upperBound.toString()
            result = null
            error = null
        }
    }

    fun selectMethod(method: IntegrationMethod) {
        selectedMethod = method
        result = null
        error = null
    }

    fun updateEpsilon(value: String) {
        epsilon = value
        result = null
        error = null
    }

    fun updateLowerBound(value: String) {
        lowerBound = value
        result = null
        error = null
    }

    fun updateUpperBound(value: String) {
        upperBound = value
        result = null
        error = null
    }
} 