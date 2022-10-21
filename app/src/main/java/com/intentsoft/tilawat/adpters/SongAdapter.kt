package com.intentsoft.tilawat.adpters

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.AsyncListDiffer
import com.bumptech.glide.RequestManager
import com.intentsoft.tilawat.R
import kotlinx.android.synthetic.main.list_item.view.tvPrimary
import kotlinx.android.synthetic.main.list_item.view.tvSurahNumber
import javax.inject.Inject

class SongAdapter @Inject constructor(
    private val glide: RequestManager
) : BaseSongAdapter(R.layout.list_item) {

    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.itemView.apply {
            tvPrimary.text = song.title
            tvSurahNumber.text = removeZero(song.mediaId)

            animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.zoomin)

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(song)
                }
            }
        }
    }

    private fun removeZero(text: String): String {
        var counter = 0
        for (element in text) {
            if (element == '0') {
                counter++
            } else {
                break
            }
        }

        return text.drop(counter)
    }

}
