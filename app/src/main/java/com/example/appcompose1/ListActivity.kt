package com.example.appcompose1

//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appcompose1.ui.theme.AppCompose1Theme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppCompose1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ProfileCard()
                }
            }
        }
    }
}

data class Profile(val name: String, val job: String)

fun getDummyProfiles(): List<Profile> {
    return listOf(
        Profile("John", "Software Engineer"),
        Profile("Alice", "Designer"),
        Profile("Bob", "Data Scientist"),
        Profile("Emily", "Product Manager"),
        Profile("Michael", "Marketing Specialist"),
        Profile("Olivia", "Teacher"),
        Profile("David", "Doctor"),
        Profile("Sophia", "Accountant"),
        Profile("Daniel", "Sales Manager"),
        Profile("Emma", "HR Manager"),
        Profile("William", "Graphic Designer"),
        Profile("Ava", "Lawyer"),
        Profile("James", "Chef"),
        Profile("Isabella", "Architect"),
        Profile("Alexander", "Financial Analyst"),
        Profile("Mia", "Journalist"),
        Profile("Ethan", "Mechanical Engineer"),
        Profile("Charlotte", "Nurse"),
        Profile("Oliver", "Photographer"),
        Profile("Amelia", "Researcher")
    )
}

@Composable
fun ProfileCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {

        getDummyProfiles().forEach {

                Card(
                    elevation = 20.dp, modifier = Modifier
                        .background(color = Color.DarkGray)
                        .padding(16.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(30.dp))


                        .fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Start
                        //  verticalAlignment = Alignment.CenterVertically
                    ) {

                    Image(

                        painter = painterResource(id = R.drawable.user),
                contentDescription = "image user",
               alignment = Alignment.CenterStart
             ,  modifier = Modifier.padding(15.dp)
                            .size(50.dp))


                    Column(modifier = Modifier.padding(16.dp) , horizontalAlignment = Alignment.Start) {
                        Text(text = it.name, fontSize = 25.sp)
                        Text(text = it.job, fontSize = 20.sp)

                    }

                }
            }
        }
    }
}

@Preview
@Composable
fun Show() {
    ProfileCard()
}



