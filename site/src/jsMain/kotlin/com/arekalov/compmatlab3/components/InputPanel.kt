package com.arekalov.compmatlab3.components

import androidx.compose.runtime.Composable
import com.arekalov.compmatlab3.data.function.Functions
import com.arekalov.compmatlab3.data.integration.IntegrationMethod
import com.arekalov.compmatlab3.viewmodel.IntegrationViewModel
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.GridEntry.Repeat.Auto.Type
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Option
import org.jetbrains.compose.web.dom.Select
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextInput

@Composable
fun InputPanel(
    viewModel: IntegrationViewModel,
    modifier: Modifier = Modifier
) {
    val breakpoint = rememberBreakpoint()
    
    Column(
        modifier = modifier.padding(1.cssRem),
        verticalArrangement = Arrangement.spacedBy(1.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpanText(
            "Ввод данных",
            modifier = Modifier.fontSize(1.2.cssRem).fontWeight(FontWeight.Bold)
        )

        // Выбор функции
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(1.cssRem),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SpanText(
                "Функция:",
                modifier = Modifier.width(if (breakpoint >= Breakpoint.MD) 20.percent else 30.percent)
            )
            Select(
                attrs = modifier
                    .margin(left = 1.cssRem)
                    .background(Color.transparent)
                    .borderRadius(0.5.cssRem)
                    .minWidth(5.cssRem)
                    .padding(0.3.cssRem)
                    .toAttrs {
                        onChange { event ->
                            viewModel.selectFunction(event.value?.toInt() ?: 0)
                        }
                    }
            ) {
                Functions.availableFunctions.forEachIndexed { index, function ->
                    Option(
                        value = index.toString()
                    ) {
                        Text(function.name)
                    }
                }
            }
        }

        // Выбор метода
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(1.cssRem),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SpanText(
                "Метод:",
                modifier = Modifier.width(if (breakpoint >= Breakpoint.MD) 20.percent else 30.percent)
            )
            Select(
                attrs = modifier
                    .background(Color.transparent)
                    .borderRadius(0.5.cssRem)
                    .minWidth(5.cssRem)
                    .padding(0.3.cssRem)
                    .toAttrs {
                        onChange { event ->
                            viewModel.selectMethod(IntegrationMethod.valueOf(event.value.toString()))
                        }
                    }
            ) {
                IntegrationMethod.entries.forEach { method ->
                    Option(
                        value = method.name
                    ) {
                        Text(when (method) {
                            IntegrationMethod.LEFT_RECTANGLE -> "Левые прямоугольники"
                            IntegrationMethod.RIGHT_RECTANGLE -> "Правые прямоугольники"
                            IntegrationMethod.MIDDLE_RECTANGLE -> "Средние прямоугольники"
                            IntegrationMethod.TRAPEZOID -> "Метод трапеций"
                            IntegrationMethod.SIMPSON -> "Метод Симпсона"
                        })
                    }
                }
            }
        }

        // Ввод точности
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(1.cssRem),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SpanText(
                "Точность:",
                modifier = Modifier.width(if (breakpoint >= Breakpoint.MD) 20.percent else 30.percent).margin(right = 1.cssRem)
            )
            TextInput(
                attrs = {
                    value(viewModel.epsilon)
                    onInput { event ->
                        viewModel.updateEpsilon(event.value)
                    }
                }
            )
        }

        // Кнопка расчета
        Button(
            onClick = { viewModel.calculate() },
            modifier = Modifier.fillMaxWidth()
        ) {
            SpanText("Вычислить")
        }

        // Вывод ошибки
        viewModel.error?.let { error ->
            SpanText(
                error,
                modifier = Modifier.color(Color.red)
            )
        }
    }
} 