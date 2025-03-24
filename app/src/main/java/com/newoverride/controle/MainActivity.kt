package com.newoverride.controle

import UDPSender
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
                    clickUP = { UDPSender.sendCommand("up") },
                    clickLEFT = { UDPSender.sendCommand("left")},
                    clickRIGHT = { UDPSender.sendCommand("right")},
                    clickDOWN = { UDPSender.sendCommand("down")},
                    clickSTOP = { UDPSender.sendCommand("stop")}
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