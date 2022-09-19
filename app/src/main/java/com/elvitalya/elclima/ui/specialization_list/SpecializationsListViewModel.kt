package com.elvitalya.elclima.ui.specialization_list

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elvitalya.elclima.data.remote.Worker
import com.elvitalya.elclima.data.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpecializationsListViewModel @Inject constructor(
    private val dataRepository: DataRepository
) : ViewModel() {

    private var getWorkersListJob: Job? = null

    var workersList = mutableStateListOf<Worker>()
        private set

    fun getWorkersList() {
        getWorkersListJob?.cancel()
        getWorkersListJob = viewModelScope.launch {
            try {
                workersList.addAll(dataRepository.getWorkersList())
                Log.d("check___", "getWorkersList list $workersList")
            } catch (e: Exception) {
                Log.d("check___", "getWorkersList error! ${e.message}")
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        getWorkersListJob?.cancel()
    }

}