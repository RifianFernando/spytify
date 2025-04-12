package com.example.spytify.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spytify.R
import com.example.spytify.Storage.Song.Song

class SongAdapter(
    private var items: List<Song>
) : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    inner class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.tvSongName)
        private val artistAlbum: TextView = view.findViewById(R.id.tvArtistAlbum)
        private val thumbnail: ImageView = view.findViewById(R.id.imgThumbnail)

        @SuppressLint("SetTextI18n")
        fun bind(song: Song) {
            title.text = song.songTitle
            artistAlbum.text = "${song.artistName}\n${song.albumName}"

            // Load image from drawable by name
            val context = itemView.context
            val imageResId = context.resources.getIdentifier(
                song.thumbnail, "mipmap", context.packageName
            )
            thumbnail.setImageResource(
                if (imageResId != 0) imageResId else R.drawable.app_logo
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun updateSongs(newSongs: List<Song>) {
        items = newSongs
        notifyDataSetChanged()
    }
}
