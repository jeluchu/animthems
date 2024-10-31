package com.jeluchu.animthems

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class AnimesTests {
    @Test
    fun `on getAnimes and return a list with animes`() {
        val result = runBlocking { Animthems.getAnimes() }
        assert(result.isNotEmpty())
    }

    @Test
    fun `on getAnimesFiltered pass query and return a list with animes filtered`() {
        val result = runBlocking { Animthems.getAnimesFiltered(year = 2024, season = "Summer" ) }
        assert(result.isNotEmpty())
    }

    @Test
    fun `on getAnime pass query and return a list with animes`() {
        val result = runBlocking { Animthems.getAnime("hackliminality") }
        assertEquals(result?.name, ".hack//Liminality")
    }

    companion object {
        @BeforeAll
        @JvmStatic
        internal fun setup() {
            Animthems
        }
    }
}