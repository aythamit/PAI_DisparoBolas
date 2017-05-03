/**
 * Canion.java
 * @asignatura Programacion de Aplicaciones Interactivas
 * @practica Practica 12 : BubbleShot
 * @author Aythami Torrado Cabrera <alu0100837018@ull.edu.es>
 * @date 3 may. 2017
 *
 */
package modelo;

public class Canion {
	
	private final static int GRADOS_MIN = 0;
	private final static int GRADOS_MAX = 180;
	private final static int GRADOS_INICIO = 90;
	private final static int TAMANIO_CANION = 50;
	private int xInicio; // Posicion inicio x del cañon
	private int yInicio; // Posicion inicio y del cañon
	private int xFinal; // Posicion final x del cañon
	private int yFinal; // Posicion final y del cañon
	private int grados; //Grado de inclinacion
	
	public Canion(int x, int y){
		setxInicio(x);
		setyInicio(y);
		setGrados(GRADOS_INICIO);
		setxFinal( (int) (getxInicio() - TAMANIO_CANION * Math.cos(Math.toRadians(getGrados()))) );
		setyFinal((int) (getyInicio() - TAMANIO_CANION * Math.sin(Math.toRadians(getGrados()))));
	}

	public int getxInicio() {
		return xInicio;
	}

	public void setxInicio(int xInicio) {
		this.xInicio = xInicio;
	}

	public int getyInicio() {
		return yInicio;
	}

	public void setyInicio(int yInicio) {
		this.yInicio = yInicio;
	}

	public int getxFinal() {
		return xFinal;
	}

	public void setxFinal(int xFinal) {
		this.xFinal = xFinal;
	}

	public int getyFinal() {
		return yFinal;
	}

	public void setyFinal(int yFinal) {
		this.yFinal = yFinal;
	}

	public int getGrados() {
		return grados;
	}

	public void setGrados(int grados) {
		if( grados > GRADOS_MIN && grados < GRADOS_MAX)
			this.grados = grados;
		else
			System.out.println("Lanzar excepcion");
	}
	

}
