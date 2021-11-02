package com.example.schoolexercises

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExercisesViewModel : ViewModel() {

    enum class Exercise {
        EX1,        // Visualizza "Ciao"
        EX2,
        EX3,
        EX12,
        NONE
    }

    private val _selectedExercise = MutableLiveData(Exercise.NONE)
    val selectedExercise: LiveData<Exercise> = _selectedExercise
    fun setSelectedEx (exercise: Exercise) {
        if (exercise!=_selectedExercise.value) {
            _selectedExercise.value = exercise
        }
    }

    // TO BE INVESTIGATED (it seems that the only way to observe Array<String> forcing recomposition
    // is to copy again the whole array, also if we need to change one single array location only)
    private val _valArray =  MutableLiveData<Array<String>>(Array<String>(10, init= {_ -> ""}))
    val valArray: LiveData<Array<String>> = _valArray
    fun setValArray(myText: String, index: Int) {
        if (index< _valArray.value!!.size) {
            _valArray.value!![index] = myText
            _valArray.value = _valArray.value!!.clone()
        }
    }
    // TO BE INVESTIGATED


    fun resetViewData() {
        for (index in valArray.value!!.indices) {
            setValArray("", index = index)
        }
    }
}