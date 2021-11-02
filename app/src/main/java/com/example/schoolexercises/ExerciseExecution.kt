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
            {myAdd1Val, index1 -> myViewModel.setValArray(myAdd1Val, index1) },
            add1Val = paramArray!![0],
            {myAdd2Val, index2 -> myViewModel.setValArray(myAdd2Val, index2) },
            add2Val = paramArray!![1],
            {myText, index -> myViewModel.setValArray(myText, index)},
            outputText = paramArray!![2]
        )

        ExercisesViewModel.Exercise.EX12 -> RunExercise12(
            {nVal, index -> myViewModel.setValArray(nVal, index)},
            nVal = paramArray!![0],
            {myText, index -> myViewModel.setValArray(myText, index)},
            outputText = paramArray!![1]
        )

        else -> { }
    }

}
