package com.example.schoolexercises

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun SelectExercise( myViewModel: ExercisesViewModel = ExercisesViewModel(), navigateToDestination: (String) -> Unit = {"destination"}) {

    val exerciseSelection: ExercisesViewModel.Exercise by myViewModel.selectedExercise.observeAsState(initial = ExercisesViewModel.Exercise.NONE)
    //val nValue: ExercisesViewModel.


    myViewModel.resetViewData()

    Column() {
        Text(
            fontSize = 16.sp,
            text =
            """
                Benvenuti nell'app Esercizi di Informatica.
                Selezionate un esercizio tra quelli elencati
                e buon divertimento!
                """.trimIndent(),
            modifier = Modifier
                .padding(10.dp)
                .weight(1F)
        )

        Box(modifier = Modifier.weight(2F)) {
            ShowExercises(
                exerciseSelection,
                { exercise -> myViewModel.setSelectedEx(exercise) },
                { destination -> navigateToDestination(destination) }
            )
        }

    }

}


@Composable
fun ShowExercises(
    selectedExercise: ExercisesViewModel.Exercise,
    setSelectedExercise: (exercise: ExercisesViewModel.Exercise) -> Unit,
    navigateToDestination: (String) -> Unit
) {
    val exercises = mutableListOf(ExercisesViewModel.Exercise.EX1)
    exercises.add(ExercisesViewModel.Exercise.EX2)
    exercises.add(ExercisesViewModel.Exercise.EX3)
    exercises.add(ExercisesViewModel.Exercise.EX12)


    LazyColumn {
        items(exercises.size) { index ->
            ExerciseRow(
                exercises[index],
                selectedExercise,
                { exercise -> setSelectedExercise(exercise) },
                { destination -> navigateToDestination(destination) }
            )
        }
    }
}


@Composable
fun ExerciseRow(
    exercise: ExercisesViewModel.Exercise,
    selectedExercise: ExercisesViewModel.Exercise,
    setSelectedExercise: (exercise: ExercisesViewModel.Exercise) -> Unit,
    navigateToDestination: (String) -> Unit
) {
    Row (modifier = Modifier
        .selectable(
            selected = (exercise == selectedExercise),
            onClick = {
                setSelectedExercise(exercise)
                navigateToDestination("showExercise")
            }
        )
    ) {
        Text(
            text = when (exercise) {
                ExercisesViewModel.Exercise.EX1 -> "Visualizza la scritta \"Ciao\""
                ExercisesViewModel.Exercise.EX2 -> "Esercizio 2"
                ExercisesViewModel.Exercise.EX3 -> "Esercizio 3"
                ExercisesViewModel.Exercise.EX12 -> "Inserito un valore intero positivo N, visualizzare i valori interi da 1 a N"
                else -> ""
            },
            modifier = Modifier
                .weight(5F)
                .align(Alignment.CenterVertically)
                .padding(horizontal = 10.dp, vertical = 5.dp),
            fontSize = 14.sp
        )
    }
}