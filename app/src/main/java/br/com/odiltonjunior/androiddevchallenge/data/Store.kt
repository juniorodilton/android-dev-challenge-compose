package br.com.odiltonjunior.androiddevchallenge.data

import br.com.odiltonjunior.androiddevchallenge.R

object Store {
    private var mPetList = mutableListOf<Pet>()

    init {
        val pet1 = Pet(
            id = "pet1",
            name = "Jujuba",
            petType = PetType.Dog,
            sex = Sex.Female,
            breed = "Pincher",
            shortDescription = "Uma cadelinha bem bonita!",
            description = "Uma cadelinha de 5 anos bem feliz e alegre!",
            imageURL = "fotoaqui",
            image = R.mipmap.dog1
        )

        val pet2 = Pet(
            id = "pet2",
            name = "Dumbo",
            petType = PetType.Dog,
            sex = Sex.Male,
            breed = "Husky",
            shortDescription = "Um cachorro lindão!",
            description = "Um cachorro que vai te trazer muita felicidade",
            imageURL = "fotoaqui",
            image = R.mipmap.dog2
        )

        val pet3 = Pet(
            id = "pet3",
            name = "Snowball",
            petType = PetType.Cat,
            sex = Sex.Male,
            breed = "Amarelo",
            shortDescription = "Um gato, apenas.",
            description = "Come, dorme e peida.",
            imageURL = "fotoaqui",
            image = R.mipmap.dog3
        )

        val pet4 = Pet(
            id = "pet4",
            name = "Ketty",
            petType = PetType.Cat,
            sex = Sex.Female,
            breed = "Laranja",
            shortDescription = "Um gato, apenas.",
            description = "Come, dorme e peida.",
            imageURL = "fotoaqui",
            image = R.mipmap.dog4
        )

        val pet5 = Pet(
            id = "pet5",
            name = "Caramelo",
            petType = PetType.Dog,
            sex = Sex.Male,
            breed = "Caramelo",
            shortDescription = "Melhor cachorro do mundo!",
            description = "BRASIL!",
            imageURL = "fotoaqui",
            image = R.mipmap.dog5
        )

        mPetList.addAll(
            listOf(
                pet1,
                pet2,
                pet3,
                pet4,
                pet5,
                pet1.copy(id = "pet6", image = R.mipmap.dog6),
                pet2.copy(id = "pet7", image = R.mipmap.dog7),
                pet3.copy(id = "pet8", image = R.mipmap.dog8),
                pet4.copy(id = "pet9", image = R.mipmap.dog9),
                pet5.copy(id = "pet10", image = R.mipmap.dog10)
            )
        )
    }

    fun getPetList(): List<Pet> = mPetList.toList()

    fun getPet(petId: String) = mPetList.find { it.id == petId }
}