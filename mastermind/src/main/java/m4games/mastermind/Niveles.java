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
	private int boton_seleccionado;
	private int boton_intentos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Niveles frame = new Niveles();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Niveles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 266, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rbtnPrincipiante = new JRadioButton("Principiante");
		rbtnPrincipiante.setBounds(62, 39, 111, 23);
		contentPane.add(rbtnPrincipiante);
		
		JRadioButton rbtnMedio = new JRadioButton("Medio");
		rbtnMedio.setBounds(62, 65, 111, 23);
		contentPane.add(rbtnMedio);
		
		JRadioButton rbtnAvanzado = new JRadioButton("Avanzado");
		rbtnAvanzado.setBounds(62, 91, 111, 23);
		contentPane.add(rbtnAvanzado);
		
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(rbtnPrincipiante);
		bgroup.add(rbtnMedio);
		bgroup.add(rbtnAvanzado);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
			}
		});
		btnNewButton.setBounds(23, 152, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//this.setVisible(false);
				//System.exit(0);
				dispose();
			}
		});
		btnNewButton_1.setBounds(144, 152, 89, 23);
		contentPane.add(btnNewButton_1);
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
