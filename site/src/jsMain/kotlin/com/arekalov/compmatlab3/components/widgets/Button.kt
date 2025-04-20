package com.arekalov.compmatlab3.components.widgets

import androidx.compose.runtime.Composable
import com.arekalov.compmatlab3.CircleButtonVariant
import com.arekalov.compmatlab3.UncoloredButtonVariant
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonVars
import org.jetbrains.compose.web.css.em

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        onClick = { onClick() },
        modifier.setVariable(ButtonVars.FontSize, 1.em),
        variant = CircleButtonVariant.then(UncoloredButtonVariant)
    ) {
        content()
    }
}
