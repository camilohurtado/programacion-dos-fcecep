package matrices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OperacionMatrices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] unidimensional = null;
		int[][] bidimensional = null;
		int multidimensional;

		// Coleccion que representa el total de matrices creados por el usuario
		ArrayList listadoMatrices = new ArrayList();

		// Coleccion que representa el total de vectores creados por el usuario
		ArrayList listadoVectores = new ArrayList();

		// Variable que almacena la cantidad de vectores que creará el usuario
		int cantidadVectores = 0;

		// Variable que almacena la cantidad de matrices que creará el usuario
		int cantidadMatrices = 0;

		// Variable que representa un elemento de un arreglo
		int element = 0;

		// Variable que representa la cantidad de dimensiones de una matriz
		// multidimensional
		int dimension;

		// Variable que representa la acción en el menu principal (CREACION
		// MATRICES)
		int opcionMenuPrincipal = 0;

		// Variable que representa las filas de la matriz que se va a ingresar
		int filas = 0;

		// Variable que representa las columnas de la matriz que se va a
		// ingresar
		int columnas = 0;

		// Variable que representa la acción en el menu de creación de matrices
		int opcionMenuCreacion = 0;

		// Variable que representa la accion de las operaciones con matrices
		int opcionOperaciones = 0;
		

		// Variable que representa las opciones dentro de la operacion suma de
		// vectores
		String casos = "";

		int cont = 0;

		do {

			System.out.print("\t\tMENÚ MATRICES\t\t\n");
			System.out.println("1. Creación de matrices\n2. Operación con matrices\n3. Salir");
			// Variable que representa la entrada por teclado del usuario
			Scanner lector = new Scanner(System.in);
			opcionMenuPrincipal = lector.nextInt();

			switch (opcionMenuPrincipal) {

			case 1:

				do {
					System.out.println("\t\tCREACIÓN DE MATRICES\t\t\n");
					System.out.println("1. Unidimensional\n2. Bidimensional\n3. Multidimensional\n4. Salir ");
					opcionMenuCreacion = lector.nextInt();

					switch (opcionMenuCreacion) {
					case 1:
						System.out.print("¿Cuantos vectores creará? ");
						cantidadVectores = lector.nextInt();
						cont = 0;
						while (cont < cantidadVectores) {

							System.out.print("Digite el tamaño del vector: ");
							filas = lector.nextInt();
							unidimensional = new int[filas];

							int elemento = 1;
							for (int i = 0; i < unidimensional.length; i++) {

								System.out.println("Digite el elemento " + elemento + " : ");
								element = lector.nextInt();
								unidimensional[i] = element;
								elemento++;
							}

							System.out.println("Vector unidimensional creado: " + Arrays.toString(unidimensional));
							listadoVectores.add(unidimensional);
							cont ++;
						}

						break;
					case 2:

						System.out.print("¿Cuantas matrices creará? ");
						cantidadMatrices = lector.nextInt();
						cont = 0;

						while (cont < cantidadMatrices) {

							System.out.print("Digite la cantidad de filas de la matriz: ");
							filas = lector.nextInt();
							System.out.print("Digite la cantidad de columnas de la matriz: ");
							columnas = lector.nextInt();
							bidimensional = new int[filas][columnas];

							int f = 1;
							int c = 1;
							for (int i = 0; i < bidimensional.length; i++) {

								for (int j = 0; j < bidimensional[i].length; j++) {

									System.out.println("Digite el elemento en la posición: " + f + ", " + c + " : ");
									element = lector.nextInt();
									bidimensional[i][j] = element;

									c++;

								}

								f++;
							}
						}
						System.out.println("Matriz recien creada: ");
						imprimirMatrices(bidimensional);
						break;
					case 3:
						System.out.print("Digite la dimensión de la matriz a crear: ");
						dimension = lector.nextInt();

					case 4:
					default:
						System.out.println("Opción inválida!");
						break;
					}
				} while (opcionMenuCreacion >= 5);
			case 2:

				do {

					System.out.println(
							"\t\t MENÚ DE OPERACIONES CON MATRICES \t\t\n1. Suma de matrices\n2.  Multiplicación de matrices\n3. Matrices transversales\n4. Matriz transpuesta\n5. Salir");
					opcionOperaciones = lector.nextInt();

					switch (opcionOperaciones) {

					case 1:
						do {
							System.out.println("¿Sumará vectores o matrices?\nA. Vectores\nB. Matrices\nC. Salir");
							casos = lector.next();
							boolean control = false;

							switch (casos) {

							case "A":
							case "a":
								// Suma vectores
								sumarVectores(listadoVectores);
								break;
							case "b":
							case "B":
								// Suma matrices
								sumarMatrices(listadoMatrices);
								break;
							}

						} while (!(casos.equals("C") || casos.equals("c")));
						break;
					case 2:
						do{
							
							System.out.println("\t\tMULTIPLICACIÓN DE MATRICES O VECTORES\t\t\nA. Multiplicación de escalar por matriz\nB. Multiplicacion de escalar por vector\nC. Multiplicacion de vector por matriz\nD. Multiplicacion de vector por vector\nE. Multiplicacion de matriz por matriz\nF. Salir");
							casos = lector.nextLine();
							
							switch(casos){
							case "A":
							case "a":
								System.out.println("Digite un escalar: ");
								int escalar = lector.nextInt();
								int mult = 0;
								
								int [][] matriz = (int[][] )listadoMatrices.get(0);
								imprimirMatrices(matriz);
								System.out.println(" x " + escalar);
								
								for(int i = 0; i < matriz.length; i ++){
									
									for(int j = 0; j < matriz[i].length; j ++){
										
										mult = matriz[i][j] * escalar;
										matriz[i][j] = mult;
									}
								}
								
								imprimirMatrices(matriz);
								break;
							case "B":
							case "b":
								break;
							case "C":
							case "c":
								break;
							case "D":
							case "d":
								break;
							case "E":
							case "e":
								break;
						
							}
						}while(!(casos.equalsIgnoreCase("F")));
						
						break;
					case 3:

						break;
					case 4:

						break;
					case 5:

						break;
					case 6:
						break;
					default:

						System.out.println("\t\tOpción inválida\t\t");
						break;

					}
				} while (opcionOperaciones != 6);

			case 3:
			case 4:

			}

		} while (opcionMenuPrincipal != 3);

	}

	public static void imprimirMatrices(int[][] matriz) {

		for (int i = 0; i < matriz.length; i++) {

			for (int j = 0; j < matriz[i].length; j++) {

				System.out.printf("%4d", matriz[i][j]);
			}

			System.out.println();
		}
	}

	public static void imprimirVectores(int[] vector) {

		for (int i = 0; i < vector.length; i++) {

			System.out.printf("%4d", vector[i]);

			System.out.println();
		}

	}

	public static void sumarVectores(ArrayList vectores) {

		int suma[] = null;
		int sumando1[];
		int sumando2[];
		boolean control = false;

		if (vectores.size() >= 2) {

			sumando1 = (int[]) vectores.get(0);
			sumando2 = (int[]) vectores.get(1);

			if (sumando1.length == sumando2.length) {

				imprimirVectores(sumando1);
				System.out.println("     +      ");
				imprimirVectores(sumando2);
				for (int i = 0; i < sumando1.length && control == true; i++) {

					suma = new int[sumando1.length];
					suma[i] = sumando1[i] + sumando2[i];

				}

				imprimirVectores(suma);

			} else {

				System.out.println("Los tamaños de los vectores no son iguales, no se puede hacer la suma!");
				return;
			}

		} else {

			System.out.println(
					"No hay suficientes vectores para realizar la operación. Mínimo deben haber dos (2). Actualmente hay: "
							+ vectores.size());
			return;
		}

	}

	public static void sumarMatrices(ArrayList matrices) {

		int sumaM[][] = null;
		int sumandoM1[][];
		int sumandoM2[][];

		if (matrices.size() >= 2) {

			sumandoM1 = (int[][]) matrices.get(0);
			sumandoM2 = (int[][]) matrices.get(1);

			if (sumandoM1.length == sumandoM2.length) {

				imprimirMatrices(sumandoM1);
				System.out.println("     +      ");
				imprimirMatrices(sumandoM2);
				for (int i = 0; i < sumandoM1.length; i++) {

					for (int j = 0; j < sumandoM1[i].length; j++) {

						sumaM = new int[sumandoM1.length][sumandoM1[i].length];
						sumaM[i][j] = sumandoM1[i][j] + sumandoM2[i][j];
					}

				}

				imprimirMatrices(sumaM);

			} else {

				System.out.println("Los tamaños de las matrices no son iguales, no se puede hacer la suma!");

				return;
			}

		} else {

			System.out.println(
					"No hay suficientes matrices para realizar la operación. Mínimo deben haber dos (2). Actualmente hay: "
							+ matrices.size());
			return;
		}

	}
}