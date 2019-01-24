package com.phellipesilva.daggerworkshop.dagger

import com.phellipesilva.daggerworkshop.business.BusinessClassA
import com.phellipesilva.daggerworkshop.business.BusinessClassB
import com.phellipesilva.daggerworkshop.interactor.MainInteractor
import com.phellipesilva.daggerworkshop.navigation.Navigator
import dagger.Component

@Component(modules = [MainModule::class])
interface ApplicationComponent {

    fun getInteractor(): MainInteractor
    fun getNavigator(): Navigator
    fun getBusinessClassA(): BusinessClassA
    fun getBusinessClassB(): BusinessClassB
}