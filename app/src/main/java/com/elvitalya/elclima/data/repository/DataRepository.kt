package com.elvitalya.elclima.data.repository

import com.elvitalya.elclima.data.remote.ApiService
import com.elvitalya.elclima.data.remote.Worker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getWorkersList(): List<Worker> = withContext(Dispatchers.IO) {
        apiService.getWorkersList().workersList ?: emptyList()
    }

}