package com.example.coinapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.coinapp.data.model.CoinIcon
import com.example.coinapp.data.model.ResponseState
import com.example.coinapp.data.source.remote.CoinService
import com.example.coinapp.ui.theme.CoinAppTheme
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var service: CoinService

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            CoinAppTheme {
                Surface {
                    MainScreen()
                }
            }
        }

        viewModel.getCoinIcon()
    }
}

@Composable
fun MainScreen() {
    Text(
        text = "Hello world",
        fontSize = 12.sp
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewFunc() {
    MainScreen()
}


