package com.firstproject.chatapp.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.firstproject.chatapp.dto.UserDTO;
import com.firstproject.chatapp.utils.Encryption;

//User CRUD operations
public class UserDAO {
	//DTO received
	public boolean isLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException,Exception   {
		Connection con = null;
		PreparedStatement pstmt =  null; //query
		ResultSet rs = null;
		final String SQL = "select userid from users where userid=? and password=?";
		try {
			con =CommonDAO.createConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, userDTO.getUserid());//get the value from DTO
			String encryptedPass = Encryption.passwordEncrypt(new String(userDTO.getPassword()));
			pstmt.setString(2,encryptedPass);
			rs = pstmt.executeQuery();
			return rs.next();
//			if(rs.next()) {
//				return true;
//			}
//			else {
//				return false;
//			}
		}
		finally 
		{
			if(rs!=null) {
				rs.close();
			} 
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			} 
			
		}
	}   
	
	
	
	
	
	public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException, Exception {
		
		
		System.out.println("Recieved : "+userDTO.getUserid()+"  "+"Recieved : "+userDTO.getPassword()+"  "+"Recieved : "+userDTO.getEmail());
		
		Connection connection = null;
		Statement stmt = null; //query
		
		try  //guarded region
		{
			connection = CommonDAO.createConnection(); //connection create
			//Step 2 we do a query
			
			stmt = connection.createStatement();
			
			int record = stmt.executeUpdate("insert into users (userid,password,email) values "+ "('"+userDTO.getUserid()+"','"+Encryption.passwordEncrypt(new String(userDTO.getPassword()))+"','"+userDTO.getEmail()+"')");                            
			return record;
		}
		
		finally	//Always execute
		{ 
			if(stmt!=null) 
				{
					stmt.close();
				}
			
			if(connection!=null) 
				{
					connection.close();}
				}
		}

}
