package com.example.android.wearable.composeforwearos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.dialog.Alert
import com.example.android.wearable.composeforwearos.theme.WearAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WearAppTheme {
                /* Change to true to trigger IllegalArgumentException
                 * Change to false to see the horizontalScroll works
                 * val hasChildSLC = true
                 */
                val hasChildSLC = false
                horizontalScollSLC(hasChildSLC = hasChildSLC)
            }
        }
    }
}

@Composable
fun horizontalScollSLC(hasChildSLC: Boolean) {
    val horizontalScrollState = rememberScrollState()
    if (!hasChildSLC) {
        Box(modifier = Modifier
            .fillMaxSize()
        ) {
            ScalingLazyColumn {
                item {
                    Text(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .horizontalScroll(horizontalScrollState),
                        text = "This text can be scrolled horizontally - to dismiss, swipe " +
                                "right from the left edge of the screen (called Edge Swiping)",
                    )
                }
            }
        }
    } else {
        Box(
            modifier = Modifier.horizontalScroll(horizontalScrollState), // doesn't work
        ) {

                ScalingLazyColumn {
                    item {
                        Text("hi")
                    }
                }
            Alert(
                // modifier = Modifier.horizontalScroll(horizontalScrollState), // doesn't work
                title = {
                    Text(
                        text = "Hello Dialog",
                        textAlign = TextAlign.Center
                    )
                }) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                        // .horizontalScroll(horizontalScrollState) // works
                    ) {
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            //.edgeSwipeToDismiss(swipeDismissState)
                            text = "This text can be scrolled horizontally - to dismiss, swipe " +
                                    "right from the left edge of the screen (called Edge Swiping)",
                        )
                    }
                }
            }

        }
    }
}