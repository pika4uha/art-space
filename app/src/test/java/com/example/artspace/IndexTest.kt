package com.example.artspace

import org.junit.Assert.assertEquals
import org.junit.Test

class IndexTest {
    @Test
    fun next_wraps_to_start() {
        assertEquals(0, nextIndex(2, 3))
    }

    @Test
    fun previous_wraps_to_end() {
        assertEquals(2, previousIndex(0, 3))
    }
}