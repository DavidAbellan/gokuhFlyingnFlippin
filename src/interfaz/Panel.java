/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author barry
 */
class Panel {
    private boolean toDerecha, toIzq, hit,toAbajo,toArriba,jump;
    private Character chr;
    private JFrame frame;
    private JPanel pane;
    animaMov hilo;
    
    public Panel(JFrame fram) {
        frame = fram;
        Components();
        ComponentsFrame();
        hilo = new animaMov();
        hilo.start();
        addCharacter();
       
    }

    private void Components() {
        pane = new JPanel();
        Image background = Toolkit.getDefaultToolkit().createImage("ashes/terrain/clouds.png");
        GroupLayout grup = new GroupLayout(pane);
        pane.setLayout(grup);
        pane.setBackground(Color.GRAY);
        pane.setBounds(0, 0, 1000, 600);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                movCharacter(e);
            }
        });

    }

    private void ComponentsFrame() {
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                accionKeyEvent(e);
            }
        });
        frame.getContentPane().add(pane);
    }

    private void addCharacter() {
        chr = new Character(120, 120);
        pane.add(chr.gokuh);
    }

    private void accionKeyEvent(KeyEvent e) {
        int code = e.getExtendedKeyCode();
        if (code == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        if(checkEstado(toDerecha)) 
        {
            toDerecha=false;
        }
        if(checkEstado(toIzq))
        {
            toIzq = false;
        }
         if(checkEstado(toAbajo))
        {
            toAbajo = false;
        } 
         if(checkEstado(toArriba))
        {
            toArriba = false;
        }
        chr.stopped();

    }

    private void movCharacter(KeyEvent tcl) {
        int code = tcl.getExtendedKeyCode();
        if (code == KeyEvent.VK_D) {
            if (chr.limiteX()) {
                chr.setPosicion(chr.getPosX() + 10, chr.getPosY());
                toDerecha = true;
            }
        }
        if (code == KeyEvent.VK_A) {
            
            chr.setPosicion(chr.getPosX() - 8, chr.getPosY());
            toIzq = true;
           
        }
        if (code == KeyEvent.VK_F)
        {
            hit=true;
        }
        if (code == KeyEvent.VK_X)
        {
            toAbajo=true;
            chr.setPosicion(chr.getPosX(),chr.getPosY() + 10);
        }
        if (code == KeyEvent.VK_W) {
            chr.setPosicion(chr.getPosX() , chr.getPosY()- 8);
            toArriba = true;
        }
         if (code == KeyEvent.VK_S) {
            jump=true;
        }
    }
    /**
     *
     * hilos de movimiento para animaciones !!!
     */
    

    public class animaMov extends Thread {
       
        @Override
        public void run() {
            while(true) {
               System.out.println(".");
               if (checkEstado(toDerecha)) 
               {
                  for(int i = 0; i < 8; i ++) {
                     
                      try {         
                          chr.paintCharacter("gokuhRight");
                          Thread.sleep(1);
                      } catch (InterruptedException ex) {
                          Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      
                  }
                 
               } 
               toDerecha = false;
               
               if (checkEstado(toIzq)) 
               {
                  for(int i = 0; i < 8; i ++) {
                     
                      
                      try {         
                          chr.paintCharacter("gokuhBack");
                          Thread.sleep(1);
                      } catch (InterruptedException ex) {
                          Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  
                  }
               }
               toIzq =false;
               
                if (checkEstado(toAbajo)) 
               {
                  for(int i = 0; i < 8; i ++) {
                      if(chr.limiteY()){
                      try {         
                          chr.paintCharacter("gokuhBack");
                          Thread.sleep(1);
                      } catch (InterruptedException ex) {
                          Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
                  }
               }
               toAbajo =false;
                 if (checkEstado(toArriba)) 
               {
                  for(int i = 0; i < 8; i ++) {
                      if(chr.limiteY()) 
                      {
                      try {         
                          chr.paintCharacter("gokuhRight");
                          Thread.sleep(1);
                      } catch (InterruptedException ex) {
                          Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      }
                  }
                 
               } 
               toArriba = false;
               
               
               
               if (checkEstado(hit))
               {
                  System.out.println(chr.getPosY());
                  for(int i =0 ; i<4;i++) 
                  {
                     try{
                      chr.paintCharacter("gokuhHit"+i);
                      Thread.sleep(200);
                     }catch (InterruptedException ex) {
                          Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
                 chr.paintCharacter("gokuhIdle");
                   
               }
               hit=false;
               
             /*   if (checkEstado(jump))
               {
                   chr.jump();
               }
              
               jump=false;*/
              
            }
            
              
    }
}
    private boolean checkEstado(boolean state) 
    {
        boolean estado = false;
        if(state==true)
        {
            estado = true;
        }
        return estado;
    }

   private void setBackGround() {
       JLabel bg = new JLabel();
       bg.setBounds(0,0,1000,600);
       URL url =getClass().getResource("ashes/terrain/clouds.png");
       ImageIcon fond = new ImageIcon(url);
       
   }

}
