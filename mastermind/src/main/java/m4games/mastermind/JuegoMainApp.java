package m4games.mastermind;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

public class JuegoMainApp {

	/**
	 * Método main en el que creamos la instancia principal de mastermind pasandole por parámetro la dificultad predeterminada
	 * 
	 */
	public static void main(String[] args) {
		int numero_colores_iniciales = 4;
		int numero_intentos_iniciales = 10;
		ArrayList<Color> coloresDefault =  new ArrayList<>(Arrays.asList(Color.RED, Color.GREEN, Color.BLUE, Color.BLACK, Color.PINK, Color.ORANGE));
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mastermind frame = new Mastermind(numero_colores_iniciales, numero_intentos_iniciales, coloresDefault);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}