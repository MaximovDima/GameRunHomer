/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dagame;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Enemy extends JPanel {
    
    int x_En0, y_En0, x_En, y_En, dx_En, dy_En;
    boolean checkHomer;
    
    Image img_north = new ImageIcon(getClass().getResource("/images/enemy_north.JPG")).getImage();
    Image img_east = new ImageIcon(getClass().getResource("/images/enemy_east.JPG")).getImage();
    Image img_south = new ImageIcon(getClass().getResource("/images/enemy_south.JPG")).getImage();
    Image img_west = new ImageIcon(getClass().getResource("/images/enemy_west.JPG")).getImage();
    
    
    Image img_enemy = img_north;
    
    public int getXEneLoc(int xRescue, int yRescue){
        
        if ((xRescue == 616) & (yRescue == 462))  {
            x_En0 = 616;
        }
        if ((xRescue == 0) & (yRescue == 462)) {
            x_En0 = 616;
        }    
        if ((xRescue == 0) & (yRescue == 0)) {
            x_En0 = 0;
        }
        if ((xRescue == 616) & (yRescue == 0)) {
            x_En0 = 0;
        }
        x_En = x_En0;               
        return x_En0;
    }    
 
    public int getYEneLoc(int xRescue, int yRescue){

        if ((xRescue == 616) & (yRescue == 462))  {
            y_En0 = 0;
        }
        if ((xRescue == 0) & (yRescue == 462)) {
            y_En0 = 462;
        }    
        if ((xRescue == 0) & (yRescue == 0)) {
            y_En0 = 462;
        }
        if ((xRescue == 616) & (yRescue == 0)) {
            y_En0 = 0;
        }    
        y_En = y_En0;
        return y_En0;
    }    
    
    public void moveEnemy(int xHomer, int yHomer) {
        
        dx_En = xHomer - x_En;
        dy_En = yHomer - y_En;
        
        
        if (Math.abs(dx_En) >= Math.abs(dy_En)) {
        if (dx_En >= 77) {
            x_En = x_En + 77;
            img_enemy = img_east;
        }
        
        if (dx_En <= -77) {
            x_En = x_En - 77;
            img_enemy = img_west;
        }
        
        if ((dx_En < 78) && (dx_En > -78)) {         
            if (dy_En > 0) {
                y_En = y_En + 77;
                img_enemy = img_south;
            }
        
            if (dy_En < 0) {
                y_En = y_En - 77;
                img_enemy = img_north;
            }
        }
        }
        else {
        
        if (dy_En >= 77) {
            y_En = y_En + 77;
            img_enemy = img_south;
        }
        
        if (dy_En <= 77) {
            y_En = y_En - 77;
            img_enemy = img_north;
        }
        
        if ((dy_En < 78) && (dy_En > -78)) {         
            if (dx_En > 0) {
                x_En = x_En + 77;
                img_enemy = img_east;
            }
        
            if (dx_En < 0) {
                x_En = x_En - 77;
                img_enemy = img_west;
            }
        }
        }
    }
    
    public void checkHomer (int xHomer, int yHomer) {
        checkHomer = false;
        if ((x_En == xHomer) && (y_En == yHomer)) {
            checkHomer = true;    
        } 
    }
    
    public void ShowGameOver() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ee){
            ee.printStackTrace();    
        }   
            JOptionPane.showMessageDialog(null,"Mr. Burns caught Homer!","Game over!", JOptionPane.ERROR_MESSAGE);
    }
    
}
