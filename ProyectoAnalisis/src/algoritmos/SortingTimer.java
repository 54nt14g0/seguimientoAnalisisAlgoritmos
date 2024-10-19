package algoritmos;

public class SortingTimer {

    // Método para medir el tiempo de ejecución de un algoritmo de ordenamiento
    public static long measureSortingTime(int[] arr, String algorithm, int target, int limit) {
    	
    	
        long tiempoInicial = System.nanoTime();

        switch (algorithm) {
            case "BubbleSort":
                BubbleSort.bubbleSort(arr);
                break;
            case "QuickSort":
                QuickSort.quickSort(arr, 0, arr.length - 1);
                break;
            case "StoogeSort":
                StoogeSort.stoogeSort(arr, 0, arr.length - 1);
                break;
            case "PigeonholeSort":
                PigeonholeSort.pigeonholeSort(arr);
                break;
            case "MergeSort":
                MergeSort.mergeSort(arr, 0, arr.length - 1);
                break;
            case "BitonicSort":
                BitonicSort.bitonicSort(arr, 0, arr.length, true);
                break;
                
            // algoritmos de búsqueda
            case "BusquedaLineal":
            	System.out.println(AlgoritmosBusqueda.busquedaLineal(arr, target));
            	break;
            	
            	
            case "BusquedaBinaria":
                System.out.println(AlgoritmosBusqueda.busquedaBinaria(arr, target));
                break;	
            	
            case "BusquedaLinealLimitada":
            	System.out.println(AlgoritmosBusqueda.busquedaLinealLimitada(arr, target, limit));
            	break;
            	
            case "BusquedaSaltos":
            	System.out.println(AlgoritmosBusqueda.busquedaSaltos(arr, target));
            	break;
            	
        }

        long tiempoFinal = System.nanoTime();
        
        long durationInNano = tiempoFinal - tiempoInicial;
        long durationInMillis = durationInNano / 1_000_000;
        
        
        return durationInMillis;  // Retorna el tiempo en nanosegundos
    }
}
