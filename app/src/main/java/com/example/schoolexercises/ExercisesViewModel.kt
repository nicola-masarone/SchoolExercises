package com.example.schoolexercises

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExercisesViewModel : ViewModel() {

    enum class Exercise {
        EX1,        // Visualizza "Ciao"
        EX2,
        EX3,
        NONE
    }

    private val _selectedExercise = MutableLiveData(Exercise.NONE)
    val selectedExercise: LiveData<Exercise> = _selectedExercise
    fun setSelectedEx (exercise: Exercise) {
        if (exercise!=_selectedExercise.value) {
            _selectedExercise.value = exercise
        }
    }

    private val _outputText = MutableLiveData<String>("")
    val outputText: LiveData<String> = _outputText
    fun setOutputText (myText: String) {
        if (myText!=_outputText.value) {
            _outputText.value = myText
        }
    }

}