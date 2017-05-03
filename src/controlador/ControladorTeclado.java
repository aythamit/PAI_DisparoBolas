/**
 * ControladorTeclado.java
 * @asignatura Programacion de Aplicaciones Interactivas
 * @practica Practica 12 : BubbleShot
 * @author Aythami Torrado Cabrera <alu0100837018@ull.edu.es>
 * @date 3 may. 2017
 *
 */
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.Bola;
import modelo.Canion;
import vista.PanelJuego;

public class ControladorTeclado implements KeyListener {
	
	Canion canion;
	Bola bolaCanion;
	PanelJuego panel;
	public ControladorTeclado(Canion can, PanelJuego panelJuego, Bola bolaCan){
		setCanion(can);
		setPanel(panelJuego);
		setBolaCanion(bolaCan);
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
			getBolaCanion().moveCanion(getCanion().getxFinal(), getCanion().getyFinal());
			getPanel().repaint();
		} else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			Thread one = new Thread(new Runnable(){
				public void run() {
					try {
						int cont = 0;
						while(cont < 200){
						getBolaCanion().move();
						getPanel().repaint();
						Thread.sleep(100);
						cont++;
						}
					} catch (Exception e){ e.printStackTrace(); }
					
					}
				});
				one.start();

			}
		
			
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

}
