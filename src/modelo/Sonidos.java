/**
 * Sonidos.java
 * @asignatura Programacion de Aplicaciones Interactivas
 * @practica Practica 12 : BubbleShot
 * @author Aythami Torrado Cabrera <alu0100837018@ull.edu.es>
 * @date 8 may. 2017
 *
 */
package modelo;

import java.applet.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Sonidos {
	
	
    public static Clip acierto;
    
    Sonidos() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
    	String nombreSonido = "sounds/acierto.wav"; 
    	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
    	acierto = AudioSystem.getClip();
    	acierto.open(audioInputStream);
    }
}
