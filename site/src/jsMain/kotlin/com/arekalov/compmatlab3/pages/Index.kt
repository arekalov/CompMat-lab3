package com.arekalov.compmatlab3.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.arekalov.compmatlab3.common.PAGE_TITLE
import com.arekalov.compmatlab3.components.InputPanel
import com.arekalov.compmatlab3.components.ResultPanel
import com.arekalov.compmatlab3.components.layouts.PageLayout
import com.arekalov.compmatlab3.components.widgets.BorderBox
import com.arekalov.compmatlab3.toSitePalette
import com.arekalov.compmatlab3.viewmodel.IntegrationViewModel
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem

@Page
@Composable
fun Index() {
    PageLayout(
        title = PAGE_TITLE
    ) {
        val palette = ColorMode.current.toSitePalette()
        val viewModel = remember { IntegrationViewModel() }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.5.cssRem),
            horizontalArrangement = Arrangement.spacedBy(1.cssRem)
        ) {
            // Панель ввода данных
            BorderBox(
                color = palette.brand.accent,
                modifier = Modifier.width(40.cssRem)
            ) {
                InputPanel(viewModel = viewModel)
            }

            // Панель результатов
            BorderBox(
                color = palette.brand.accent,
                modifier = Modifier.fillMaxWidth()
            ) {
                ResultPanel(viewModel = viewModel)
            }
        }
    }
}
