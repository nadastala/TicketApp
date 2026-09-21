package com.example.ticketapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat
import java.util.Locale

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    TicketScreen()
                }
            }
        }
    }
}

@Composable
fun TicketScreen() {

    val hargaTiket = 25000

    var jumlahTiket by remember {
        mutableStateOf(1)
    }

    val totalBayar = hargaTiket * jumlahTiket

    val formatRupiah =
        NumberFormat.getNumberInstance(Locale("id", "ID"))

    val hargaText =
        "Rp${formatRupiah.format(hargaTiket)}"

    val totalText =
        "Rp${formatRupiah.format(totalBayar)}"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "🎟",
            fontSize = 42.sp
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Pemesanan Tiket",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Pesan tiket dengan mudah!",
            fontSize = 14.sp
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Harga Tiket",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = hargaText,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "per tiket"
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Jumlah Tiket",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {

            Button(
                onClick = {
                    if (jumlahTiket > 1) {
                        jumlahTiket--
                    }
                },
                shape = RoundedCornerShape(50),
                modifier = Modifier.width(64.dp)
            ) {
                Text(
                    text = "−",
                    fontSize = 24.sp
                )
            }

            Text(
                text = jumlahTiket.toString(),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    horizontal = 28.dp
                )
            )

            Button(
                onClick = {
                    jumlahTiket++
                },
                shape = RoundedCornerShape(50),
                modifier = Modifier.width(64.dp)
            ) {
                Text(
                    text = "+",
                    fontSize = 24.sp
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Text(
            text = "Total",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = totalText,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF087A3B)
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {
                jumlahTiket = 1
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE53935)
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("↻  RESET")
        }
    }
}