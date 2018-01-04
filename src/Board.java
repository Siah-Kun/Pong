import org.w3c.dom.css.Rect;

import javax.security.auth.kerberos.KerberosTicket;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Board extends JPanel implements KeyListener, ActionListener{
    private BufferedImage background;

    //player one information
    private int p1X = 20;
    private int p1Y = 200;
    private Rectangle playerOne;

    //player two information
    private int p2X = 860;
    private int p2Y = 200;
    private Rectangle playerTwo;

    // puck information
    private int PuckX = 440;
    private int PuckY = 265;
    private Ball Puck;

    private Timer timer = new Timer(1000/100,this);


    public Board(){

        // creating each player and puck
        playerOne = new Rectangle(p1X,p1Y);
        playerTwo = new Rectangle(p2X,p2Y);
        Puck = new Ball(PuckX, PuckY);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);

        setOpaque(false);

        // setting background with image
        background = new BufferedImage(900,550, BufferedImage.TYPE_INT_RGB);
        g.drawImage(background,0,0, this);

        // drawing player one
        g.setColor(Color.blue);
        ((Graphics2D) g).fill(playerOne);

        // drawing player two
        g.setColor(Color.red);
        ((Graphics2D) g).fill(playerTwo);

        // drawing puck
        g.setColor(Color.orange);
        ((Graphics2D) g).fill(Puck);

        //drawing middle line
        g.setColor(Color.white);
        g.drawLine(450,0,450,550);

        //drawing mid-line and circle
        g.setColor(Color.white);
        g.drawOval(350, 175, 200,200);

        //Player One Score
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN,20));
        g.drawString(Puck.p1Score(),185,30);

        //Player Two Score
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN,20));
        g.drawString(Puck.p2Score(),675,30);

    }


    public void actionPerformed(ActionEvent event){
        if(event.getSource() == timer){
            Puck.MovePuck(playerOne.getX(),playerOne.getY(), playerTwo.getX(), playerTwo.getY());
            repaint();
        }
    }

    public void keyTyped(KeyEvent event){
        // Move Player One
        if(event.getKeyCode() == KeyEvent.VK_UP){
            playerOne.movePlayerUP();
            repaint();
        }

        else if(event.getKeyCode() == KeyEvent.VK_DOWN){
            playerOne.movePlayerDown();
           // repaint();
        }

        // Move Player Two
        else if(event.getKeyCode() == KeyEvent.VK_0){
            playerTwo.movePlayerUP();
           // repaint();
        }
        else if(event.getKeyCode() == KeyEvent.VK_9){
            playerTwo.movePlayerDown();
           // repaint();
        }
    }
    public void keyPressed(KeyEvent event){
        if(event.getKeyCode() == KeyEvent.VK_UP){
            playerOne.movePlayerUP();
           // repaint();

        }
        else if(event.getKeyCode() == KeyEvent.VK_DOWN){
            playerOne.movePlayerDown();
           // repaint();
        }
        // Move Player Two
        else if(event.getKeyCode() == KeyEvent.VK_0){
            playerTwo.movePlayerUP();
           // repaint();
        }
        else if(event.getKeyCode() == KeyEvent.VK_9){
            playerTwo.movePlayerDown();
            //repaint();
        }

        // Press the Space Bar to Start the timer
        else if(event.getKeyCode() == KeyEvent.VK_SPACE){
            timer.start();
        }
    }
    public void keyReleased(KeyEvent event){}
}
