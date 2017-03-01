/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import java.util.ArrayList;

/**
 *
 * @author Yori
 */
public class Klas {
    private String naam;
    private int id,aantal;
    private LeerlingModel leerling;
    
    public Klas(){
       leerling = new LeerlingModel();
       
       aantal = leerling.getLeerlingList().size();
    }
    
    public void setNaam(String naam){
        this.naam = naam;
        
        
    }
    public void setId(int id){
        this.id = id;
    }
    public void setAantal(int aantal){
        this.aantal = aantal;
    }
    public String getNaam(){
        return this.naam;
    }
    public int getId(){
        return this.id;
    }
    public int getAantal(){
        return this.aantal;
    }
}
