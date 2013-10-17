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
    private int radius;
    
    /**
     * center of the ball
     */
    private Point middlePoint;
    
    /**
     * ball created with two defined parameters : a radius and a center
     * @param radiusOfTheBallWanted radius of the ball
     * @param centerOfTheBallWanted center of the ball
     */
    public Ball(int radiusOfTheBallWanted, Point centerOfTheBallWanted)
    {
        this.radius = radiusOfTheBallWanted;
        this.middlePoint = centerOfTheBallWanted;
    }
}
