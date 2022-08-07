package m4games.mastermind;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

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
	private JMenuItem opciones = new JMenuItem("Opciones");
	public JMenuItem salir = new JMenuItem("Salir");
	private JMenuItem como_jugar = new JMenuItem("Cómo jugar");
	private JMenuItem acerca_de = new JMenuItem("Acerca de");
	
	// Vector de colores
	private ArrayList<Color> coloresDisponibles;
	private ArrayList<Color> coloresDefault =  new ArrayList<>(Arrays.asList(Color.RED, Color.GREEN, Color.BLUE, Color.BLACK, Color.PINK, Color.ORANGE));
	private Color[] coloresDisponiblesPrincipiante =  new Color[4];
	private Color[] coloresDisponiblesMedio =  new Color[5];
	private Color[] coloresDisponiblesAvanzado = new Color[6];
	private ArrayList<Color> coloresDisponiblesPersonalizados = new ArrayList<Color>();
	private ArrayList<Color> colores = new ArrayList<Color>();
	private JLabel bolacoloresUno, bolacoloresDos, bolacoloresTres, bolacoloresCuatro, bolaTemp;
	private JLabel bolaresulUno, bolaresulDos, bolaresulTres, bolaresulCuatro;
	private Color[] solucionUsuario = new Color[4];
	private Color[] bola_solucion = new Color[4];
	private int rand;
	private Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
	
	//Componentes de niveles
	private Niveles nivel = new Niveles(this);
	private OpcionesJuego opciones_juego = new OpcionesJuego(this);
	private int intentos = nivel.getBoton_intentos();
	private int nivelDificultad = nivel.getBoton_seleccionado();
	private int nivel_seleccionado;
	private int amplitudColoresDisponibles = 209;
	
	private JLabel labelNumIntentos;
	
	//Componentes de opciones de juego
	private boolean opcionColoresDefecto = true;
	private boolean opcionColoresPersonalizados = false;
	
	/**
	 * Constructor principal de Mastermind
	 * @param nivel_seleccionado
	 */
	public Mastermind(int nivel_seleccionado, int intentos, ArrayList<Color> coloresDisponibles) {
		this.coloresDisponibles = new ArrayList<Color>(coloresDisponibles);
		this.nivelDificultad = nivel_seleccionado;
		this.intentos = intentos;
		this.coloresDisponibles = coloresDisponibles;
		for(int i = 0; i < coloresDisponiblesPrincipiante.length; i++) {
			coloresDisponiblesPrincipiante[i] = coloresDisponibles.get(i);
		}
		for(int i = 0; i < coloresDisponiblesMedio.length; i++) {
			coloresDisponiblesMedio[i] = coloresDisponibles.get(i);
		}
		for(int i = 0; i < coloresDisponiblesAvanzado.length; i++) {
			coloresDisponiblesAvanzado[i] = coloresDisponibles.get(i);
		}
		
		
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
		
		labelNumIntentos = new JLabel("Intentos restantes: " + intentos);
		labelNumIntentos.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelNumIntentos.setBounds(598, 240, 200, 25);
		contentPane.add(labelNumIntentos);
		
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
		
		crearBarraMenu(barra_menu, archivo, ayuda, nuevo_juego, opciones, salir, como_jugar, acerca_de);
		
		funcionalidadBarraMenu();
		
		crearSolucion();
		
		crearColores(y,nivel_seleccionado, coloresDisponibles); // Llamamos al método que añade los componentes de label a la ejecución
		
		botonComprobar = new JButton("Comprobar");
		botonComprobar.setBounds(180, y, 100, 23);
		contentPane.add(botonComprobar);
		botonComprobar.addActionListener(this);
	}
	
	
	/**
	 * Añadimos al menú sus diferentes opciones
	 * @param barra_menu
	 * @param archivo
	 * @param ayuda
	 * @param nuevo_juego
	 * @param salir
	 * @param como_jugar
	 * @param acerca_de
	 */
	public void crearBarraMenu(JMenuBar barra_menu, JMenu archivo, JMenu ayuda, JMenuItem nuevo_juego, JMenuItem opciones, JMenuItem salir, JMenuItem como_jugar, JMenuItem acerca_de) {		
		barra_menu.add(archivo);
		barra_menu.add(ayuda);
		archivo.add(nuevo_juego);
		archivo.add(opciones);
		archivo.add(salir);
		ayuda.add(como_jugar);
		ayuda.add(acerca_de);
		setJMenuBar(barra_menu);
	}	
	
	/**
	 * Creamos en el frame de Mastermind las diferentes casillas junto con la solución disponible. Incluimos listener
	 * a las label con click bidireccional para ir cambiando el color
	 * @param y
	 * @param nivel
	 */
	public void crearColores(int y, int nivel, ArrayList<Color> coloresDisponibles) {		
		mostrarSolucion(coloresDisponibles);
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
            	if (e.getButton()==MouseEvent.BUTTON1){
					//Se presiono el boton izquierdo
					cambiarColorI(bolacoloresUno);
					solucionUsuario[0] = bolacoloresUno.getBackground();
				}
				if(e.getButton()==MouseEvent.BUTTON3){
					//Se presiono el boton derecho
					cambiarColor(bolacoloresUno);
					solucionUsuario[0] = bolacoloresUno.getBackground();
				}
            }
        });
		
		bolacoloresDos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if (e.getButton()==MouseEvent.BUTTON1){
					//Se presiono el boton izquierdo
					cambiarColorI(bolacoloresDos);
					solucionUsuario[1] = bolacoloresDos.getBackground();
				}
				if(e.getButton()==MouseEvent.BUTTON3){
					//Se presiono el boton derecho
					cambiarColor(bolacoloresDos);
					solucionUsuario[1] = bolacoloresDos.getBackground();
				}
            }
        });
		
		bolacoloresTres.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if (e.getButton()==MouseEvent.BUTTON1){
					//Se presiono el boton izquierdo
					cambiarColorI(bolacoloresTres);
					solucionUsuario[2] = bolacoloresTres.getBackground();
				}
				if(e.getButton()==MouseEvent.BUTTON3){
					//Se presiono el boton derecho
					cambiarColor(bolacoloresTres);
					solucionUsuario[2] = bolacoloresTres.getBackground();
				}
            }
        });
		
		bolacoloresCuatro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if (e.getButton()==MouseEvent.BUTTON1){
					//Se presiono el boton izquierdo
					cambiarColorI(bolacoloresCuatro);
					solucionUsuario[3] = bolacoloresCuatro.getBackground();
				}
				if(e.getButton()==MouseEvent.BUTTON3){
					//Se presiono el boton derecho
					cambiarColor(bolacoloresCuatro);
					solucionUsuario[3] = bolacoloresCuatro.getBackground();
				}
            }
        });
		
	}
	
	/**
	 * Cambia el color de la label hacia la derecha. El tamaño de la lista de colores dependerá del nivel de dificultad
	 * @param bolaColores
	 */
	public void cambiarColor(JLabel bolaColores) {
		if(nivelDificultad == 4) {
			if(contador == coloresDisponiblesPrincipiante.length - 1) {
				bolaColores.setBackground(coloresDisponiblesPrincipiante[contador]);
	    		contador = 0;
	    	} else {
	    		bolaColores.setBackground(coloresDisponiblesPrincipiante[contador]);
	    		contador++;
	    	}
		} else if (nivelDificultad == 5) {
			if(contador == coloresDisponiblesMedio.length - 1) {
				bolaColores.setBackground(coloresDisponiblesMedio[contador]);
	    		contador = 0;
	    	} else {
	    		bolaColores.setBackground(coloresDisponiblesMedio[contador]);
	    		contador++;
	    	}
		} else if (nivelDificultad == 6) {
			if(contador == coloresDisponiblesAvanzado.length - 1) {
				bolaColores.setBackground(coloresDisponiblesAvanzado[contador]);
	    		contador = 0;
	    	} else {
	    		bolaColores.setBackground(coloresDisponiblesAvanzado[contador]);
	    		contador++;
	    	}
		}
	}
	
	/**
	 * Cambia el color de la label hacia la izquierda. El tamaño de la lista de colores dependerá del nivel de dificultad
	 * @param bolaColores
	 */
	public void cambiarColorI(JLabel bolaColores) {
		if(nivelDificultad == 4) {
			if(contador == 0) {
				contador = 3;
				bolaColores.setBackground(coloresDisponiblesPrincipiante[contador]);
			} else {
				contador--;
				bolaColores.setBackground(coloresDisponiblesPrincipiante[contador]);
			}
		} else if (nivelDificultad == 5) {
			if(contador == 0) {
				contador = 4;
				bolaColores.setBackground(coloresDisponiblesMedio[contador]);
			} else {
				contador--;
				bolaColores.setBackground(coloresDisponiblesMedio[contador]);
			}
		} else if (nivelDificultad == 6) {
			if(contador == 0) {
				contador = 5;
				bolaColores.setBackground(coloresDisponiblesAvanzado[contador]);
			} else {
				contador--;
				bolaColores.setBackground(coloresDisponiblesAvanzado[contador]);
			}
		}
	}
	
	/**
	 * Comprobamos que las fichas que ha introducido el usuario son correctas
	 * @param y
	 */
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
					labelNumIntentos.setText("Intentos restantes: " + intentos);
					System.out.println("Intentos: " + intentos);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Faltan fichas!");
		}
	}

	/**
	 * Creamos una solución de colores
	 */
	public void crearSolucion() {
		//System.out.println(nivelDificultad);
		//int colorRandom = (int)((Math.random() * nivelDificultad));
		//System.out.println(colorRandom);
		
		int colorRandom;
		
		ArrayList<Color> arrayColores = new ArrayList<Color>(); 
		
		switch(nivelDificultad) {
		case 4:
			for(int i = 0; i < coloresDisponiblesPrincipiante.length; i++) {
				arrayColores.add(coloresDisponiblesPrincipiante[i]);
			}
			break;
		case 5:
			for(int i = 0; i < coloresDisponiblesMedio.length; i++) {
				arrayColores.add(coloresDisponiblesMedio[i]);
			}
			break;
		case 6:
			for(int i = 0; i < coloresDisponiblesAvanzado.length; i++) {
				arrayColores.add(coloresDisponiblesAvanzado[i]);
			}
			break;
		default:
			System.out.println("No hay un nivel de dificultad seleccionado.");
			break;
		}
		
		
		for(int i = 0; i < bola_solucion.length; i++) {
			colorRandom = (int)((Math.random() * nivelDificultad));
			bola_solucion[i] = arrayColores.get(colorRandom);
		}
	}
	
	/**
	 * Mostramos una solución de colores y los colores disponibles
	 */
	public void mostrarSolucion(ArrayList<Color> coloresDisponibles) {
		JLabel bolasolucionUno, bolasolucionDos, bolasolucionTres, bolasolucionCuatro;
		JLabel colorDisponibleUno, colorDisponibleDos, colorDisponibleTres, colorDisponibleCuatro, colorDisponibleCinco, colorDisponibleSeis;
        
		colorDisponibleUno = new JLabel("");
		colorDisponibleUno.setBackground(coloresDisponibles.get(0));
		colorDisponibleUno.setBorder(border);
		colorDisponibleUno.setOpaque(true);
		colorDisponibleUno.setBounds(600, 170, 30, 30);
		contentPane.add(colorDisponibleUno);
		
		colorDisponibleDos = new JLabel("");
		colorDisponibleDos.setBackground(coloresDisponibles.get(1));
		colorDisponibleDos.setBorder(border);
		colorDisponibleDos.setOpaque(true);
		colorDisponibleDos.setBounds(640, 170, 30, 30);
		contentPane.add(colorDisponibleDos);
		
		colorDisponibleTres = new JLabel("");
		colorDisponibleTres.setBackground(coloresDisponibles.get(2));
		colorDisponibleTres.setBorder(border);
		colorDisponibleTres.setOpaque(true);
		colorDisponibleTres.setBounds(680, 170, 30, 30);
		contentPane.add(colorDisponibleTres);
		
		colorDisponibleCuatro = new JLabel("");
		colorDisponibleCuatro.setBackground(coloresDisponibles.get(3));
		colorDisponibleCuatro.setBorder(border);
		colorDisponibleCuatro.setOpaque(true);
		colorDisponibleCuatro.setBounds(720, 170, 30, 30);
		contentPane.add(colorDisponibleCuatro);
		
		if(nivelDificultad == 5) {
			colorDisponibleCinco = new JLabel("");
			colorDisponibleCinco.setBackground(coloresDisponibles.get(4));
			colorDisponibleCinco.setBorder(border);
			colorDisponibleCinco.setOpaque(true);
			colorDisponibleCinco.setBounds(760, 170, 30, 30);
			contentPane.add(colorDisponibleCinco);
		} else if (nivelDificultad == 6) {
			colorDisponibleCinco = new JLabel("");
			colorDisponibleCinco.setBackground(coloresDisponibles.get(4));
			colorDisponibleCinco.setBorder(border);
			colorDisponibleCinco.setOpaque(true);
			colorDisponibleCinco.setBounds(760, 170, 30, 30);
			contentPane.add(colorDisponibleCinco);
			
			colorDisponibleSeis = new JLabel("");
			colorDisponibleSeis.setBackground(coloresDisponibles.get(5));
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
	
	/**
	 * Para cada una de las opciones del menú creamos un listener
	 */
	public void funcionalidadBarraMenu() {
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

		opciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							opciones_juego.setVisible(true);
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
	}
	
	/**
	 * Cuando presionamos el botón comprobar, comprobamos la solución del usuario
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		botonComprobar.setBounds(180, y+=40, 100, 23);
		crearColores(y,nivel_seleccionado, coloresDisponibles);
		contentPane.revalidate();
		contentPane.repaint();
		comprobarSolucionUsuario(y);
		contentPane.revalidate();
		contentPane.repaint();
	}

	public ArrayList<Color> getColoresDefault() {
		return coloresDefault;
	}


	public void setColoresDefault(ArrayList<Color> coloresDefault) {
		this.coloresDefault = coloresDefault;
	}


	public ArrayList<Color> getColoresDisponiblesPersonalizados() {
		return coloresDisponiblesPersonalizados;
	}

	public void setColoresDisponiblesPersonalizados(ArrayList<Color> coloresDisponiblesPersonalizados) {
		this.coloresDisponiblesPersonalizados = coloresDisponiblesPersonalizados;
	}

	public ArrayList<Color> getColoresDisponibles() {
		return coloresDisponibles;
	}

	public void setColoresDisponibles(ArrayList<Color> coloresDisponibles) {
		this.coloresDisponibles = coloresDisponibles;
	}


	public boolean isOpcionColoresDefecto() {
		return opcionColoresDefecto;
	}


	public void setOpcionColoresDefecto(boolean opcionColoresDefecto) {
		this.opcionColoresDefecto = opcionColoresDefecto;
	}


	public boolean isOpcionColoresPersonalizados() {
		return opcionColoresPersonalizados;
	}


	public void setOpcionColoresPersonalizados(boolean opcionColoresPersonalizados) {
		this.opcionColoresPersonalizados = opcionColoresPersonalizados;
	}
}