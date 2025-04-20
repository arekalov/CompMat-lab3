package com.arekalov.compmatlab3.pages

import androidx.compose.runtime.Composable
import com.arekalov.compmatlab3.common.PAGE_TITLE
import com.arekalov.compmatlab3.components.layouts.PageLayout
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.cssRem

@Page
@Composable
fun Index() {
    PageLayout(
        title = PAGE_TITLE
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(0.5.cssRem)
        ) {

        }
    }
}
