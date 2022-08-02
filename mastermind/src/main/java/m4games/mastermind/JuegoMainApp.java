package m4games.mastermind;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JuegoMainApp extends JFrame implements ActionListener{

	private JPanel contentPane;
	private int y = 11;
	private Mastermind mastermind;
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
		
		JMenuBar barra_menu = new JMenuBar();
		JMenu archivo = new JMenu("Archivo");
		JMenu ayuda = new JMenu("Ayuda");
		JMenuItem nuevo_juego = new JMenuItem("Nuevo juego");
		JMenuItem salir = new JMenuItem("Salir");
		JMenuItem como_jugar = new JMenuItem("Cómo jugar");
		JMenuItem acerca_de = new JMenuItem("Acerca de");
		
		nuevo_juego.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				y = 11;
				mastermind = new Mastermind(contentPane);
				mastermind.crearColores(y);
				
				botonComprobar = new JButton("Comprobar");
				botonComprobar.setBounds(180, y, 100, 23);
				contentPane.add(botonComprobar);
				//botonComprobar.addActionListener(this);
			}
		});
		crearBarraMenu(barra_menu, archivo, ayuda, nuevo_juego, salir, como_jugar, acerca_de);
		
		mastermind = new Mastermind(contentPane);
		mastermind.crearColores(y);
		
		botonComprobar = new JButton("Comprobar");
		botonComprobar.setBounds(180, y, 100, 23);
		contentPane.add(botonComprobar);
		botonComprobar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		botonComprobar.setBounds(180, y+=40, 100, 23);
		mastermind.crearColores(y);
		contentPane.revalidate();
		contentPane.repaint();
		mastermind.comprobarSolucionUsuario(y);
		contentPane.revalidate();
		contentPane.repaint();
	}

	public void crearBarraMenu(JMenuBar barra_menu, JMenu archivo, JMenu ayuda, JMenuItem nuevo_juego, JMenuItem salir, JMenuItem como_jugar, JMenuItem acerca_de) {		
		barra_menu.add(archivo);
		barra_menu.add(ayuda);
		archivo.add(nuevo_juego);
		archivo.add(salir);
		ayuda.add(como_jugar);
		ayuda.add(acerca_de);
		setJMenuBar(barra_menu);
	}	
}
