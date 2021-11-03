package com.example.schoolexercises

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun ShowExercise(myViewModel: ExercisesViewModel) {
    val paramArray: Array<String>? by myViewModel.valArray.observeAsState()

    when(myViewModel.selectedExercise.value) {

        ExercisesViewModel.Exercise.EX1 -> RunExercise1(
            {myText, index -> myViewModel.setValArray(myText, index)},
            outputText = paramArray!![0]
        )

        ExercisesViewModel.Exercise.EX2 -> RunExercise2(
            {addVal, index -> myViewModel.setValArray(addVal, index) },
            add1Val = paramArray!![0],
            add2Val = paramArray!![1],
            outputText = paramArray!![2]
        )

        ExercisesViewModel.Exercise.EX3 -> RunExercise3(
            {myVal, index -> myViewModel.setValArray(myVal, index) },
            firstVal = paramArray!![0],
            secondVal = paramArray!![1],
            outputText = paramArray!![2]
        )

        ExercisesViewModel.Exercise.EX12 -> RunExercise12(
            {myVal, index -> myViewModel.setValArray(myVal, index)},
            nVal = paramArray!![0],
            outputText = paramArray!![1]
        )

        else -> { }
    }

}
