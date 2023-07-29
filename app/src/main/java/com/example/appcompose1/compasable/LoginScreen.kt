package com.example.appcompose1.compasable

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcompose1.ui.theme.*


@Preview
@Composable
fun LoginScreen() {
    var isChecked by remember {
        mutableStateOf(false)
    }
    val regex = Regex("[$%#@ ]")
    val context = LocalContext.current
    var userName by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .background(color = BackgroundScreen)
    )
    {
        Spacer(modifier = Modifier.height(150.dp))
        Text(text = "Login", color = TextWhite, fontSize = 25.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "please sign in to continue", color = TextWhite, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = userName,
            textStyle = TextStyle(fontSize = 18.sp, color = TextWhite),
            onValueChange = {
                userName = it
            },
            label = { Text(text = "Enter user name") }
        )

        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = password,
            textStyle = TextStyle(fontSize = 18.sp, color = TextWhite),
            onValueChange = {
                password = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),

            label = { Text(text = "enter your password") },
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Default.LockOpen else Icons.Default.Lock,
                        contentDescription = "password"
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(80.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = isChecked, onCheckedChange = {isChecked=it})
                Text(text = "Remember me", fontSize = 18.sp, color = Blue200)
            }
            Spacer(modifier = Modifier.width(45.dp))
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Forget passwod?", fontSize = 18.sp, color = Blue200)
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                if (userName.isEmpty() || password.isEmpty() || password.length > 4) {
                    Toast.makeText(
                        context,
                        "please enter valid username and password",
                        Toast.LENGTH_LONG
                    ).show()

                }
                if (userName.contains(regex))
                    Toast.makeText(context, "invalid user name", Toast.LENGTH_LONG).show()

            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Blue200),
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(40.dp),
            content = { Text(text = "LOGIN", fontSize = 20.sp, color = TextWhite) },
            shape = RoundedCornerShape(50)
        )


    }
}