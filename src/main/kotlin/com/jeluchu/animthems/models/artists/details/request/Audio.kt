package com.jeluchu.animthems.models.artists.details.request

import kotlinx.serialization.Serializable

@Serializable
data class Audio(
    val id: Int?,
    val size: Int?,
    val link: String?,
    val path: String?,
    val basename: String?,
    val filename: String?
)