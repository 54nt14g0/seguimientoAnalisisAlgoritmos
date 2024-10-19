package algoritmos;

import java.util.Arrays;

public class AlgoritmosBusqueda {
	
	
	
	 // Búsqueda lineal (O(n))
	
	 public static int busquedaLineal(int[] arr, int target) {
	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] == target) {
	                return i;
	            }
	        }
	        return -1;
	    }


    // Búsqueda lineal limitada (O(m)), donde m es el número de elementos a verificar
	 public static int busquedaLinealLimitada(int[] arr, int target, int bound) {
	        int limit = Math.min(arr.length, bound);
	        for (int i = 0; i < limit; i++) {
	            if (arr[i] == target) {
	                return i;
	            }
	        }
	        return -1;
	    }

    // Búsqueda binaria (O(log n)), requiere que el arreglo esté ordenado
	 public static int busquedaBinaria(int[] arr, int target) {
	        Arrays.sort(arr);  // Aseguramos que el array esté ordenado
	        int left = 0;
	        int right = arr.length - 1;

	        while (left <= right) {
	            int mid = left + (right - left) / 2;
	            if (arr[mid] == target) {
	                return mid;
	            }
	            if (arr[mid] < target) {
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }
	        }
	        return -1;
	    }
    // Búsqueda por saltos (Jump Search) (O(√n)), requiere que el arreglo esté ordenado
	 public static int busquedaSaltos(int[] arr, int target) {
	        int n = arr.length;
	        int step = (int) Math.floor(Math.sqrt(n));
	        int prev = 0;

	        while (arr[Math.min(step, n) - 1] < target) {
	            prev = step;
	            step += (int) Math.floor(Math.sqrt(n));
	            if (prev >= n) {
	                return -1;
	            }
	        }

	        while (arr[prev] < target) {
	            prev++;
	            if (prev == Math.min(step, n)) {
	                return -1;
	            }
	        }

	        if (arr[prev] == target) {
	            return prev;
	        }

	        return -1;
	    }
	

}
