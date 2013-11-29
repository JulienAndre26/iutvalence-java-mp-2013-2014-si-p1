package fr.iutvalence.java.mp.RollingBall;

/**
 * Interface which is an abstract player
 * 
 * @author andrejul
 *
 */
public interface Player
{
    /**
     * method to initialize the game
     * 
     * @param segmentWhereTheBallCanBeReleased 
     *                  the segment where the ball can be released to start the play
     * @return Point
     *                  the position of the ball
     */
    public Point initialize(Segment segmentWhereTheBallCanBeReleased);
}
