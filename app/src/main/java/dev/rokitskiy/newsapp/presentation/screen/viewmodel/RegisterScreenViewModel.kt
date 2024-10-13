package dev.rokitskiy.newsapp.presentation.screen.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dev.rokitskiy.newsapp.presentation.navigation.Screen
import dev.rokitskiy.newsapp.presentation.screen.state.RegisterScreenEvent
import dev.rokitskiy.newsapp.presentation.screen.state.RegisterScreenState

class RegisterScreenViewModel: ViewModel() {
    var state by mutableStateOf(RegisterScreenState())
        private set

    fun onEvent(event: RegisterScreenEvent){
        when(event){
            is RegisterScreenEvent.UsernameUpdated -> state = state.copy(username = event.newUsername)
            is RegisterScreenEvent.EmailUpdated -> state = state.copy(email = event.newEmail)
            is RegisterScreenEvent.PasswordUpdated -> state = state.copy(password = event.newPassword)
        }

    }
}