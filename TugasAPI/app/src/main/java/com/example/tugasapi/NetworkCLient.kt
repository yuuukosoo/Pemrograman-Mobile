package com.example.tugasapi

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface StudentApiService {
    @GET("api/student")
    suspend fun getStudentProfile(): ApiResponse<Student>
}

object NetworkClient {

    private const val BASE_URL = "https://tugas-android-api.free.beeceptor.com/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val apiService: StudentApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(StudentApiService::class.java)
    }
}