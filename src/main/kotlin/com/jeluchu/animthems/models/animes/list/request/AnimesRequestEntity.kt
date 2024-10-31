package com.jeluchu.animthems.models.animes.list.request

import kotlinx.serialization.Serializable

@Serializable
data class AnimesRequestEntity(
    val anime: List<Anime>?
)