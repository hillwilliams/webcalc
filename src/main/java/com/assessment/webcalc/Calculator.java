package com.assessment.webcalc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Calculator {

    private static Calculator calculator = null;
    private final Map<String, Integer> storage = new HashMap<>();

    private Calculator() {}

    public static Calculator getInstance() {
        if (calculator == null) {
            calculator = new Calculator();
        }
        return calculator;
    }

    public void sum(String key, Integer value) {
        var num = storage.get(key);
        if (num == null) {
            num = value;
            storage.put(key, num);
        } else {
            num = num + value;
            storage.put(key, num);
        }
    }

    public Integer getValue(String key) {
        return storage.get(key);
    }

    public Pair getPair(String key) {
        return new Pair(key, storage.get(key).toString());
    }

    public void cleanValue(String key) {
        storage.remove(key);
    }

    public void reset() {
        storage.clear();
    }
}
