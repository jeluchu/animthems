package com.jeluchu.animthems.models.artists.details.request

import com.jeluchu.animthems.models.artists.details.response.ArtistDetailsEntity
import kotlinx.serialization.Serializable

@Serializable
data class Video(
    val id: Int?,
    val size: Int?,
    val nc: Boolean?,
    val tags: String?,
    val link: String?,
    val audio: Audio?,
    val path: String?,
    val source: String?,
    val uncen: Boolean?,
    val basename: String?,
    val filename: String?,
    val lyrics: Boolean?,
    val overlap: String?,
    val resolution: Int?,
    val subbed: Boolean?
) {
    fun toMedia() = ArtistDetailsEntity.Song.Theme.ThemeEntry.Media(
        video = link.orEmpty(),
        audio = audio?.link.orEmpty()
    )
}