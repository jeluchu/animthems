package com.jeluchu.animthems.models.animes.details.request

import com.jeluchu.animthems.models.animes.details.response.AnimeDetailsEntity
import kotlinx.serialization.Serializable

@Serializable
data class Animethemeentry(
    val episodes: String?,
    val id: Int?,
    val notes: String?,
    val nsfw: Boolean?,
    val spoiler: Boolean?,
    val videos: List<Video>?
) {
    fun toThemeEntry() = AnimeDetailsEntity.Theme.ThemeEntry(
        id = id ?: 0,
        nsfw = nsfw ?: false,
        spoiler = spoiler ?: false,
        episodes = episodes.orEmpty(),
        videos = videos?.map { it.toMedia() }.orEmpty()
    )
}