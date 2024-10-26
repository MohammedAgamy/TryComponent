package com.example.trycomponent.repository

import com.example.trycomponent.Model.Users

interface UserRepository {
    suspend fun getUsers():List<Users>
    suspend fun addUsers(user: Users):List<Users>
    suspend fun deleteUser(user: Users): List<Users>
    suspend fun clearUsers(): List<Users>
}