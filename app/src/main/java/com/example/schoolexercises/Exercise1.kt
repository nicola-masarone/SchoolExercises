package com.example.schoolexercises

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun ShowRunExercise1() {
    val output = remember { mutableStateOf("") }

    RunExercise1(
        { outputText, index -> when (index) {
            0 -> output.value = outputText
        }
        },
        output.value
    )
}

@Composable
fun RunExercise1(
    setOutputText: (outputText:String, index: Int) -> Unit,
    outputText: String
) {
    Column(modifier = Modifier.padding(10.dp)) {
        Box(modifier = Modifier
            .background(Color(0x80ffe0b2), RoundedCornerShape(16.dp))
            .padding(10.dp)
            .fillMaxWidth()
        ) {
            Text(
                fontSize = 16.sp,
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) { append("Esercizio: visualizza ") }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )
                    ) { append("Ciao\n") }
                    append("Obiettivo di questo programma è mostrare la scritta ")
                    withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) { append("Ciao\n") }
                    append("Per l'esecuzione premere il tasto Play.")
                },
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }

        Button(
            enabled = true,
            onClick = { setOutputText(evalResult(), 0) },
            modifier = Modifier.padding(vertical = 10.dp)
        ) { Text(text = "Play") }

        Text(
            modifier = Modifier
                .weight(1F, fill = true)
                .padding(vertical = 10.dp)
                .fillMaxWidth()
                .background(color = Color.Black)
                .offset(x = 5.dp),
            color = Color.Green,
            text = outputText,
            fontSize = 20.sp
        )
    }
}

private fun evalResult(): String {
    return "Ciao"
}