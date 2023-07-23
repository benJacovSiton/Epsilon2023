package com.example.guessthenumber.gameMode;

public class question {
    String q;
    int a;

    public static int numOfQ = 10;

    public question(String q, int a) {
        this.q = q;
        this.a = a;
    }

    public String getQ() {
        return q;
    }

    public int getA() {
        return a;
    }
}
