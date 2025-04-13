package com.example.spytify.Data.Repository

import com.example.spytify.Domain.repository.MainRepository
import com.example.spytify.Storage.Song.Song
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor() : MainRepository {

    // Declare 'items' as a class-level property
    private val items = listOf(
        Song("album_1", "Lagu 1", "Rifian F.", "World Championship"),
        Song("album_2", "Lagu 2", "Adelle", "Sad Songs 2025"),
        Song("album_3", "Lagu 3", "test3", "Funny Songs 2025"),
        Song("album_4", "Lagu 4", "test3", "Funny Songs 2025"),
        Song("album_5", "Lagu 5", "test3", "Funny Songs 2025"),
        Song("album_1", "Lagu 1", "test3", "Funny Songs 2025"),
        Song("album_2", "Lagu 2", "test3", "Funny Songs 2025"),
        Song("album_3", "Lagu 3", "test3", "Funny Songs 2025")
    )

    override fun getListItems(): List<Song> {
        return items
    }
}