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
import java.util.ArrayList;

import javax.swing.JPanel;

import controlador.ControladorTeclado;
import modelo.Bola;
import modelo.Canion;
import modelo.Utiles;

@SuppressWarnings("serial")
public class PanelJuego extends JPanel {
	
	public static final int PANEL_WIDTH = VentanaJuego.FRAME_WIDTH;
	public static final int PANEL_HEIGTH = VentanaJuego.FRAME_HEIGTH ;
	
	Canion canion = new Canion(PANEL_WIDTH / 2 , PANEL_HEIGTH -40);
	Bola bolaCanion;
	ArrayList<Bola> nivel;
	
	public PanelJuego(){
		setSize(PANEL_WIDTH, PANEL_HEIGTH);
		setBackground(Color.CYAN);
		setFocusable(true);
		setNivel(new ArrayList<Bola>());
		setBolaCanion(new Bola(canion.getxFinal() - Bola.POSCANION , canion.getyFinal() - Bola.POSCANION 
				, Bola.VELOCIDAD));
		int yPos = 0;
		int nBolas = PANEL_WIDTH / Bola.TAMANIO;
		Utiles.aniadirBolas( yPos, nBolas , getNivel());
		ControladorTeclado tecladoListen= new ControladorTeclado(getCanion(), this, getBolaCanion() , getNivel());
		addKeyListener(tecladoListen);
		addMouseListener(tecladoListen);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		dibujaCanion(g2);
		dibujaBola(g2);
		dibujaNivel(g2);
	}

	private void dibujaBola(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.setColor(getBolaCanion().getColor());
		g2.fillOval(getBolaCanion().getX(), getBolaCanion().getY(), Bola.TAMANIO, Bola.TAMANIO);
	}

	private void dibujaNivel(Graphics2D g2) {
		// TODO Auto-generated method stub
		for(Bola it : getNivel()){
			g2.setColor(it.getColor());
			g2.fillOval(it.getX(), it.getY(), Bola.TAMANIO, Bola.TAMANIO);
		}
		
	}
	private void dibujaCanion(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.setStroke(new BasicStroke(4));
		g2.setColor(Color.RED);
		g2.drawLine(canion.getxInicio(), canion.getyInicio(), canion.getxFinal(), canion.getyFinal());
		
	}

	public Canion getCanion() {
		return canion;
	}

	public void setCanion(Canion canion) {
		this.canion = canion;
	}

	public Bola getBolaCanion() {
		return bolaCanion;
	}

	public void setBolaCanion(Bola bolaCanion) {
		this.bolaCanion = bolaCanion;
	}

	public ArrayList<Bola> getNivel() {
		return nivel;
	}

	public void setNivel(ArrayList<Bola> nivel) {
		this.nivel = nivel;
	}

}
