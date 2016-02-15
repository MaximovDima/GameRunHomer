/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dagame;


import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;


/**
 *
 * @author Admin
 */
public class Homer {
    
    int dx, dy;
    
    final Random random = new Random();
    
    Image img_north = new ImageIcon(getClass().getResource("/images/stay_north.JPG")).getImage();
    Image img_east = new ImageIcon(getClass().getResource("/images/stay_east.JPG")).getImage();
    Image img_west = new ImageIcon(getClass().getResource("/images/stay_west.JPG")).getImage();
    Image img_south = new ImageIcon(getClass().getResource("/images/stay_south.JPG")).getImage();
    Image img_up = new ImageIcon(getClass().getResource("/images/step_up.JPG")).getImage();
    Image img_down = new ImageIcon(getClass().getResource("/images/step_down.JPG")).getImage();
    Image img_left = new ImageIcon(getClass().getResource("/images/step_left.JPG")).getImage();
    Image img_right = new ImageIcon(getClass().getResource("/images/step_right.JPG")).getImage();
    Image img_homerTr = new ImageIcon(getClass().getResource("/images/big_trouble.JPG")).getImage();
    Image img_win = new ImageIcon(getClass().getResource("/images/homer_wins.JPG")).getImage();
    Image img_loose = new ImageIcon(getClass().getResource("/images/homer_loose.JPG")).getImage();
    

    
    Image img_f = img_north;
    
    int x_x0 = 77*random.nextInt(8);
    int y_y0 = 77*random.nextInt(6); 
    int x = x_x0;
    int y = y_y0;
    
    
    public void move(){
            
        x = x + dx;
        y = y + dy;      
        if (x<=0) x = 0;
        if (x>=616) x = 616;
        if (y<=0) y = 0;
        if (y>=462) y = 462;
        

    }
    
    
    public void keyPressed(KeyEvent e){
       int key = e.getKeyCode();
        if (key == KeyEvent.VK_D) {
            dx = 77;
            img_f = img_right;
            
        }
        if (key == KeyEvent.VK_A) {
            dx = -77;
            img_f = img_left;
        }
        if (key == KeyEvent.VK_W) {
            dy = -77;
            img_f = img_up;
        }
        if (key == KeyEvent.VK_S) {
            dy = 77;
            img_f = img_down;
        }
    }
    
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D) {
            try{
                dx = 77;
                Thread.sleep(150);
                } catch (InterruptedException ee) {
                ee.printStackTrace();
            }
            img_f = img_east;
        }
        if (key == KeyEvent.VK_A) {
            try{
                dx = -77;
                Thread.sleep(150);
                } catch (InterruptedException ee) {
                ee.printStackTrace();
            }
            img_f = img_west;
        }
        if (key == KeyEvent.VK_W) {
            try{
                dy = -77;
                Thread.sleep(150);
                } catch (InterruptedException ee) {
                ee.printStackTrace();
            }
            img_f = img_north;
        }
        if (key == KeyEvent.VK_S) {
            try{
                dy = 77;
                Thread.sleep(150);
                } catch (InterruptedException ee) {
                ee.printStackTrace();
            }
            img_f = img_south;
        }            
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_A) {
            dx = 0;
        }
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_S) {
            dy = 0;
        
        }

    }
    
}
