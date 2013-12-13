package fr.iutvalence.java.mp.RollingBall;


/**
 * graphical display of the game
 *
 * @author andrejul
 *
 */
public class GraphicalDisplay implements Display
{

    @Override
    public void ballCreated()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void bounce()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void flyingBall(MovingBall movingBall)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void gameEnd(double numberOfBounces, String playerName, double scoreOfThePlayer, Window myWindow)
    {
        myWindow.getScoreLabel().setText("Your final score " + playerName + " : " + ((double)((int)(scoreOfThePlayer*500))/500)
                + " and the number of bounces of your ball : " + (int)numberOfBounces);
    }

    /**
     * method which opens a new window
     * @param playerName
     * unused parameter
     */
    @Override
    public Window gameStart(String playerName)
    {
        Window myWindow = new Window();
        return myWindow;
    }

    @Override
    public void mapCreated()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void roundEnd(String playerName, double scoreOfThePlayer, Window myWindow)
    {
        myWindow.getScoreLabel().setText("Your score " + playerName + " : " + ((double)((int)(scoreOfThePlayer*500))/500));
    }

    @Override
    public void roundStart(MovingBall ball, Map map, Window myWindow)
    {
        myWindow.go(ball,map);
    }

    @Override
    public void theBallHits(Segment segmentHit, Vector reactPower, MovingBall ballInMove)
    {
        // TODO Auto-generated method stub

    }

}