package com.example.spytify.Activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spytify.Adapter.SongAdapter
import com.example.spytify.R
import dagger.hilt.android.AndroidEntryPoint

//import androidx.hilt.navigation.compose.hiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var songAdapter: SongAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.songListRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        songAdapter = SongAdapter(emptyList())
        recyclerView.adapter = songAdapter

        // Observe the songs from the ViewModel
        // Use ViewModel provided by Hilt
//        val viewModel: MainViewModel by viewModels()
//        val viewModel = hiltViewModel<MyViewModel>()
//        viewModel.songs.observe(this) { songs ->
//            // Update the adapter when the song list changes
//            songAdapter.updateSongs(songs)
//        }

        // Edge-to-edge UI setup
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}