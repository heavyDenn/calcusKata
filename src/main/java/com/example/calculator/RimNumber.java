package com.example.calculator;

public enum RimNumber {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10);
    int number;

    RimNumber(int number) {
        this.number = number;
    }

    int getNumber() {
        return number;
    }


}
