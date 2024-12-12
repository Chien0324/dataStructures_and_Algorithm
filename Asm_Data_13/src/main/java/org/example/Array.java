package org.example;

public class Array {
    public static void main(String[] args) {
        // Initialize an array with 5 elements of type int
        int[] arr = {1, 2, 3, 4, 5};

        // Access the 3rd element (index = 2)
        System.out.println("3rd element: " + arr[2]);

        // Modify the value of the element at the 4th position
        arr[3] = 10;
        System.out.println("New element at position 4: " + arr[3]);

        // Iterate and print all elements in the array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
