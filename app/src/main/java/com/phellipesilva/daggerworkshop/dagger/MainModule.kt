package com.phellipesilva.daggerworkshop.dagger

import com.phellipesilva.daggerworkshop.view.MainActivity
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors

@Module
class MainModule(private val mainActivity: MainActivity) {

    @Provides
    fun providesMainActivity(): MainActivity = mainActivity

    @Provides
    fun providesExecutor(): Executor = Executors.newSingleThreadExecutor()

}