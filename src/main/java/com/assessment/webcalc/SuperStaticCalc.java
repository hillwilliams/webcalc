package com.assessment.webcalc;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SuperStaticCalc {

    private static final SuperStaticCalc superStaticCalc = null;

    private SuperStaticCalc() {
    }

    private static final AtomicInteger count = new AtomicInteger();
    private static final AtomicBoolean isEnd = new AtomicBoolean();

    private static String roundName = null;

    public static SuperStaticCalc getInstance() {
        return Objects.requireNonNullElseGet(superStaticCalc, SuperStaticCalc::new);
    }

    public Integer getCount() {
        return count.intValue();
    }

    public void sum(int value) {
        count.addAndGet(value);
    }

    public boolean isIsEnd() {
        return isEnd.get();
    }

    public void setIsEnd() {
        isEnd.set(true);
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        SuperStaticCalc.roundName = roundName;
    }
}