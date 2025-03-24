package com.newoverride.controle.components

import SpringPressReleaseButton
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.newoverride.controle.util.Dimens

@Composable
fun HomeController(
    clickUP: () -> Unit,
    clickLEFT: () -> Unit,
    clickRIGHT: () -> Unit,
    clickDOWN: () -> Unit,
    clickSTOP: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.ColumSpacing)
        ) {
            Row {
                SpringPressReleaseButton(
                    onPress = clickUP,
                    onRelease = clickSTOP,
                    text = "UP",
                    width = Dimens.ButtonWidth,
                    height = Dimens.ButtonHeight,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SpringPressReleaseButton(
                    onPress = clickLEFT,
                    onRelease = clickSTOP,
                    text = "LEFT",
                    width = Dimens.ButtonWidth,
                    height = Dimens.ButtonHeight,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = Dimens.RowSpacing)
                )
                SpringPressReleaseButton(
                    onPress = clickSTOP,
                    onRelease = {},
                    text = "STOP",
                    width = Dimens.ButtonWidth,
                    height = Dimens.ButtonHeight,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = Dimens.RowSpacing)
                )
                SpringPressReleaseButton(
                    onPress = clickRIGHT,
                    onRelease = clickSTOP,
                    text = "RIGHT",
                    width = Dimens.ButtonWidth,
                    height = Dimens.ButtonHeight,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = Dimens.RowSpacing)
                )
            }
            Row {
                SpringPressReleaseButton(
                    onPress = clickDOWN,
                    onRelease = clickSTOP,
                    text = "DOWN",
                    width = Dimens.ButtonWidth,
                    height = Dimens.ButtonHeight,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        }
    }
}