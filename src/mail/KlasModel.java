/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;


import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Yori
 */
public class KlasModel {
    
    private int id,aantal;
    
    private String naam,sql;
    private String sqlId,sqlNaam;
    private ArrayList<Klas> lijst;

    
    private ResultSet resultSet = null;
   
    Context db;
    
    public KlasModel()
    {
        
        lijst = new ArrayList<Klas>();
        sqlId = "id";
        sqlNaam = "naam";
        
        db = new Context();
        
        try{
            resultSet = db.getStatement().executeQuery("SELECT * FROM klas");
            
            while(resultSet.next()){
                naam = resultSet.getString(sqlNaam);
                id = resultSet.getInt(sqlId);

                Klas klas = new Klas();
                
                klas.setId(id);
                klas.setNaam(naam);
               
                lijst.add(klas);
            }
            
        }catch(SQLException se){
      //Handle errors for JDBC
            se.printStackTrace();
        }
    }
    
    public ArrayList<Klas> getKlasList(){
       return this.lijst;
    }
    public void addKlas(Klas klas)
    {
        sql = "INSERT INTO klas("+sqlNaam+") " +
                   "VALUES ( '"+klas.getNaam()+"')";
        
        try{
            db.getStatement().executeUpdate(sql);
        }catch(SQLException se){
      //Handle errors for JDBC
            se.printStackTrace();
        }
        
        lijst.add(klas);

    }
    
    
 
    
}
