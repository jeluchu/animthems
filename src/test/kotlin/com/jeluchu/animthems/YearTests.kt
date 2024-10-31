package com.jeluchu.animthems

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class YearTests {
    @Test
    fun `on getYearIndex and return a list with years`() {
        val result = runBlocking { Animthems.getYearsIndex() }
        assert(result.isNotEmpty())
    }

    companion object {
        @BeforeAll
        @JvmStatic
        internal fun setup() {
            Animthems
        }
    }
}