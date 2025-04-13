package com.example.spytify


import com.example.spytify.Data.Repository.SongRepositoryImpl
import com.example.spytify.Storage.Song.Song
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class MainRepositoryUnitTest {

    @Test
    fun `getListItems should return correct number of songs`() = runBlocking {
        val repository = SongRepositoryImpl()
        val songs: List<Song> = repository.getListItems()

        // Assert the expected number of songs
        assertEquals(8, songs.size)

        // Optional: check content of first song
        assertEquals("Lagu 1", songs[0].songTitle)
        assertEquals("album_1", songs[0].thumbnail)
        assertEquals("Rifian F.", songs[0].artistName)
        assertEquals("World Championship", songs[0].albumName)
    }
}