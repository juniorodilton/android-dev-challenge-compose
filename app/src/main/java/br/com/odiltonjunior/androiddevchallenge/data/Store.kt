package br.com.odiltonjunior.androiddevchallenge.data

import android.content.Context
import br.com.odiltonjunior.androiddevchallenge.R
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream

class Store(context: Context) {
    private val mContext = context
    private var mPetList = mutableListOf<Pet>()
    private val mJsonValue = getJsonValue()
    private val mDescriptionList = getArray("descriptions")
    private val mShortDescriptionList = getArray("shortDescriptions")
    private val mBreedList = getArray("breeds")
    private val mNameList = getArray("names")

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

    private fun JSONArray.asArray(): Array<Any> {
        return Array(this.length()) { this[it] }
    }

    init {
        for (i in 1..10){
            mPetList.add(
                Pet(
                    id = "pet$i",
                    name = mNameList.random() as String,
                    petType = PetType.Dog,
                    sex = Sex.values().random(),
                    breed = mBreedList.random() as String,
                    shortDescription = mShortDescriptionList.random() as String,
                    description = mDescriptionList.random() as String,
                    imageURL = "fotoaqui",
                    image = R.mipmap.dog1
                )
            )
        }
    }

    fun getPetList(): List<Pet> = mPetList.toList()

    fun getPet(petId: String) = mPetList.find { it.id == petId }
}