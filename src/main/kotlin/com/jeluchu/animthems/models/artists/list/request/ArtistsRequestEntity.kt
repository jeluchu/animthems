package com.jeluchu.animthems.models.artists.list.request

import kotlinx.serialization.Serializable

@Serializable
data class ArtistsRequestEntity(
    val artists: List<Artist>?
)