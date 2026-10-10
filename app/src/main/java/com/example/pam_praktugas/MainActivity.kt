package com.example.pam_praktugas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pam_praktugas.ui.theme.PAM_PrakTugasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PAM_PrakTugasTheme {
                TugasLayoutApp()
            }
        }
    }
}

data class Mahasiswa(
    val namaResId: Int,
    val telpResId: Int,
    val alamatResId: Int,
    val warnaBackground: Color
)

@Composable
fun TugasLayoutApp() {
    val listMahasiswa = listOf(
        Mahasiswa(R.string.nama_1, R.string.telp_1, R.string.alamat_1, colorResource(id = R.color.card_grey)),
        Mahasiswa(R.string.nama_2, R.string.telp_2, R.string.alamat_2, colorResource(id = R.color.card_purple)),
        Mahasiswa(R.string.nama_3, R.string.telp_3, R.string.alamat_3, colorResource(id = R.color.card_blue)),
        Mahasiswa(R.string.nama_4, R.string.telp_4, R.string.alamat_4, colorResource(id = R.color.card_green))
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.white)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            HeaderSection()

            Spacer(modifier = Modifier.height(24.dp))

            listMahasiswa.forEach { mahasiswa ->
                StudentCard(mahasiswa = mahasiswa)
                Spacer(modifier = Modifier.height(12.dp))
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = stringResource(id = R.string.copyright),
                color = Color.Black,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun HeaderSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(id = R.string.header_title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = stringResource(id = R.string.header_subtitle),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
fun StudentCard(mahasiswa: Mahasiswa) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = mahasiswa.warnaBackground)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo_umy),
                contentDescription = "Logo Kiri",
                modifier = Modifier.size(56.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = stringResource(id = mahasiswa.namaResId),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(id = mahasiswa.telpResId),
                    color = colorResource(id = R.color.text_cyan),
                    fontSize = 12.sp
                )
                Text(
                    text = stringResource(id = mahasiswa.alamatResId),
                    color = colorResource(id = R.color.text_yellow),
                    fontSize = 12.sp
                )
            }

            Image(
                painter = painterResource(id = R.drawable.logo_umy),
                contentDescription = "Logo Kanan",
                modifier = Modifier.size(56.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTugas() {
    PAM_PrakTugasTheme {
        TugasLayoutApp()
    }
}