/**
 * PanelJuego.java
 * @asignatura Programacion de Aplicaciones Interactivas
 * @practica Practica 12 : BubbleShot
 * @author Aythami Torrado Cabrera <alu0100837018@ull.edu.es>
 * @date 3 may. 2017
 *
 */
package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import controlador.ControladorTeclado;
import modelo.Canion;

@SuppressWarnings("serial")
public class PanelJuego extends JPanel {
	
	public static final int PANEL_WIDTH = VentanaJuego.FRAME_WIDTH;
	public static final int PANEL_HEIGTH = VentanaJuego.FRAME_HEIGTH ;
	
	Canion canion = new Canion(PANEL_WIDTH / 2 , PANEL_HEIGTH -40);
	
	public PanelJuego(){
		setSize(PANEL_WIDTH, PANEL_HEIGTH);
		setBackground(Color.CYAN);
		System.out.println("Holica");
//		KeyListener listener = new MyKeyListener();
//		addKeyListener(listener);
		setFocusable(true);
		ControladorTeclado tecladoListen= new ControladorTeclado(canion, this);
		
		addKeyListener(tecladoListen);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(4));
		g2.setColor(Color.RED);
		g2.drawLine(canion.getxInicio(), canion.getyInicio(), canion.getxFinal(), canion.getyFinal());
	}

}
