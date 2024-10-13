package dev.rokitskiy.newsapp.data.databace

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.rokitskiy.newsapp.domain.dao.UserDao
import dev.rokitskiy.newsapp.domain.entity.User

@Database(entities = [User::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun getUserDao(): UserDao
}