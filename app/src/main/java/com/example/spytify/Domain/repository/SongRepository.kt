package com.example.spytify.Domain.repository

import com.example.spytify.Storage.Song.Song

interface SongRepository {
    fun getListItems(): List<Song>
}