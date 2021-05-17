package app;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Leer la consigna: escribir un algoritmo que permita almacenar las cargas
 * transportadas por camiones en el dep�sito m�s adecuado.
 * 
 * Una empresa tiene tres dep�sitos: uno grande de 30 toneladas, uno mediano de
 * 20 toneladas y uno chico de 15 toneladas. Sus camiones soportan distintas
 * capacidades en toneladas y no siempre est�n cargados totalmente. Cada vez que
 * llega un cami�n hay que pesarlo y dirigirlo al dep�sito adecuado. La balanza
 * tiene un l�mite de 30 toneladas, es el tope m�ximo de carga permitido.
 * 
 * Si un dep�sito recibi� una carga debe cerrarse. Informar la carga ociosa de
 * los dep�sitos.
 * 
 */
public class Sistema {

	public static void main(String[] args) {
		Scanner Tc = new Scanner(System.in);
		Dep depo = new Dep();
		int nDepositos = -1;

		Float entrada = null;
		// Verifico que se ingrese solo numero
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
		// Ingreso toneladas y verifico que no manden numeros
		while (depo.getToneladas() == 0f) {
			try {
				System.out.println("////////////////////////////////////////////////�����////////////////////////////////////////////////");
				System.out.println("Ingresar las toneladas que entran a pesar");
				entrada = Tc.nextFloat();
				if (entrada.compareTo(31f) < 0f) {
					depo.setToneladas(entrada);
					depo.llamadoSolucionFinal();
				} else {
					System.out.println("////////////////////////////////////////////////�����////////////////////////////////////////////////");
					System.out.println("La entrada debe ser menor o igual a 30 ");
				}
			} catch (Exception e) {
				System.out.println("Debe ingresar solo numeros no letras " + e);
				Tc.nextLine();
			}
		}
	}
}
