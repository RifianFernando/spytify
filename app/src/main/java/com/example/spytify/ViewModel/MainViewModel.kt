package com.example.spytify.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spytify.Domain.repository.SongRepository
import com.example.spytify.Storage.Song.Song
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: SongRepository
): ViewModel() {
    private val _songs = MutableLiveData<List<Song>>()
    init {
        loadData()
    }
    val songs: LiveData<List<Song>> get() = _songs

    private fun loadData() {
        viewModelScope.launch {
            val result = repository.getListItems()
            _songs.value = result
        }
    }
}