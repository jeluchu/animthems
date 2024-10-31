package com.jeluchu.animthems

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class RandomTests {
    @Test
    fun `on getRandomVideo and return video and possibly song links`() {
        val result = runBlocking { Animthems.getRandomVideo() }
        assert(result != null)
    }

    companion object {
        @BeforeAll
        @JvmStatic
        internal fun setup() {
            Animthems
        }
    }
}