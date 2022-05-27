package com.assessment.webcalc;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/")
public class WebCalcController {

    private final CalcService calcService = new CalcService();

    @POST
    @Produces("text/plain")
    public String calculate(String val) {

        var incoming = calcService.parseIncomingString(val);
        var isEndOfRound = false;
        var processed = calcService.processIncomingValue(incoming);

        while (!isEndOfRound) {
            isEndOfRound = calcService.isEndOfRound(incoming.key());

        }
        var result = calcService.getSumm(processed.key());
        calcService.reset(incoming);
        return result + " " + processed.key();
    }

}