package m4games.mastermind;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Mastermind extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private int contadorUno = 0, contadorDos = 0, contadorTres = 0, contadorCuatro = 0;
	
	// Vector de colores
	Color[] coloresDisponibles =  { Color.RED, Color.GREEN, Color.BLUE, Color.BLACK, Color.PINK, Color.ORANGE, Color.MAGENTA, Color.YELLOW, Color.CYAN, Color.GRAY };
	ArrayList<Color> colores2 = new ArrayList<Color>();
	ArrayList<Color> colores = new ArrayList<Color>();
	Color[] bola_solucion = new Color[4];
	int rand;
	
	public Mastermind(JPanel contentPane) {
		this.contentPane = contentPane;
	}
	
	// crear_colores. Asignamos colores aleatorios al array de 4 posiciones.
	public void crearColores(int y) {
		JLabel bolacoloresUno, bolacoloresDos, bolacoloresTres, bolacoloresCuatro;
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
		
		bolacoloresUno = new JLabel("");
		bolacoloresUno.setForeground(Color.WHITE);
		bolacoloresUno.setBackground(Color.WHITE);
		bolacoloresUno.setBorder(border);
		bolacoloresUno.setOpaque(true);
		bolacoloresUno.setBounds(10, y, 30, 30);
		contentPane.add(bolacoloresUno);
		
		bolacoloresDos = new JLabel("");
		bolacoloresDos.setForeground(Color.WHITE);
		bolacoloresDos.setBackground(Color.WHITE);
		bolacoloresDos.setBorder(border);
		bolacoloresDos.setOpaque(true);
		bolacoloresDos.setBounds(50, y, 30, 30);
		contentPane.add(bolacoloresDos);
		
		bolacoloresTres = new JLabel("");
		bolacoloresTres.setForeground(Color.WHITE);
		bolacoloresTres.setBackground(Color.WHITE);
		bolacoloresTres.setBorder(border);
		bolacoloresTres.setOpaque(true);
		bolacoloresTres.setBounds(90, y, 30, 30);
		contentPane.add(bolacoloresTres);
		
		bolacoloresCuatro = new JLabel("");
		bolacoloresCuatro.setForeground(Color.WHITE);
		bolacoloresCuatro.setBackground(Color.WHITE);
		bolacoloresCuatro.setBorder(border);
		bolacoloresCuatro.setOpaque(true);
		bolacoloresCuatro.setBounds(130, y, 30, 30);
		contentPane.add(bolacoloresCuatro);
		
		bolacoloresUno.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if(contadorUno == coloresDisponibles.length - 1) {
            		bolacoloresUno.setBackground(coloresDisponibles[contadorUno]);
        			contadorUno = 0;
            	} else {
            		bolacoloresUno.setBackground(coloresDisponibles[contadorUno]);
            		contadorUno++;
            	}
            }
        });
		
		bolacoloresDos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if(contadorDos == coloresDisponibles.length - 1) {
            		bolacoloresDos.setBackground(coloresDisponibles[contadorDos]);
            		contadorDos = 0;
            	} else {
            		bolacoloresDos.setBackground(coloresDisponibles[contadorDos]);
            		contadorDos++;
            	}
            }
        });
		
		bolacoloresTres.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if(contadorTres == coloresDisponibles.length - 1) {
            		bolacoloresTres.setBackground(coloresDisponibles[contadorTres]);
            		contadorTres = 0;
            	} else {
            		bolacoloresTres.setBackground(coloresDisponibles[contadorTres]);
            		contadorTres++;
            	}
            }
        });
		
		bolacoloresCuatro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if(contadorCuatro == coloresDisponibles.length - 1) {
            		bolacoloresCuatro.setBackground(coloresDisponibles[contadorCuatro]);
            		contadorCuatro = 0;
            	} else {
            		bolacoloresCuatro.setBackground(coloresDisponibles[contadorCuatro]);
            		contadorCuatro++;
            	}
            }
        });
	}
	
	public void crearSolucion() {
		for(int i = 0; i < bola_solucion.length; i++) {
			rand = (int)(Math.random() * (10 - 0)+0);
			bola_solucion[i] = coloresDisponibles[rand];
		}
		JLabel bolasolucionUno, bolasolucionDos, bolasolucionTres, bolasolucionCuatro;
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        
		bolasolucionUno = new JLabel("");
		bolasolucionUno.setBackground(bola_solucion[0]);
		bolasolucionUno.setBorder(border);
		bolasolucionUno.setOpaque(true);
		bolasolucionUno.setBounds(320, 50, 30, 30);
		contentPane.add(bolasolucionUno);
		
		bolasolucionDos = new JLabel("");
		bolasolucionDos.setBackground(bola_solucion[1]);
		bolasolucionDos.setBorder(border);
		bolasolucionDos.setOpaque(true);
		bolasolucionDos.setBounds(353, 50, 30, 30);
		contentPane.add(bolasolucionDos);
		
		bolasolucionTres = new JLabel("");
		bolasolucionTres.setBackground(bola_solucion[2]);
		bolasolucionTres.setBorder(border);
		bolasolucionTres.setOpaque(true);
		bolasolucionTres.setBounds(386, 50, 30, 30);
		contentPane.add(bolasolucionTres);
		
		bolasolucionCuatro = new JLabel("");
		bolasolucionCuatro.setBackground(bola_solucion[3]);
		bolasolucionCuatro.setBorder(border);
		bolasolucionCuatro.setOpaque(true);
		bolasolucionCuatro.setBounds(419, 50, 30, 30);
		contentPane.add(bolasolucionCuatro);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//bolacoloresUno.setBackground(Color.GREEN);
		
	}
	
	/* crear_solución. Obtener aleatoriamente colores para la solución. Estos colores los guardamos
	   en un vector aux. */
	
	// crear_linea_bola. Creamos un conjunto de 4 PictureBox con una constante con valor 4. A su lado crearemos un boton comprobar.
	
	// borrar_componentes. Nos permite borrar todos los componentes creados durante el juego cuando pulsamos nuevo Juego.
	
	// Método ayuda. Nos explica como jugar, acerca de (con información de los alumnos)
	
}