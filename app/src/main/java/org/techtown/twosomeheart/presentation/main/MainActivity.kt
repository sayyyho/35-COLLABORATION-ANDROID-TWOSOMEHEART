package org.techtown.twosomeheart.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navigator = rememberNavController()
            val mainNavigator = rememberMainNavigator(navigator)

            TwosomeHeartTheme {
                MainScreen(navigator = mainNavigator)
            }
        }
    }
}
