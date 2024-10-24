package com.example.trycomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.trycomponent.ui.theme.TryComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TryComponentTheme {
                //RememberMeExample()
                ContactApp()
            }
        }
    }
}


@Composable
fun ContactApp() {

    //state to listen change to Recomposition component
    var count by remember {
        mutableStateOf(0)
    }

    // column to all view
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //to space
        Spacer(modifier = Modifier.height(35.dp))
        //text view count
        Text(text = "Count is $count")
        Spacer(modifier = Modifier.height(16.dp))
        //click button to change value state and target Recomposition
        Button(onClick = { count++ }) {
            Text(text = "Click Me")
        }

    }
}

/*
// Local State Management  with checkbox component
@Composable
fun RememberMeExample() {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 20.dp)) {
        Spacer(modifier = Modifier.padding(40.dp))

        var rememberMe by remember { mutableStateOf(false) }
        Checkbox(
            checked = rememberMe,
            onCheckedChange = { rememberMe = it }
        )
    }

}*/
