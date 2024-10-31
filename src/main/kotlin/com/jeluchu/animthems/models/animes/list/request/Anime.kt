package com.jeluchu.animthems.models.animes.list.request

import com.jeluchu.animthems.models.animes.list.response.AnimesEntity
import kotlinx.serialization.Serializable

@Serializable
data class Anime(
    val id: Int?,
    val images: List<Image>?,
    val name: String?,
    val season: String?,
    val slug: String?,
    val synopsis: String?,
    val year: Int?
) {
    fun toAnimesEntity() = AnimesEntity(
        year = year ?: 0,
        slug = slug.orEmpty(),
        name = name.orEmpty(),
        season = season.orEmpty(),
        image = images?.firstOrNull { it.facet == "Large Cover" }?.link ?:
        images?.firstOrNull { it.facet == "Small Cover" }?.link.orEmpty()
    )
}