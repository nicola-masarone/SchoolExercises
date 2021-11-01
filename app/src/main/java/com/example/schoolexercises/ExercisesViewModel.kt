package com.example.schoolexercises

import androidx.compose.runtime.State
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

    private val _outputText = MutableLiveData<String>("")
    val outputText: LiveData<String> = _outputText
    fun setOutputText (myText: String) {
        if (myText!=_outputText.value) {
            _outputText.value = myText
        }
    }

    private val _nValue = MutableLiveData<String>("")
    val nValue: LiveData<String> = _nValue
    fun setNValue(myText: String) {
        if (myText!=_nValue.value) {
            _nValue.value = myText
        }
    }

    // TO BE INVESTIGATED
    private val _valArray =  MutableLiveData<Array<String>>(Array<String>(10, init= {_ -> ""}))
    val valArray: LiveData<Array<String>> = _valArray
    fun setValArray(myText: String, index: Int) {
        if (index< _valArray.value!!.size) {
            val dummyArray = _valArray.value!!.clone()
            dummyArray[index] = myText
            _valArray.value = dummyArray.clone()
        }
    }
    // TO BE INVESTIGATED


    fun resetViewData() {
        setOutputText("")
        setNValue("")

        for (index in valArray.value!!.indices) {
            setValArray("", index = index)
        }

    }
}