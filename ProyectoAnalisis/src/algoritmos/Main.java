package algoritmos;

import java.util.Arrays;

import javax.swing.JOptionPane;

import org.jfree.data.category.DefaultCategoryDataset;

public class Main {

	public static void main(String[] args) throws Exception {

		int size = Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el número de elementos que poner al arreglo"));  // Cambia el tamaño del arreglo según sea necesario (10.000, 100.000, 1.000.000)
		System.out.println("tamaño de arreglo seteado en "+size);


		String respuesta = JOptionPane.showInputDialog(null,"digite '1' para probar los algoritmos de ordenamiento"
				+ " o ingrese '2' para poner a prueba los de búsqueda");

		int limit =  0;



		// Generar números aleatorios y guardarlos en un archivo de texto en la carpeta "algoritmos"
		UtilidadesGenerales.generarNumerosAleatorios(size);



		// Cargar los números desde el archivo de texto a un arreglo
		int[] arr =  UtilidadesGenerales.LlenarArregloNumerosAleatorios(size);

		

		
		int target = 0;
		

		if (respuesta.equals("1")){


			String[] algorithms = { "BubbleSort" ,"QuickSort", "PigeonholeSort", "MergeSort", "BitonicSort","StoogeSort"};
			long[] times = new long[algorithms.length];

			for (int i = 0; i < algorithms.length; i++) {
				int[] arrCopy = arr.clone();  // Clonar el arreglo para cada algoritmo
				times[i] = SortingTimer.measureSortingTime(arrCopy, algorithms[i], target, limit);
				System.out.println(algorithms[i] + " tomó " + times[i] + " milisegundos");
			}

			DefaultCategoryDataset dataset = ChartGenerator.createDataset(algorithms, times);
			ChartGenerator chart = new ChartGenerator("Tiempos de Ejecución", "Algoritmos", "Tiempo (ns)", dataset);
			chart.pack();
			chart.setVisible(true);
		}

		if (respuesta.equals("2")){
			
			
			
			
			int [] arregloOrdenado = arr;
			QuickSort.quickSort(arregloOrdenado, 0, arregloOrdenado.length - 1);

			
			//Acá se pone que el objetivo a buscar para los algoritmos de busqueda es el último elemento del array
			target = arregloOrdenado [arregloOrdenado.length-1];
			System.out.println(target);
			limit = Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el número límite para el método de busqueda lineal limitado"));

			String[] algorithms = { "BusquedaLineal"
					,"BusquedaBinaria", "BusquedaLinealLimitada", "BusquedaSaltos"};
			long[] times = new long[algorithms.length];

			for (int i = 0; i < algorithms.length; i++) {
				int[] arrCopy = arregloOrdenado.clone();  // Clonar el arreglo para cada algoritmo
				times[i] = SortingTimer.measureSortingTime(arrCopy, algorithms[i], target, limit);
				System.out.println(algorithms[i] + " tomó " + times[i] + " milisegundos");
			}

			DefaultCategoryDataset dataset = ChartGenerator.createDataset(algorithms, times);
			ChartGenerator chart = new ChartGenerator("Tiempos de Ejecución", "Algoritmos", "Tiempo (ns)", dataset);
			chart.pack();
			chart.setVisible(true);
		}
	}




}


    



