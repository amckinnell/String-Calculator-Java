package com.valuablecode.kata;

public class StringCalculator {

    public int add(String numbers) {
        int sum = 0;

        for (String value : parse(numbers)) {
            sum += Integer.parseInt(value);
        }

        return sum;
    }

    private String[] parse(String numbers) {
        if (numbers.isEmpty()) return new String[] {};

        return numbers.split(",");
    }

}
