package com.assessment.webcalc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calc = null;

    @BeforeEach
    public void beforeEach(){
        calc = Calculator.getInstance();
    }

    @AfterEach
    public void afterEach(){
        calc.reset();
    }

    @Test
    public void shouldAddValueToEmptyStorage() {
        calc.sum("round1", 12);
        var res = calc.getValue("round1");

        assertEquals(12, res);
    }

    @Test
    public void shouldAddValueToNonEmptyStorageAndReturnSum() {
        //add initial value
        calc.sum("round1", 12);
        //add new value
        calc.sum("round1", 12);
        var res = calc.getValue("round1");

        assertEquals(24, res);
    }

    @Test
    public void shouldAddValueForMultipleKeysAndReturnSums() {
        //add initial values
        calc.sum("round1", 12);
        calc.sum("round2", 5);
        calc.sum("round3", 99);

        //new values round1
        calc.sum("round1", 0);
        calc.sum("round1", 5);
        calc.sum("round1", 100);
        var round1Res = calc.getValue("round1");

        //new values round2
        calc.sum("round2", 10);
        calc.sum("round2", 5);
        calc.sum("round2", 1);
        var round2Res = calc.getValue("round2");

        //new values round3
        calc.sum("round3", 10);
        calc.sum("round3", 5);
        calc.sum("round3", 2);
        var round3Res = calc.getValue("round3");

        assertEquals(117, round1Res);
        assertEquals(21, round2Res);
        assertEquals(116, round3Res);
    }
}