import java.awt.geom.Rectangle2D;

public class Rectangle extends Rectangle2D.Double{
    private boolean isMovingUp, isMovingDown;

    public Rectangle(double x, double y){
        this.x = x;
        this.y = y;

        width = 10;
        height = 50;

    }

    public void movePlayerUP(){
        y-=3;
    }

    public void movePlayerDown(){
        y+=3;
    }

    public void setMovingDown(boolean movingDown) {
        isMovingDown = movingDown;
    }

    public boolean isMovingDown() {
        return isMovingDown;
    }

    public void setMovingUp(boolean movingUp) {
        isMovingUp = movingUp;
    }

    public boolean isMovingUp() {
        return isMovingUp;
    }

    @Override
    public double getY() {return super.getY();}
    public double getX(){return super.getX();}
}

