package dev.rokitskiy.newsapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.rokitskiy.newsapp.data.databace.UserDatabase
import dev.rokitskiy.newsapp.domain.dao.UserDao
import javax.inject.Singleton

@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context): UserDatabase{
        return Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "userDatabase.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(userDatabase: UserDatabase) : UserDao{
        return userDatabase.getUserDao()
    }

}