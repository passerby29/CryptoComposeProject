package dev.passerby.crypto_compose_project

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.passerby.crypto_compose_project.Constants.placeholder
import dev.passerby.domain.models.CoinModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FavouritesCardSlider(favItems: List<CoinModel>) {
    val pagerState = rememberPagerState { favItems.size }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(
                state = pagerState,
                key = { favItems[it].rank },
                pageSize = PageSize.Fill
            ) { index ->
                FavouriteCardItem(favItems[index])
            }
            DotsIndicator(
                totalDots = favItems.size,
                selectedIndex = pagerState.currentPage,
                dotSize = 8.dp
            )
        }
    }

}

@Composable
fun FavouriteCardItem(favItem: CoinModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 48.dp),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_favorite_border),
                    contentDescription = "favoriteIcon",
                    modifier = Modifier.size(24.dp)
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "$${favItem.price}", style = TextStyle(fontSize = 40.sp))
                Text(text = "+$${favItem.priceChange1h}", style = TextStyle(fontSize = 18.sp))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row {
                    AsyncImage(
                        model = favItem.icon,
                        contentDescription = "coinIcon",
                        modifier = Modifier.size(36.dp)
                    )
                    Column(
                        modifier = Modifier.height(36.dp),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = favItem.name,
                            style = TextStyle(fontSize = 16.sp),
                            fontWeight = FontWeight.Bold
                        )
                        Text(text = favItem.symbol, style = TextStyle(fontSize = 12.sp))
                    }
                }
                Button(
                    onClick = { },
                    modifier = Modifier
                        .height(36.dp)
                        .width(104.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "More",
                        style = TextStyle(fontSize = 16.sp),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun DotsIndicator(
    modifier: Modifier = Modifier,
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color = Color.DarkGray, /* Color.Yellow */
    unSelectedColor: Color = Color.Gray, /* Color.Gray */
    dotSize: Dp,
) {
    LazyRow(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight()
    ) {
        items(totalDots) { index ->
            IndicatorDot(
                color = if (index == selectedIndex) selectedColor else unSelectedColor,
                size = dotSize
            )

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@Composable
fun IndicatorDot(
    modifier: Modifier = Modifier,
    size: Dp,
    color: Color
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(color)
    )
}


@Composable
@Preview
fun SliderPreview() {
    FavouritesCardSlider(placeholder)
}