package com.example.demo;

import java.util.ArrayList;

public class MathService {
    public static String calculateQuery(String operation, double x, double y){
        double result = 0;
        switch (operation){
            case "add":
                result =  x + y;
                break;
            case "subtract":
                result =  x - y;
                break;
            case "multiply":
                result = x * y;
                break;
            case "divide":
                if(y != 0){
                    result = x / y;
                }
                else{
                    return "impossibru!";
                }
        }
        return String.valueOf(result);
    }

    public static String sumQuery(ArrayList valsToSum){
        double sum = 0;
        int size = valsToSum.size();
        for(int i = 0; i < size; i++){
            sum += Integer.parseInt(valsToSum.get(i).toString());
        }
        return String.valueOf(sum);
    }
}
