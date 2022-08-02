package m4games.mastermind;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JuegoMainApp extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Mastermind mastermind;
	private int y = 11;
	private JButton botonComprobar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoMainApp frame = new JuegoMainApp();
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
	public JuegoMainApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mastermind = new Mastermind(contentPane);
		mastermind.crearColores();
		
		botonComprobar = new JButton("Comprobar");
		botonComprobar.setBounds(180, 11, 100, 23);
		contentPane.add(botonComprobar);
		botonComprobar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		botonComprobar.setBounds(180, y+=40, 100, 23);
		mastermind.crearColores();
		contentPane.revalidate();
		contentPane.repaint();
		mastermind.comprobarSolucionUsuario();
		contentPane.revalidate();
		contentPane.repaint();
	}


}
