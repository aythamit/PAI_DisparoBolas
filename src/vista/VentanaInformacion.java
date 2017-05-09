/**
 * VentanaInformacion.java
 * @asignatura Programacion de Aplicaciones Interactivas
 * @practica Practica 13 : Juego de Disparos
 * @author Aythami Torrado Cabrera <alu0100837018@ull.edu.es>
 * @date 2 may. 2017
 *
 */

package vista;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaInformacion extends JFrame{
	
	private JLabel practica;
	private JLabel asignatura;
	private JLabel autor;
	private JLabel informacion;
	
	public VentanaInformacion(){
		setTitle("Informacion");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,150);
		setPractica(new JLabel("Practica 13 - Juego de Disparos"));
		setAsignatura(new JLabel("Programacion de Aplicaciones Interactivas"));
		setAutor(new JLabel("Aythami Torrado Cabrera - alu0100837018"));
		setInformacion(new JLabel("Juego que dispara bolas y consiste en golpear la una bola de lleno."));
		
		setLayout(new FlowLayout());
		add(getAutor());
		add(getAsignatura());
		add(getPractica());
		add(getInformacion());
	
		
		setVisible(true);
	
	}

	/**
	 * @return the practica
	 */
	public JLabel getPractica() {
		return practica;
	}

	/**
	 * @param practica the practica to set
	 */
	public void setPractica(JLabel practica) {
		this.practica = practica;
	}

	/**
	 * @return the asignatura
	 */
	public JLabel getAsignatura() {
		return asignatura;
	}

	/**
	 * @param asignatura the asignatura to set
	 */
	public void setAsignatura(JLabel asignatura) {
		this.asignatura = asignatura;
	}

	/**
	 * @return the autor
	 */
	public JLabel getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(JLabel autor) {
		this.autor = autor;
	}

	public JLabel getInformacion() {
		return informacion;
	}

	public void setInformacion(JLabel informacion) {
		this.informacion = informacion;
	}

}
