package com.example.schoolexercises

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly

@Composable
fun RunExercise3(
    setVal: (myVal: String, index: Int ) -> Unit,
    firstVal: String,
    secondVal: String,
    outputText: String
) {
    Column(modifier = Modifier.padding(10.dp)) {
        Box(
            modifier = Modifier
                .background(Color(0x80ffe0b2), RoundedCornerShape(16.dp))
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(
                fontSize = 16.sp,
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) { append("Esercizio: inserire due valori interi distinti e visualizzare il maggiore\n") }
                    append("Inserire i due valori (diversi tra loro) nelle relative caselle e premere il tasto Play.")
                },
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }

        OutlinedTextField(
            value = firstVal,
            onValueChange = { setVal(it, 0) },
            label = { Text("Primo valore") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = secondVal,
            onValueChange = { setVal(it, 1) },
            label = { Text("Secondo valore") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            enabled = firstVal.isDigitsOnly() && firstVal != "" && secondVal.isDigitsOnly() && secondVal != "" && firstVal!=secondVal,
            onClick = {
                setVal("Il maggiore é: " +
                        if(firstVal.toInt() > secondVal.toInt())
                            firstVal
                        else
                            secondVal,
                    2
                )
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
