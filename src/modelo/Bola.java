/**
 * Bola.java
 * @asignatura Programacion de Aplicaciones Interactivas
 * @practica Practica 12 : BubbleShot
 * @author Aythami Torrado Cabrera <alu0100837018@ull.edu.es>
 * @date 3 may. 2017
 *
 */
package modelo;

import java.awt.Color;
import java.util.ArrayList;

import vista.PanelJuego;

public class Bola {

	public static final int ESTATICA = 0;
	public static final int VELOCIDAD = 1;
	public static final int TAMANIO = 50;
	public static final int POSCANION = TAMANIO / 2;
	private static final int RADIO = TAMANIO / 2;
	Color color;
	private int x;
	private int y;
	private double angulo;
	private int xCanion;
	private int yCanion;
	
	
	private int velocidadX;
	private int velocidadY;
	private boolean running;
	private boolean derecha = false;
	
	public Bola(int x, int y, int modo, ArrayList<Color> colores){
		setAngulo(0);
		reset(x, y);
		setRunning(false);
		setColor(Utiles.colorBolaAleatorio(colores));
		if(modo == ESTATICA){
			setVelocidadX(ESTATICA);
			setVelocidadY(ESTATICA);
		}else{
			setVelocidadX(VELOCIDAD);
			setVelocidadY(VELOCIDAD);
		}
		
	}
	
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVelocidadX() {
		return velocidadX;
	}

	public void setVelocidadX(int velocidadX) {
		this.velocidadX = velocidadX;
	}

	public int getVelocidadY() {
		return velocidadY;
	}

	public void setVelocidadY(int velocidadY) {
		this.velocidadY = velocidadY;
	}



	public Color getColor() {
		return color;
	}



	public void setColor(Color color) {
		this.color = color;
	}



	public void moveCanion(int xFinal, int yFinal) {
		setX(xFinal);
		setY(yFinal);
		setxCanion(xFinal);
		setyCanion(yFinal);
		
	}



	public void move() {
		
		if(getX() <= 0 ){
		 setAngulo(180 - getAngulo());
		 setxCanion(getX() + 1);
		 setyCanion(getY());
		 System.out.println("incio " + xCanion + " final " + yCanion);
		 setVelocidadX(VELOCIDAD);
		}else if(getX() >= PanelJuego.PANEL_WIDTH - Bola.TAMANIO ){
			derecha = false;
			setAngulo(180 - getAngulo());
			 xCanion = getX();
			 yCanion = getY();
			 setVelocidadX(VELOCIDAD);
		}
		
		int yCentro = getY();
		int xFinal = 0, yFinal = 0;
		if(getAngulo() == 90){
			xFinal = getX();
			yFinal = getY() + VELOCIDAD;
		}
		else if(getAngulo() < 90){
			xFinal = (int) (xCanion - getVelocidadX() * Math.cos(Math.toRadians(getAngulo()))) ;
		   
		} else if (getAngulo() > 90){
			double ang =  getAngulo();
			if(!derecha){
				 xFinal = (int) (getxCanion()  - getVelocidadX() * Math.cos(Math.toRadians(ang))) ;
			}
			else{
				xFinal = (int) (getxCanion()  + getVelocidadX() * Math.cos(Math.toRadians(ang))) ;
			}

		}
		yFinal = (int) (yCanion - getVelocidadX() * Math.sin(Math.toRadians(getAngulo()))) ;
		setX( xFinal );
		setY( yFinal );
		setVelocidadX(getVelocidadX()+ 1);

	}



	public boolean isRunning() {
		return running;
	}



	public void setRunning(boolean running) {
		this.running = running;
	}



	@Override
	public String toString() {
		return "Bola [x=" + x + ", y=" + y + "]";
	}



	public boolean isColision(ArrayList<Bola> nivel) {
		
		//porque esa Y??
		if(getY() <= 0)
			return true;
		else{
			for(Bola it : nivel){
				if( choca(it))
					return true;
			}
		}
		return false;
		
	}
	public Bola Colision(ArrayList<Bola> nivel) {
		
		//porque esa Y??
		if(getY() <= 0)
			return this;

			for(Bola it : nivel){
				if( choca(it))
					return it;
			}
		
		return null;
		
	}
	
	public ArrayList<Bola> colision(ArrayList<Bola> nivel) {
		ArrayList<Bola> temp = new ArrayList<Bola>();
		//porque esa Y??
		if(getY() <= 0)
			temp.add(this);

			for(Bola it : nivel){
				if( choca(it)){
					temp.add(it);
				}
			}
		
		return temp;
		
	}

	public boolean choca(Bola it) {
//			// Si la bola llega a la misma posicion
			if( dentroCuadrado(it)){
			
				return true;
			}


		return false;
	}


	private boolean dentroCuadrado( Bola it) {
		
		// Linea inferior
		
		for(int i = getX() + 10; i < getX() + TAMANIO - 10 ; i++){
			if( i >= it.getX() - POSCANION && i <= (it.getX() + TAMANIO)  && ( getY() >= it.getY() && getY() <= (it.getY() + TAMANIO) ) )
				return true;
		}
		int x = getX() + TAMANIO;
		for(int i = getY() + 10; i < getY() + TAMANIO - 10; i++){
			if( x >= it.getX() && x <= (it.getX() + TAMANIO)  && ( i >= it.getY() && i <= (it.getY() + TAMANIO) ) )
				return true;
		}
		x = getX();
		for(int i = getY() + 10; i < getY() + TAMANIO - 10; i++){
			if( x >= it.getX() - POSCANION && x <= (it.getX() + TAMANIO)  && ( i >= it.getY() && i <= (it.getY() + TAMANIO) ) )
				return true;
		}
				
		return false;
	}



	public double getAngulo() {
		return angulo;
	}



	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}



	public int getxCanion() {
		return xCanion;
	}



	public void setxCanion(int xCanion) {
		this.xCanion = xCanion;
	}



	public int getyCanion() {
		return yCanion;
	}



	public void setyCanion(int yCanion) {
		this.yCanion = yCanion;
	}



	public void reset(int x, int y) {
		setX(x);
		setY(y);
		setxCanion(getX());
		setyCanion(getY());
		setVelocidadX(VELOCIDAD);
	}

	

}
