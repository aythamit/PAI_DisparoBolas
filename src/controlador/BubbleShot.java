/**
 * BubbleShot.java
 * @asignatura Programacion de Aplicaciones Interactivas
 * @practica Practica 12 : BubbleShot
 * @author Aythami Torrado Cabrera <alu0100837018@ull.edu.es>
 * @date 3 may. 2017
 *
 */
package controlador;

import javax.swing.JApplet;

import vista.VentanaJuego;

public class BubbleShot extends JApplet{
	
	public void init(){

		VentanaJuego frame = new VentanaJuego();
		this.add(frame.getBubbleshot());
		frame.setVisible(false);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaJuego frame = new VentanaJuego();
	}

}
