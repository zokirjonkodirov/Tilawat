package com.intentsoft.tilawat.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.intentsoft.tilawat.data.entities.Song
import com.intentsoft.tilawat.data.other.Constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await

class MusicDatabase {

    private val fireStore = FirebaseFirestore.getInstance()
    private val songCollection = fireStore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}