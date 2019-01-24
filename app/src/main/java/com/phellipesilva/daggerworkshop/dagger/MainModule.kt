package com.phellipesilva.daggerworkshop.dagger

import android.content.Context
import androidx.room.Room
import com.phellipesilva.daggerworkshop.business.BusinessClassA
import com.phellipesilva.daggerworkshop.business.BusinessClassB
import com.phellipesilva.daggerworkshop.business.HelperClass
import com.phellipesilva.daggerworkshop.database.UserDAO
import com.phellipesilva.daggerworkshop.database.UserDatabase
import com.phellipesilva.daggerworkshop.interactor.MainInteractor
import com.phellipesilva.daggerworkshop.navigation.Navigator
import com.phellipesilva.daggerworkshop.service.MainService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors

@Module
class MainModule(private val context: Context) {

    @Provides
    fun providesContext(): Context = context

    @Provides
    fun providesCurrencyRatesService(): MainService = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MainService::class.java)

    @Provides
    fun providesUserDAO(context: Context): UserDAO =  Room.databaseBuilder(context, UserDatabase::class.java, "UserDatabase")
        .build()
        .getUserDAO()

    @Provides
    fun providesHelperClass(): HelperClass = HelperClass()

    @Provides
    fun providesBusinessClassA(helperClass: HelperClass): BusinessClassA = BusinessClassA(helperClass)

    @Provides
    fun providesBusinessClassB(helperClass: HelperClass): BusinessClassB = BusinessClassB(helperClass)

    @Provides
    fun providesExecutor(): Executor = Executors.newSingleThreadExecutor()

    @Provides
    fun providesMainInteractor(mainService: MainService, userDAO: UserDAO, executor: Executor): MainInteractor
            = MainInteractor(mainService, userDAO, executor)

    @Provides
    fun providesNavigator(context: Context): Navigator = Navigator(context)

}