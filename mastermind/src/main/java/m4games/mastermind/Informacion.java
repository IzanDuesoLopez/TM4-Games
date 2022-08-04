package m4games.mastermind;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;

public class Informacion extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	
	
	/**
	 * Método con la información de juego
	 */
	public Informacion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Acerca de");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(161, 11, 97, 32);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Creado por: Equipo 3");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(28, 58, 147, 40);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Contribuidores: Izan Dueso");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(28, 109, 199, 40);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Daniel Floria");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(124, 136, 88, 32);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Bárbara Broto");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(124, 160, 113, 32);
		contentPane.add(lblNewLabel_4);
	}
}
