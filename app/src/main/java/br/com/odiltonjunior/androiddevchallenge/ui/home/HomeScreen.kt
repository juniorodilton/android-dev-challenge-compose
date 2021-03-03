package br.com.odiltonjunior.androiddevchallenge.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import br.com.odiltonjunior.androiddevchallenge.data.Pet
import br.com.odiltonjunior.androiddevchallenge.data.Store
import br.com.odiltonjunior.androiddevchallenge.ui.detail.PetDetail
import br.com.odiltonjunior.androiddevchallenge.util.ThemedPreview

@Composable
fun PetList(navController: NavController, dataList: List<Pet>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Adopt-me")
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

@Preview("PetList")
@Composable
fun PetListPreview() {
    ThemedPreview {
        Surface {
            Store(LocalContext.current).getPetList()?.let {
                PetList(
                    navController = rememberNavController(),
                    dataList = it
                )
            }
        }
    }
}