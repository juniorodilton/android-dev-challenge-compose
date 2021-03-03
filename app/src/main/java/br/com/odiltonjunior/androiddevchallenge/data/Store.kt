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

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class Store(context: Context) {
    private val mContext = context
    private var mPetList = mutableListOf<Pet>()
    private val mJsonValue = getJsonValue()
    private val mDescriptionList = getArray("descriptions")
    private val mShortDescriptionList = getArray("shortDescriptions")
    private val mBreedList = getArray("breeds")
    private val mNameList = getArray("names")
    private var mImageList = getImageList()

    private fun getArray(name: String): Array<Any> =
        mJsonValue.getJSONArray(name).asArray()

    private fun getJsonValue(): JSONObject {
        val inputStream: InputStream = mContext.assets.open("values.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val myJson = String(buffer)
        return JSONObject(myJson)
    }

    private fun getImageList(): MutableList<Bitmap> {
        val imageList = mContext.assets.list("photos")
        var inputStream: InputStream
        val bitmapList = emptyList<Bitmap>().toMutableList()
        imageList?.forEach {
            try {
                inputStream = mContext.assets.open("photos/$it")
                val bitmap = BitmapFactory.decodeStream(inputStream)
                bitmapList.add(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return bitmapList
    }

    private fun JSONArray.asArray(): Array<Any> {
        return Array(this.length()) { this[it] }
    }

    init {
        for (i in 1..10) {
            mPetList.add(
                Pet(
                    id = "pet$i",
                    name = mNameList.random() as String,
                    petType = PetType.Dog,
                    sex = Sex.values().random(),
                    breed = mBreedList.random() as String,
                    shortDescription = mShortDescriptionList.random() as String,
                    description = mDescriptionList.random() as String,
                    bitmap = mImageList.random()
                )
            )
        }
    }

    fun getPetList(): List<Pet> = mPetList.toList()

    fun getPet(petId: String) = mPetList.find { it.id == petId }
}
