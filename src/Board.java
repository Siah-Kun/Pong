import org.w3c.dom.css.Rect;

import javax.security.auth.kerberos.KerberosTicket;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Board extends JPanel {
    private BufferedImage background;

    //player one information
    private int p1X = 20;
    private int p1Y = 150;
    private Rectangle playerOne;

    //player two information
    private int p2X = 550;
    private int p2Y = 150;
    private Rectangle playerTwo;

    // puck information
    private int PuckX = 290;
    private int PuckY = 190;
    private Ball Puck;

    public Board() {

        // creating each player and puck
        playerOne = new Rectangle(p1X, p1Y);
        playerTwo = new Rectangle(p2X, p2Y);
        Puck = new Ball(PuckX, PuckY);
        setDoubleBuffered(true);

        addKeyBinding(this, KeyEvent.VK_UP,   "moveUpPressed",  false, (evt) -> {
            playerOne.setMovingUp(true);
        });

        addKeyBinding(this, KeyEvent.VK_UP,  "moveUpReleased", true, (evt) -> {
            playerOne.setMovingUp(false);
        });

        addKeyBinding(this, KeyEvent.VK_DOWN,   "moveDownPressed",  false, (evt) -> {
            playerOne.setMovingDown(true);
        });

        addKeyBinding(this, KeyEvent.VK_DOWN,  "moveDownReleased", true, (evt) -> {
            playerOne.setMovingDown(false);
        });

        addKeyBinding(this, KeyEvent.VK_W,  " moveP2UpPressed",  false, (evt) -> {
            playerTwo.setMovingUp(true);
        });

        addKeyBinding(this, KeyEvent.VK_W,  " moveP2UpReleased", true, (evt) -> {
            playerTwo.setMovingUp(false);
        });
        addKeyBinding(this, KeyEvent.VK_S,  " moveP2DownPressed",  false, (evt) -> {
            playerTwo.setMovingDown(true);
        });

        addKeyBinding(this, KeyEvent.VK_S,  " moveP2DownReleased", true, (evt) -> {
            playerTwo.setMovingDown(false);
        });

        // Timer to represent frames per second and constantly check the status of each button pressed
        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Move puck
                Puck.MovePuck(playerOne.getX(), playerOne.getY(), playerTwo.getX(), playerTwo.getY());
                repaint();
                //Only move if the player is pressing each button
                //Player One Moving UP
                if(playerOne.isMovingUp()){
                    playerOne.movePlayerUP();
                }

                //Player One Moving Down
                if(playerOne.isMovingDown()){
                    playerOne.movePlayerDown();
                }

                //Player Two Moving Up
                if(playerTwo.isMovingUp()){
                    playerTwo.movePlayerUP();
                }

                //Player Two Moving Down
                if(playerTwo.isMovingDown()){
                    playerTwo.movePlayerDown();
                }
            }
        });

        //Start Timer
        timer.start();
    }

    // Created a function that represents adding keybinding. Easier than re-writing a function each time
    public void addKeyBinding(JComponent comp, int keyCode, String id, boolean movement, ActionListener ActionListener){
            InputMap im = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap ap = comp.getActionMap();

            im.put(KeyStroke.getKeyStroke(keyCode, 0 ,  movement), id);

            ap.put(id, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ActionListener.actionPerformed(e);
                    repaint();
                }
            });
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);

        setOpaque(false);

        // setting background with image
        background = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
        g.drawImage(background, 0, 0, this);

        // drawing player one
        g.setColor(Color.blue);
        ((Graphics2D) g).fill(playerOne);

        // drawing player two
        g.setColor(Color.red);
        ((Graphics2D) g).fill(playerTwo);

        // drawing puck
        g.setColor(Color.orange);
        ((Graphics2D) g).fill(Puck);

        //Player One Score
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString(Puck.p1Score(), 100, 30);

        //Player Two Score
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString(Puck.p2Score(), 450, 30);

        g.dispose();

    }
}


