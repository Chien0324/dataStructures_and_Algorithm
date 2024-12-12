package org.example;
import java.util.Arrays;
import java.util.Random;

public class SortComparison {
    // Bubble Sort implementation
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);   // Sort elements before partition
            quickSort(arr, pi + 1, high);  // Sort elements after partition
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        // Array sizes to test
        int[] smallArray = generateRandomArray(10);      // Small array
        int[] mediumArray = generateRandomArray(100);     // Medium array
        int[] largeArray = generateRandomArray(1000);     // Large array

        // Test Bubble Sort
        System.out.println("Bubble Sort Performance:");
        testSortPerformance(smallArray.clone(), "Bubble Sort");
        testSortPerformance(mediumArray.clone(), "Bubble Sort");
        testSortPerformance(largeArray.clone(), "Bubble Sort");

        // Test Quick Sort
        System.out.println("\nQuick Sort Performance:");
        testSortPerformance(smallArray.clone(), "Quick Sort");
        testSortPerformance(mediumArray.clone(), "Quick Sort");
        testSortPerformance(largeArray.clone(), "Quick Sort");
    }

    // Method to test and time each sort
    public static void testSortPerformance(int[] array, String sortType) {
        long startTime = System.nanoTime();

        if (sortType.equals("Bubble Sort")) {
            bubbleSort(array);
        } else if (sortType.equals("Quick Sort")) {
            quickSort(array, 0, array.length - 1);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Convert to milliseconds
        System.out.println(sortType + " (Array size " + array.length + "): " + duration + " ms");
    }

    // Helper method to generate a random array of specified size
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(1000);
        }
        return array;
    }
}
