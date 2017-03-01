/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import java.sql.*;
/**
 *
 * @author Yori
 */
public class Context {
    static final String JDBC_driver = "com.mysql.jdbc.Driver"; 
    static final String DB_URL = "jdbc:mysql://localhost/maillijst";
    
    static final String user = "root";
    static final String pass = "";
    
    private Connection connection = null;
    private Statement statement = null;
    
    
    public Context(){
        
        try{
            Class.forName(JDBC_driver);

            connection = DriverManager.getConnection(DB_URL,user,pass);
            
            statement = connection.createStatement();

        }catch(SQLException se){
      //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
      //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
   
    public Statement getStatement(){
        return this.statement;
    }
    public void close(){
        try{
         connection.close();
        }catch(SQLException se){
      //Handle errors for JDBC
            se.printStackTrace();
        }
    }
    
  
}
