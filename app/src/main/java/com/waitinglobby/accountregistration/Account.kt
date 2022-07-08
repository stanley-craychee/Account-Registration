package com.waitinglobby.accountregistration

import java.io.Serializable

data class Account(
    val username: String,
    val firstName: String,
    val lastName: String,
    val suffix: String,
    val email: String,
    val phone: String
) : Serializable {

    fun getFullName() =
        when (suffix) {
            "None" -> "$firstName $lastName"
            "Mr." -> "$suffix$firstName $lastName"
            "Mrs." -> "$suffix$firstName $lastName"
            else -> "$firstName $lastName $suffix"
        }

}