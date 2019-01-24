package com.phellipesilva.daggerworkshop.dagger

import com.phellipesilva.daggerworkshop.view.MainActivity
import dagger.Component

@Component(modules = [MainModule::class], dependencies = [ApplicationComponent::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}