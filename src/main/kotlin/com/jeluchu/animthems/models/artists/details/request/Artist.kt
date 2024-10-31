package com.jeluchu.animthems.models.artists.details.request

import com.jeluchu.animthems.models.artists.details.response.ArtistDetailsEntity
import kotlinx.serialization.Serializable

@Serializable
data class Artist(
    val id: Int?,
    val name: String?,
    val slug: String?,
    val songs: List<Song>?,
    val images: List<Image>?,
    val members: List<Member>?,
    val resources: List<Resource>?
) {
    fun toArtistDetails() = ArtistDetailsEntity(
        id = id ?: 0,
        slug = slug.orEmpty(),
        name = name.orEmpty(),
        resources = resources,
        songs = songs?.map { it.toSongResponse() }.orEmpty(),
        image = images?.firstOrNull { it.facet == "Large Cover" }?.link ?:
        images?.firstOrNull { it.facet == "Small Cover" }?.link.orEmpty()    )
}