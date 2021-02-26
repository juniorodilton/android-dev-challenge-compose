package br.com.odiltonjunior.androiddevchallenge.data

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
    @DrawableRes val image: Int
)

enum class PetType {
    Dog,
    Cat
}

enum class Sex {
    Male,
    Female
}
