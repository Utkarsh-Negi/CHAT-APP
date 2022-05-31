package com.firstproject.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.firstproject.chatapp.dao.UserDAO;
import com.firstproject.chatapp.dto.UserDTO;
import com.firstproject.chatapp.utils.UserInfo;

import javax.swing.UIManager;

import org.apache.log4j.Logger;

import java.awt.SystemColor;

public class UserScreen extends JFrame{
	Logger logger = Logger.getLogger(UserScreen.class);
	private JTextField useridtxt;
	private JPasswordField passwordField;
	private JTextField emailField;
	
	public static void main(String[] args) {
		
					UserScreen window = new UserScreen();
					
				
	}
	UserDAO userDAO  = new UserDAO();
	
	
	private void doLogin() {
		logger.debug("Inside the Do Login");
		String userid = useridtxt.getText(); //getting the user text box value and store it into the string
		char[] password = passwordField.getPassword(); //ClassName @Hashcode (hexadecimal)
		String email = emailField.getText();
//		String city  = citytxt.getText();
//		String number = numbertxt.getText();
	
		UserDTO userDTO = new UserDTO(userid,password,email); //Create the object of DTO and store the values
		try 
		{
			
			String message = "";
			
			logger.debug("Calling DAO..");
			if(userDAO.isLogin(userDTO)) { //pass the DTO object which contains user info to the DAO
				message = "Welcome"+userid;
				UserInfo.USER_NAME = userid;
				JOptionPane.showMessageDialog(this, message);
				setVisible(false);
				dispose();
				DashBoard dashboard = new DashBoard(message);
				dashboard.setVisible(true);
				logger.debug("In a new Screen.. Login Successfull"+userid);
			}
			else {
				message = "Invalid userid or password";
				JOptionPane.showMessageDialog(this, message);
				
			} 
		//	JOptionPane.showMessageDialog(this, message);
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("userid : "+userid+" "+"password : "+password +" "+"email : "+email);
		
		
	}
	private void register() {
		String userid = useridtxt.getText();
		char[] password = passwordField.getPassword();
		String email = emailField.getText();
		
//		String city  = citytxt.getText();
//		String number = numbertxt.getText();
		//UserDAO userDAO  = new UserDAO();
		UserDTO userDTO = new UserDTO(userid,password,email); //Doubt cleared
		
		try 
		{
			int result = userDAO.add(userDTO);
			if(result>0) {
				
				JOptionPane.showMessageDialog(this,"Registered Successfully...");
				
				//System.out.println("Record added...");
				
			}
			else {
				
				JOptionPane.showMessageDialog(this,"Registration Failed..");
				//System.out.println("Record not added..");
			}
		}
		
		
		catch(ClassNotFoundException | SQLException ex) 
		{
			System.out.println("DB issue....");
			ex.printStackTrace();
		}
		
		catch(Exception ex) 
		{
			
			System.out.println("Some generic exception...");
			ex.printStackTrace(); //where is the exception
		}
		
		
		//System.out.println("userid : "+userid+" "+"password : "+password); // class name @hash code in hexadecimal form
	}

	/**
	 * Create the application.
	 */
	public UserScreen() {
		setResizable(false);
		setTitle("LOGIN");
		getContentPane().setBackground(SystemColor.activeCaption);
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 40));
		lblNewLabel.setBounds(316, 34, 203, 65);
		getContentPane().add(lblNewLabel);
		
		useridtxt = new JTextField();
		useridtxt.setBounds(435, 144, 266, 29);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("User Id");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(225, 135, 103, 46);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_2.setBounds(200, 192, 128, 38);
		getContentPane().add(lblNewLabel_2);
		
		JButton loginbt = new JButton("Login");
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				doLogin();
			}
		});
		loginbt.setFont(new Font("Calibri", Font.BOLD, 30));
		loginbt.setBounds(213, 397, 154, 46);
		getContentPane().add(loginbt);
		setBackground(Color.DARK_GRAY);
		setSize(888,544);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				register();
			}
		});
		btnRegister.setFont(new Font("Calibri", Font.BOLD, 30));
		btnRegister.setBounds(525, 397, 160, 46);
		getContentPane().add(btnRegister);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(435, 197, 266, 29);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("eMail");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_3.setBounds(253, 254, 66, 32);
		getContentPane().add(lblNewLabel_3);
		
		emailField = new JTextField();
		emailField.setBounds(435, 256, 266, 29);
		getContentPane().add(emailField);
		emailField.setColumns(10);
		setBackground(Color.WHITE);
		setBounds(100, 100, 833, 491);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
}
