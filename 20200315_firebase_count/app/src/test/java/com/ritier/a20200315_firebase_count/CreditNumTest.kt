package com.ritier.a20200315_firebase_count

import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.regex.Pattern

class CreditNumTest {

    lateinit var testText :String

    @Before
    fun setData(){
        testText = "1234 5678 1234 5678"
    }

    @Test
    fun getCreditFormat(){
        val regex = "^[1-9][0-9][0-9][0-9] [0-9][0-9][0-9][0-9] [0-9][0-9][0-9][0-9] [0-9][0-9][0-9][0-9]$"
        assertEquals(Pattern.matches(regex, testText), true)
    }
}