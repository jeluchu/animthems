package com.jeluchu.animthems.models.animes.details.response

import kotlinx.serialization.Serializable

@Serializable
data class AnimeDetailsEntity(
    val year: Int?,
    val slug: String?,
    val name: String?,
    val image: String?,
    val season: String?,
    val themes: List<Theme>?,
) {
    @Serializable
    data class Theme(
        val id: Int?,
        val slug: String?,
        val type: String?,
        val themeEntry: List<ThemeEntry>?
    ) {
        @Serializable
        data class ThemeEntry(
            val id: Int?,
            val nsfw: Boolean?,
            val episodes: String?,
            val spoiler: Boolean?,
            val videos: List<Media>?
        ) {
            @Serializable
            data class Media(
                val video: String?,
                val audio: String?
            )
        }
    }
}