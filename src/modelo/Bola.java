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

import vista.PanelJuego;

public class Bola {

	public static final int ESTATICA = 0;
	public static final int VELOCIDAD = 10;
	public static final int TAMANIO = 20;
	public static final int POSCANION = TAMANIO / 2;
	Color color;
	private int x;
	private int y;
	private int velocidadX;
	private int velocidadY;
	
	public Bola(int x, int y, int modo){
		setX(x);
		setY(y);
		setColor(Color.BLUE);
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
		setX(xFinal - POSCANION);
		setY(yFinal - POSCANION);
		
	}



	public void move() {
		
		setX( getX() - getVelocidadX());
		setY( getY() - getVelocidadY());
		if(getX() >= PanelJuego.PANEL_WIDTH || x < 0)
			setVelocidadX( -getVelocidadX());
		if(getY() >= PanelJuego.PANEL_HEIGTH || getY() < 0)
			setVelocidadY( -getVelocidadY());
		
	}

	

}
