package com.example.tugasapi
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse<T>(
    @param:Json(name = "message") val message: String,
    @param:Json(name = "code") val code: String,
    @param:Json(name = "data") val data: T
)

@JsonClass(generateAdapter = true)
data class Student(
    @param:Json(name = "studentId") val studentId: String,
    @param:Json(name = "fullName") val fullName: String,
    @param:Json(name = "major") val major: String
)