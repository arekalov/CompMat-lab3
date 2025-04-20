package com.arekalov.compmatlab3.components

import androidx.compose.runtime.Composable
import com.arekalov.compmatlab3.data.strings.Strings
import com.arekalov.compmatlab3.viewmodel.IntegrationViewModel
import com.varabyte.kobweb.compose.css.BorderCollapse
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.borderCollapse
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun ResultPanel(
    viewModel: IntegrationViewModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(1.cssRem),
        verticalArrangement = Arrangement.spacedBy(1.cssRem),
        horizontalAlignment = Alignment.Start
    ) {
        SpanText(
            Strings.RESULT_TITLE,
            modifier = Modifier.fontSize(1.2.cssRem).fontWeight(FontWeight.Bold)
        )

        viewModel.result?.let { result ->
            // Общая информация
            Column(
                modifier = Modifier.fillMaxWidth().margin(bottom = 1.cssRem),
                verticalArrangement = Arrangement.spacedBy(0.5.cssRem)
            ) {
                // Информация о функции
                SpanText(Strings.FUNCTION_RESULT + viewModel.selectedFunction.name)
                SpanText(Strings.BOUNDS_RESULT + "[${viewModel.lowerBound}, ${viewModel.upperBound}]")

                // Информация о методе и результатах
                SpanText(Strings.METHOD_RESULT + result.method)
                SpanText(Strings.EXACT_VALUE + result.exactValue)
                SpanText(Strings.CALCULATED_VALUE + result.finalValue)
                SpanText(Strings.FINAL_ERROR + result.finalError)
                SpanText(Strings.ITERATIONS_COUNT + result.totalIterations)
            }

            // Таблица с результатами по итерациям
            Table(
                attrs = {
                    style {
                        width(100.percent)
                        borderCollapse(BorderCollapse.Collapse)
                    }
                }
            ) {
                Tr {
                    Th(
                        attrs = {
                            style {
                                fontWeight(FontWeight.Bold.toString())
                                padding(0.5.cssRem)
                                border(1.px, LineStyle.Solid, Color.gray)
                            }
                        }
                    ) {
                        Text(Strings.ITERATION_HEADER)
                    }
                    Th(
                        attrs = {
                            style {
                                fontWeight(FontWeight.Bold.toString())
                                padding(0.5.cssRem)
                                border(1.px, LineStyle.Solid, Color.gray)
                            }
                        }
                    ) {
                        Text(Strings.SPLITS_HEADER)
                    }
                    Th(
                        attrs = {
                            style {
                                fontWeight(FontWeight.Bold.toString())
                                padding(0.5.cssRem)
                                border(1.px, LineStyle.Solid, Color.gray)
                            }
                        }
                    ) {
                        Text(Strings.VALUE_HEADER)
                    }
                    Th(
                        attrs = {
                            style {
                                fontWeight(FontWeight.Bold.toString())
                                padding(0.5.cssRem)
                                border(1.px, LineStyle.Solid, Color.gray)
                            }
                        }
                    ) {
                        Text(Strings.ERROR_HEADER)
                    }
                }

                result.iterations.forEachIndexed { index, iteration ->
                    Tr {
                        Td(
                            attrs = {
                                style {
                                    padding(0.5.cssRem)
                                    border(1.px, LineStyle.Solid, Color.gray)
                                }
                            }
                        ) {
                            Text("${index + 1}")
                        }
                        Td(
                            attrs = {
                                style {
                                    padding(0.5.cssRem)
                                    border(1.px, LineStyle.Solid, Color.gray)
                                }
                            }
                        ) {
                            Text("${iteration.n}")
                        }
                        Td(
                            attrs = {
                                style {
                                    padding(0.5.cssRem)
                                    border(1.px, LineStyle.Solid, Color.gray)
                                }
                            }
                        ) {
                            Text("${iteration.value}")
                        }
                        Td(
                            attrs = {
                                style {
                                    padding(0.5.cssRem)
                                    border(1.px, LineStyle.Solid, Color.gray)
                                }
                            }
                        ) {
                            Text("${iteration.error}")
                        }
                    }
                }
            }
        }
    }
} 