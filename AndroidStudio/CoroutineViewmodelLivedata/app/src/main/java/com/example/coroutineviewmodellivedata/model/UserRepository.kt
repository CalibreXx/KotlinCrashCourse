package com.example.coroutineviewmodellivedata.model

import kotlinx.coroutines.delay

class UserRepository {
    //call to API and get users info
    //but here is create new users

    suspend fun getUser(): List<User> {
        delay(8000)// to mimic data fetching
        val users: List<User> = listOf(
            User(1, "Ben"),
            User(2, "John"),
            User(3, "Cain"),
            User(4, "MCd")
        )
        return users
    }
}