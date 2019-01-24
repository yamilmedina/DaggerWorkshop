package com.phellipesilva.daggerworkshop.business

import com.phellipesilva.daggerworkshop.database.User
import javax.inject.Inject

class BusinessClassA @Inject constructor(
    private val helperClass: HelperClass
) {

    fun generateRandomFromUser(user: User): Int = user.hashCode()
}