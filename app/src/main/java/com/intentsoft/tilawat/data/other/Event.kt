package com.intentsoft.tilawat.data.other

open class Event<out T>(
    private val data: T
){

    var hasBeenHandeled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandeled) {
            null
        } else {
            hasBeenHandeled = true
            data
        }
    }

    fun peekContent() = data
}