package com.newoverride.controle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.newoverride.controle.components.HomeController
import com.newoverride.controle.ui.theme.ControleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ControleTheme {
                HomeController(
                    clickUP = { println("Button UP -> On") },
                    clickLEFT = { println("Button LEFT -> On") },
                    clickRIGHT = { println("Button RIGHT -> On") },
                    clickDOWN = { println("Button DOWN -> On") },
                    clickSTOP = { println("Button STOP -> On") }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    ControleTheme {
        HomeController(
            clickUP = {},
            clickLEFT = {},
            clickRIGHT = {},
            clickDOWN = {},
            clickSTOP = {}
        )
    }
}