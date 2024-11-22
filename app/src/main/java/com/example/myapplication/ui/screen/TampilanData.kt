package com.example.myapplication.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.Mahasiswa
import com.example.myapplication.model.RencanaStudi

@Composable
fun TampilanData(
    mahasiswa: Mahasiswa,
    rencanaStudi: RencanaStudi
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Data Mahasiswa", style = androidx.compose.material3.MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        TampilData(
            judul = "NIM",
            isinya = mahasiswa.nim // untuk menampilkan nim
        )
        TampilData(
            judul = "Nama",
            isinya = mahasiswa.nama // untuk menampilkan data nama mahasiswa
        )
        TampilData(
            judul = "Email",
            isinya = mahasiswa.email //untuk menampilkan data email mahasiswa
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Rencana Studi", style = androidx.compose.material3.MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        TampilData(
            judul = "Mata Kuliah",
            isinya = rencanaStudi.mataKuliah
        )
        TampilData(
            judul = "Kelas",
            isinya = rencanaStudi.kelas
        )
    }
}

