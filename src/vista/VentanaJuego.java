/**
 * VentanaJuego.java
 * @asignatura Programacion de Aplicaciones Interactivas
 * @practica Practica 12 : BubbleShot
 * @author Aythami Torrado Cabrera <alu0100837018@ull.edu.es>
 * @date 3 may. 2017
 *
 */
package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaJuego extends JFrame {
	
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGTH = 600;
	private PanelJuego bubbleshot;
	
	public VentanaJuego(){
		
		bubbleshot = new PanelJuego();
		add(bubbleshot);
		initVentanta();
		
	}

	private void initVentanta() {
		// TODO Auto-generated method stub
		setTitle("BubbleShot");
		setSize( FRAME_WIDTH , FRAME_HEIGTH);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
