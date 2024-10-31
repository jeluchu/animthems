package com.jeluchu.animthems.models.artists.details.response

import com.jeluchu.animthems.models.artists.details.request.Resource
import kotlinx.serialization.Serializable

@Serializable
data class ArtistDetailsEntity(
    val id: Int?,
    val slug: String?,
    val name: String?,
    val image: String?,
    val songs: List<Song>?,
    val resources: List<Resource>?
) {
    @Serializable
    data class Song(
        val id: Int?,
        val title: String?,
        val themes: List<Theme>?
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
}