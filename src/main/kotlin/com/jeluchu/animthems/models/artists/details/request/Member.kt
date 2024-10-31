package com.jeluchu.animthems.models.artists.details.request

import kotlinx.serialization.Serializable

@Serializable
data class Member(
    val id: Int?,
    val name: String?,
    val slug: String?
)