package fr.iutvalence.java.mp.RollingBall;

/**
 * initialization of the game
 *
 * @author andrejul
 *
 */
public class PlayerFixed implements Player
{
    /**
     * method to initialize the game
     *
     * @param segmentWhereTheBallCanBeReleased
     * the segment where the ball can be released to start the play
     * @return Point
     * the position of the ball
     */
    @Override
    public Point getStartingPoint(Segment segmentWhereTheBallCanBeReleased)
    {
        Point center = segmentWhereTheBallCanBeReleased.getStartingPoint();

        return center;
    }
}
