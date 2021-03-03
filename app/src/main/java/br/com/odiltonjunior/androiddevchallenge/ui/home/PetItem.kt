package br.com.odiltonjunior.androiddevchallenge.ui.home

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import br.com.odiltonjunior.androiddevchallenge.data.Pet
import br.com.odiltonjunior.androiddevchallenge.data.Store
import br.com.odiltonjunior.androiddevchallenge.util.ThemedPreview

@Composable
fun PetItem(data: Pet, onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick.invoke() },
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.background(color = Color.LightGray)
        ) {
            Photo(petData = data)
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = data.name,
                    modifier = Modifier
                        .padding(4.dp),
                    color = MaterialTheme.colors.primary,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
                )
                Text(
                    text = data.shortDescription!!,
                    modifier = Modifier
                        .padding(4.dp),
                    color = Color.Gray,
                    style = TextStyle(fontStyle = FontStyle.Italic, fontSize = 12.sp)
                )

            }
        }
    }
}

@Composable
fun Photo(petData: Pet) {
    Surface(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Image(
            painter = painterResource(id = petData.image),
            contentDescription = petData.name,
            modifier = Modifier
                .requiredSize(100.dp),
            contentScale = ContentScale.FillWidth
        )
    }
}


@Preview("PetItem")
@Composable
fun PetItemPreview() {
    ThemedPreview {
        Surface {
            Store(LocalContext.current).getPet("pet1")?.let {
                PetItem(
                    data = it,
                    onClick = {}
                )
            }
        }
    }
}
