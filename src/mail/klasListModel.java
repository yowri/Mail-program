/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author Yori
 */
public class klasListModel {
    LeerlingModel lm;
    KlasModel km;
   
    ArrayList<Leerling> lijst;
    
    public klasListModel(){
        lm = new LeerlingModel();
        km = new KlasModel();
        
        lijst = new ArrayList<Leerling>();
    }
    
    public void addKlasToCB(JComboBox cb){
        for(Klas klas  : km.getKlasList()){
            cb.addItem(klas.getNaam());
        }
    }

    public ArrayList<Leerling> getKlasList(){
        return this.lijst;
    }
    
    public void setKlasList(String naam){
        
        this.lijst.clear();
        
        for(Klas klas : km.getKlasList())
        {
            if(klas.getNaam().equals(naam))
            {
                for(Leerling leerling : lm.getLeerlingList())
                {
                    if(klas.getId() == leerling.getKlasId())
                    {
                        this.lijst.add(leerling);
                    }
                }
            }
        }
    }
    public int getAantal(String klasNaam){
        for(Klas klas: km.getKlasList()){
            if(klas.getNaam().equals(klasNaam)){
                return klas.getAantal();
            }
        }
        return 0;
    }
    public void addModel(DefaultListModel model,String klasNaam){
        
        setKlasList(klasNaam);
        
        Object[] leerlingen = getKlasList().toArray();
        
        model.clear();
        
        for(int i = 0; i < leerlingen.length ; i++){
          model.add(i, leerlingen[i]);
        }
    }
    public String getInfo(JList list){
        int count = -1;

        for(Leerling leerling : getKlasList()){
            count++;

            if(list.getSelectedIndex() == count){
                return "voornaam: "+ leerling.getVoornaam() + "\nachternaam: " + leerling.getAchternaam() + "\ne-mail:" + leerling.getEmail();
            }
        }

        return "";
    }
    public void addLeerlingToKlas(String voornaam,String achternaam, String email,String klasNaam,DefaultListModel model){
        Leerling leerling = new Leerling();
        
        for(Klas klas : km.getKlasList()){
            if(klas.getNaam().equals(klasNaam))
            {
                leerling.setVoornaam(voornaam);
                leerling.setAchternaam(achternaam);
                leerling.setEmail(email);
                leerling.setKlasId(klas.getId());
   
                lm.addLeerling(leerling);
                
                addModel(model,klasNaam);
            }
        }
    }
    public void addKlas(String klasNaam,JComboBox cb){
        for(Klas klas : km.getKlasList())
        {
            if(!klas.getNaam().equals(klasNaam)){
                Klas newKlas = new Klas();
                newKlas.setNaam(klasNaam);
                
                km.addKlas(newKlas);
                
                cb.addItem(klasNaam);
            }
            else{
                System.out.print("naam bestaad al!");
            }
        }
    }

}
