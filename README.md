# Lemonade App

![lemonade](https://github.com/2Kelvin/lemonade-app/assets/85868026/10fc21a6-2894-46b0-9b5e-178797f3f252)

## Future Notes

In this project I learnt to add interactivity to my app through buttons, clickable composables and state.

- To create similar data objects define a `data class <objectName>`. Then use it to initialize the new objects
- import custom fonts in a simple way like so: (upload the fonts in res/fonts folder and rename into all font names to small letters without any special characters)
    ```Kotlin
    // my custom PT sans font
    val ptSansFont = FontFamily(
        Font(R.font.pt_sans_caption_regular, FontWeight.Normal),
        Font(R.font.pt_sans_caption_bold, FontWeight.Bold)
    )
    ```
- define a state variable in Kotlin | Jetpack Compose like so: 
    ```Kotlin
    // remember stores your variable in state
    var stateVariable by remember { mutableStateOf(stateValue) }
    ```
- create reusable stateless composables by `hoisting` state to the parent. i.e. put the state in the parent
- to update the state in the reusable comosable, pass it a lambda function
  ```Kotlin
  // updateIndex() is the lambda function passed  into ImageAndText reusable composable
  // to update the state variable 'index'
  @Composable
  fun ImageAndText(obj: ImageTextObject, updateIndex: () -> Unit, modifier: Modifier) {}
  ```
- then pass the lambda function to the **onClick** function of the necessary element in your reusable composable. In my composable I passed it to the Button's onClick as shown below.
- you can set onClick event to any other jetpack compose element, just use the 'Modifier.clickable()' property
- remove the automatic rounded corners of a button by using the Button's Shape property
- also set custom button colors using ButtonDefaults.buttonColors()
  ```Kotlin
  // updateIndex() is the lambda function passed  into ImageAndText reusable composable
  Button(
            onClick = { updateIndex() },
            shape = RoundedCornerShape(40.dp), // custom button rounded corners
            colors = ButtonDefaults.buttonColors(Color(0xFFc3ecd2)),
  )
  ```
- to make a parent center the child horizontally & vertically, give the parent a height & width then use:
  ```Kotlin
  modifier = Modifier.wrapContentSize(Alignment.Center)
  ```