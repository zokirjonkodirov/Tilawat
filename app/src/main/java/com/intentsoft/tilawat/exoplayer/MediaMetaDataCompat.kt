package com.intentsoft.tilawat.exoplayer

import android.support.v4.media.MediaMetadataCompat
import com.intentsoft.tilawat.data.entities.Song

/**
 * @author user
 * @date 30.09.2021
 */
fun MediaMetadataCompat.toSong(): Song? {
    return description?.let {
        Song(
            it.mediaId ?: "",
            it.title.toString(),
            it.subtitle.toString(),
            it.mediaUri.toString(),
            it.iconUri.toString()
        )
    }
}