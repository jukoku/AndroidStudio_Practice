package com.example.bussinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bussinesscard.ui.theme.BussinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BussinessCardTheme {
                // import androidx.compose.material3.Surface
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //import androidx.compose.material3.MaterialTheme
                    color = MaterialTheme.colorScheme.background
                )  {
                    MainPart()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(){
    Column(
        Modifier
            .background(Color(0xFF6BA987))
            .fillMaxSize()

    ){
        Box(Modifier.weight(1f))
        MainPart(
            modifier = Modifier.weight(1f)
        )
        Box(Modifier.weight(0.1f))
        ContactPart(
            modifier = Modifier.weight(1f)
        )
    }
}


@Composable
fun MainPart(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Box(Modifier
            .padding(start = 120.dp, end = 120.dp, bottom = 10.dp)
            .background(Color(0xFF122E04))) {
            Image(
                painter = image,
                contentDescription = null
            )
        }
        Text(
            text = stringResource(R.string.john_doe),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(5.dp)
        )
        Text(
            text = stringResource(R.string.android_developer_extraordinaire)
        )
    }
}

@Composable
fun ContactPart(modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(start = 100.dp)
    ){
        OneContact(
            image = R.drawable.baseline_phone_iphone_24,
            contactInfo = stringResource(R.string._82_10_1234_5678)
        )
        OneContact(
            image = R.drawable.baseline_share_24,
            contactInfo = stringResource(R.string.androiddev)
        )
        OneContact(
            image = R.drawable.baseline_email_24,
            contactInfo = stringResource(R.string.johndoe_androiddev_com)
        )
    }
}

@Composable
fun OneContact(image: Int, contactInfo: String){
    Row{
        Image(
            painter = painterResource(image),
            contentDescription = null
            )
        Text(
            text = contactInfo
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BussinessCardTheme {
        BusinessCard()
    }
}