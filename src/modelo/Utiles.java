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
import java.util.ArrayList;

import vista.PanelJuego;

public class Utiles {
	
	public final static int MORADO = 0;
	public final static int AZUL = 1;
	public final static int AMARILLO = 2;
	public final static int ROJO = 3;
	public final static int VERDE = 4;
	
	/**
	 * @return Un color aleatorio para la bola
	 */
	public static Color colorBolaAleatorio() {
		int select = (int) (Math.random() * 5);
		Color color = null;
		switch(select){
		case MORADO :{
			color = new Color(153,51,197);
		}break;
		case AZUL :{
			color = new Color(43,93,212);
		}break;
		case AMARILLO :{
			color = new Color(255, 254, 14);
		}break;
		case ROJO :{
			color = new Color(255,17,17);
		}break;
		case VERDE :{
			color = new Color(43,208,48);
		}break;
			default:
				color = Color.BLACK;
		}
		
		return color;
	}

	
	/**
	 * @return Un color aleatorio
	 */
	public static Color colorAleatorio() {
		int red = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		
		return new Color(red, green, blue);
	}

	public static void aniadirBolas(int yPos, int nBolas, ArrayList<Bola> nivel) {
		int x = 0;
		for(int i = 0; i < nBolas - 1; i++){
			nivel.add(new Bola( x , yPos, Bola.ESTATICA));
				x += Bola.TAMANIO;
		}
		
		x = Bola.POSCANION;
		yPos = Bola.TAMANIO;
		for(int i = 0; i < nBolas - 2; i++){
			nivel.add(new Bola( x , yPos, Bola.ESTATICA));
				x += Bola.TAMANIO;
		}
		
	}

}
