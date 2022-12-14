package m4games.mastermind;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Niveles extends JFrame {

	private JPanel contentPane;
	private int boton_seleccionado = 6; // 4 - 5 - 6
	private int boton_intentos = 8;

	/**
	 * Constructor de una ventana que permite elegir el nivel de dificultad mediante tres radiobuttons
	 * @param frameMastermind
	 */
	public Niveles(Mastermind frameMastermind) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 266, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rbtnPrincipiante = new JRadioButton("Principiante");
		rbtnPrincipiante.setBounds(62, 39, 111, 23);
		contentPane.add(rbtnPrincipiante);
		
		JRadioButton rbtnMedio = new JRadioButton("Medio");
		rbtnMedio.setSelected(true);
		rbtnMedio.setBounds(62, 65, 111, 23);
		contentPane.add(rbtnMedio);
		
		JRadioButton rbtnAvanzado = new JRadioButton("Avanzado");
		rbtnAvanzado.setBounds(62, 91, 111, 23);
		contentPane.add(rbtnAvanzado);
		
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(rbtnPrincipiante);
		bgroup.add(rbtnMedio);
		bgroup.add(rbtnAvanzado);
		
		JButton btnAceptar = new JButton("Aceptar");
		/**
		 * Se añade el actionListener al botón de aceptar para elegir una de las tres dificultades. 
		 * Se pasan los valores del número de colores disponibles y del número de intentos a la instancia de Mastermind
		 * para crear una nueva ventana y se cierra la ventana anterior.
		 */
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbtnPrincipiante.isSelected()) {
					boton_seleccionado = 4;
					boton_intentos = 10;
				} else if(rbtnMedio.isSelected()) {
					boton_seleccionado = 5;
					boton_intentos = 8;
				} else if(rbtnAvanzado.isSelected()) {
					boton_seleccionado = 6;
					boton_intentos = 6;
				}
				Mastermind m = new Mastermind(boton_seleccionado, boton_intentos, frameMastermind.getColoresDisponibles());
				frameMastermind.setEnabled(false);
				frameMastermind.setVisible(false);
				m.setVisible(true);
				
				dispose();
			}
		});
		btnAceptar.setBounds(23, 152, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		/**
		 * Se añade el actionListener al botón de salir del menú,
		 * se cierra la ventana actual y se sale del programa.
		 */
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//this.setVisible(false);
				//System.exit(0);
				dispose();
			}
		});
		btnCancelar.setBounds(144, 152, 89, 23);
		contentPane.add(btnCancelar);
	}

	public int getBoton_seleccionado() {
		return boton_seleccionado;
	}

	public void setBoton_seleccionado(int boton_seleccionado) {
		this.boton_seleccionado = boton_seleccionado;
	}

	public int getBoton_intentos() {
		return boton_intentos;
	}

	public void setBoton_intentos(int boton_intentos) {
		this.boton_intentos = boton_intentos;
	}
	
	
}
