package com.example.ricknmorty_compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ricknmorty_compose.ui.main.ui.RickList
import com.example.ricknmorty_compose.ui.main.viewModel.ListViewModel
import com.example.ricknmorty_compose.ui.theme.RickNMortyComposeTheme
import com.example.ricknmorty_compose.utils.ApiResponse
import com.ogie.printfultest.model.RickMorty
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val listViewModel: ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickNMortyComposeTheme {
                val listState by listViewModel.rickAndMortyListState.observeAsState(ApiResponse.Loading())

                Scaffold(modifier = Modifier.fillMaxSize()) {
                    when (listState) {
                        is ApiResponse.Loading -> {
                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                CircularProgressIndicator()
                            }
                        }
                        is ApiResponse.Success -> {
                            RickList((listState as ApiResponse.Success).data.rickMorties) {
                                Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
                            }
                        }
                        is ApiResponse.Failure -> {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp), contentAlignment = Alignment.Center
                            ) {
                                Text((listState as ApiResponse.Failure).message)
                            }
                        }
                    }


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickNMortyComposeTheme {
        Greeting("Android")
    }
}