/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Image;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author barry
 */
public class Enemy {
    JLabel enemy = new JLabel();
    public Enemy(int posX,int posY)
    {
        setTamano();
        setPosicion(100,100);
        paintCharacter("enemyIdle");
    }
    public void setTamano()
    {
      enemy.setSize(72,88);
    }
    public void setPosicion(int posX, int posY)
    {
      enemy.setLocation(posY, posY);
    }
    public void paintCharacter(String pos)
    {
      URL url =getClass().getResource("ashes/soldier/" + pos + ".png");
      ImageIcon img  =new ImageIcon(url);
      Icon icono = new ImageIcon(img.getImage().getScaledInstance(enemy.getWidth(), enemy.getHeight(),Image.SCALE_DEFAULT));
      enemy.setIcon(icono);
      enemy.repaint();
    }
    public int getPosX() 
    {
        return  enemy.getX();
    }
    public int getPosY() 
    {
        return enemy.getY();
    }
    
    
   /* public class moviment extends Thread() 
    {
        @Override
        public void run() {
        
    }
    }*/
}
