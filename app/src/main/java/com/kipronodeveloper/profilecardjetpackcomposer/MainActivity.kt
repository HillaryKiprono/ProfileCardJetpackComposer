package com.kipronodeveloper.profilecardjetpackcomposer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kipronodeveloper.profilecardjetpackcomposer.ui.theme.ProfileCardJetpackComposerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           UserList()
        }
    }
}

data class User(
    val id: Int
        )
val users= listOf(
    User(1),
    User(2),
    User(3),
    User(4),
    User(5),
    User(6),
    User(7),
    User(8),
    User(9),
    User(10),
    User(11),
    User(12)
)
@Composable
fun UserList(){
//    Column(modifier =Modifier.verticalScroll(rememberScrollState())) {
//        for(i in 1..10)
//        {
//            UserCard()
//        }
//    }
    LazyColumn{
        items((users)){ user->
            UserCard()

    }
    }
}
@Composable
fun UserCard(){
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        Row(modifier= Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(12.dp)
            .border(width = 1.dp, color = Color.Blue)
            .padding(12.dp)

        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "",
                contentScale=ContentScale.Crop,
                modifier= Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            Column() {
                Text(text = "I am an android developer and web developer")
                Button(onClick = {
                    //perform click listener
                }) {
                    Text(text = "View the Profile")
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileCardJetpackComposerTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            //UserCard()
            UserList()
        }
    }
}