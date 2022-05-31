package com.firstproject.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame{
	
	int counter =0;
	public UserView(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// when we want to close the tab after closing it from the cross mark  
		setSize(500,500);
		setResizable(false);//when we want the tab size to be fixed
		setTitle("Login");
//		setLocation(500,150);
		setLocationRelativeTo(null);
		JLabel welcome = new JLabel("Login");
		welcome.setFont(new Font ("Arial",Font.BOLD,40));
		Container container = this.getContentPane(); 
		container.setLayout(null);
		welcome.setBounds(100,70,200,60);
		container.add(welcome);
		JButton button  = new JButton("Count"); //Source
		button.addActionListener(new ActionListener() //Anonymous class
		{
			@Override
			public void actionPerformed(ActionEvent event) 
			{
				counter++;
				welcome.setText("Count :" +counter);
			}
		});
		button.setBounds(100, 300,200, 50);
		container.add(button);
		setVisible (true);
		
		
	}
	public static void main(String[] args) {
		UserView userView = new UserView();
		
	}

}
