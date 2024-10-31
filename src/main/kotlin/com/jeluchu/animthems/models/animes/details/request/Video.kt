package com.jeluchu.animthems.models.animes.details.request

import com.jeluchu.animthems.models.animes.details.response.AnimeDetailsEntity
import kotlinx.serialization.Serializable

@Serializable
data class Video(
    val basename: String?,
    val filename: String?,
    val id: Int?,
    val link: String?,
    val lyrics: Boolean?,
    val nc: Boolean?,
    val overlap: String?,
    val path: String?,
    val resolution: Int?,
    val size: Int?,
    val source: String?,
    val subbed: Boolean?,
    val tags: String?,
    val uncen: Boolean?
) {
    fun toMedia() = AnimeDetailsEntity.Theme.ThemeEntry.Media(
        audio = null,
        video = link.orEmpty()
    )
}