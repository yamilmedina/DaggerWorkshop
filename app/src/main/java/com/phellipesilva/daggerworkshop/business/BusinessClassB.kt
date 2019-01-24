package com.phellipesilva.daggerworkshop.business

import javax.inject.Inject

class BusinessClassB @Inject constructor(
    private val helperClass: HelperClass
) {

    fun doNothing(number: Int): Int = number
}