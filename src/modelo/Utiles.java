/**
 * Utiles.java
 * @asignatura Programacion de Aplicaciones Interactivas
 * @practica Practica 13 : Disparo Bolas
 * @author Aythami Torrado Cabrera <alu0100837018@ull.edu.es>
 * @date 2 may. 2017
 *
 */
package modelo;

import java.awt.Color;

public class Utiles {
	
	
	
	
	
	/**
	 * @return Un color aleatorio
	 */
	public static Color colorAleatorio() {
		int red = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		
		return new Color(red, green, blue);
	}

}
