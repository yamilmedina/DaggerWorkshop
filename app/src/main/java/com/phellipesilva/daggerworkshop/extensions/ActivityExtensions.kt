package com.phellipesilva.daggerworkshop.extensions

import android.app.Activity
import com.phellipesilva.daggerworkshop.MyApplication
import com.phellipesilva.daggerworkshop.dagger.DaggerMainActivityComponent
import com.phellipesilva.daggerworkshop.dagger.MainModule
import com.phellipesilva.daggerworkshop.view.MainActivity

val Activity.applicationComponent get() = (application as MyApplication).getApplicationComponent()
val MainActivity.mainActivityComponent get() = DaggerMainActivityComponent
    .builder()
    .applicationComponent(applicationComponent)
    .mainModule(MainModule(this))
    .build()