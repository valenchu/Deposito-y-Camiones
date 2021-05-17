package app;

import java.util.Arrays;
import java.util.Scanner;

public class Dep {

	private Float toneladas = 0f; // 30 20 15
	private String nombre = ""; // grande, mediano o chico
	private String cerrado = ""; // Si o NO
	private Float[] cantidadDep = null;
	///////////////////////////////////
	Scanner sn = new Scanner(System.in);

	public Float getToneladas() {
		return toneladas;
	}

	public void setToneladas(Float toneladas) {
		this.toneladas = toneladas;
	}

	public Float[] getCantidadDep() {
		return cantidadDep;
	}

	// Funcion que determina los depositos y cuantas toneladas entran en cada uno
	public void setCantidadDep(Float[] cantidadDep) {
		this.cantidadDep = cantidadDep;

		for (int i = 0; i < cantidadDep.length; i++) {
			System.out.println(
					"////////////////////////////////////////////////°°°°°////////////////////////////////////////////////");
			System.out.println("Ingrese la cantidad de toneladas que entran en el deposito " + i);
			this.cantidadDep[i] = sn.nextFloat();
		}
		System.out.println(toString());
	}

	public void llamadoSolucionFinal() {
		solucionFinal();
	}

	private void solucionFinal() {
		// Calculo la ociosa
		int xDeposito = calculoOciosa(this.cantidadDep, this.toneladas);
		// Asigno el nombre del deposito
		if (this.cantidadDep[xDeposito] >= 30f) {
			this.nombre = "Grande";
		} else if (this.cantidadDep[xDeposito] >= 20f && this.cantidadDep[xDeposito] < 30f) {
			this.nombre = "Mediano";
		} else {
			this.nombre = "Pequeño";
		}
		System.out.println(
				"////////////////////////////////////////////////°°°°°////////////////////////////////////////////////");
		// Muestro por pantalla cantidad ociosa y el deposito que se cerrara
		System.out.println(
				"El depósito quedó con una capacidad ociosa de " + (this.cantidadDep[xDeposito] - this.toneladas));
		this.cantidadDep[xDeposito] = 0f; // Depósito cerrado
		System.out.println(
				"////////////////////////////////////////////////°°°°°////////////////////////////////////////////////");
		if (xDeposito >= 0) {
			System.out.println(
					"En el depósito " + this.nombre + " caben las " + this.toneladas.intValue() + " toneladas");
		} else {
			System.out.println("No hay depósito para ese peso en toneladas  " + this.toneladas.intValue());
		}
		System.out.println(
				"////////////////////////////////////////////////°°°°°////////////////////////////////////////////////");
		System.out.println("El deposito " + this.nombre + " se cerro");

	}

	// Realizo calculo osciosa
	private int calculoOciosa(Float[] deposito, Float entrada) {
		int xDeposito = -1; // depósito seleccionado
		float min = 9999;
		float xOciosa = 0;
		for (int i = 0; i < deposito.length; i++) {
			xOciosa = deposito[i].intValue() - entrada.intValue();
			if ((min > xOciosa) && (xOciosa >= 0f)) {
				min = xOciosa;
				xDeposito = i;
			}
		}
		return xDeposito;
	}

	@Override
	public String toString() {
		return "Dep [cantidadDep=" + Arrays.toString(cantidadDep) + "]";
	}

}
