package pacman;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;


public class Display extends JFrame implements ActionListener{
    BuildUp pman;
    Timer timer;
    byte[][] board = {  {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,0,0,0,0,0,0,0,1,1,0,0,0,0,1},
                        {1,1,1,1,1,1,1,0,1,0,0,1,1,0,1},
                        {1,1,1,1,1,1,1,0,0,0,1,0,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1,1,0,1,0,1},
                        {1,1,1,1,1,1,1,1,1,1,1,0,1,0,0},
                        {1,1,1,1,1,1,1,1,1,1,1,0,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,0,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,0,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,0,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
                        {1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    
                     };
    
    public Display(){
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(600,600));
        pman = new BuildUp(300,300,210,360);
        //300 facing down
        //300 facing up
        //210 left
        //360 right
        this.setVisible(true);
        timer = new Timer(50, this);
        timer.start();
        
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                
            }
               
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    pman.changeDirection(120);
                }
                else if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    pman.changeDirection(300);
                }
                else if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    pman.changeDirection(210);
                }
                else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    pman.changeDirection(30);
                        }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
          
        
       
    });
    }
    public void paint(Graphics g){
        this.paintComponents(g);
        g.setColor(Color.black);
        int dx=0,dy=0;
        for(int row=0;row<board.length;row++){
            for(int column=0;column<board.length;column++){
                if(board[row][column]==1)
                g.fillRect(dx, dy, 40, 40);     
                
                dx+=40;
            }
            dy+=40;
            dx=0;
        }    
        pman.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      repaint();
    }
}



