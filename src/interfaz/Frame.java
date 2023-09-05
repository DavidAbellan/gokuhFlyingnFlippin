/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author barry
 */
public class Frame {
   JFrame frame;
   Panel cmp;
   public Frame()
   {
       frame = new JFrame();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.getContentPane().setLayout(null);
       frame.setSize(1000,600);
       cmp = new Panel(frame);
       frame.setLocationRelativeTo(null);
       frame.setUndecorated(true);
       frame.setVisible(true);
   
   }
   public static void main(String []args)
   {
      Frame p =new Frame(); 
   }
   
    
}
