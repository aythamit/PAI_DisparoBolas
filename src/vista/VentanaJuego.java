/**
 * VentanaJuego.java
 * @asignatura Programacion de Aplicaciones Interactivas
 * @practica Practica 12 : BubbleShot
 * @author Aythami Torrado Cabrera <alu0100837018@ull.edu.es>
 * @date 3 may. 2017
 *
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaJuego extends JFrame {
	
	public static final int FRAME_WIDTH = 1300;
	public static final int FRAME_HEIGTH = 600;
	private PanelJuego bubbleshot;
	private JPanel panelPrincipal;
	public VentanaJuego(){
		
		bubbleshot = new PanelJuego();
		setPanelPrincipal(new JPanel());
//		getPanelPrincipal().add(getBubbleshot());
//		add(getPanelPrincipal());
		add(getBubbleshot());
		initVentanta();
		
	}

	private void initVentanta() {
		// TODO Auto-generated method stub
		setTitle("BubbleShot");
		setSize( FRAME_WIDTH , FRAME_HEIGTH);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Getter de bubbleshot
	 * @return the bubbleshot
	 */
	public PanelJuego getBubbleshot() {
		return bubbleshot;
	}

	/**
	 * Setter de bubbleshot
	 * @param bubbleshot the bubbleshot to set
	 */
	public void setBubbleshot(PanelJuego bubbleshot) {
		this.bubbleshot = bubbleshot;
	}

	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}

	public void setPanelPrincipal(JPanel panelPrincipal) {
		this.panelPrincipal = panelPrincipal;
	}

}
