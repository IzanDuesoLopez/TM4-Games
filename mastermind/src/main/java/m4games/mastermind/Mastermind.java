package m4games.mastermind;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Mastermind extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private int contador = 0;
	
	// Vector de colores
	private Color[] coloresArray =  {Color.RED, Color.GREEN, Color.BLUE, Color.BLACK, Color.PINK, Color.ORANGE};
	private Color[] coloresDisponibles =  { Color.RED, Color.GREEN, Color.BLUE, Color.BLACK, Color.PINK, Color.ORANGE};
	private ArrayList<Color> colores = new ArrayList<Color>();
	private JLabel bolacoloresUno, bolacoloresDos, bolacoloresTres, bolacoloresCuatro;
	private JLabel bolaresulUno, bolaresulDos, bolaresulTres, bolaresulCuatro;
	private Color[] solucionUsuario = new Color[4];
	private Color[] bola_solucion = {Color.RED, Color.GREEN, Color.BLACK, Color.BLACK};
	private int rand;
	private Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
	
	public Mastermind(JPanel contentPane) {
		this.contentPane = contentPane;
	}
	
	// crear_colores. Asignamos colores aleatorios al array de 4 posiciones.
	public void crearColores(int y) {		
		crearSolucion();
		
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
            	cambiarColor(bolacoloresUno);
            	solucionUsuario[0] = bolacoloresUno.getBackground();
            }
        });
		
		bolacoloresDos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	cambiarColor(bolacoloresDos);
        		solucionUsuario[1] = bolacoloresDos.getBackground();
            }
        });
		
		bolacoloresTres.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	cambiarColor(bolacoloresTres);
        		solucionUsuario[2] = bolacoloresTres.getBackground();
            }
        });
		
		bolacoloresCuatro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	cambiarColor(bolacoloresCuatro);
            	solucionUsuario[3] = bolacoloresCuatro.getBackground();
            }
        });
	}
	
	public void cambiarColor(JLabel bolaColores) {
		if(contador == coloresArray.length - 1) {
			bolaColores.setBackground(coloresArray[contador]);
    		contador = 0;
    	} else {
    		bolaColores.setBackground(coloresArray[contador]);
    		contador++;
    	}
	}
	
	public void comprobarSolucionUsuario(int y) {		
		int x = 270;
		
		try {
			for (int i = 0; i < solucionUsuario.length; i++) {
				System.out.println("Color user: " + solucionUsuario[i] + " " + "Color solucion: " + bola_solucion[i]);
				if(solucionUsuario[i].getRGB() == bola_solucion[i].getRGB()) {
					JLabel bolaTemp = new JLabel("");
					bolaTemp.setForeground(Color.BLACK);
					bolaTemp.setBackground(Color.BLACK);
					bolaTemp.setBorder(border);
					bolaTemp.setOpaque(true);
					bolaTemp.setBounds(x += 40, y-40, 30, 30);
					contentPane.add(bolaTemp);
				} else {
					for (int j = 0; j < bola_solucion.length; j++) {
						if(solucionUsuario[i].getRGB() == bola_solucion[j].getRGB() && solucionUsuario[j].getRGB() != bola_solucion[j].getRGB()) {
							JLabel bolaTemp = new JLabel("");
							bolaTemp.setForeground(Color.WHITE);
							bolaTemp.setBackground(Color.WHITE);
							bolaTemp.setBorder(border);
							bolaTemp.setOpaque(true);
							bolaTemp.setBounds(x += 40, y-40, 30, 30);
							contentPane.add(bolaTemp);
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Faltan fichas!");
		}
		
	}

	public void crearSolucion() {
//		for(int i = 0; i < bola_solucion.length; i++) {
//			rand = (int)(Math.random() * (6 - 0)+0);
//			bola_solucion[i] = coloresDisponibles[rand];
//		}
		JLabel bolasolucionUno, bolasolucionDos, bolasolucionTres, bolasolucionCuatro;
        
		bolasolucionUno = new JLabel("");
		bolasolucionUno.setBackground(bola_solucion[0]);
		bolasolucionUno.setBorder(border);
		bolasolucionUno.setOpaque(true);
		bolasolucionUno.setBounds(600, 50, 30, 30);
		contentPane.add(bolasolucionUno);
		
		bolasolucionDos = new JLabel("");
		bolasolucionDos.setBackground(bola_solucion[1]);
		bolasolucionDos.setBorder(border);
		bolasolucionDos.setOpaque(true);
		bolasolucionDos.setBounds(640, 50, 30, 30);
		contentPane.add(bolasolucionDos);
		
		bolasolucionTres = new JLabel("");
		bolasolucionTres.setBackground(bola_solucion[2]);
		bolasolucionTres.setBorder(border);
		bolasolucionTres.setOpaque(true);
		bolasolucionTres.setBounds(680, 50, 30, 30);
		contentPane.add(bolasolucionTres);
		
		bolasolucionCuatro = new JLabel("");
		bolasolucionCuatro.setBackground(bola_solucion[3]);
		bolasolucionCuatro.setBorder(border);
		bolasolucionCuatro.setOpaque(true);
		bolasolucionCuatro.setBounds(720, 50, 30, 30);
		contentPane.add(bolasolucionCuatro);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
	/* crear_solución. Obtener aleatoriamente colores para la solución. Estos colores los guardamos
	   en un vector aux. */
	
	// crear_linea_bola. Creamos un conjunto de 4 PictureBox con una constante con valor 4. A su lado crearemos un boton comprobar.
	
	// borrar_componentes. Nos permite borrar todos los componentes creados durante el juego cuando pulsamos nuevo Juego.
	
	// Método ayuda. Nos explica como jugar, acerca de (con información de los alumnos)
	
}