package com.assessment.webcalc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class CalcService {

    private final Calculator calc = Calculator.getInstance();

    private static final Map<String, String> roundStatuses = new ConcurrentHashMap<>();

    public Pair parseIncomingString(String val) {

        var numRegex = "(end)([a-z]+)|(\\d+|[a-z]+)(?:\s*)([a-z]+)";
        var pattern = Pattern.compile(numRegex);
        var matcher = pattern.matcher(val);
        while (matcher.find()) {
            var value1 = matcher.group(1); //value should be command
            var key1 = matcher.group(2); //key round name
            var value2 = matcher.group(3); //value should be number
            var key2 = matcher.group(4); //key round name
            if (value1 != null) {
                return new Pair(key1, value1);

            }
            if (value2 != null) {
                return new Pair(key2, value2);
            }
        }
        return new Pair("","");
    }

    public boolean isEndOfRound(String roundKey){
        var status =  roundStatuses.get(roundKey);
              if(status != null){
                 return status.equals("end");
              }
              return false;
    }

    public Pair processIncomingValue(Pair incoming){
        var value = incoming.value();
        try {
            var number = Integer.parseInt(value);
            calc.sum(incoming.key(), number);
        }catch (NumberFormatException e){
            roundStatuses.put(incoming.key(), value);
            var val = calc.getValue(incoming.key());
            return new Pair(incoming.key(), String.valueOf(val));
        }
        return new Pair(incoming.key(), calc.getValue(incoming.key()).toString());
    }

    public Integer getSumm(String key){
        return calc.getValue(key);
    }

    public void reset(Pair incoming){
        roundStatuses.remove(incoming.key(), incoming.value());
        calc.cleanValue(incoming.key());
    }
}
