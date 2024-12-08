package ru.faimizufarov.yarche.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ru.faimizufarov.yarche.R
import ru.faimizufarov.yarche.data.models.Name
import ru.faimizufarov.yarche.navigation.NavItems
import ru.faimizufarov.yarche.ui.theme.YarcheTheme

@Composable
fun HelloScreen(
    modifier: Modifier = Modifier,
    helloViewModel: HelloViewModel = hiltViewModel(),
    navController: NavController
) {
    var userName by rememberSaveable { mutableStateOf("") }

    HelloScreenBase(
        modifier = Modifier,
        name = userName,
        onNameChange = { userName = it }
    ) {
        helloViewModel.saveUserName(
            Name(
                id = 0,
                name = userName
            )
        )
        navController.navigate(NavItems.BOTTOM_GRAPH)
    }
}

@Composable
fun HelloScreenBase(
    modifier: Modifier = Modifier,
    name: String,
    onNameChange: (String) -> Unit,
    onStart: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(R.drawable.larisa_picture),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(0.8f),
            contentScale = ContentScale.Crop
        )

        Text(
            text = stringResource(R.string.hello_text),
            modifier = Modifier.padding(
                vertical = 16.dp,
                horizontal = 32.dp
            ),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(
                    bottom = WindowInsets.navigationBars
                        .asPaddingValues()
                        .calculateBottomPadding()
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = name,
                onValueChange = { onNameChange(it) },
                modifier = Modifier
                    .padding(16.dp),
                label = {
                    Text(stringResource(R.string.what_is_your_name))
                },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            Button(
                onClick = { onStart() },
                modifier = Modifier
            ) {
                Text(
                    text = stringResource(R.string.lets_go)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewHelloScreen() {
    YarcheTheme {
        HelloScreenBase(
            name = "check",
            onNameChange = {  },
            onStart = {  }
        )
    }
}