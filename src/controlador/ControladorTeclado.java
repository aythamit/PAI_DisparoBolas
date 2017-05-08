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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import modelo.Bola;
import modelo.Canion;
import modelo.Utiles;
import vista.PanelJuego;

public class ControladorTeclado implements KeyListener , MouseListener , MouseMotionListener{
	
	private static final int TIEMPO = 5;
	
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
				getBolaCanion().setAngulo(getCanion().getGrados());
			getPanel().repaint();
		} if(e.getKeyCode() == KeyEvent.VK_SPACE && !getBolaCanion().isRunning()){
			
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
					getBolaCanion().setAngulo( getCanion().getGrados());
					ArrayList<Bola> temporal = new ArrayList<Bola>();
					while(temporal.size() == 0){ // Mientras este rodando
						temporal = getBolaCanion().colision(getNivel());
						getBolaCanion().move();
						getPanel().repaint();
						Thread.sleep(TIEMPO);
					} // Cuando colisiona ->
					//System.out.println("Color Colisionada: " + temporal.getColor() + " Bola del cañon: " + getBolaCanion().getColor());
					if(temporal.size() == 1){ //Colisiona con uno
////						if(temporal.get(0).equals(getBolaCanion()))
////							getNivel().add(getBolaCanion());
//						else
							getNivel().remove( temporal.get(0));
					} else if(temporal.size() > 1){
						// Sonido de error Tiro fallido
					}
					
//					
//					if( !temporal.equals(getBolaCanion()) && temporal.getColor().equals(getBolaCanion().getColor())){
//						//Elimimanos temporal del array
//						//System.out.println("Son del mismo color");
//						getNivel().remove(temporal);
//					}else{
//						//La metemos dentro del array
//					Bola bolaTemp = new Bola(getBolaCanion().getX(), getBolaCanion().getY() + 1, Bola.ESTATICA);
//					bolaTemp.setColor(getBolaCanion().getColor());
//					getNivel().add(bolaTemp);		
//					}
					
					getBolaCanion().reset(getCanion().getxFinal() , getCanion().getyFinal());
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		lanzarBola();
		if(getBolaCanion().isRunning()){
		//x.interrupt();
		getBolaCanion().setRunning(false);
		}
		getPanel().repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		getCanion().calculoNuevaPos(e.getX(), e.getY());
		if(!getBolaCanion().isRunning())
			getBolaCanion().moveCanion(getCanion().getxFinal(), getCanion().getyFinal());
		getBolaCanion().setAngulo(getCanion().getGrados());
		getPanel().repaint();
		
	}

}
