package com.example.schoolexercises

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly

@Composable
fun RunExercise12(
    setNValue: (nValue: String, index: Int ) -> Unit,
    nVal: String,
    setOutputText: (outputText: String, indexOut: Int) -> Unit,
    outputText: String
) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            fontSize = 16.sp,
            text =
            """
                Esercizio: Inserito un valore N, visualizzare i valori da 1 a N.
                Inserire prima il valore N nella relativa casella e poi premere il tasto Play.
                """.trimIndent(),
            modifier = Modifier.padding(vertical = 10.dp)
        )

        OutlinedTextField(
            value = nVal,
            onValueChange = { setNValue(it, 0) },
            label = { Text("N") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            enabled = nVal.isDigitsOnly() && nVal!="",
            onClick = {
                var evalText = ""
                var i = 0
                while (i < nVal.toInt()) {
                    i++
                    evalText = if (evalText == "")
                        i.toString()
                    else
                        evalText + "\n" + i.toString()
                }
                setOutputText(evalText, 1)
            },
            modifier = Modifier.padding(vertical = 10.dp)
        ) { Text(text = "Play") }

        Text(
            modifier = Modifier
                .weight(1F, fill = true)
                .padding(vertical = 10.dp)
                .fillMaxWidth()
                .background(color = Color.Black)
                .offset(x = 5.dp)
                .verticalScroll(rememberScrollState()),
            color = Color.Green,
            text = outputText,
            fontSize = 20.sp
        )
    }
}