package com.arekalov.compmatlab3.pages

import androidx.compose.runtime.Composable
import com.arekalov.compmatlab3.common.PAGE_TITLE
import com.arekalov.compmatlab3.components.layouts.PageLayout
import com.arekalov.compmatlab3.components.widgets.BorderBox
import com.arekalov.compmatlab3.toSitePalette
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
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
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.5.cssRem),
            horizontalArrangement = Arrangement.spacedBy(1.cssRem)
        ) {
            BorderBox(
                color = palette.brand.accent,
                modifier = Modifier.width(40.cssRem)
            ) {

            }
            BorderBox(
                color = palette.brand.accent,
                modifier = Modifier.fillMaxWidth()
            ) {

            }
        }
    }
}
