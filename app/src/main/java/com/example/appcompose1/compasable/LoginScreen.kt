package com.example.appcompose1.compasable

import android.content.Intent
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
import androidx.compose.ui.draw.clip

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.appcompose1.ListActivity
import com.example.appcompose1.R
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
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center, modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .background(color = BackgroundScreen)
    )
    {
        // Spacer(modifier = Modifier.height(40.dp))
        Text(text = stringResource(R.string.login_text), color = TextWhite, fontSize = 25.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = stringResource(R.string.please_sign_text), color = TextWhite, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = userName,
            modifier = Modifier.clip(RoundedCornerShape(15.dp)),
            textStyle = TextStyle(fontSize = 18.sp, color = TextWhite),
            onValueChange = {
                userName = it
            },
            label = { Text(text = stringResource(R.string.Enter_user_name)) }
        )

        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = password, modifier = Modifier.clip(RoundedCornerShape(15.dp)),
            textStyle = TextStyle(fontSize = 18.sp, color = TextWhite),
            onValueChange = {
                password = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),

            label = { Text(text = stringResource(R.string.Enter_your_password)) },
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Default.LockOpen else Icons.Default.Lock,
                        contentDescription = "password"
                    )
                }
            }
        )
        Spacer(modifier = Modifier.height(45.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = isChecked, onCheckedChange = { isChecked = it })
                Text(text = stringResource(R.string.remember_me), fontSize = 18.sp, color = Blue200)
            }
            Spacer(modifier = Modifier.width(45.dp))
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = stringResource(R.string.forget_password), fontSize = 18.sp, color = Blue200)
            }
        }


        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                if (userName.isEmpty() || password.isEmpty() || password.length < 4 || (userName.contains(
                        regex
                    ))
                ) {
                    Toast.makeText(
                        context,
                        "please enter valid username and password",
                        Toast.LENGTH_LONG
                    ).show()

                } else
                {  val intent=Intent(context,ListActivity::class.java)
             context.startActivity(intent)
                }

            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Blue200),
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(40.dp),
            content = { Text(text = stringResource(R.string.login), fontSize = 20.sp, color = TextWhite) },
            shape = RoundedCornerShape(50)
        )


    }
}