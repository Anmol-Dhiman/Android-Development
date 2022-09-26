package com.example.tipcalculator

import junit.framework.TestCase

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TipCalTest {
    @Test
    fun calculate_20_percent_tip_no_roundup() {
        val amount = 100.00
        val tipPercent = 20.00
        val expectedTip = "$20.00"
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)
        TestCase.assertEquals(expectedTip, actualTip)
    }

}