package dev.passerby.crypto_compose_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import dev.passerby.crypto_compose_project.Constants.placeholder
import dev.passerby.crypto_compose_project.ui.theme.CryptoComposeProjectTheme
import dev.passerby.crypto_compose_project.viewmodels.HomeViewModel
import dev.passerby.domain.models.CoinModel

class MainActivity : ComponentActivity() {

    private val homeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray
                ) {
                    val favItems = homeViewModel.favoritesList.observeAsState().value
                    val topCoinList =
                        homeViewModel.topCoinsList.observeAsState().value ?: placeholder
                    if (favItems.isNullOrEmpty()) {
                        HomeScreen(favItems = placeholder, topCoinList = topCoinList)
                    } else {
                        HomeScreen(favItems, topCoinList)
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(favItems: List<CoinModel>, topCoinList: List<CoinModel>) {
    Column {
        HomeTopAppBar()
        Spacer(modifier = Modifier.size(16.dp))
        FavouritesCardSlider(
            favItems = favItems
        )
    }
    HomeBottomSheetScaffold(topCoinList)
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    CryptoComposeProjectTheme {
        HomeScreen(placeholder, placeholder)
    }
}