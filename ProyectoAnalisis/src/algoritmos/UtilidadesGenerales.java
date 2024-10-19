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

    // M�todo para generar n�meros aleatorios de 8 d�gitos y guardarlos en un archivo de texto
    public static void generarNumerosAleatorios(int size) throws IOException {
        Random random = new Random();
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));

        for (int i = 0; i < size; i++) {
            int randomNumber = 10000000 + random.nextInt(90000000);  // N�meros aleatorios de 8 d�gitos
            writer.write(Integer.toString(randomNumber));
            writer.newLine();
        }
        writer.close();
        
        System.out.println("n�meros aleatorios generados y guardados en un TXT");
    }

    // M�todo para cargar los n�meros desde un archivo de texto a un arreglo
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
        System.out.println("conjunto de n�meros cargado y establecidos en un arreglo ");
        return arr;
    }
}
