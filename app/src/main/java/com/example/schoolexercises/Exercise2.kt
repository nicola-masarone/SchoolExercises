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
fun RunExercise2(
    setAdd1Val: (add1Val: String, index1: Int ) -> Unit,
    add1Val: String,
    setAdd2Val: (add2Val: String, index2: Int ) -> Unit,
    add2Val: String,
    setOutputText: (outputText: String, index: Int) -> Unit,
    outputText: String
) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            fontSize = 16.sp,
            text =
            """
                Esercizio: inserire due valori interi e visualizzarne la somma.
                Inserire prima i due addendi nelle relative caselle e poi premere il tasto Play.
                """.trimIndent(),
            modifier = Modifier.padding(vertical = 10.dp)
        )

        OutlinedTextField(
            value = add1Val,
            onValueChange = { setAdd1Val(it, 0) },
            label = { Text("Addendo 1") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = add2Val,
            onValueChange = { setAdd2Val(it, 1) },
            label = { Text("Addendo 2") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            enabled = add1Val.isDigitsOnly() && add1Val!="" && add2Val.isDigitsOnly() && add2Val!="",
            onClick = {
                setOutputText((add1Val.toInt() + add2Val.toInt()).toString(), 2)
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

