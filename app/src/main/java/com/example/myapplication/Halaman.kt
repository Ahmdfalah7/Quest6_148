package com.example.myapplication

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.screen.MahasiswaFormView
import com.example.myapplication.ui.screen.RencanaStudiView
import com.example.myapplication.ui.screen.SplashView
import com.example.myapplication.ui.screen.TampilanData
import com.example.myapplication.ui.viewModel.MahasiswaViewModel
import com.example.myapplication.ui.viewModel.RencanaStudyViewModel
import androidx.compose.ui.Modifier


enum class Halaman {
    Splash,
    Mahasiswa,
    Matakuliah,
    TampilanData
}

@Composable
fun Navigasi(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value
    val rencanaStudyUiState = krsViewModel.krsStateUi.collectAsState().value

    NavHost(
        modifier = modifier.padding(),
        navController = navController,
        startDestination = Halaman.Splash.name
    ) {
        composable(route = Halaman.Splash.name) {
            SplashView(onMulaiButton = {
                navController.navigate(Halaman.Mahasiswa.name)
            })
        }
        composable(route = Halaman.Mahasiswa.name) {
            MahasiswaFormView(
                onSubmitButtonClicked = {
                    mahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.Matakuliah.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.Matakuliah.name) {
            RencanaStudiView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = {
                    krsViewModel.saveDataKRS(it)
                    navController.navigate(Halaman.TampilanData.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.TampilanData.name) {
            TampilanData(
                mahasiswa = mahasiswaUiState,
                rencanaStudi = rencanaStudyUiState
            )
        }
    }
}
