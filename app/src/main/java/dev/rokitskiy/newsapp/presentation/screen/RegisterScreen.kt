package dev.rokitskiy.newsapp.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.rokitskiy.newsapp.R
import dev.rokitskiy.newsapp.presentation.navigation.Screen
import dev.rokitskiy.newsapp.presentation.screen.state.LoginScreenEvent
import dev.rokitskiy.newsapp.presentation.screen.state.RegisterScreenEvent
import dev.rokitskiy.newsapp.presentation.screen.state.RegisterScreenState
import dev.rokitskiy.newsapp.presentation.screen.viewmodel.RegisterScreenViewModel
import dev.rokitskiy.newsapp.presentation.ui.component.StyledButton

@Composable
fun RegisterScreen (
    onNavigateTo: (Screen) -> Unit = {}
){
    val viewModel = viewModel<RegisterScreenViewModel>()
    RegisterView(
        onNavigateTo = onNavigateTo,
        state = viewModel.state,
        onEvent = viewModel::onEvent

    )

}

@Composable
fun RegisterView(
    onNavigateTo: (Screen) -> Unit = {},
    state: RegisterScreenState = RegisterScreenState(),
    onEvent: (RegisterScreenEvent) -> Unit = {}
){
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 100.dp)
        )
        OutlinedTextField(
            modifier = Modifier.padding(top = 180.dp),
            value = state.username,
            onValueChange = {
                onEvent(RegisterScreenEvent.UsernameUpdated(it))
            },
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Person),
                    contentDescription = null
                )
            },
            placeholder = {
                Text(text = stringResource(id = R.string.enter_username))
            }
        )
        OutlinedTextField(
            modifier = Modifier.padding(top = 10.dp),
            value = state.email,
            onValueChange = {
                onEvent(RegisterScreenEvent.EmailUpdated(it))
            },
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Email),
                    contentDescription = null
                )
            },
            placeholder = {
                Text(text = stringResource(id = R.string.enter_email))
            }
        )
        OutlinedTextField(
            modifier = Modifier.padding(top = 10.dp),
            value = state.password,
            onValueChange = {
                onEvent(RegisterScreenEvent.PasswordUpdated(it))
            },
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Lock),
                    contentDescription = null
                )
            },
            placeholder = {
                Text(text = stringResource(id = R.string.enter_password))
            }
        )
        StyledButton(
            onClick = { },
            modifier = Modifier.padding(top = 100.dp)
        ) {
            Text(
                text = stringResource(id = R.string.register),
                fontSize = 19.sp
            )

        }
        Text(
            text = stringResource(id = R.string.already_have_account),
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 20.dp)
                .clickable {
                    onNavigateTo(Screen.Login)
                }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun RegisterScreenPreview() {
    RegisterView()
}