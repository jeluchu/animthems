package com.jeluchu.animthems.models.artists.details.request

import kotlinx.serialization.Serializable

@Serializable
data class ArtistDetailsRequestEntity(
    val artist: Artist
)