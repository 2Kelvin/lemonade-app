package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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

// creating data objects
data class ImageTextObject(val img: Int, val txt: Int)

// list of all imageText objects
val listOfImageTextObjects = listOf(
    ImageTextObject(img = R.drawable.lemon_tree, txt = R.string.tap_lemon_string),
    ImageTextObject(img = R.drawable.lemon_squeeze, txt = R.string.lemon_squeeze_string),
    ImageTextObject(img = R.drawable.lemon_drink, txt = R.string.lemon_drink_string),
    ImageTextObject(img = R.drawable.lemon_restart, txt = R.string.lemon_start_string),
)

// my custom PT sans font
val ptSansFont = FontFamily(
    Font(R.font.pt_sans_caption_regular, FontWeight.Normal),
    Font(R.font.pt_sans_caption_bold, FontWeight.Bold)
)

// image and text reusable composable
@Composable
fun ImageAndText(obj: ImageTextObject, updateIndex: () -> Unit, modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { updateIndex() },
            shape = RoundedCornerShape(40.dp), // custom button rounded corners
            colors = ButtonDefaults.buttonColors(Color(0xFFc3ecd2)), // custom button bg color
            modifier = Modifier.size(180.dp)
        ) {
            Image(
                painter = painterResource(id = obj.img),
                contentDescription = "lemonade image",
                modifier = Modifier.size(160.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = stringResource(id = obj.txt),
            fontSize = 16.sp,
            fontFamily = ptSansFont,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun LemonadeApp(
    modifier: Modifier = Modifier
        .fillMaxSize()
) {
    // initializing state
    var index by remember { mutableStateOf(0) }

    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.lemonade_header),
            modifier = Modifier
                .background(Color.Yellow)
                .height(55.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            color = Color.Black,
            fontSize = 22.sp,
            fontFamily = ptSansFont,
        )

        ImageAndText(
            obj = listOfImageTextObjects[index],
            updateIndex = { // lambda updating index state
                          if (index >= (listOfImageTextObjects.size - 1)) {
                              index = 0
                          } else index++
            },
            modifier = modifier
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeApp()
}