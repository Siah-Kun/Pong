import java.awt.geom.Ellipse2D;


public class Ball extends Ellipse2D.Double{
    //Ball movement variables
    boolean movementX = true;
    boolean movementY = true;

    // Player one info
    private int p1Number = 0;
    private String p1Score = "0";

    // Player two info
    private int p2Number = 0;
    private String p2Score = "0";

    // Constructor
    public Ball(double x, double y){
        this.x = x;
        this.y = y;

        height = 20;
        width = 20;

    }

    //function created to move the puck based on the position of the Puck, and the Players
    public void MovePuck(double PlayerX, double PlayerY, double PlayerTwoX, double PlayerTwoY) {
        // automatically move the X values
        if (movementX) {
            x+=5;
            if (x >= 580) {
                movementX = false;
            }
        } else {
            x-=5;
            if (x <= 0) {
                movementX = true;
            }
        }

        // automatically move the Y values
        if (movementY) {
            y+=2;
            if (y >= 380) {
                movementY = false;
            }
        } else {
            y-=2;
            if (y <= 0) {
                movementY = true;
            }
        }

        // Make Puck Bounce Off Player One
        if(x == PlayerX + 10 && y <= PlayerY + 50 && y >= PlayerY){
            movementX = true;
        }

        // Make Puck Bounce off Player Two
        if(x == PlayerTwoX - 10 && y <= PlayerTwoY + 50 && y >= PlayerTwoY){
            movementX = false;
        }

    }

    // function created to keep track of Player One's Score
    public String p1Score(){
        if(x == 580){
            p1Number++;
        }
        p1Score = String.valueOf(p1Number);
        return p1Score;
    }

    // function created to keep track of Player Two's Score
    public String p2Score(){
        if (x == 0) {
            p2Number++;
        }
        p2Score = String.valueOf(p2Number);
        return p2Score;
    }

}
