/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Yori
 */
public class Paneel extends JPanel{    
    klasListModel klm = new klasListModel();
    
    JComboBox cbKlas;
    
    JList klasList;
    
    JTextArea leerlingTxt;
    
    JTextField voornaamFld,achternaamFld,emailFld , klasFld;
    
    JLabel voornaamLbl, achternaamLbl, emailLbl, klasLbl,errorLbl , aantalLbl;
    
    JButton toevoegenLeerlingBtn, toevoegenKlasBtn;
    
    DefaultListModel model = new DefaultListModel();
        
    public Paneel(){
       
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        
        JPanel overzicht = new JPanel();
        JPanel toevoegen = new JPanel();
        
        overzicht.setLayout(new BoxLayout(overzicht, BoxLayout.PAGE_AXIS));
        toevoegen.setLayout(new BoxLayout(toevoegen, BoxLayout.PAGE_AXIS));
        
        
        cbKlas = new JComboBox();
        
        klasList = new JList(model);
        
        leerlingTxt = new JTextArea();
        
        voornaamFld = new JTextField(15);
        achternaamFld = new JTextField(15);
        emailFld = new JTextField(15);
        klasFld = new JTextField(15);
        
        voornaamLbl = new JLabel("voornaam");
        achternaamLbl = new JLabel("achternaam");
        emailLbl = new JLabel("E-mail");
        klasLbl = new JLabel("Klas");
        errorLbl = new JLabel("");
        
        
        toevoegenLeerlingBtn = new JButton("toevoegen leerling");
        toevoegenKlasBtn = new JButton("toevoegen klas");
        
        klm.addModel(model, "4A3A");   
        
        aantalLbl = new JLabel("");
        
        klm.addKlasToCB(cbKlas);
        
        add(overzicht, "overzicht");
        add(toevoegen, "toevoegen");
        
        overzicht.add(cbKlas);
        overzicht.add(klasList);
        overzicht.add(leerlingTxt);
        
        toevoegen.add(voornaamLbl);
        toevoegen.add(voornaamFld);
        toevoegen.add(achternaamLbl);
        toevoegen.add(achternaamFld);
        toevoegen.add(emailLbl);
        toevoegen.add(emailFld);
        toevoegen.add(toevoegenLeerlingBtn);
        toevoegen.add(klasLbl);
        toevoegen.add(klasFld);
        toevoegen.add(toevoegenKlasBtn);
        toevoegen.add(errorLbl);
        
        cbKlas.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                 clearTxt();
                 
                 klm.addModel(model, cbKlas.getSelectedItem().toString());
            }
        });
        
        klasList.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                leerlingTxt.setText(klm.getInfo(klasList));
            }
        });
        toevoegenLeerlingBtn.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if(!voornaamFld.getText().equals("") && !achternaamFld.getText().equals("") && !emailFld.getText().equals("")){
                    
                    klm.addLeerlingToKlas(voornaamFld.getText(),achternaamFld.getText(),emailFld.getText(),cbKlas.getSelectedItem().toString(),model);
                    
                    errorLbl.setText("leerling toegevoegd");
                }
                else{
                    errorLbl.setText("iets niet goed ingevuld!");
                }
            }
        });
        toevoegenKlasBtn.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if(!klasFld.getText().equals("")){
                    
                    klm.addKlas(klasFld.getText(),cbKlas);
                    
                    
                    errorLbl.setText("klas toegevoegd");
                }
                else{
                    errorLbl.setText("iets niet goed ingevuld!");
                }
            }
        });
        
        
    }
    public void clearTxt(){
        leerlingTxt.setText("");
        voornaamFld.setText("");
        achternaamFld.setText("");
        emailFld.setText("");
        errorLbl.setText("");
    }
    
}
