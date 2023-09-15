package dev.passerby.crypto_compose_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.passerby.crypto_compose_project.ui.theme.CryptoComposeProjectTheme
import dev.passerby.domain.models.CoinModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column {
        HomeTopAppBar()
        Spacer(modifier = Modifier.size(16.dp))
        FavouritesCardSlider(
            favItems = listOf(
                CoinModel(
                    1,
                    "",
                    1,
                    emptyList(),
                    "",
                    "",
                    1.0,
                    "Bitcoin",
                    1.0,
                    1.0,
                    1.0,
                    1.0,
                    1.0,
                    1,
                    "",
                    "BTC",
                    1L,
                    "",
                    1.0,
                    "",
                    true
                ),
                CoinModel(
                    1,
                    "",
                    1,
                    emptyList(),
                    "",
                    "",
                    1.0,
                    "Bitcoin",
                    1.0,
                    1.0,
                    1.0,
                    1.0,
                    1.0,
                    2,
                    "",
                    "BTC",
                    1L,
                    "",
                    1.0,
                    "",
                    true
                ),
                CoinModel(
                    1,
                    "",
                    1,
                    emptyList(),
                    "",
                    "",
                    1.0,
                    "Bitcoin",
                    1.0,
                    1.0,
                    1.0,
                    1.0,
                    1.0,
                    3,
                    "",
                    "BTC",
                    1L,
                    "",
                    1.0,
                    "",
                    true
                )
            )
        )
    }
    HomeBottomSheetScaffold()
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    CryptoComposeProjectTheme {
        HomeScreen()
    }
}