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
public class LeerlingModel {
    
    private int id,klasId;
    
    private String voornaam,achternaam,email;
    private String sqlVoornaam,sqlAchternaam,sqlEmail,sqlKlasId,sqlId,sql;
    private ArrayList<Leerling> lijst;
    
    private ResultSet resultSet = null;
   
    Context db;
    
    public LeerlingModel()
    {
        lijst = new ArrayList<Leerling>();
        sqlId = "Id";
        sqlVoornaam = "voornaam";
        sqlAchternaam = "achternaam";
        sqlEmail = "email";
        sqlKlasId = "klasID";
        db = new Context();
        
        try{
            resultSet = db.getStatement().executeQuery("SELECT * FROM leerling");
            
            while(resultSet.next()){
                id = resultSet.getInt(sqlId);
                voornaam = resultSet.getString(sqlVoornaam);
                achternaam = resultSet.getString(sqlAchternaam);
                email = resultSet.getString(sqlEmail);
                klasId = resultSet.getInt(sqlKlasId);
                
                Leerling leerling = new Leerling();
                
                leerling.setVoornaam(voornaam);
                leerling.setAchternaam(achternaam);
                leerling.setEmail(email);
                leerling.setKlasId(klasId);
                leerling.setId(id); 
                
                lijst.add(leerling);
            }
            
        }catch(SQLException se){
      //Handle errors for JDBC
            se.printStackTrace();
        }
    }
    
    public ArrayList<Leerling> getLeerlingList(){
       return this.lijst;
    }
    public void addLeerling(Leerling leerling)
    {
        sql = "INSERT INTO leerling("+sqlVoornaam+","+sqlAchternaam+","+sqlEmail+","+sqlKlasId+") " +
                   "VALUES ( '"+leerling.getVoornaam()+"', '"+leerling.getAchternaam()+"', '"+leerling.getEmail()+"', '"+leerling.getKlasId()+"')";
        
        try{
            db.getStatement().executeUpdate(sql);
        }catch(SQLException se){
      //Handle errors for JDBC
            se.printStackTrace();
        }
        
        lijst.add(leerling);

    }
    
    
 
    
}
