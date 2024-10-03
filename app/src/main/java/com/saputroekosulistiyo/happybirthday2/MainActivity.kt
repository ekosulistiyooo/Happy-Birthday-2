package com.saputroekosulistiyo.happybirthday2
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saputroekosulistiyo.happybirthday2.ui.theme.HappyBirthday2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Menerapkan tema HappyBirthday2Theme
            HappyBirthday2Theme {
                // Surface sebagai kontainer dengan warna latar belakang sesuai dengan tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Memanggil fungsi GreetingImage dengan parameter pesan dan nama pengirim
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_text),
                        from = "From Emma",
                        //modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    // Mengatur tampilan teks ucapan menggunakan kolom dengan perataan vertikal di tengah
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        // Menampilkan pesan ucapan ulang tahun
        Text(
            text = message,
            fontSize = 100.sp,  // Ukuran font besar
            lineHeight = 116.sp,
            textAlign = TextAlign.Center  // Mengatur teks agar berada di tengah secara horizontal
        )
        // Menampilkan nama pengirim
        Text(
            text = from,
            fontSize = 36.sp,  // Ukuran font lebih kecil untuk nama pengirim
            modifier = Modifier
                .padding(16.dp)  // Menambahkan padding di sekitar teks
                .align(alignment = Alignment.CenterHorizontally)  // Perataan horizontal di tengah
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    // Mengambil resource gambar dari drawable
    val image = painterResource(R.drawable.androidparty)
    // Box digunakan untuk menumpuk gambar dan teks
    Box(modifier) {
        // Menampilkan gambar latar belakang dengan sedikit transparansi
        Image(
            painter = image,
            contentDescription = null,  // Tidak ada deskripsi karena gambar hanya dekoratif
            contentScale = ContentScale.Crop,  // Menyesuaikan gambar agar memenuhi kotak yang tersedia
            alpha = 0.5F  // Mengatur transparansi gambar
        )
        // Menampilkan teks ucapan di atas gambar
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()  // Mengatur teks agar memenuhi layar
                .padding(8.dp)  // Menambahkan sedikit padding di sekitar teks
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    // Pratinjau kartu ulang tahun menggunakan tema yang sama
    HappyBirthday2Theme {
        // Menampilkan kartu dengan pesan ucapan ulang tahun dan nama pengirim
        GreetingImage(
            message = stringResource(R.string.happy_birthday_text),
            from = stringResource(R.string.signature_text)
        )
    }
}