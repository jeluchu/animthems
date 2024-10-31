package com.jeluchu.animthems.models.animes.list.response

import kotlinx.serialization.Serializable

@Serializable
data class AnimesEntity(
    val year: Int?,
    val slug: String?,
    val name: String?,
    val image: String?,
    val season: String?,
)