package br.com.odiltonjunior.androiddevchallenge

import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import br.com.odiltonjunior.androiddevchallenge.data.Store
import br.com.odiltonjunior.androiddevchallenge.ui.detail.PetDetail
import br.com.odiltonjunior.androiddevchallenge.ui.home.PetList
import br.com.odiltonjunior.androiddevchallenge.ui.theme.AdoptMeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdoptMeTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        val navController = rememberNavController()
        val storeValues = Store(LocalContext.current)
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                PetList(navController, storeValues.getPetList())
            }
            composable(
                "detail/{petId}",
                arguments = listOf(navArgument("petId") { type = NavType.StringType })
            ){
                val petId = it.arguments?.getString("petId") ?: ""
                val pet = storeValues.getPet(petId) ?: return@composable
                PetDetail(navController = navController, data = pet)
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    AdoptMeTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    AdoptMeTheme(darkTheme = true) {
        MyApp()
    }
}
