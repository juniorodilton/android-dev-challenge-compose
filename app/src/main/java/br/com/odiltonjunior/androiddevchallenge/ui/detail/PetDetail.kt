/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.odiltonjunior.androiddevchallenge.ui.detail

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.odiltonjunior.androiddevchallenge.R
import br.com.odiltonjunior.androiddevchallenge.data.Pet
import br.com.odiltonjunior.androiddevchallenge.data.Store
import br.com.odiltonjunior.androiddevchallenge.util.ThemedPreview

@Composable
fun PetDetail(navController: NavController, data: Pet) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Adopt-me")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.app_name)
                        )
                    }
                }
            )
        }
    ) {
        Column(modifier = Modifier.fillMaxHeight()) {
            Row(modifier = Modifier.height(200.dp)) {
                Photo(data)
            }
            Row(modifier = Modifier.padding(8.dp)) {
                PetInfo(data)
            }
            Row(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
                    .fillMaxHeight(),
                verticalAlignment = Alignment.Bottom
            ) {
                AdoptButton()
            }
        }
    }
}

@Composable
private fun AdoptButton() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = { /*TODO*/ }) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.ic_adopt_me),
                    contentDescription = "Logo",
                    Modifier.size(80.dp)
                )
                Text(
                    text = "Adopt",
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
                )
            }
        }
    }
}

@Composable
fun Photo(petData: Pet) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
        elevation = 8.dp
    ) {
        Image(
            painter = painterResource(id = petData.image),
            contentDescription = petData.name,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxSize(),
            alignment = Alignment.Center
        )
    }
}

@Composable
fun PetInfo(petData: Pet) {
    Column(horizontalAlignment = Alignment.Start) {
        Text(
            text = petData.name,
            color = MaterialTheme.colors.primary,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
        )
        Text(
            text = petData.shortDescription!!,
            color = Color.Gray,
            style = TextStyle(fontStyle = FontStyle.Italic, fontSize = 12.sp)
        )
        Row(modifier = Modifier.padding(top = 16.dp)) {
            Column() {
                Text(
                    text = "About-me",
                    color = Color.DarkGray,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                )
                Text(
                    text = petData.description!!,
                    color = Color.Black,
                    style = TextStyle(fontSize = 16.sp),
                    modifier = Modifier
                        .padding(start = 8.dp)
                )
            }
        }
    }
}

@Preview("PetDetail")
@Composable
fun PetDetailPreview() {
    ThemedPreview {
        Surface {
            Store(LocalContext.current).getPet("pet1")?.let {
                PetDetail(
                    navController = rememberNavController(),
                    data = it
                )
            }
        }
    }
}
