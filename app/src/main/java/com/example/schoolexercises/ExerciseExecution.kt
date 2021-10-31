package com.example.schoolexercises

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShowExercise(myViewModel: ExercisesViewModel) {

    val outputText: String by myViewModel.outputText.observeAsState(initial = "")
    val nValue: String by myViewModel.nValue.observeAsState(initial = "")

    when(myViewModel.selectedExercise.value) {

        ExercisesViewModel.Exercise.EX1 -> RunExercise1(
            {myText -> myViewModel.setOutputText(myText)},
            outputText = outputText
        )

        ExercisesViewModel.Exercise.EX2 -> RunExercise2()


        ExercisesViewModel.Exercise.EX12 -> RunExercise12(
            {myValue -> myViewModel.setNValue(myValue)},
            nVal = nValue,
            {textOutput -> myViewModel.setOutputText(textOutput)},
            outputText = outputText
        )
        else -> { }

    }

}
