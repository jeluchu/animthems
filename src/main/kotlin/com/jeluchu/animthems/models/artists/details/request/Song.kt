package com.jeluchu.animthems.models.artists.details.request

import com.jeluchu.animthems.models.artists.details.response.ArtistDetailsEntity
import kotlinx.serialization.Serializable

@Serializable
data class Song(
    val id: Int?,
    val title: String?,
    val animethemes: List<Animetheme>?
) {
    fun toSongResponse() = ArtistDetailsEntity.Song(
        id = id ?: 0,
        title = title.orEmpty(),
        themes = animethemes?.map { it.toTheme() }.orEmpty()
    )
}