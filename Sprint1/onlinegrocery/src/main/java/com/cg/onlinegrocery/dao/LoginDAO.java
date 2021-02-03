package com.cg.onlinegrocery.dao;


import com.cg.onlinegrocery.domain.Login;
import java.sql.ResultSet;


public class LoginDAO {
	public String authenticateUser(Login login)
	{
	    String userName = login.getUserName();
	    String password = login.getPassword();
	 
	    ResultSet resultSet = null;
	 
	    String userNameDB = "";
	    String passwordDB = "";
	    String roleDB = "";
	
        while(resultSet.next())
        {
            userNameDB = resultSet.getString("username");
            passwordDB = resultSet.getString("password");
            roleDB = resultSet.getString("role");
 
            if(userName.equals(userName) && password.equals(password) && roleDB.equals("Admin"))
            return "Admin_Role";
            else if(userName.equals(userName) && password.equals(password) && roleDB.equals("StoreIncharge"))
            return "StoreIncharge_Role";
            else if(userName.equals(userName) && password.equals(password) && roleDB.equals("User"))
            return "User_Role";
        }
	}

        

