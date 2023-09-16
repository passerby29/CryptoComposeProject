package dev.passerby.crypto_compose_project

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.passerby.domain.models.CoinModel

@Composable
fun HomeBottomSheetScaffold(list: List<CoinModel>) {
    MyBottomSheetScaffold(list)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MyBottomSheetScaffold(list: List<CoinModel>) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    BottomSheetScaffold(
        sheetPeekHeight = 320.dp,
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                Text("Coin list")
            }
            HomeCoinList(list = list)
        },
        scaffoldState = scaffoldState
    ) {}
}

@Composable
private fun HomeCoinList(list: List<CoinModel>) {
    LazyColumn {
        itemsIndexed(
            list
        ) { _, item ->
            CoinListItem(item = item)
        }
    }
}

@Composable
private fun CoinListItem(item: CoinModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 4.dp)
            .clickable {

            },
        elevation = CardDefaults.cardElevation(0.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = item.icon,
                    contentDescription = "icon",
                    modifier = Modifier.size(48.dp)
                )
                Column(
                    modifier = Modifier.padding(start = 4.dp),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = item.name,
                        style = TextStyle(fontSize = 16.sp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = item.symbol,
                        style = TextStyle(fontSize = 12.sp),
                        fontWeight = FontWeight.ExtraLight
                    )
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "${item.price}",
                    style = TextStyle(fontSize = 16.sp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${item.priceChange1h}",
                    style = TextStyle(fontSize = 12.sp),
                    fontWeight = FontWeight.ExtraLight
                )
            }
        }
    }
}

@Composable
@Preview
private fun ListItemPreview() {
    CoinListItem(
        item = CoinModel(
            1,
            "",
            1,
            emptyList(),
            "",
            "",
            1.0,
            "",
            1.0,
            1.0,
            1.0,
            1.0,
            1.0,
            1,
            "",
            "",
            1,
            "",
            1.0,
            ""
        )
    )
}