package algoritmos;

import java.util.Arrays;

public class PigeonholeSort {
    public static void pigeonholeSort(int[] arr) {
        int min = Arrays.stream(arr).min().orElse(Integer.MIN_VALUE);
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        int range = max - min + 1;

        int[] holes = new int[range];

        for (int i = 0; i < arr.length; i++) {
            holes[arr[i] - min]++;
        }

        int index = 0;
        for (int i = 0; i < range; i++) {
            while (holes[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }
}