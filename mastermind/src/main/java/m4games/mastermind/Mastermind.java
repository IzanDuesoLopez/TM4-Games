package m4games.mastermind;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Mastermind extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private int contador = 0;
	private int y = 11;
	private JButton botonComprobar;
	
	// Componentes de la barra del menú
	private JMenuBar barra_menu = new JMenuBar();
	private JMenu archivo = new JMenu("Archivo");
	private JMenu ayuda = new JMenu("Ayuda");
	private JMenuItem nuevo_juego = new JMenuItem("Nuevo juego");
	public JMenuItem salir = new JMenuItem("Salir");
	private JMenuItem como_jugar = new JMenuItem("Cómo jugar");
	private JMenuItem acerca_de = new JMenuItem("Acerca de");
	
	// Vector de colores
	private Color[] coloresArray =  {Color.RED, Color.GREEN, Color.BLUE, Color.BLACK, Color.PINK, Color.ORANGE};
	private Color[] coloresDisponibles =  { Color.RED, Color.GREEN, Color.BLUE, Color.BLACK, Color.PINK, Color.ORANGE};
	private ArrayList<Color> colores = new ArrayList<Color>();
	private JLabel bolacoloresUno, bolacoloresDos, bolacoloresTres, bolacoloresCuatro, bolaTemp;
	private JLabel bolaresulUno, bolaresulDos, bolaresulTres, bolaresulCuatro;
	private Color[] solucionUsuario = new Color[4];
	private Color[] bola_solucion = {Color.BLUE, Color.RED, Color.BLACK, Color.GREEN};
	private int rand;
	private Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
	
	private Niveles nivel = new Niveles();
	private int intentos = nivel.getBoton_intentos();
	private int nivelDificultad = nivel.getBoton_seleccionado();
	private int nivel_seleccionado;
	private int amplitudColoresDisponibles = 209;
	
	public Mastermind() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel solucionLabel = new JLabel("Solución");
		solucionLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		solucionLabel.setBounds(598, 24, 90, 14);
		contentPane.add(solucionLabel);
		
		JLabel solucionLabel2 = new JLabel("Colores disponibles");
		solucionLabel2.setFont(new Font("Tahoma", Font.BOLD, 14));
		solucionLabel2.setBounds(598, 140, 200, 25);
		contentPane.add(solucionLabel2);
		
		JLabel bordeSolucion = new JLabel("");
		bordeSolucion.setBounds(572, 11, 209, 95);
		contentPane.add(bordeSolucion);
		bordeSolucion.setBorder(border);
		
		if(nivelDificultad == 5) {
			amplitudColoresDisponibles += 30;
		} else if (nivelDificultad == 6) {
			amplitudColoresDisponibles += 60;
		}
		
		JLabel bordeColoresDisponibles = new JLabel("");
		bordeColoresDisponibles.setBounds(572, 130, amplitudColoresDisponibles, 95);
		contentPane.add(bordeColoresDisponibles);
		bordeColoresDisponibles.setBorder(border);
		
		crearBarraMenu(barra_menu, archivo, ayuda, nuevo_juego, salir, como_jugar, acerca_de);
		
		nuevo_juego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							nivel.setVisible(true);
							nivel_seleccionado = nivel.getBoton_seleccionado();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		como_jugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Reglas reglas = new Reglas();
							reglas.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		acerca_de.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Informacion info = new Informacion();
							info.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		
		
		crearColores(y,nivel_seleccionado);
		
		botonComprobar = new JButton("Comprobar");
		botonComprobar.setBounds(180, y, 100, 23);
		contentPane.add(botonComprobar);
		botonComprobar.addActionListener(this);
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
	
	// crear_colores. Asignamos colores aleatorios al array de 4 posiciones.
	public void crearColores(int y, int nivel) {		
		crearSolucion();
		/**
		 * Nivel sale 1ero un 0, luego sale el num que toca, la 1era partida sale 0 directamente
		 * Se tiene que poder coger el numero de colores disponibles y el de intentos (variables de niveles) para al crear solucion
		 * cambie según el nivel que se haya escogido
		 * El nivel se cambia en un menu de juego llamado nivel, el juego nuevo es para empezar de 0 en el nivel que se estaba por ello lo de borrar componentes
		 * 
		 * hay que crear metodo borrar_componentes (diapo 4) 
		 */
		System.out.println(nivel);
		
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
		
		int numFichasNegras = 0;
		boolean hasGanado = false;
		
		try {
			for (int i = 0; i < solucionUsuario.length; i++) {
				System.out.println("Color user: " + solucionUsuario[i] + " " + "Color solucion: " + bola_solucion[i]);
				if(solucionUsuario[i].getRGB() == bola_solucion[i].getRGB()) {
					bolaTemp = new JLabel("");
					bolaTemp.setForeground(Color.BLACK);
					bolaTemp.setBackground(Color.BLACK);
					bolaTemp.setBorder(border);
					bolaTemp.setOpaque(true);
					bolaTemp.setBounds(x += 40, y-40, 30, 30);
					contentPane.add(bolaTemp);
					numFichasNegras++;
				} else {
					for (int j = 0; j < bola_solucion.length; j++) {
						if(solucionUsuario[i].getRGB() == bola_solucion[j].getRGB() && solucionUsuario[j].getRGB() != bola_solucion[j].getRGB()) {
							bolaTemp = new JLabel("");
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
			if(numFichasNegras == 4) {
				hasGanado = true;
				JOptionPane.showMessageDialog(null, "HAS GANADO! \n" + "Número de intentos restantes: " + intentos);
				botonComprobar.setEnabled(false);
			} else {
				if(intentos  <= 0) {
					JOptionPane.showMessageDialog(null, "PARTIDA PERDIDA");
					botonComprobar.setEnabled(false);
				} else if (intentos > 0) {
					numFichasNegras = 0;
					intentos--;
					System.out.println("Intentos: " + intentos);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Faltan fichas!");
		}
	}

	public void crearSolucion() {
//		for(int i = 0; i < bola_solucion.length; i++) {
//			rand = (int)(Math.random() * (4 - 0)+0);
//			bola_solucion[i] = coloresArray[rand];
//		}
		JLabel bolasolucionUno, bolasolucionDos, bolasolucionTres, bolasolucionCuatro;
		JLabel colorDisponibleUno, colorDisponibleDos, colorDisponibleTres, colorDisponibleCuatro, colorDisponibleCinco, colorDisponibleSeis;
        
		colorDisponibleUno = new JLabel("");
		colorDisponibleUno.setBackground(coloresDisponibles[0]);
		colorDisponibleUno.setBorder(border);
		colorDisponibleUno.setOpaque(true);
		colorDisponibleUno.setBounds(600, 170, 30, 30);
		contentPane.add(colorDisponibleUno);
		
		colorDisponibleDos = new JLabel("");
		colorDisponibleDos.setBackground(coloresDisponibles[1]);
		colorDisponibleDos.setBorder(border);
		colorDisponibleDos.setOpaque(true);
		colorDisponibleDos.setBounds(640, 170, 30, 30);
		contentPane.add(colorDisponibleDos);
		
		colorDisponibleTres = new JLabel("");
		colorDisponibleTres.setBackground(coloresDisponibles[2]);
		colorDisponibleTres.setBorder(border);
		colorDisponibleTres.setOpaque(true);
		colorDisponibleTres.setBounds(680, 170, 30, 30);
		contentPane.add(colorDisponibleTres);
		
		colorDisponibleCuatro = new JLabel("");
		colorDisponibleCuatro.setBackground(coloresDisponibles[3]);
		colorDisponibleCuatro.setBorder(border);
		colorDisponibleCuatro.setOpaque(true);
		colorDisponibleCuatro.setBounds(720, 170, 30, 30);
		contentPane.add(colorDisponibleCuatro);
		
		if(nivelDificultad == 5) {
			colorDisponibleCinco = new JLabel("");
			colorDisponibleCinco.setBackground(coloresDisponibles[4]);
			colorDisponibleCinco.setBorder(border);
			colorDisponibleCinco.setOpaque(true);
			colorDisponibleCinco.setBounds(760, 170, 30, 30);
			contentPane.add(colorDisponibleCinco);
		} else if (nivelDificultad == 6) {
			colorDisponibleCinco = new JLabel("");
			colorDisponibleCinco.setBackground(coloresDisponibles[4]);
			colorDisponibleCinco.setBorder(border);
			colorDisponibleCinco.setOpaque(true);
			colorDisponibleCinco.setBounds(760, 170, 30, 30);
			contentPane.add(colorDisponibleCinco);
			
			colorDisponibleSeis = new JLabel("");
			colorDisponibleSeis.setBackground(coloresDisponibles[5]);
			colorDisponibleSeis.setBorder(border);
			colorDisponibleSeis.setOpaque(true);
			colorDisponibleSeis.setBounds(800, 170, 30, 30);
			contentPane.add(colorDisponibleSeis);
		}
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
		botonComprobar.setBounds(180, y+=40, 100, 23);
		crearColores(y,nivel_seleccionado);
		contentPane.revalidate();
		contentPane.repaint();
		comprobarSolucionUsuario(y);
		contentPane.revalidate();
		contentPane.repaint();
	}
	/* crear_solución. Obtener aleatoriamente colores para la solución. Estos colores los guardamos
	   en un vector aux. */
	
	// crear_linea_bola. Creamos un conjunto de 4 PictureBox con una constante con valor 4. A su lado crearemos un boton comprobar.
	
	// borrar_componentes. Nos permite borrar todos los componentes creados durante el juego cuando pulsamos nuevo Juego.
	
	// Método ayuda. Nos explica como jugar, acerca de (con información de los alumnos)
	
}