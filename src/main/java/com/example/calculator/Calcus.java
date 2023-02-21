package com.example.calculator;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Calcus {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String inputData = scanner.nextLine();
        System.out.println(calc(inputData));
    }

    public static String calc(String input) throws Exception {
        String[] numbers = input.split(" ");
        if (numbers.length > 3) {
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            throw new Exception();
        }
        if (numbers.length < 3) {
            System.out.println("строка не является математической операцией");
            throw new Exception();
        }
        if (isDigit(numbers[0]) & isDigit(numbers[2])) {
            switch (numbers[1]) {
                case "+":
                    return String.valueOf(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[2]));
                case "-":
                    return String.valueOf(Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[2]));
                case "*":
                    return String.valueOf(Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[2]));
                case "/":
                    return String.valueOf(Integer.parseInt(numbers[0]) / Integer.parseInt(numbers[2]));
            }
        } else if (isDigitRim(numbers[0]) & isDigitRim(numbers[2])) {
            switch (numbers[1]) {
                case "+":
                    int sum = RimNumber.valueOf(numbers[0]).number + RimNumber.valueOf(numbers[2]).number;
                    return converter(sum);
                case "-":
                    int sum2 = RimNumber.valueOf(numbers[0]).number - RimNumber.valueOf(numbers[2]).number;
                    return converter(sum2);
                case "*":
                    int sum3 = RimNumber.valueOf(numbers[0]).number * RimNumber.valueOf(numbers[2]).number;
                    return converter(sum3);
                case "/":
                    int sum4 = RimNumber.valueOf(numbers[0]).number / RimNumber.valueOf(numbers[2]).number;
                    return converter(sum4);
            }
        }
        return "";
    }

    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            int i = Integer.parseInt(s);
            if (i >= 0 & i < 11) return true;
            else return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDigitRim(String s) throws NumberFormatException {
        try {
            RimNumber rimNumber = RimNumber.valueOf(s);
            if (rimNumber.number >= 0 & rimNumber.number < 11) return true;
            else return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String converter(int s) throws Exception {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");
        if (s < 0) {
            System.out.println("в римской системе нет отрицательных чисел");
            throw new Exception();
        } else if (s < 11) return map.get(s);
        else if (s < 20) return "X" + map.get(s % 10);
        else if (s < 30) return "XX" + map.get(s % 10);
        else if (s < 40) return "XXX" + map.get(s % 10);
        else if (s < 50) return "XL" + map.get(s % 10);
        else if (s < 60) return "L" + map.get(s % 10);
        else if (s < 70) return "LX" + map.get(s % 10);
        else if (s < 80) return "LXX" + map.get(s % 10);
        else if (s < 90) return "LXXX" + map.get(s % 10);
        else if (s < 100) return "XC" + map.get(s % 10);
        else return "C";

    }


}