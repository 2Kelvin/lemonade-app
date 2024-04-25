package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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

// image and text reusable composable
@Composable
fun ImageAndText(theImg: Int, theTxt: String, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(30.dp)) // rounded corners | border-radius
                .background(Color(0xFFc3ecd2)) // custom hex code color
                .padding(all = 10.dp)
                .size(140.dp)
                .wrapContentSize(Alignment.Center) // center items horizontally & vertically
                .clickable {
                    // onclick => change the image and the text
                }
        ) {
            Image(
                painter = painterResource(id = theImg),
                contentDescription = "lemonade image",
                modifier = Modifier.size(90.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = theTxt,
            fontSize = 16.sp
        )
    }
}

@Composable
fun LemonadeApp(
    modifier: Modifier = Modifier
        .fillMaxSize()
) {
    Column(modifier = modifier) {
        Text(
            text = "Lemonade",
            modifier = Modifier
                .background(Color.Yellow)
                .height(55.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
        )

        ImageAndText(
            theImg = lemonTree,
            theTxt = stringResource(R.string.tap_lemon_string),
            modifier = modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeApp()
}