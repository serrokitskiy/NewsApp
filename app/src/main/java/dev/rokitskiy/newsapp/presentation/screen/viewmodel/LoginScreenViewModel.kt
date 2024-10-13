package dev.rokitskiy.newsapp.presentation.screen.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dev.rokitskiy.newsapp.presentation.screen.state.LoginScreenEvent
import dev.rokitskiy.newsapp.presentation.screen.state.LoginScreenState

class LoginScreenViewModel : ViewModel() {
     var state by mutableStateOf(LoginScreenState())
        private set


    fun onEvent(event: LoginScreenEvent) {
        when (event) {
            is LoginScreenEvent.EmailUpdated -> state = state.copy(email = event.newEmail)
            is LoginScreenEvent.PasswordUpdated -> state = state.copy(password = event.newPassword)
        }
    }

}