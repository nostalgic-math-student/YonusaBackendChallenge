/*
 *  Yonusa Backend Challenge 
 *  Solucion por Josue Rojas Noble
 *  Version de JDK: openjdk 11.0.7
 *  
 *  Objetivo: Se introduce una cadena de texto (tipo String) y se imprime en pantalla 
 *  cuantas palabras hay en el archivo asi como cuantas repeticiones por palabra.
 *  La cadena dada está inicializada en linea 20 con el nombre de cadena
 */

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		// Cadena inicial del problema
		String cadena = new String("The lazy. brown fox; jumped lazy lazy");
		
		// Usamos StringTokenizer para separar cadena por palabras. 
		StringTokenizer tokenizer = new StringTokenizer(cadena," ;,.",false);
		
		// Hashmap donde guardaremos cada palabra con su contador
		HashMap<String, Integer> contador = new HashMap<String, Integer>(); 
		
		
		// Ciclo sobre tokens en StringTokenizer para contar palabras.
		while(tokenizer.hasMoreTokens()) 
			{
				// Para evitar confusiones con mayusculas convertimos las palabras a minusculas
				String s = tokenizer.nextToken();
				s = s.toLowerCase();
				
				// Si la palabra ya fue registrada
				if(contador.containsKey(s)) 
				{
					// Sobreescribe la entrada sumando +1 al contador, registrando otra palabra.
					contador.put(s, contador.get(s)+1);
					
				}
				
				// Si la palabra no ha sido registrada
				else 
				{
					// Anota la palabra con contador en 1
					contador.put(s, 1);	
					
				}
			}
		// entero con total de palabras leídas
		int total_palabras = 0; 
		
		//creamos arreglo de Strings para ordenar alfabéticamente
		String[] contador_ordenado = new String[contador.size()];
		
		//ciclo sobre elementos de Hashmap para contar todas las palabras y asignar el array de Strings a ordenar
		int j = 0;
		for(String s : contador.keySet()) 
		{
			contador_ordenado[j] = s;
			total_palabras = total_palabras + contador.get(s);
			j++;
		}
		// Ordenamos el arreglo de palabras
		Arrays.sort(contador_ordenado);
		
		 //Ciclo sobre las palabras en el arreglo para escribir los resultados en pantalla
		for(String s : contador_ordenado ) 
		{
			System.out.println(s + ": " +String.format("%03d", contador.get(s)));
			
		}

		// Conteo total de palabras en pantalla
		System.out.println("Total words: " + total_palabras);
	}

}
