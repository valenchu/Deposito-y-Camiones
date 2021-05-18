package app;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dep {

	private Float toneladas = 0f; // 30 20 15
	private String nombre = ""; // grande, mediano o chico
	private ArrayList a = new ArrayList<>();
	private String cerrado = ""; // Si o NO
	private Float[] cantidadDep = null;
	private int cuantosDep = -1;
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

	public ArrayList getA() {
		return a;
	}

	// Funcion que determina los depositos y cuantas toneladas entran en cada uno
	public void setCantidadDep(Float[] cantidadDep) {
		this.cantidadDep = cantidadDep;
		this.cuantosDep = cantidadDep.length;
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

		System.out.println(
				"////////////////////////////////////////////////°°°°°////////////////////////////////////////////////");

		System.out.println(
				"////////////////////////////////////////////////°°°°°////////////////////////////////////////////////");
		if (xDeposito >= 0) {
			// Asigno el nombre del deposito
			if (this.cantidadDep[xDeposito] >= 30f) {
				this.nombre = "Grande";
			} else if (this.cantidadDep[xDeposito] >= 20f && this.cantidadDep[xDeposito] < 30f) {
				this.nombre = "Mediano";
			} else {
				this.nombre = "Pequeño";
			}
			// Muestro por pantalla cantidad ociosa y el deposito que se cerrara
			System.out.println(
					"El depósito quedó con una capacidad ociosa de " + (this.cantidadDep[xDeposito] - this.toneladas));
			System.out.println(
					"////////////////////////////////////////////////°°°°°////////////////////////////////////////////////");
			this.cerrado = this.cantidadDep[xDeposito].toString();
			this.cantidadDep[xDeposito] = 0f; // Depósito cerrado
			System.out.println(
					"En el depósito " + this.nombre + " entraron las " + this.toneladas.intValue() + " toneladas");
		} else {

			System.out.println("No hay depósito para ese peso en toneladas disponible " + this.toneladas.intValue());

		}
		if (xDeposito >= 0) {
			System.out.println(
					"////////////////////////////////////////////////°°°°°////////////////////////////////////////////////");
			System.out.println("El deposito " + this.nombre + " se cerro");
			// Voy guardando los depositos en una lista que me permite verla en la parte del
			// sistema ingresando 1
			a.add("El deposito " + this.nombre + " con la capacidad de " + this.cerrado
					+ " esta cerrado y en 0 capacidad");
		}

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
