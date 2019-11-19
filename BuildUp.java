package pacman;
import java.awt.Color;
import java.awt.Graphics;


public class BuildUp {
    
    private int x,y,direction,animation;

    public BuildUp(int x, int y, int direction, int animation) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.animation = animation;
    }
    
    public void draw(Graphics g){
        
        g.setColor(Color.red);
        if(animation == 360){
            animation = 300;
        }else {    
            animation=360;
        }  
       
        if(direction==300 && y<550){
             y+=5;
             System.out.println(y);
        }
        else if(direction==120 && y>30){
            y-=5;
        }
        else if(direction==30 && x<550){
            x+=5;
        }
        else if(direction==210 && x>10){
            x-=5;
        }
        g.fillArc(x, y, 40, 40, direction,animation );
         
    }
    
    public void changeDirection(int newDirection){
        direction=newDirection;
    }
}
