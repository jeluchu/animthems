package com.jeluchu.animthems.models.artists.details.request

import kotlinx.serialization.Serializable

@Serializable
data class Resource(
    val link: String?,
    val site: String?
)