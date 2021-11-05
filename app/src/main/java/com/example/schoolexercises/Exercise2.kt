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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly

@Preview(showSystemUi = true)
@Composable
fun ShowRunExercise2() {
    val add1 = remember { mutableStateOf("") }
    val add2 = remember { mutableStateOf("") }
    val output = remember { mutableStateOf("") }

    RunExercise2(
        { addVal, index -> when (index) {
                                0 -> add1.value = addVal
                                1 -> add2.value = addVal
                                2 -> output.value = addVal
                            }
        },
        add1.value,
        add2.value,
        output.value
    )
}

@Composable
fun RunExercise2(
    setVal: (addVal: String, index: Int ) -> Unit,
    add1Val: String,
    add2Val: String,
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
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) { append("Esercizio: inserire due valori interi e visualizzarne la somma\n") }
                    append("Inserire i due addendi nelle relative caselle e premere il tasto Play.")
                },
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }

        OutlinedTextField(
            value = add1Val,
            onValueChange = { setVal(it, 0) },
            label = { Text("Addendo 1") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        OutlinedTextField(
            value = add2Val,
            onValueChange = { setVal(it, 1) },
            label = { Text("Addendo 2") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(
            enabled = add1Val.isDigitsOnly() && add1Val != "" && add2Val.isDigitsOnly() && add2Val != "",
            onClick = { setVal(evalResult(add1Val, add2Val), 2) },
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

private fun evalResult(add1: String, add2: String): String {
    return "La somma é: " + (add1.toInt() + add2.toInt()).toString()
}
