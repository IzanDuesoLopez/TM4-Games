package m4games.mastermind;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Mastermind extends JFrame{
	
	public Mastermind() {
		
	}
	
	// Vector de colores
	//Color[] colores =  { Color.RED, Color.RED, Color.GREEN, Color.GREEN ,Color.BLUE, Color.BLUE, Color.BLACK, Color.BLACK };
	ArrayList<Color> coloresDisponibles = new ArrayList<Color>();
	ArrayList<Color> colores = new ArrayList<Color>();
	
	// crear_colores. Asignamos colores aleatorios al array de 4 posiciones.
	
	/* crear_solución. Obtener aleatoriamente colores para la solución. Estos colores los guardamos
	   en un vector aux. */
	
	// crear_linea_bola. Creamos un conjunto de 4 PictureBox con una constante con valor 4. A su lado crearemos un boton comprobar.
	
	// borrar_componentes. Nos permite borrar todos los componentes creados durante el juego cuando pulsamos nuevo Juego.
	
	// Método ayuda. Nos explica como jugar, acerca de (con información de los alumnos)
	
}
