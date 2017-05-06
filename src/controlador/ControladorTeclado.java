/**
 * ControladorTeclado.java
 * @asignatura Programacion de Aplicaciones Interactivas
 * @practica Practica 12 : BubbleShot
 * @author Aythami Torrado Cabrera <alu0100837018@ull.edu.es>
 * @date 3 may. 2017
 *
 */
package controlador;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import modelo.Bola;
import modelo.Canion;
import modelo.Utiles;
import vista.PanelJuego;

public class ControladorTeclado implements KeyListener {
	
	Canion canion;
	Bola bolaCanion;
	PanelJuego panel;
	ArrayList<Bola> nivel;
	public ControladorTeclado(Canion can, PanelJuego panelJuego, Bola bolaCan, ArrayList<Bola> nivel){
		setCanion(can);
		setPanel(panelJuego);
		setBolaCanion(bolaCan);
		setNivel(nivel);
	}

	public Canion getCanion() {
		return canion;
	}

	public void setCanion(Canion canion) {
		this.canion = canion;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT){
			getCanion().mover(e);
			if(!getBolaCanion().isRunning())
				getBolaCanion().moveCanion(getCanion().getxFinal(), getCanion().getyFinal());
			getPanel().repaint();
		} if(e.getKeyCode() == KeyEvent.VK_SPACE && !getBolaCanion().isRunning()){
			System.out.println(getBolaCanion().getX() + " == " + getCanion().getxFinal());
				lanzarBola();
				if(getBolaCanion().isRunning()){
				//x.interrupt();
				getBolaCanion().setRunning(false);
				}
				getPanel().repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_F5){
			getPanel().repaint();
		}
	}


	private void lanzarBola() {
		getBolaCanion().setRunning(true);
		Thread one = new Thread(new Runnable(){
			public void run() {
				try {
					
					while(!getBolaCanion().isColision(getNivel())){ // Mientras este rodando
						//System.out.println(getBolaCanion());
						getBolaCanion().move();
						getPanel().repaint();
						Thread.sleep(100);
					} // Cuando colisiona ->
					
					Bola bolaTemp = new Bola(getBolaCanion().getX(), getBolaCanion().getY(), Bola.ESTATICA);
					bolaTemp.setColor(getBolaCanion().getColor());
					getNivel().add(bolaTemp);		

					getBolaCanion().setX(canion.getxFinal() - Bola.POSCANION);
					getBolaCanion().setY(canion.getyFinal() - Bola.POSCANION);
					getBolaCanion().setColor(Utiles.colorBolaAleatorio());
					
					getNivel().get(2).setColor(Color.BLACK);
					getPanel().repaint();
				} catch (Exception e){ e.printStackTrace(); }
				
				}
			});
			one.start();
			

			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public PanelJuego getPanel() {
		return panel;
	}

	public void setPanel(PanelJuego panel) {
		this.panel = panel;
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
