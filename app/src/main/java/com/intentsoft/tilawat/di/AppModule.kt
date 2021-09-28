package com.intentsoft.tilawat.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.intentsoft.tilawat.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author user
 * @date 27.09.2021
 */
@Module
@InstallIn(SingletonComponent::class) // ApplicationComponent lives when our application is running
object AppModule {

    @Singleton
    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(R.drawable.ic_image) //sets image until fully downloaded
            .error(R.drawable.ic_image) //if download is unSuccesfull glide will set this image
            .diskCacheStrategy(DiskCacheStrategy.DATA) //cashes images
    )
}