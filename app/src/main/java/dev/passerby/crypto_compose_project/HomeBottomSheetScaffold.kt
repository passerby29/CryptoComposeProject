package dev.passerby.crypto_compose_project

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun HomeBottomSheetScaffold() {
    MyBottomSheetScaffold()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
private fun MyBottomSheetScaffold() {
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(64.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "text")
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = {
                    scope.launch { scaffoldState.bottomSheetState.hide() }
                }) {
                    Text(text = "Click to collapse")
                }
            }
        },
        scaffoldState = scaffoldState
    ){}
}