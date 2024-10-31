package com.jeluchu.animthems

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class ArtistsTests {
    @Test
    fun `on getArtists and return list for artists animes list`() {
        val result = runBlocking { Animthems.getArtists() }
        assert(result.isNotEmpty())
    }

    @Test
    fun `on getArtist pass a query with slug and return artists details`() {
        val result = runBlocking { Animthems.getArtist("yoasobi") }
        assert(result != null)
        assertEquals(result?.name, "YOASOBI")
    }

    companion object {
        @BeforeAll
        @JvmStatic
        internal fun setup() {
            Animthems
        }
    }
}