import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class PongGame extends JFrame {
    private Board board;

    public PongGame(){
        super("Pong");
        //create and add board
        board = new Board();
        add(board);

        // Create JFrame
        getContentPane();
        setSize(600,400);
        setResizable(false);
        setVisible(true);

    }

    // MAIN
    public static void main(String args[]){
        PongGame P = new PongGame();
        P.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}
