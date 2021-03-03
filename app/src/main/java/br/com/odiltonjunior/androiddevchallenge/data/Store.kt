package br.com.odiltonjunior.androiddevchallenge.data

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
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

    private fun getImageList() : MutableList<Bitmap> {
        val imageList = mContext.assets.list("photos")
        var inputStream: InputStream
        val bitmapList = emptyList<Bitmap>().toMutableList()
        imageList?.forEach {
            try {
                inputStream = mContext.assets.open("photos/$it")
                val bitmap = BitmapFactory.decodeStream(inputStream)
                bitmapList.add(bitmap)
            }
            catch (e: IOException){
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