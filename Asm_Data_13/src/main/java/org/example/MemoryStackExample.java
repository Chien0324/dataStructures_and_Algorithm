package org.example;

public class MemoryStackExample {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        int result = multiply(x, y);
        System.out.println("Result: " + result);
    }

    public static int multiply(int a, int b) {
        return a * b;
    }
}
