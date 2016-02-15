/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dagame;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Trouble extends JPanel {
    
    boolean checkHomer;
    final Random random = new Random();
    Image img_trouble = new ImageIcon(getClass().getResource("/images/trouble.JPG")).getImage();
    int x_trouble = 77*random.nextInt(8);
    int y_trouble = 77*random.nextInt(6);
    double i = 0;
    
    public void checkHomer (int xHomer, int yHomer) {
        checkHomer = false;
        if ((x_trouble == xHomer) && (y_trouble == yHomer)) {
            checkHomer = true;    
        } 
    }    

    
    public void checkEnemy (int xEnemy, int yEnemy) {
            if (i == 0) {
                
            
        if ((x_trouble == xEnemy) && (y_trouble == yEnemy)) {
            i = 1.5;
        }
            }else {
            i = i - 0.5;
        }
        
    }
}
