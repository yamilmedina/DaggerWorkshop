package com.phellipesilva.daggerworkshop

import android.app.Application
import com.phellipesilva.daggerworkshop.dagger.ApplicationComponent
import com.phellipesilva.daggerworkshop.dagger.DaggerApplicationComponent
import com.phellipesilva.daggerworkshop.dagger.DatabaseModule
import com.phellipesilva.daggerworkshop.dagger.ServiceModule

class MyApplication : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .databaseModule(DatabaseModule(applicationContext))
            .serviceModule(ServiceModule())
            .build()
    }

    fun getApplicationComponent(): ApplicationComponent {
        return applicationComponent
    }
}