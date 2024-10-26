package com.example.trycomponent.repository

import com.example.trycomponent.Model.Users
import kotlinx.coroutines.delay

class UserRepositoryImpl : UserRepository {
    private var users = mutableListOf<Users>()


    override suspend fun getUsers(): List<Users> {
        delay(3000)
        return users
    }

    override suspend fun addUsers(user: Users): List<Users> {
        delay(3000)
        users.add(user)
        return users
    }

    override suspend fun deleteUser(user: Users): List<Users> {
        delay(500)
        users.remove(user)
        return users
    }

    override suspend fun clearUsers(): List<Users> {
        delay(500)
        users.clear()
        return users
    }

}