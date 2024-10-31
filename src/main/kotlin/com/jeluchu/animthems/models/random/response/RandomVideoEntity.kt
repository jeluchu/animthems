package com.jeluchu.animthems.models.random.response

import kotlinx.serialization.Serializable

@Serializable
data class RandomVideoEntity(
    val name: String?,
    val type: String?,
    val video: String?,
    val episodes: String?,
)