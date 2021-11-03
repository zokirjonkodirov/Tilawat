package com.intentsoft.tilawat.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.intentsoft.tilawat.data.entities.Song
import com.intentsoft.tilawat.data.other.Constants.SONG_COLLECTION
import com.intentsoft.tilawat.data.other.Constants.SURAH_COLLECTION
import kotlinx.coroutines.tasks.await

/**
 * @author user
 * @date 27.09.2021
 */
class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION  )

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }
}