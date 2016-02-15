/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dagame;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Rescue extends JPanel {
    
    boolean checkHomer;
    Image img_rescue = new ImageIcon(getClass().getResource("/images/rescue.JPG")).getImage();
    int x_Res;
    int y_Res;
    
    public int getXResLoc(int xHomer){
        if ((693 - xHomer) <= 346){
            x_Res = 0;
        }
        else x_Res = 616;        
        return x_Res;
    }    
 
    public int getYResLoc(int yHomer){
        if ((539 - yHomer) <= 269){
            y_Res = 0;
        }
        else y_Res = 462;
        return y_Res;
    }
    
    public void checkHomer (int xHomer, int yHomer) {
        checkHomer = false;
        if ((x_Res == xHomer) && (y_Res == yHomer)) {
            checkHomer = true;    
        } 
    }
    

}

