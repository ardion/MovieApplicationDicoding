package com.example.core.di

import android.content.Context
import androidx.room.Room
import com.example.core.data.source.local.room.MovieDao
import com.example.core.data.source.local.room.MovieDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MovieDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val factory = SupportFactory(passphrase)
        val builder = Room.databaseBuilder(
            context,
            MovieDatabase::class.java, "Movie.db"
        ).fallbackToDestructiveMigration().openHelperFactory(factory)
        return builder.build()
    }

    @Provides
    fun provideDao(database: MovieDatabase): MovieDao = database.movieDao()


}