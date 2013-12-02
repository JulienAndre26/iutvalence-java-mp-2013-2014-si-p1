package fr.iutvalence.java.mp.RollingBall;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * graphical display of the game 
 * 
 * @author andrejul
 *
 */
public class GraphicalDisplay implements Display
{


    public void mapCreated()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void ballCreated()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void flyingBall(MovingBall movingBall)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void theBallHits(Segment segmentHit, Vector reactPower, MovingBall ballInMove)
    {
        // TODO Auto-generated method stub

    }

    /**
     * method which opens a new window
     * @param playerName 
     *                  unused parameter
     */
    public void gameStart(String playerName)
    {
        JFrame myWindow = new JFrame();
        myWindow.setSize(1024, 728);
        myWindow.setTitle("Awesome Rolling Ball");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setLocationRelativeTo(null);
        myWindow.setResizable(false); 

        myWindow.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JPanel myFirstPanel = new JPanel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        myWindow.getContentPane().add(myFirstPanel, c);

        JLabel myFirstLabel = new JLabel("56454");
        myFirstPanel.add(myFirstLabel, BorderLayout.CENTER);
       
        JLabel mySecondLabel = new JLabel("AZDAZDAZD");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        myWindow.getContentPane().add(mySecondLabel, c);
        
        myWindow.setVisible(true);
    }

    @Override
    public void roundStart(Map map)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void roundEnd(String playerName, double scoreOfThePlayer)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void gameEnd(double numberOfBounces, String playerName, double scoreOfThePlayer)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void bounce()
    {
        // TODO Auto-generated method stub

    }

}
