package com.mattrobertson.creeds

import com.mattrobertson.creeds.data.catechisms.wlc
import com.mattrobertson.creeds.data.catechisms.wsc
import org.junit.Test

import org.junit.Assert.*

class CatechismTests {
    @Test
    fun wsc_num_questions_correct() {
        assertEquals(107, wsc.numQuestions)
    }

    @Test
    fun wlc_num_questions_correct() {
        assertEquals(196, wlc.numQuestions)
    }
}