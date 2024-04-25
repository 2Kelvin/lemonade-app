package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                LemonadeApp()
            }
        }
    }
}

// all images
val lemonTree = R.drawable.lemon_tree
val lemonSqueeze = R.drawable.lemon_squeeze
val lemonadeDrink = R.drawable.lemon_drink
val lemonRestart = R.drawable.lemon_restart

@Composable
fun ImageAndText(modifier: Modifier) {
    // here
}

@Composable
fun LemonadeApp(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
) {
    Column(modifier = modifier) {
        Text(
            text = "Lemonade",
            modifier = modifier
                .background(Color.Yellow)
                .padding(top = 10.dp, bottom = 10.dp)
                .height(14.dp),
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeApp()
}