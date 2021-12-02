package com.example.individualassignmentux

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.individualassignmentux.ui.theme.IndividualAssignmentUXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IndividualAssignmentUXTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
private fun MyApp() {
    val currentWord = Word("Further")
    MakeKeyboard(currentWord)}

@Composable
private fun MakeKeyboard(word: Word) {
    var status: GameState by remember {
        mutableStateOf(App.game.gameState)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth(1f)) {
        if (status == GameState.SPIN) {
            Text(text = "We are ready for your spin!", fontSize = 30.sp, color = Color.Green)
        }
        else {
            Text(text = "Please guess a consonant", fontSize = 30.sp, color = Color.Green)
        }
    }
    Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .padding(5.dp)
        .fillMaxSize(1f)) {
        MakeWord(word = word)
        Button(onClick = {
                         if (App.game.gameState == GameState.SPIN) {
                             App.game.gameState = GameState.GUESS
                             status = App.game.gameState
                         }
        },
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp)) {
            Text(text = "Change State!")
        }
        Row(modifier = Modifier.padding(5.dp)) {
            MakeLetter(letter = "B")
            MakeLetter(letter = "C")
            MakeLetter(letter = "D")
            MakeLetter(letter = "F")
            MakeLetter(letter = "G")
            MakeLetter(letter = "H")
            MakeLetter(letter = "J")
        }
        Row(modifier = Modifier.padding(5.dp)) {
            MakeLetter(letter = "K")
            MakeLetter(letter = "L")
            MakeLetter(letter = "M")
            MakeLetter(letter = "N")
            MakeLetter(letter = "P")
            MakeLetter(letter = "Q")
            MakeLetter(letter = "R")
        }
        Row(modifier = Modifier.padding(5.dp)) {
            MakeLetter(letter = "S")
            MakeLetter(letter = "T")
            MakeLetter(letter = "V")
            MakeLetter(letter = "W")
            MakeLetter(letter = "X")
            MakeLetter(letter = "Z")
        }
    }
}

@Composable
fun MakeLetter(letter: String, gameState: GameState) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .border(2.dp, Color.Green)
        .width(35.dp)
        .height(35.dp)){
        Text(text = letter)
    }
}

@Composable
fun MakeWord(word: Word) {
    Row(modifier = Modifier
        .fillMaxWidth(1f)
        .padding(10.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        for (i in 0 until word.charList.size) {
            Letter(word.charList[i])
        }
    }
}

@Composable
fun Letter(letter: Letter) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .border(2.dp, Color.Green)
        .width(35.dp)
        .height(35.dp)){
        if (letter.isShown) {
            Text(text = letter.char.toString())
        } else {
            Text(text = "_")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KeyboardPreview() {
    IndividualAssignmentUXTheme {
        MyApp()
    }
}

