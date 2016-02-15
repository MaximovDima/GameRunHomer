/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dagame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Admin
 */

public class Game {
    
    private static final int DEFAULT_WIDTH = 700;
    private static final int DEFAULT_HEIGHT = 559;
    private JFrame Frame = new JFrame("Game");
    private JPanel place = new Place();
    
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();  
    }
        
    public void startGame() {
        
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        Frame.setLocationRelativeTo(null);
        Frame.setResizable(false);
        Frame.add(place);
        Frame.setVisible(true);
    }
    
    public void restartGame(){
        Frame.remove(place);
        Frame.validate();
        Frame.repaint();
        Frame.add(place = new Place());
        Frame.setVisible(true);
        
        
    }
    


class Place extends JPanel implements ActionListener {
    
    Homer homer = new Homer();
    Trouble trouble1 = new Trouble();
    Trouble trouble2 = new Trouble();
    Rescue rescue = new Rescue();
    Enemy enemy = new Enemy();

    
    int x_trouble1 = trouble1.x_trouble;
    int y_trouble1 = trouble1.y_trouble;
    int x_trouble2 = trouble2.x_trouble;
    int y_trouble2 = trouble2.y_trouble;
    
    boolean enemyGo = false;
    
    Image img = new ImageIcon(getClass().getResource("/images/place.JPG")).getImage();

    
    
    public Place() {
    
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }
  
    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {        
            homer.keyPressed(e);
            homer.move();       
            repaint();
            trouble1.checkHomer(homer.x, homer.y);
            trouble2.checkHomer(homer.x, homer.y);
            rescue.checkHomer(homer.x, homer.y);
            trouble1.checkEnemy(enemy.x_En, enemy.y_En);
            trouble2.checkEnemy(enemy.x_En, enemy.y_En);
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            homer.keyReleased(e);
            if ((trouble1.checkHomer == true) || (trouble2.checkHomer == true)) {
                homer.img_f = homer.img_homerTr; 
                repaint();
                Place.this.showGameOver();
                }
            
            if (rescue.checkHomer == true) {
                homer.img_f = homer.img_win; 
                repaint();
                Place.this.showGameWin();
            }
            
            repaint();
           
                
            if ((trouble1.i == 0) && (trouble2.i == 0)) {
                enemy.moveEnemy(homer.x, homer.y);
                repaint(); 

            }
            enemy.checkHomer(homer.x, homer.y);
            if (enemy.checkHomer == true) {
                homer.img_f = homer.img_loose; 
                repaint();  
                Place.this.showGameOver();
            }
        }
    }
    
    @Override
    public void paint(Graphics g) {
        g = (Graphics2D) g;
        g.drawImage(img, 0, 0, null);
    
        g.drawImage(trouble1.img_trouble, trouble1.x_trouble, trouble1.y_trouble, null);
        g.drawImage(trouble2.img_trouble, trouble2.x_trouble, trouble2.y_trouble, null);
        
        g.drawImage(rescue.img_rescue, rescue.getXResLoc(homer.x_x0), rescue.getYResLoc(homer.y_y0), null);
        
        if (enemyGo == false) {
            g.drawImage(enemy.img_enemy, enemy.getXEneLoc(rescue.x_Res, rescue.y_Res), 
                                     enemy.getYEneLoc(rescue.x_Res, rescue.y_Res), null);
            enemyGo = true;
        }
        else {
            g.drawImage(enemy.img_enemy, enemy.x_En, enemy.y_En, null);            
        }
        g.drawImage(homer.img_f, homer.x, homer.y, null);    
    }
    
    
    @Override
    public void actionPerformed (ActionEvent e){
        //homer.move();
        //repaint();
    }
    
    public void showGameOver() {
        JOptionPane.showMessageDialog(null,"Homer failed!!!","Game over!", JOptionPane.ERROR_MESSAGE);                              
        restartGame(); 
    }
    
    public void showGameWin() {
        JOptionPane.showMessageDialog(null,"Homer WINS!!!","You are lucky!", JOptionPane.ERROR_MESSAGE);
        restartGame();           
    }
}
}
