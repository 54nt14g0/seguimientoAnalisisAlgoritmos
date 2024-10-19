package algoritmos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class UtilidadesGenerales {

	
	
	
	 // Ruta del archivo dentro del paquete "algoritmos"
    private static final String FILE_PATH = "C:\\Users\\ljane\\Downloads\\proyecto\\ProyectoAnalisis\\src\\algoritmos\\numerosAleatorios.txt";

    // Método para generar números aleatorios de 8 dígitos y guardarlos en un archivo de texto
    public static void generarNumerosAleatorios(int size) throws IOException {
        Random random = new Random();
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));

        for (int i = 0; i < size; i++) {
            int randomNumber = 10000000 + random.nextInt(90000000);  // Números aleatorios de 8 dígitos
            writer.write(Integer.toString(randomNumber));
            writer.newLine();
        }
        writer.close();
        
        System.out.println("números aleatorios generados y guardados en un TXT");
    }

    // Método para cargar los números desde un archivo de texto a un arreglo
    public static int[] LlenarArregloNumerosAleatorios(int size) throws IOException {
        int[] arr = new int[size];
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));

        String line;
        int index = 0;
        while ((line = reader.readLine()) != null && index < size) {
            arr[index] = Integer.parseInt(line);
            index++;
        }
        reader.close();
        System.out.println("conjunto de números cargado y establecidos en un arreglo ");
        return arr;
    }
}
