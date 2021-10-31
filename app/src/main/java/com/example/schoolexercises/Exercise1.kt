package com.example.schoolexercises

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RunExercise1(
    setOutputText: (outputText:String) -> Unit,
    outputText: String
) {
    Column(modifier = Modifier.padding(10.dp)) {
        Text(
            fontSize = 16.sp,
            text =
            """
                Esercizio: visualizza Ciao.
                Obiettivo di questo programma è mostrare la scritta "Ciao".
                Per l'esecuzione premere il tasto Play
                """.trimIndent(),
            modifier = Modifier.padding(vertical = 10.dp)
        )

        Button(
            enabled = true,
            onClick = { setOutputText("Ciao") },
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
