package com.elvitalya.elclima.ui.specialization_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.elvitalya.elclima.data.remote.Worker

@Composable
fun SpecializationsListScreen(viewModel: SpecializationsListViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = viewModel, block = {
        viewModel.getWorkersList()
    })
    SpecializationsList(
        workersList = viewModel.workersList
    )
}


@Composable
fun SpecializationsList(
    workersList: List<Worker>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        workersList.forEach {
            Text(text = it.fullName ?: "null")
        }
    }
}