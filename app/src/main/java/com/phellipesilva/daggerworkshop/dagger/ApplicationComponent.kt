package com.phellipesilva.daggerworkshop.dagger

import android.content.Context
import com.phellipesilva.daggerworkshop.database.UserDAO
import com.phellipesilva.daggerworkshop.service.MainService
import dagger.Component

@Component(modules = [DatabaseModule::class, ServiceModule::class])
interface ApplicationComponent {

    fun getUserDAO(): UserDAO
    fun getMainService(): MainService
    fun getContext(): Context

}