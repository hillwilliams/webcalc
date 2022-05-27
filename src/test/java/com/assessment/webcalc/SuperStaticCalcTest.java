package com.assessment.webcalc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperStaticCalcTest {

    @Test
    public void shouldMakeAddOperation(){
        var c = SuperStaticCalc.getInstance();
        c.sum(10);
        c.sum(12);

        assertEquals(22, c.getCount());
    }
}