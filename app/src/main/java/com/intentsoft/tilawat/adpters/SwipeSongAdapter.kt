package com.intentsoft.tilawat.adpters

import androidx.recyclerview.widget.AsyncListDiffer
import com.intentsoft.tilawat.R
import kotlinx.android.synthetic.main.list_item.view.tvPrimary

class SwipeSongAdapter : BaseSongAdapter(R.layout.swipe_item) {

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.itemView.apply {
            val text = "${song.title} - surasi"
            tvPrimary.text = text

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(song)
                }
            }
        }
    }

}