package com.jeluchu.animthems.models.artists.details.request

import com.jeluchu.animthems.models.artists.details.response.ArtistDetailsEntity
import kotlinx.serialization.Serializable

@Serializable
data class Animethemeentry(
    val id: Int?,
    val version: Int?,
    val notes: String?,
    val nsfw: Boolean?,
    val episodes: String?,
    val spoiler: Boolean?,
    val videos: List<Video>?
) {
    fun toThemeEntry() = ArtistDetailsEntity.Song.Theme.ThemeEntry(
        id = id ?: 0,
        nsfw = nsfw ?: false,
        spoiler = spoiler ?: false,
        episodes = episodes.orEmpty(),
        videos = videos?.map { it.toMedia() }.orEmpty()
    )
}