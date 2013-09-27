package fr.iutvalence.java.mp.RollingBall;

/**
 * 
 * a simple ball which will roll over the map
 * @author andrejul
 *
 */
public class Ball
{
    /**
     * radius of the ball
     */
    private int r;
    
    /**
     * center of the ball
     */
    private Point o;
    
    /**
     * a simple ball
     * @param r radius of the ball
     * @param o center of the ball
     */
    public Ball(int r, Point o)
    {
        this.r = r;
        this.o = o;
    }
}
