package m4games.mastermind;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Label;
import javax.swing.border.LineBorder;

public class JuegoMainApp {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mastermind frame = new Mastermind();		
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}