package com.example.solutionx.Network

import com.example.solutionx.UserData.User

class Api {
    suspend fun getRemoteUserData(userId: String): User {
        // Send a network request to fetch user data from the backend
//        val response = Http.get("$API_URL/users/$userId")
//        return JSON.parse(User.serializer(), response.body())
    }
}