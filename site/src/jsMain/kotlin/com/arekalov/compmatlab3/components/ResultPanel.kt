package com.arekalov.compmatlab3.components

import androidx.compose.runtime.Composable
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
            "Результаты вычислений",
            modifier = Modifier.fontSize(1.2.cssRem).fontWeight(FontWeight.Bold)
        )

        viewModel.result?.let { result ->
            // Общая информация
            Column(
                modifier = Modifier.fillMaxWidth().margin(bottom = 1.cssRem),
                verticalArrangement = Arrangement.spacedBy(0.5.cssRem)
            ) {
                // Информация о функции
                SpanText("Функция: ${viewModel.selectedFunction.name}")
                SpanText("Пределы интегрирования: [${viewModel.selectedFunction.lowerBound}, ${viewModel.selectedFunction.upperBound}]")
                
                // Информация о методе и результатах
                SpanText("Метод: ${result.method}")
                SpanText("Точное значение: ${result.exactValue}")
                SpanText("Вычисленное значение: ${result.finalValue}")
                SpanText("Итоговая погрешность: ${result.finalError}")
                SpanText("Количество итераций: ${result.totalIterations}")
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
                                backgroundColor(Color.lightgray)
                                fontWeight(FontWeight.Bold.toString())
                                padding(0.5.cssRem)
                                border(1.px, LineStyle.Solid, Color.gray)
                            }
                        }
                    ) {
                        Text("Итерация")
                    }
                    Th(
                        attrs = {
                            style {
                                backgroundColor(Color.lightgray)
                                fontWeight(FontWeight.Bold.toString())
                                padding(0.5.cssRem)
                                border(1.px, LineStyle.Solid, Color.gray)
                            }
                        }
                    ) {
                        Text("Разбиения (n)")
                    }
                    Th(
                        attrs = {
                            style {
                                backgroundColor(Color.lightgray)
                                fontWeight(FontWeight.Bold.toString())
                                padding(0.5.cssRem)
                                border(1.px, LineStyle.Solid, Color.gray)
                            }
                        }
                    ) {
                        Text("Значение")
                    }
                    Th(
                        attrs = {
                            style {
                                backgroundColor(Color.lightgray)
                                fontWeight(FontWeight.Bold.toString())
                                padding(0.5.cssRem)
                                border(1.px, LineStyle.Solid, Color.gray)
                            }
                        }
                    ) {
                        Text("Погрешность")
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