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
package br.com.odiltonjunior.androiddevchallenge.data

import android.graphics.Bitmap
import androidx.annotation.DrawableRes

data class Pet(
    val id: String,
    val name: String,
    val petType: PetType = PetType.Dog,
    val sex: Sex = Sex.Male,
    val breed: String?,
    val shortDescription: String? = null,
    val description: String? = null,
    val imageURL: String? = null,
    @DrawableRes val image: Int? = null,
    val bitmap: Bitmap
)

enum class PetType {
    Dog,
    Cat
}

enum class Sex {
    Male,
    Female
}
