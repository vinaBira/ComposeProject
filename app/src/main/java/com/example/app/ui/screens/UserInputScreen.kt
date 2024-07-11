package com.example.app.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
//import androidx.core.content.pm.ShortcutInfoCompat.Surface
import androidx.compose.material3.Surface
import androidx.compose.ui.unit.dp
import com.example.app.ui.TextComponent
import com.example.app.ui.TopBar
import androidx.compose.ui.unit.sp
import com.example.app.data.UserDataUiEvents
import com.example.app.ui.AnimalCard
import com.example.app.ui.TextFieldComponent
import com.example.app.R
import com.example.app.ui.ButtonComponent

@Composable
fun UserInputScreen(
    userInputViewModel: UserInputViewModel,
    showWelcomeScreen:(userName: String, animalSelected: String) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize()

    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)){
            TopBar("Hi There, \uD83D\uDE0A")
            TextComponent(textValue = "Let's learn about you!", textSize = 24.sp)
            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "This app will prepare details page based on input provided by you",
                textSize = 18.sp)
            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(textValue = "Name", textSize =18.sp )
            Spacer(modifier = Modifier.size(10.dp))
            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            })

            Spacer(modifier = Modifier.size(20.dp))
            TextComponent(textValue = "What do you like", textSize = 18.sp)

            Row(modifier = Modifier.fillMaxWidth()){
                AnimalCard(image = R.drawable.cat, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected=="Cat")
                AnimalCard(image = R.drawable.dog, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )

                }, selected = userInputViewModel.uiState.value.animalSelected=="Dog")
            }

            Spacer(modifier = Modifier.weight(1f))
            if(userInputViewModel.isValidState()){
                ButtonComponent(
                    goToDetailsScreen = {
                        println("--------Coming!")
                        showWelcomeScreen(
                            userInputViewModel.uiState.value.nameEntered,
                            userInputViewModel.uiState.value.animalSelected
                        )

                    }
                )
            }

        }
    }
}
