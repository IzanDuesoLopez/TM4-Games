package m4games.mastermind;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcionesJuego extends JFrame {

	private JPanel contentPane;
	private Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
	
	public OpcionesJuego() {
		setTitle("Opciones del juego");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bolacoloresUno = new JLabel("");
		bolacoloresUno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Color color = JColorChooser.showDialog(contentPane, "Elige un color", Color.WHITE);
				bolacoloresUno.setBackground(color);
				bolacoloresUno.setOpaque(true);
			}
		});
		bolacoloresUno.setForeground(Color.WHITE);
		bolacoloresUno.setBackground(Color.WHITE);
		bolacoloresUno.setBorder(border);
		bolacoloresUno.setOpaque(true);
		bolacoloresUno.setBounds(25, 90, 55, 55);
		contentPane.add(bolacoloresUno);
		
		JLabel bolacoloresDos = new JLabel("");
		bolacoloresDos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Color color = JColorChooser.showDialog(contentPane, "Elige un color", Color.WHITE);
				bolacoloresDos.setBackground(color);
				bolacoloresDos.setOpaque(true);
			}
		});
		bolacoloresDos.setOpaque(true);
		bolacoloresDos.setForeground(Color.WHITE);
		bolacoloresDos.setBorder(border);
		bolacoloresDos.setBackground(Color.WHITE);
		bolacoloresDos.setBounds(90, 90, 55, 55);
		contentPane.add(bolacoloresDos);
		
		JLabel bolacoloresTres = new JLabel("");
		bolacoloresTres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Color color = JColorChooser.showDialog(contentPane, "Elige un color", Color.WHITE);
				bolacoloresTres.setBackground(color);
				bolacoloresTres.setOpaque(true);
			}
		});
		bolacoloresTres.setOpaque(true);
		bolacoloresTres.setForeground(Color.WHITE);
		bolacoloresTres.setBorder(border);
		bolacoloresTres.setBackground(Color.WHITE);
		bolacoloresTres.setBounds(155, 90, 55, 55);
		contentPane.add(bolacoloresTres);
		
		JLabel bolacoloresCuatro = new JLabel("");
		bolacoloresCuatro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Color color = JColorChooser.showDialog(contentPane, "Elige un color", Color.WHITE);
				bolacoloresCuatro.setBackground(color);
				bolacoloresCuatro.setOpaque(true);
			}
		});
		bolacoloresCuatro.setOpaque(true);
		bolacoloresCuatro.setForeground(Color.WHITE);
		bolacoloresCuatro.setBorder(border);
		bolacoloresCuatro.setBackground(Color.WHITE);
		bolacoloresCuatro.setBounds(220, 90, 55, 55);
		contentPane.add(bolacoloresCuatro);
		
		JLabel bolacoloresCinco = new JLabel("");
		bolacoloresCinco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Color color = JColorChooser.showDialog(contentPane, "Elige un color", Color.WHITE);
				bolacoloresCinco.setBackground(color);
				bolacoloresCinco.setOpaque(true);
			}
		});
		bolacoloresCinco.setOpaque(true);
		bolacoloresCinco.setForeground(Color.WHITE);
		bolacoloresCinco.setBorder(border);
		bolacoloresCinco.setBackground(Color.WHITE);
		bolacoloresCinco.setBounds(285, 90, 55, 55);
		contentPane.add(bolacoloresCinco);
		
		JLabel bolacoloresSeis = new JLabel("");
		bolacoloresSeis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Color color = JColorChooser.showDialog(contentPane, "Elige un color", Color.WHITE);
				bolacoloresSeis.setBackground(color);
				bolacoloresSeis.setOpaque(true);
			}
		});
		bolacoloresSeis.setOpaque(true);
		bolacoloresSeis.setForeground(Color.WHITE);
		bolacoloresSeis.setBorder(border);
		bolacoloresSeis.setBackground(Color.WHITE);
		bolacoloresSeis.setBounds(350, 90, 55, 55);
		contentPane.add(bolacoloresSeis);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
			}
		});
		btnNewButton.setBounds(90, 223, 85, 28);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(255, 223, 85, 28);
		contentPane.add(btnNewButton_1);
	}
}
