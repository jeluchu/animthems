package com.jeluchu.animthems.models.animes.list.request
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val facet: String?,
    val id: Int?,
    val link: String?,
    val path: String?
)