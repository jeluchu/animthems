package com.jeluchu.animthems.models.animes.details.request

import com.jeluchu.animthems.models.animes.details.response.AnimeDetailsEntity
import kotlinx.serialization.Serializable

@Serializable
data class Animetheme(
    val animethemeentries: List<Animethemeentry>?,
    val id: Int?,
    val sequence: Int?,
    val slug: String?,
    val type: String
) {
    fun toTheme() = AnimeDetailsEntity.Theme(
        id = id,
        type = type,
        slug = slug,
        themeEntry = animethemeentries?.map { it.toThemeEntry() }.orEmpty()
    )
}