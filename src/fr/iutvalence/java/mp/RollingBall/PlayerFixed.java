package fr.iutvalence.java.mp.RollingBall;

/**
 * initialization of the game
 * 
 * @author andrejul
 *
 */
public class Player
{
    // TODO (FIXED) this method should not be static
    /**
     * method to initialize the game
     * 
     * @param segmentWhereTheBallCanBeReleased 
     *                  the segment where the ball can be released to start the play
     * @return MovingBall
     *                  the game initialized
     */
    // TODO (FIXED) this method should only contain code related to the initial
    // action of the player (it should return a position)
    public MovingBall initialize(Segment segmentWhereTheBallCanBeReleased)
    {
        Vector speedOfTheBall = new Vector(0, 0);
        Point centerOfTheBallWanted = segmentWhereTheBallCanBeReleased.getStartingPoint();
        int radiusOfTheBallWanted = 10;

        MovingBall ball = new MovingBall(radiusOfTheBallWanted, centerOfTheBallWanted, speedOfTheBall);

        return ball;
    }
}
