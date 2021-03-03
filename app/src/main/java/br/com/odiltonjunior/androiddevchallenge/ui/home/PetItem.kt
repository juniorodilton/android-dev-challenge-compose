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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.odiltonjunior.androiddevchallenge.data.Pet
import br.com.odiltonjunior.androiddevchallenge.data.Store
import br.com.odiltonjunior.androiddevchallenge.util.ThemedPreview

@Composable
fun PetItem(data: Pet, onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick.invoke() },
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.background(color = Color.LightGray)
        ) {
            Photo(petData = data)
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = data.name,
                    modifier = Modifier
                        .padding(4.dp),
                    color = MaterialTheme.colors.primary,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
                )
                Text(
                    text = data.shortDescription!!,
                    modifier = Modifier
                        .padding(4.dp),
                    color = Color.Gray,
                    style = TextStyle(fontStyle = FontStyle.Italic, fontSize = 12.sp)
                )
            }
        }
    }
}

@Composable
fun Photo(petData: Pet) {
    Surface(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Image(
            bitmap = petData.bitmap.asImageBitmap(),
            contentDescription = petData.name,
            modifier = Modifier
                .requiredSize(100.dp),
            contentScale = ContentScale.FillWidth
        )
    }
}

@Preview("PetItem")
@Composable
fun PetItemPreview() {
    ThemedPreview {
        Surface {
            Store(LocalContext.current).getPet("pet1")?.let {
                PetItem(
                    data = it,
                    onClick = {}
                )
            }
        }
    }
}
