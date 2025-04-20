package com.arekalov.compmatlab3.data.strings

object Strings {
    // InputPanel
    const val INPUT_TITLE = "Input Data"
    const val FUNCTION_LABEL = "Function:"
    const val METHOD_LABEL = "Method:"
    const val BOUNDS_LABEL = "Bounds:"
    const val BOUNDS_SEPARATOR_BEFORE = "from"
    const val BOUNDS_SEPARATOR_AFTER = "to"
    const val PRECISION_LABEL = "Precision:"
    const val CALCULATE_BUTTON = "Calculate"

    // ResultPanel
    const val RESULT_TITLE = "Calculation Results"
    const val FUNCTION_RESULT = "Function: "
    const val BOUNDS_RESULT = "Integration bounds: "
    const val METHOD_RESULT = "Method: "
    const val EXACT_VALUE = "Exact value: "
    const val CALCULATED_VALUE = "Calculated value: "
    const val FINAL_ERROR = "Final error: "
    const val ITERATIONS_COUNT = "Iterations count: "

    // Table headers
    const val ITERATION_HEADER = "Iteration"
    const val SPLITS_HEADER = "Splits (n)"
    const val VALUE_HEADER = "Value"
    const val ERROR_HEADER = "Error"

    // Integration methods
    const val LEFT_RECTANGLE_METHOD = "Left Rectangle Method"
    const val RIGHT_RECTANGLE_METHOD = "Right Rectangle Method"
    const val MIDDLE_RECTANGLE_METHOD = "Middle Rectangle Method"
    const val TRAPEZOID_METHOD = "Trapezoid Method"
    const val SIMPSON_METHOD = "Simpson's Method"

    // Error messages
    const val ERROR_INVALID_PRECISION = "Precision must be a positive number"
    const val ERROR_INVALID_BOUNDS = "Integration bounds must be numbers"
    const val ERROR_INVALID_BOUNDS_ORDER = "Lower bound must be less than upper bound"
    const val ERROR_CALCULATION = "Calculation error: "
} 