package com.elvitalya.elclima.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WorkersListResponse(
    @Json(name = "response") val workersList: List<Worker>? = null
)

@JsonClass(generateAdapter = true)
data class Worker(
    @Json(name = "avatr_url") val avatar: String? = null,
    @Json(name = "birthday") val birthday: String? = null,
    @Json(name = "f_name") val fullName: String? = null,
    @Json(name = "l_name") val lastName: String? = null,
    @Json(name = "specialty") val specialty: List<Specialty>? = null
)

@JsonClass(generateAdapter = true)
data class Specialty(
    @Json(name = "name") val name: String? = null,
    @Json(name = "specialty_id") val specialtyId: Int? = null
)