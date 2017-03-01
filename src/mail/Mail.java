/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import javax.swing.*;



/**
 *
 * @author Yori
 */
public class Mail extends JFrame {
    



    /**
     * @param args the command line arguments
     */
    public static void main(String[] argv) throws Exception {
        JFrame frame = new Mail();
        frame.setSize(400, 400);
        frame.setTitle("Eindopdracht");
        JPanel paneel = new Paneel();
        frame.setContentPane(paneel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); 
    }
       
}
