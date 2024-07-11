package com.example.app.ui.screens

import android.nfc.Tag
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.app.data.UserDataUiEvents
import com.example.app.data.UserInputScreenState

class UserInputViewModel: ViewModel() {

    companion object{
        const val TAG ="UserInputViewModel"
    }
    var uiState = mutableStateOf(UserInputScreenState())

        fun onEvent(event:UserDataUiEvents){
            when(event){
                is UserDataUiEvents.UserNameEntered -> {
                    uiState.value = uiState.value.copy(
                        nameEntered = event.name
                    )
                    Log.d(TAG, "onEvent: UserNameEntered ->>")
                    Log.d(TAG, "${uiState.value}")
                }
                is UserDataUiEvents.AnimalSelected ->{
                    uiState.value = uiState.value.copy(
                        animalSelected = event.animalValue
                    )
                    Log.d(TAG, "onEvent: UserNameEntered ->>")
                    Log.d(TAG, "${uiState.value}")
                }
            }
        }

    fun isValidState() : Boolean{
        if (!uiState.value.nameEntered.isNullOrEmpty() && !uiState.value.animalSelected.isNullOrEmpty()){
            return true
        }else{
            return false
        }
    }
}
