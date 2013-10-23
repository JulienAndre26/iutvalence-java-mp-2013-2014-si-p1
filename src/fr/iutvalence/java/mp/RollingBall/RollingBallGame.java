package fr.iutvalence.java.mp.RollingBall;

/**
 * 
 * see readme.md Means and rules of the game.
 * 
 * @author andrejul
 * 
 */
public class RollingBallGame
{
    /**
     * the name of the player
     */
    private String nameOfThePlayer;

    /**
     * the map used by the player
     */
    private Map mapUsedByThePlayer;

    /**
     * the ball used by the player
     */
    private MovingBall ballUsedByThePlayer;

    /**
     * the score of the player
     */
    private Score scoreOfThePlayer;


    /**
     * rollingball game created with three parameters : the name of the player, the
     * map where the player wants to play and the ball the player want to use
     * 
     * @param nameOfThePlayerPlaying
     *            the name of the player
     * @param mapChoosedByThePlayer
     *            the map used by the player
     * @param ballChoosedByThePlayer
     *            the ball choose by the player
     */
    public RollingBallGame(String nameOfThePlayerPlaying, Map mapChoosedByThePlayer, MovingBall ballChoosedByThePlayer)
    {
        this.nameOfThePlayer = nameOfThePlayerPlaying;
        this.mapUsedByThePlayer = mapChoosedByThePlayer;
        this.ballUsedByThePlayer = ballChoosedByThePlayer;
    }

    /**
     * play the game
     */
    public void play()
    {
        boolean youCanPlay = true;
        Point gravityPower = new Point(0, -10);
        int t;
        
        // TODO (fix) rename local variable (more explicit)
        int i;

        t = 0;
        while (youCanPlay)
        {
            i = 0;
            while (!(this.mapUsedByThePlayer.getSegmentsOfTheField()[i].intersect(this.ballUsedByThePlayer))
                    && i < this.mapUsedByThePlayer.getSegmentsOfTheField().length)
            {
                i++;
            }
            if (i == this.mapUsedByThePlayer.getSegmentsOfTheField().length)
            {
                this.ballUsedByThePlayer.setSpeed(gravityPower);
            }
            else
            {

            }
        }
    }

}
