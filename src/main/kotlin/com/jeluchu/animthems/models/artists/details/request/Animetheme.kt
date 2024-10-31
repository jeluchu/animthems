package com.jeluchu.animthems.models.artists.details.request

import com.jeluchu.animthems.models.artists.details.response.ArtistDetailsEntity
import kotlinx.serialization.Serializable

@Serializable
data class Animetheme(
    val id: Int?,
    val sequence: Int?,
    val slug: String?,
    val type: String?,
    val animethemeentries: List<Animethemeentry>?
) {
    fun toTheme() = ArtistDetailsEntity.Song.Theme(
        id = id,
        type = type,
        slug = slug,
        themeEntry = animethemeentries?.map { it.toThemeEntry() }.orEmpty()
    )
}