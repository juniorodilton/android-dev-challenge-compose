package br.com.odiltonjunior.androiddevchallenge.data

import br.com.odiltonjunior.androiddevchallenge.R

object Store {
    private var mPetList = mutableListOf<Pet>()

    init {
        val pet1 = Pet(
            id = "dc523f0ed25c",
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
            id = "7446d8dfd7dc",
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
            id = "ac552dcc1741",
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
            id = "ac552dcc1722",
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
            id = "ac552dcc1755",
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
                pet1.copy(id = "post6"),
                pet2.copy(id = "post7"),
                pet3.copy(id = "post8"),
                pet4.copy(id = "post9"),
                pet5.copy(id = "post10")
            )
        )
    }

    fun getPetList(): List<Pet> = mPetList.toList()

    fun getPet(petId: String) = mPetList.find { it.id == petId }
}