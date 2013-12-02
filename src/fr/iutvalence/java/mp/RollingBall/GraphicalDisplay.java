package fr.iutvalence.java.mp.RollingBall;

import javax.swing.JFrame;
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

    @Override
    public void gameStart(String playerName)
    {
        JFrame myWindow = new JFrame();
        myWindow.setSize(1024, 728);;
        myWindow.setTitle("Awesome Rolling Ball");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setLocationRelativeTo(null);
        myWindow.setResizable(false);        
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
