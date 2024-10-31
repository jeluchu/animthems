package com.jeluchu.animthems.models.artists.details.request

import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val id: Int?,
    val path: String?,
    val link: String?,
    val facet: String?
)