package com.example.app.ui.screens

import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.app.ui.TextComponent
import com.example.app.ui.TopBar
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app.ui.ButtonComponent
import com.example.app.ui.FactComposable
import com.example.app.ui.FactsViewModel
import com.example.app.ui.TextWithShadow
import androidx.navigation.NavController
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment

@Composable
fun WelcomeScreen(navController: NavController, userName: String?, animalSelected: String?){
    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)
        ){
            TopBar(value = "Welcome $userName \uD83D\uDE0D")

            TextComponent(textValue = "Thank you for sharing your data", textSize = 24.sp)
            Spacer(modifier = Modifier.size(60.dp))

            val finalText = if(animalSelected=="Cat") "You are Cat Lover!\uD83D\uDC31" else "you are a Dog Lover!\uD83D\uDC36"
            TextWithShadow(value = finalText)
            val factsViewModel:FactsViewModel= viewModel()
            FactComposable(value = factsViewModel.generateRandomFact(animalSelected!!))

            Spacer(modifier = Modifier.weight(1f))
            Button( onClick = { navController.popBackStack() }) {
                Text("Back")
            }
        }
    }
}

//
