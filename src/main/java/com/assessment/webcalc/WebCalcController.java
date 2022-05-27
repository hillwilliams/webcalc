package com.assessment.webcalc;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.AsyncResponse;
import jakarta.ws.rs.container.Suspended;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Path("/")
public class WebCalcController {

    private static final ExecutorService executor = Executors.newFixedThreadPool(22);

    private static final SuperStaticCalc calc = SuperStaticCalc.getInstance();

    @POST
    @Produces("text/plain")
    public void calculate(String val, @Suspended AsyncResponse ar) {

        executor.execute(() -> {
          var res = execute(val);
          ar.resume(res);
        });
    }

    private String execute(String value){
        var val  = value.trim().toLowerCase();
        try {
            var numb = Integer.parseInt(val);
            WebCalcController.calc.sum(numb);
        } catch (NumberFormatException e) {
            var strs = val.trim().split(" ");
            if (strs.length == 2 && strs[0].equals("end")) {
                WebCalcController.calc.setIsEnd();
                WebCalcController.calc.setRoundName(strs[1]);
            }else {
                return "Wrong command";
            }
        }

        var isEnd = false;
        while (!isEnd) {
            isEnd = WebCalcController.calc.isIsEnd();
        }

        return WebCalcController.calc.getCount() + " " + WebCalcController.calc.getRoundName();
    }
}