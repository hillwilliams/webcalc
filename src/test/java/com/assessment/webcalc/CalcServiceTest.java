package com.assessment.webcalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalcServiceTest {

    @Test
    public void whenIncomingValueWithoutSpaceShouldParse() {
        var calcService = new CalcService();
        var res = calcService.parseIncomingString("12tour");

        assertEquals(new Pair("tour", "12"), res);
    }

    @Test
    public void whenIncomingValueWithSpaceShouldParse() {
        var calcService = new CalcService();
        var res = calcService.parseIncomingString("12 tour");

        assertEquals(new Pair("tour", "12"), res);
    }

    @Test
    public void whenIncomingCommandWithRoundNameShouldParse() {
        var calcService = new CalcService();
        var res = calcService.parseIncomingString("end tour");
        assertEquals(new Pair("tour", "end"), res);
    }

    @Test
    public void whenIncomingCommandWithRoundNameNoSpaceShouldParse() {
        var calcService = new CalcService();
        var res = calcService.parseIncomingString("endtour");
        assertEquals(new Pair("tour", "end"), res);
    }

    @Test
    public void whenKeyNotExistThenFalse() {
        var calcService = new CalcService();
        var res = calcService.isEndOfRound("key");

        assertFalse(res);
    }

    @Test
    public void whenKeyExistThenTrue() {
        var calcService = new CalcService();
        var incoming = calcService.parseIncomingString("end round");
        calcService.processIncomingValue(incoming);
        var res = calcService.isEndOfRound("round");

        assertTrue(res);
    }
}