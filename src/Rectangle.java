import java.awt.geom.Rectangle2D;

public class Rectangle extends Rectangle2D.Double{

    public Rectangle(double x, double y){
        this.x = x;
        this.y = y;

        width = 20;
        height = 100;

    }

    public void movePlayerUP(){
        y-=6;
    }

    public void movePlayerDown(){
        y+=6;
    }

    @Override
    public double getY() {return super.getY();}
    public double getX(){return super.getX();}
}

