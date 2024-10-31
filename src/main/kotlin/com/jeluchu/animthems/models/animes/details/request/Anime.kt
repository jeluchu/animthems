package com.jeluchu.animthems.models.animes.details.request

import com.jeluchu.animthems.models.animes.details.response.AnimeDetailsEntity
import kotlinx.serialization.Serializable

@Serializable
data class Anime(
    val animethemes: List<Animetheme>?,
    val id: Int?,
    val images: List<Image>?,
    val media_format: String?,
    val name: String?,
    val season: String?,
    val slug: String?,
    val synopsis: String?,
    val year: Int?
) {
    fun toAnimeDetails() = AnimeDetailsEntity(
        year = year ?: 0,
        slug = slug.orEmpty(),
        name = name.orEmpty(),
        season = season.orEmpty(),
        themes = animethemes?.map { it.toTheme() }.orEmpty(),
        image = images?.firstOrNull { it.facet == "Large Cover" }?.link ?:
        images?.firstOrNull { it.facet == "Small Cover" }?.link.orEmpty()
    )
}