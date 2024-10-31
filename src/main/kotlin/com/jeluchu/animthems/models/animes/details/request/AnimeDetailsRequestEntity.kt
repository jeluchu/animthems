package com.jeluchu.animthems.models.animes.details.request
import kotlinx.serialization.Serializable

@Serializable
data class AnimeDetailsRequestEntity(
    val anime: Anime
)