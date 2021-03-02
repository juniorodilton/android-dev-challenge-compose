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
package br.com.odiltonjunior.androiddevchallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Expanded(desc: String, content: @Composable ColumnScope.() -> Unit) {
    val expanded = remember { mutableStateOf(true) }
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier.clickable {
            expanded.value = !expanded.value
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(end = 30.dp)
                .background(Color.Gray)
        )
        Box(
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = desc,
                modifier = Modifier
                    .background(Color.White)
                    .padding(4.dp, 0.dp),
                fontSize = 20.sp
            )
        }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
            if (expanded.value) {
                Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "arrow")
            } else {
                Icon(imageVector = Icons.Filled.ArrowRight, contentDescription = "arrow")
            }
        }
    }
    if (expanded.value) {
        ColumnScope.content()
    }
}
