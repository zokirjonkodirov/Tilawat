package com.intentsoft.tilawat.adpters

import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.intentsoft.tilawat.R
import com.intentsoft.tilawat.data.entities.Song
import kotlinx.android.synthetic.main.list_item.view.*
import me.dara.mylib.AvatarDrawable
import javax.inject.Inject

/**
 * @author user
 * @date 29.09.2021
 */
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
        for (i in 0..text.length - 1) {
            if (text[i] == '0') {
                counter++
            } else {
                break
            }
        }

        return text.drop(counter)
    }

}
