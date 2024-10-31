package com.jeluchu.animthems.models.artists.list.request

import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val id: Int?,
    val link: String?,
    val path: String?,
    val facet: String?
)