package com.jeluchu.animthems.models.artists.list.request

import com.jeluchu.animthems.models.artists.list.response.ArtistsEntity
import kotlinx.serialization.Serializable

@Serializable
data class Artist(
    val id: Int?,
    val images: List<Image>?,
    val name: String?,
    val slug: String?
) {
    fun toArtistEntity() = ArtistsEntity(
        id = id ?: 0,
        name = name.orEmpty(),
        slug = slug.orEmpty(),
        image = images?.firstOrNull { it.facet == "Large Cover" }?.link ?:
        images?.firstOrNull { it.facet == "Small Cover" }?.link.orEmpty()
    )
}