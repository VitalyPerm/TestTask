package com.elvitalya.elclima.data.remote

import retrofit2.http.GET

interface ApiService {

    @GET("65gb/static/raw/master/testTask.json")
    suspend fun getWorkersList(): WorkersListResponse
}