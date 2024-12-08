package ru.faimizufarov.yarche.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.faimizufarov.yarche.R
import ru.faimizufarov.yarche.data.models.Name
import ru.faimizufarov.yarche.ui.theme.YarcheTheme

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    helloViewModel: HelloViewModel = hiltViewModel()
) {
    val userName by helloViewModel.userNameText.collectAsState()
    var isDialogOpen by remember { mutableStateOf(false) }
    var dialogText by remember { mutableStateOf(userName) }
    var isError by rememberSaveable { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 12.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    )
                ) {
                    Text("Имя пользователя")
                    Text(userName?: "Незнакомец")
                }
                IconButton(
                    onClick = {
                        dialogText = userName
                        isDialogOpen = true
                    },
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.edit_icon),
                        contentDescription = null,
                        modifier = Modifier
                    )
                }
            }
        }
    }

    if (isDialogOpen) {
        AlertDialog(
            onDismissRequest = { isDialogOpen = false },
            confirmButton = {
                TextButton(onClick = {
                    if (dialogText?.isNotBlank() == true) {
                        helloViewModel.updateUserName(
                            name = Name(
                                id = 0,
                                name = dialogText?: "Незнакомец"
                            )
                        )
                        isDialogOpen = false
                        isError = false
                    } else isError = true

                }) {
                    Text(stringResource(R.string.save))
                }
            },
            dismissButton = {
                TextButton(onClick = { isDialogOpen = false }) {
                    Text(stringResource(R.string.cancel))
                }
            },
            title = { Text(stringResource(R.string.change_name)) },
            text = {
                TextField(
                    value = dialogText?: "Незнакомец",
                    onValueChange = { dialogText = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(stringResource(R.string.change_name))
                    },
                    singleLine = true,
                    isError = isError,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            if (!isError) {
                                keyboardController?.hide()
                                helloViewModel.updateUserName(
                                    name = Name(
                                        id = 0,
                                        name = dialogText?: "Незнакомец"
                                    )
                                )
                                isDialogOpen = false
                            }
                        }
                    ),
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent
                    )
                )
            }
        )
    }
}

@Preview
@Composable
fun PreviewSettingsScreen() {
    YarcheTheme {
        SettingsScreen()
    }
}