package m4games.mastermind;

import java.awt.EventQueue;

public class JuegoMainApp {

	/**
	 * Método main en el que creamos la instancia principal de mastermind pasandole por parámetro la dificultad predeterminada
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mastermind frame = new Mastermind(4, 10);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}