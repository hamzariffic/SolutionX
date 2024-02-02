package com.example.solutionx.UserData

data class User(
    val id: String,
    val weight: Float,
    val name: String,
    val age: Int,
    val gender: String,
    val height: Float,
    val goal: String,
    val healthData: HealthData
)