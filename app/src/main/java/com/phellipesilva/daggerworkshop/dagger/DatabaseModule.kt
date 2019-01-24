package com.phellipesilva.daggerworkshop.dagger

import android.content.Context
import androidx.room.Room
import com.phellipesilva.daggerworkshop.database.UserDAO
import com.phellipesilva.daggerworkshop.database.UserDatabase
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule(private val context: Context) {

    @Provides
    fun providesContext(): Context = context

    @Provides
    fun providesUserDAO(context: Context): UserDAO =  Room.databaseBuilder(context, UserDatabase::class.java, "UserDatabase")
        .build()
        .getUserDAO()
}