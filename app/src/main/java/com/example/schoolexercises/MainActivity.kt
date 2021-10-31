package com.example.schoolexercises

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.schoolexercises.ui.theme.SchoolExercisesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myViewModel: ExercisesViewModel by viewModels()
        setContent {
            SchoolExercisesTheme{
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyApp(
                        myViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun MyApp(
    myViewModel: ExercisesViewModel
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "selectExercise") {
        composable(route = "selectExercise") { SelectExercise(myViewModel) { destination -> navController.navigate(destination) } }
        composable(route = "showExercise") { ShowExercise(myViewModel) }
    }
}