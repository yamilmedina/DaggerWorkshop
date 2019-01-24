package com.phellipesilva.daggerworkshop.dagger

import com.phellipesilva.daggerworkshop.presenter.MainPresenter
import dagger.Component

@Component(modules = [MainModule::class])
interface ApplicationComponent {

    fun getPresenter(): MainPresenter
}