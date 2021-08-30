package com.example.ricknmorty_compose.ui.main.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ricknmorty_compose.network.repo.INetworkRepository
import com.example.ricknmorty_compose.utils.ApiResponse
import com.ogie.printfultest.model.RickMorty
import com.ogie.printfultest.model.RickMortyResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val repository: INetworkRepository) : ViewModel() {

    private val _rickAndMortyListState = MutableLiveData<ApiResponse<RickMortyResponse>>()
    val rickAndMortyListState: LiveData<ApiResponse<RickMortyResponse>> = _rickAndMortyListState

    private val _rickAndMortyItemState = MutableLiveData<ApiResponse<RickMorty>>()
    val rickAndMortyItemState: LiveData<ApiResponse<RickMorty>> = _rickAndMortyItemState

    init {
        fetchList()
    }

    fun fetchList() {
        _rickAndMortyListState.value = ApiResponse.Loading()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = repository.fetchList()
                _rickAndMortyListState.postValue(data)
            }
        }
    }

    fun fetchItem(id: Int) {
        _rickAndMortyItemState.value = ApiResponse.Loading()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = repository.fetchItem(id)
                _rickAndMortyItemState.postValue(data)
            }
        }
    }

}