package app;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Leer la consigna: escribir un algoritmo que permita almacenar las cargas
 * transportadas por camiones en el depósito más adecuado.
 * 
 * Una empresa tiene tres depósitos: uno grande de 30 toneladas, uno mediano de
 * 20 toneladas y uno chico de 15 toneladas. Sus camiones soportan distintas
 * capacidades en toneladas y no siempre están cargados totalmente. Cada vez que
 * llega un camión hay que pesarlo y dirigirlo al depósito adecuado. La balanza
 * tiene un límite de 30 toneladas, es el tope máximo de carga permitido.
 * 
 * Si un depósito recibió una carga debe cerrarse. Informar la carga ociosa de
 * los depósitos.
 * 
 */
public class Sistema {

	public static void main(String[] args) {
		int salir = -1;
		int noConfigurar = 0;

		Scanner Tc = new Scanner(System.in);
		Dep depo = new Dep();
		int nDepositos = -1;
		Float entrada = null;
		do {

			// Verifico que se ingrese solo numero
			do {
				while (nDepositos == -1) {
					try {
						// Pido que ingrese la cantidad de depositos que posee en la empresa
						System.out.println("---CONFIGURACION DEPOSITOS EMPRESA---");
						System.out.println("Ingrese cuantos depositos tiene");
						nDepositos = Tc.nextInt();
						depo.setCantidadDep(new Float[nDepositos]);
					} catch (Exception e) {
						System.out.println("Debe ingresar solo numeros no letras " + e);
						Tc.nextLine();
					}
				}
				noConfigurar = 1;
			} while (noConfigurar != 1);
			// Ingreso toneladas y verifico que no manden numeros

			try {
				System.out.println(
						"////////////////////////////////////////////////°°°°°////////////////////////////////////////////////");
				System.out.println("Ingresar las toneladas que entran a pesar");
				entrada = Tc.nextFloat();
				if (entrada.compareTo(31f) < 0f) {
					depo.setToneladas(entrada);
					depo.llamadoSolucionFinal();
				} else {
					System.out.println(
							"////////////////////////////////////////////////°°°°°////////////////////////////////////////////////");
					System.out.println("La entrada debe ser menor o igual a 30 ");
				}
			} catch (Exception e) {
				System.out.println("Debe ingresar solo numeros no letras " + e);
				Tc.nextLine();
			}

			try {
				System.out.println("Ingrese 0 para salir si no 1 para ver lista de depositos 2 para continuar");
				salir = Tc.nextInt();
				while (salir == 1) {
					System.out.print(depo.getA());
					System.out.println(
							"Si desea salir de la lista ingrese 2 si no 1 para repetir lista o 0 para cerrar app");
					salir = Tc.nextInt();
				}
			} catch (Exception e) {
				System.out.println("Debe ingresar los numeros solicitados para que funcione el sistema");
				Tc.nextLine();
			}

		} while (salir != 0);

	}
}
