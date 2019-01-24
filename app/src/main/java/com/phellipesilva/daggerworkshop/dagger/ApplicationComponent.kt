package com.phellipesilva.daggerworkshop.dagger

import com.phellipesilva.daggerworkshop.view.MainActivity
import dagger.Component

@Component(modules = [MainModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}