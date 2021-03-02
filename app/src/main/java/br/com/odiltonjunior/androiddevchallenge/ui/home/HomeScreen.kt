package br.com.odiltonjunior.androiddevchallenge.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import br.com.odiltonjunior.androiddevchallenge.data.Pet

@Composable
fun PetList(navController: NavController, dataList: List<Pet>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "PetList")
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

@Composable
fun PetItem(data: Pet, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = Modifier
            .padding(bottom = 10.dp)
            .clickable {
                onClick.invoke()
            }
    ) {
        Image(
            painter = painterResource(id = data.image),
            contentDescription = data.name,
            modifier = Modifier
                .requiredHeight(150.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = data.name,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.primary_material_light))
                .padding(4.dp)
        )
    }
}

