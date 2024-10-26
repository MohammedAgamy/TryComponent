package com.example.trycomponent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.trycomponent.view.UserListViewModel
import com.example.trycomponent.ui.theme.TryComponentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewmodel : UserListViewModel by viewModels()

        enableEdgeToEdge()
        setContent {
            TryComponentTheme {
                //RememberMeExample()
                //ContactApp()

                UserInputScreen(viewmodel)
            }
        }
    }
}


@Composable
fun UserInputScreen(viewModel: UserListViewModel) {
    val name by viewModel.name.collectAsState()
    val email by viewModel.email.collectAsState()
    val nameError by viewModel.nameError.collectAsState()
    val emailError by viewModel.emailError.collectAsState()


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Name input field
        OutlinedTextField(
            value = name,
            onValueChange = { viewModel.updateName(it) },
            label = { Text("Name") },
            isError = nameError,
            supportingText = {
                if (nameError) {
                    Text(
                        "Name cannot be empty",
                        color = MaterialTheme.colorScheme.error
                    )  // Show error message
                }
            }

        )

        Spacer(modifier = Modifier.height(8.dp))
        // Email input field
        OutlinedTextField(
            value = email,
            onValueChange = { viewModel.updateEmail(it) },
            label = { Text("Email") },
            isError = emailError,
            supportingText = {
                if (emailError) {
                    Text(
                        text = if (email.isEmpty()) "Email cannot be empty" else "Invalid email address",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Button to add user
        Button(onClick = { viewModel.addUser() }) {
            Text("Add User")
        }
    }
}




/*
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
}*/

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
