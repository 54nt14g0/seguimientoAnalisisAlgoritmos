package algoritmos;

import java.util.Arrays;

import javax.swing.JOptionPane;

import org.jfree.data.category.DefaultCategoryDataset;

public class Main {

	public static void main(String[] args) throws Exception {

		int size = Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el n�mero de elementos que poner al arreglo"));  // Cambia el tama�o del arreglo seg�n sea necesario (10.000, 100.000, 1.000.000)
		System.out.println("tama�o de arreglo seteado en "+size);


		String respuesta = JOptionPane.showInputDialog(null,"digite '1' para probar los algoritmos de ordenamiento"
				+ " o ingrese '2' para poner a prueba los de b�squeda");

		int limit =  0;



		// Generar n�meros aleatorios y guardarlos en un archivo de texto en la carpeta "algoritmos"
		UtilidadesGenerales.generarNumerosAleatorios(size);



		// Cargar los n�meros desde el archivo de texto a un arreglo
		int[] arr =  UtilidadesGenerales.LlenarArregloNumerosAleatorios(size);

		

		
		int target = 0;
		

		if (respuesta.equals("1")){


			String[] algorithms = { "BubbleSort" ,"QuickSort", "PigeonholeSort", "MergeSort", "BitonicSort","StoogeSort"};
			long[] times = new long[algorithms.length];

			for (int i = 0; i < algorithms.length; i++) {
				int[] arrCopy = arr.clone();  // Clonar el arreglo para cada algoritmo
				times[i] = SortingTimer.measureSortingTime(arrCopy, algorithms[i], target, limit);
				System.out.println(algorithms[i] + " tom� " + times[i] + " milisegundos");
			}

			DefaultCategoryDataset dataset = ChartGenerator.createDataset(algorithms, times);
			ChartGenerator chart = new ChartGenerator("Tiempos de Ejecuci�n", "Algoritmos", "Tiempo (ns)", dataset);
			chart.pack();
			chart.setVisible(true);
		}

		if (respuesta.equals("2")){
			
			
			
			
			int [] arregloOrdenado = arr;
			QuickSort.quickSort(arregloOrdenado, 0, arregloOrdenado.length - 1);

			
			//Ac� se pone que el objetivo a buscar para los algoritmos de busqueda es el �ltimo elemento del array
			target = arregloOrdenado [arregloOrdenado.length-1];
			System.out.println(target);
			limit = Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el n�mero l�mite para el m�todo de busqueda lineal limitado"));

			String[] algorithms = { "BusquedaLineal"
					,"BusquedaBinaria", "BusquedaLinealLimitada", "BusquedaSaltos"};
			long[] times = new long[algorithms.length];

			for (int i = 0; i < algorithms.length; i++) {
				int[] arrCopy = arregloOrdenado.clone();  // Clonar el arreglo para cada algoritmo
				times[i] = SortingTimer.measureSortingTime(arrCopy, algorithms[i], target, limit);
				System.out.println(algorithms[i] + " tom� " + times[i] + " milisegundos");
			}

			DefaultCategoryDataset dataset = ChartGenerator.createDataset(algorithms, times);
			ChartGenerator chart = new ChartGenerator("Tiempos de Ejecuci�n", "Algoritmos", "Tiempo (ns)", dataset);
			chart.pack();
			chart.setVisible(true);
		}
	}




}


    



