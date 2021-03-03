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
package br.com.odiltonjunior.androiddevchallenge.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import br.com.odiltonjunior.androiddevchallenge.data.Pet
import br.com.odiltonjunior.androiddevchallenge.data.Store
import br.com.odiltonjunior.androiddevchallenge.util.ThemedPreview

@Composable
fun PetList(navController: NavController, dataList: List<Pet>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Adopt-me")
                }
            )
        }
    ) {
        LazyColumn(contentPadding = PaddingValues(10.dp)) {
            items(dataList.size) {
                val pet = dataList[it]
                PetItem(data = pet) {
                    navController.navigate("detail/${pet.id}")
                }
            }
        }
    }
}

@Preview("PetList")
@Composable
fun PetListPreview() {
    ThemedPreview {
        Surface {
            Store(LocalContext.current).getPetList()?.let {
                PetList(
                    navController = rememberNavController(),
                    dataList = it
                )
            }
        }
    }
}
