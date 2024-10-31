package com.jeluchu.animthems.models.random.request

import com.jeluchu.animthems.models.random.response.RandomVideoEntity
import kotlinx.serialization.Serializable

@Serializable
data class RandomVideoRequestEntity(
    val videos: List<Video>
) {
    @Serializable
    data class Video(
        val id: Int?,
        val size: Int?,
        val nc: Boolean?,
        val tags: String?,
        val link: String?,
        val path: String?,
        val source: String?,
        val uncen: Boolean?,
        val basename: String?,
        val filename: String?,
        val lyrics: Boolean?,
        val overlap: String?,
        val resolution: Int?,
        val subbed: Boolean?,
        val animethemeentries: List<Animethemeentry>?
    ) {
        @Serializable
        data class Animethemeentry(
            val id: Int,
            val nsfw: Boolean,
            val episodes: String,
            val spoiler: Boolean,
            val animetheme: Animetheme,
        ) {
            @Serializable
            data class Animetheme(
                val id: Int,
                val anime: Anime,
                val slug: String,
                val type: String
            ) {
                @Serializable
                data class Anime(
                    val id: Int,
                    val media_format: String,
                    val name: String,
                    val season: String,
                    val slug: String,
                    val synopsis: String,
                    val year: Int
                )
            }
        }

        fun toRandomVideoEntity() = RandomVideoEntity(
            video = link.orEmpty(),
            episodes = animethemeentries?.firstOrNull()?.episodes.orEmpty(),
            type = animethemeentries?.firstOrNull()?.animetheme?.type.orEmpty(),
            name = animethemeentries?.firstOrNull()?.animetheme?.anime?.name.orEmpty()
        )
    }
}