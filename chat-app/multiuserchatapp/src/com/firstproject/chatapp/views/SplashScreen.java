package com.firstproject.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SplashScreen extends JWindow {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
					frame.runProgressBar();
				
	}
	
	private Timer timer;// Instance variable (Initialized with null value)
	private void runProgressBar() {
		
	 timer = new Timer(20,new ActionListener() {
		 
		 @Override
		 
		 public void actionPerformed(ActionEvent e) {
			 progressBar.setValue(count);
			 count++;
			 if(count>100) {
				 if(timer!=null) {
					 
					 timer.stop();
					 SplashScreen.this.setVisible(false); 
					 SplashScreen.this.dispose(); 
					 UserScreen userScreen = new UserScreen();
					 userScreen.setVisible(true);
				 }
			 } 
		 }
	 });
		
		timer.start();
	}
	
	private int count = 0;
	JProgressBar progressBar = new JProgressBar();
	
	

	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 14));
		progressBar.setStringPainted(true);
		progressBar.setBounds(724, 11, 253, 37);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(SplashScreen.class.getResource("/images/53-1-1024x600.jpg")));
		lblNewLabel.setBounds(0, 0, 1001, 587);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
	}
}
