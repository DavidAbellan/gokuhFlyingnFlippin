/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Image;
import java.awt.Point;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author barry
 */
public class Character {
    JLabel gokuh = new JLabel();
    private int limit=999;
    private int limitY=600;
    public Character(int posX, int posY)
    {
      setTamano();
      paintCharacter("gokuhIdle");
      setPosicion(posX, posY);
    }
    public void setPosicion(int x, int y)
    { 
        gokuh.setLocation(x,y);
    
    }
    public void setTamano() 
    {
        gokuh.setSize(72,88);
    }
    public void paintCharacter(String spr){
      URL url =getClass().getResource("ashes/gokuh/" + spr + ".png");
      ImageIcon img  =new ImageIcon(url);
      Icon icono = new ImageIcon(img.getImage().getScaledInstance(gokuh.getWidth(), gokuh.getHeight(),Image.SCALE_DEFAULT));
      gokuh.setIcon(icono);
      gokuh.repaint();
    }
    public int getPosX() 
    {
        return gokuh.getX();
    }
    public int getPosY() 
    {
        return gokuh.getY();
    }
    public void stopped() 
    {
        paintCharacter("gokuhIdle");
    }
    public boolean limiteX(){
      return limit > gokuh.getX() +100 ;
    } 
    public boolean limiteY() 
    {
        return gokuh.getY()>=0;
    }
    public void jump() 
    {
        int ground = 300;
        int groundAux= ground;
        int mov = 1;//nombre de la imagen
        int jumpLimit = ground - 75;
        boolean upper = true;
        boolean lower = false;
        boolean jumpState = true;
        while (jumpState)
        {
            if (upper)
            {
                if(ground < jumpLimit)
                {
                    upper=false;
                    lower=true;
                } else {
                    ground -=5;
                }
            } else {
                if (lower)
                {
                    if(ground == groundAux)
                    {
                        jumpState = false;
                    }else{
                        ground+=5;
                    }
                    
                }
            }
        }
        if(mov<5)
        {
            paintCharacter("gokukJump"+mov);
            mov++;
        } else {
            mov=1;
        }
        try {
           Thread.sleep(150);
           setPosicion(getPosX(), ground);
        }catch(InterruptedException ex){
            
        }
    }
    
}
