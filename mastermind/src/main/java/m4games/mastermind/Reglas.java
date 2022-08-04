package m4games.mastermind;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;

public class Reglas extends JFrame {

	private JPanel contentPane;

	/**
	 * Reglas del juego
	 */
	public Reglas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 453, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Como Jugar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(154, 11, 123, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("En Mastermind compiten 2 jugadores, uno de ellos creará un código");
		lblNewLabel_1.setBounds(10, 44, 416, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("oculto con 5 clavijas de colores, pudiendo hacer las combinaciones con");
		lblNewLabel_1_1.setBounds(10, 58, 416, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("los 8 colores disponibles e incluso repitiendo color si lo desea. ");
		lblNewLabel_1_2.setBounds(10, 73, 416, 30);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("pueda verlo el oponente, que deberá acertar en el menor número");
		lblNewLabel_1_1_1.setBounds(10, 120, 416, 30);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("posible de jugadas la clave para obtener una buena puntuación.");
		lblNewLabel_1_2_1.setBounds(10, 135, 416, 30);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Para descifrar el código secreto de colores el jugador deberá");
		lblNewLabel_1_3.setBounds(10, 106, 416, 30);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("ir probando combinaciones aleatorias de colores, y en cada");
		lblNewLabel_1_3_1.setBounds(10, 149, 416, 30);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("combinación, el jugador contrario debe darle pistas mediante las");
		lblNewLabel_1_1_1_1.setBounds(10, 163, 416, 30);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("espigas blancas y negras.");
		lblNewLabel_1_2_1_1.setBounds(10, 178, 416, 30);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Por cada clavija acertada en color y posición, colocará una espiga negra,");
		lblNewLabel_1_3_2.setBounds(10, 202, 416, 30);
		contentPane.add(lblNewLabel_1_3_2);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("y por cada color acertado pero en un lugar equivocado colocará");
		lblNewLabel_1_1_1_2.setBounds(10, 216, 416, 30);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("una espiga blanca.");
		lblNewLabel_1_2_1_2.setBounds(10, 231, 416, 30);
		contentPane.add(lblNewLabel_1_2_1_2);
		
		JLabel lblPuntuacin = new JLabel("Puntuación");
		lblPuntuacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntuacin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPuntuacin.setBounds(154, 270, 123, 19);
		contentPane.add(lblPuntuacin);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("La forma de puntuación es bastante sencilla: se puede convenir antes de ");
		lblNewLabel_1_3_3.setBounds(10, 291, 416, 30);
		contentPane.add(lblNewLabel_1_3_3);
		
		JLabel lblNewLabel_1_1_1_3 = new JLabel("empezar de cuantos juegos va a ser la partida, cada jugador tiene un");
		lblNewLabel_1_1_1_3.setBounds(10, 305, 416, 30);
		contentPane.add(lblNewLabel_1_1_1_3);
		
		JLabel lblNewLabel_1_2_1_3 = new JLabel("color distinto de espiga de tanteo, rojo o azul, que colocará en el ");
		lblNewLabel_1_2_1_3.setBounds(10, 320, 416, 30);
		contentPane.add(lblNewLabel_1_2_1_3);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("número 1 de la fila vertical de tanteo. ");
		lblNewLabel_1_3_1_1.setBounds(10, 334, 416, 30);
		contentPane.add(lblNewLabel_1_3_1_1);
		
		JLabel lblNewLabel_1_3_4 = new JLabel("Al final de cada juego, el jugador que ha creado el código ganará tantos");
		lblNewLabel_1_3_4.setBounds(10, 361, 416, 30);
		contentPane.add(lblNewLabel_1_3_4);
		
		JLabel lblNewLabel_1_1_1_4 = new JLabel("puntos como filas haya cubierto el oponente hasta que ha conseguido");
		lblNewLabel_1_1_1_4.setBounds(10, 375, 416, 30);
		contentPane.add(lblNewLabel_1_1_1_4);
		
		JLabel lblNewLabel_1_2_1_4 = new JLabel("descifrar el código. Es decir, si ha necesitado probar 7 combinaciones");
		lblNewLabel_1_2_1_4.setBounds(10, 390, 416, 30);
		contentPane.add(lblNewLabel_1_2_1_4);
		
		JLabel lblNewLabel_1_3_1_2 = new JLabel("distintas antes de acertar, estos son los puntos que gana el jugador");
		lblNewLabel_1_3_1_2.setBounds(10, 404, 416, 30);
		contentPane.add(lblNewLabel_1_3_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("contrario, que se anotarán cambiando la posición de la clavija de tanteo ");
		lblNewLabel_1_1_1_1_1.setBounds(10, 418, 416, 30);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("correspondiente.");
		lblNewLabel_1_2_1_1_1.setBounds(10, 433, 416, 30);
		contentPane.add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_3_4_1 = new JLabel("En el caso de que el jugador que ha creado el código se equivoque al ");
		lblNewLabel_1_3_4_1.setBounds(10, 459, 416, 30);
		contentPane.add(lblNewLabel_1_3_4_1);
		
		JLabel lblNewLabel_1_1_1_4_1 = new JLabel("dar las pistas con las espigas blancas y negras, deberá repetir la serie y");
		lblNewLabel_1_1_1_4_1.setBounds(10, 473, 416, 30);
		contentPane.add(lblNewLabel_1_1_1_4_1);
		
		JLabel lblNewLabel_1_2_1_4_1 = new JLabel("además tendrá que dar 3 puntos al jugador contrario. Los jugadores se");
		lblNewLabel_1_2_1_4_1.setBounds(10, 488, 416, 30);
		contentPane.add(lblNewLabel_1_2_1_4_1);
		
		JLabel lblNewLabel_1_3_1_2_1 = new JLabel("alternarán para crear el código secreto e irán anotando sus ");
		lblNewLabel_1_3_1_2_1.setBounds(10, 502, 416, 30);
		contentPane.add(lblNewLabel_1_3_1_2_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("puntuaciones con las espigas de tanteo hasta terminar la partida. ");
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 516, 416, 30);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);	
	}
}
