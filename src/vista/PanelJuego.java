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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
	private Bola bolaCanion;
	private ArrayList<Bola> nivel;
	private ArrayList<Color> coloresPosibles;
	private boolean debug = false;
	private JLabel icono;
	private int score;
	
	public PanelJuego(){
		setColoresPosibles(new ArrayList<Color>());
		anidirColores();
		setLayout(null);
		setSize(PANEL_WIDTH, PANEL_HEIGTH);
		setBackground(Color.WHITE);
		setFocusable(true);
		setScore(0);
		setNivel(new ArrayList<Bola>());
		setBolaCanion(new Bola(canion.getxInicio(), canion.getyInicio() 
				, Bola.VELOCIDAD, getColoresPosibles()));
		ImageIcon icon = new ImageIcon("icon-info.png");
	    setIcono(new JLabel(icon));
		int yPos = 0;
		int nBolas = PANEL_WIDTH / Bola.TAMANIO;
		Utiles.aniadirBolas( yPos, nBolas , getNivel() , getColoresPosibles());
		ControladorTeclado tecladoListen= new ControladorTeclado(getCanion(), this, getBolaCanion() , getNivel());
		addKeyListener(tecladoListen);
		addMouseListener(tecladoListen);
		addMouseMotionListener(tecladoListen);
		getIcono().setBounds(30, 540, 32, 32);
		add(getIcono());
		
	}
	public void anidirColores(){
		for(int i = 0; i < 5; i++)
			getColoresPosibles().add( Utiles.colorBolaPrefefinido(i));
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		dibujaCanion(g2);
		dibujaBola(g2);
		dibujaNivel(g2);
		dibujaScore(g2);
		if(isDebug())
		dibujaInfo(g2);
	}

	private void dibujaScore(Graphics2D g2) {
		g2.setColor(Color.BLACK);
		g2.drawString("Score: " + getScore() , 100, 550);
		
	}
	private void dibujaBola(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.setColor(getBolaCanion().getColor());
		g2.fillOval(getBolaCanion().getX() - Bola.POSCANION, getBolaCanion().getY() - Bola.POSCANION
				, Bola.TAMANIO, Bola.TAMANIO);
		if(debug)
			g2.drawRect(getBolaCanion().getX() + 10, getBolaCanion().getY() + 10
					, Bola.TAMANIO -15, Bola.TAMANIO -15);
	}

	private void dibujaNivel(Graphics2D g2) {
		// TODO Auto-generated method stub
		for(Bola it : getNivel()){
			g2.setColor(it.getColor());
			g2.fillOval(it.getX(), it.getY(), Bola.TAMANIO, Bola.TAMANIO);
			if(debug)
			{
				g2.setStroke(new BasicStroke(2));
				g2.drawRect(it.getX() + 10, it.getY() + 10, Bola.TAMANIO -15, Bola.TAMANIO -15);
			}
		}
		
	}
	private void dibujaCanion(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.setStroke(new BasicStroke(4));
		g2.setColor(Color.RED);
		g2.drawLine(canion.getxInicio(), canion.getyInicio(), canion.getxFinal(), canion.getyFinal());
		
		
	}
	private void dibujaInfo(Graphics2D g2) {
		// TODO Auto-generated method stub
		int con = 20;
		int xInfo = 50, yInfo = PANEL_HEIGTH - 200;
		double pendiente;
		if(getCanion().getGrados() == 90){
			pendiente = 1;
		}else{
			double radians = Math.toRadians(getCanion().getGrados());
			pendiente = Math.tan(radians);
		}
		g2.setStroke(new BasicStroke(4));
		g2.setColor(Color.BLACK);
		int xInicio = getCanion().getxFinal();
		int yInicio = getCanion().getyFinal();
//		int xInicio = getBolaCanion().getX();
//		int yInicio = getBolaCanion().getY();
		int xFinal = (int) (xInicio -  600 * Math.cos(Math.toRadians(getCanion().getGrados()))) ;
		int yFinal = (int) (yInicio - 600 * Math.sin(Math.toRadians(getCanion().getGrados()))) ;
		
		g2.drawString("Bola: " + getBolaCanion().getX() + " , " + getBolaCanion().getY(), xInfo, yInfo + con);
		g2.drawString("Grados C: " + getCanion().getGrados(), xInfo, yInfo + con * 2);
		g2.drawString("Posicion boca C: " + getCanion().getxFinal() + " , " + getCanion().getyFinal() , xInfo, yInfo + con * 3);
		g2.drawString("Angulo Bola : " + getBolaCanion().getAngulo(), xInfo, yInfo + con * 4);
		g2.drawString("", xInfo, yInfo + con * 5);
		g2.drawString("Nivel bolas: " + getNivel().size(), xInfo, yInfo + con * 6);
		g2.setStroke(new BasicStroke(1));
		Color color = new Color(0, 255,0, 50);
		g2.setColor(color);
		g2.drawLine(xInicio , yInicio, xFinal, yFinal);
		
		
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

	public JLabel getIcono() {
		return icono;
	}

	public void setIcono(JLabel icono) {
		this.icono = icono;
	}

	/**
	 * Getter de debug
	 * @return the debug
	 */
	public boolean isDebug() {
		return debug;
	}

	/**
	 * Setter de debug
	 * @param debug the debug to set
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	/**
	 * Getter de coloresPosibles
	 * @return the coloresPosibles
	 */
	public ArrayList<Color> getColoresPosibles() {
		return coloresPosibles;
	}

	/**
	 * Setter de coloresPosibles
	 * @param coloresPosibles the coloresPosibles to set
	 */
	public void setColoresPosibles(ArrayList<Color> coloresPosibles) {
		this.coloresPosibles = coloresPosibles;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

}
