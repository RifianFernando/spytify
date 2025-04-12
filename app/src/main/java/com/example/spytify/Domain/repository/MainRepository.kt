package com.example.spytify.Domain.repository

import com.example.spytify.Storage.Song.Song

interface MainRepository {
    suspend fun getListItems(): List<Song>
}