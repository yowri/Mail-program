/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

/**
 *
 * @author Yori
 */
public class Leerling {
    private int id,klasId;
    private String voornaam,achternaam,email; 
    
    public Leerling()
    {
        
        
    }
    
    public void setVoornaam(String voornaam)
    {
        this.voornaam = voornaam;
    }
    public void setAchternaam(String achternaam)
    {
        this.achternaam = achternaam;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getVoornaam()
    {
        return this.voornaam;
    }
    public String getAchternaam(){
        return this.achternaam;
    }
    public String getEmail()
    {
        return this.email;
    }
    public int getId()
    {
        return this.id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
     public int getKlasId()
    {
        return this.klasId;
    }
    public void setKlasId(int id)
    {
        this.klasId = id;
    }
    public String toString(){
        return "Leerling: "+getVoornaam()+" "+getAchternaam()+" \n";
    }

}
