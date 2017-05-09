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
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import modelo.Bola;
import modelo.Canion;
import modelo.Utiles;
import vista.PanelJuego;
import vista.VentanaInformacion;

public class ControladorTeclado implements KeyListener , MouseListener , MouseMotionListener{
	
	private static final int TIEMPO = 2;
	
	Canion canion;
	Bola bolaCanion;
	PanelJuego panel;
	ArrayList<Bola> nivel;
	public ControladorTeclado(Canion can, PanelJuego panelJuego, Bola bolaCan, ArrayList<Bola> nivel){
		setCanion(can);
		setPanel(panelJuego);
		setBolaCanion(bolaCan);
		setNivel(nivel);
		
		aniadirInfo();
	}

	private void aniadirInfo() {


		getPanel().getIcono().addMouseListener(new MouseListener() {
	       
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Hola");
				VentanaInformacion nuevaVentana = new VentanaInformacion();
			}

			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
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
				getBolaCanion().setAngulo(getCanion().getGrados());
			getPanel().repaint();
		} if(e.getKeyCode() == KeyEvent.VK_SPACE && !getBolaCanion().isRunning()){
			
				lanzarBola();
				if(getBolaCanion().isRunning()){
				getBolaCanion().setRunning(false);
				}
				getPanel().repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_F5){
			getPanel().repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_F4){
			if(getPanel().isDebug())
				getPanel().setDebug(false);
			else
				getPanel().setDebug(true);
				
		}
			getPanel().repaint();
	}
	
	public void eliminaColores() {
		ArrayList<Color> coloresActuales = new ArrayList<Color>();
		
		for(Bola it : getNivel()){
			
			if(!coloresActuales.contains(it.getColor())){
					coloresActuales.add(it.getColor());
				}
		}
		getPanel().setColoresPosibles(coloresActuales);
	}

	private void lanzarBola() {
		getBolaCanion().setRunning(true);
		getBolaCanion().moveCanion(getCanion().getxFinal(), getCanion().getyFinal());
		Thread one = new Thread(new Runnable(){
			public void run() {
				try {
					
					if(!getPanel().getColoresPosibles().isEmpty()){
						
					getBolaCanion().setAngulo( getCanion().getGrados());
					ArrayList<Bola> temporal = new ArrayList<Bola>();
					while(temporal.size() == 0){ // Mientras este rodando
						temporal = getBolaCanion().colision(getNivel());
						getBolaCanion().move();
						getPanel().repaint();
						Thread.sleep(TIEMPO);
					} // Cuando colisiona ->
					//System.out.println("Color Colisionada: " + temporal.getColor() + " Bola del ca�on: " + getBolaCanion().getColor());
					if(temporal.size() == 1){ //Colisiona con uno
//						if(temporal.get(0) == getBolaCanion())
//							getNivel().add(getBolaCanion());
//						else
							getNivel().remove( temporal.get(0));
							eliminaColores();
							String nombreSonido = "sounds/acierto.wav"; 
					    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
					    	Clip acierto = AudioSystem.getClip();
					    	acierto.open(audioInputStream);
					    	acierto.start();
					} else if(temporal.size() > 1){
						// Sonido de error Tiro fallido
						String nombreSonido = "sounds/error.wav"; 
				    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
				    	Clip error = AudioSystem.getClip();
				    	error.open(audioInputStream);
				    	error.start();

						
					}
					
				
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
					
					getBolaCanion().reset(getCanion().getxInicio() , getCanion().getyInicio());
					if(!getPanel().getColoresPosibles().isEmpty())
					getBolaCanion().setColor(Utiles.colorBolaAleatorio(getPanel().getColoresPosibles()));
					
					getPanel().repaint();
					
					}
					
				} catch (Exception e){ e.printStackTrace(); }
				
				}
			});
			one.start();
			

			
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		getCanion().calculoNuevaPos(e.getX(), e.getY());			
//		getBolaCanion().setAngulo(getCanion().getGrados());
		getPanel().repaint();
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		lanzarBola();
		getPanel().repaint();
		
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
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
