package fr.iutvalence.java.mp.RollingBall;

// TODO (FIXED) add a reference to README.md
/**
 * 
 * see readme.md
 * Means and rules of the game.
 * @author andrejul
 *
 */
public class RollingBall
{
    // TODO (FIXED) rename field (more explicit)
    /**
     * the name of the player
     */
    private String nameOfThePlayer;

    // TODO (FIXED) rename field (more explicit)
    /**
     * the map used by the player
     */
    private Map mapUsedByThePlayer;
    
    // TODO (FIXED) rename field (more explicit)
    /**
     * the ball used by the player
     */
    private Ball ballUsedByThePlayer;
    
    // TODO (FIXED) rename field (more explicit)
    /**
     * the score of the player
     */
    private Score scoreOfThePlayer;
    
    // TODO (FIXED) fix comment. This constructor does not start nothing
    /**
     * rollingball created with three parameters : the name of the player, the
     * map where the player wants to play and the ball the player want to use
     * @param nameOfThePlayerPlaying the name of the player
     * @param mapChoosedByThePlayer the map used by the player
     * @param ballChoosedByThePlayer the ball choose by the player
     */
    public RollingBall(String nameOfThePlayerPlaying, 
                        Map mapChoosedByThePlayer, Ball ballChoosedByThePlayer)
    {
        this.nameOfThePlayer = nameOfThePlayerPlaying;
        this.mapUsedByThePlayer = mapChoosedByThePlayer;
        this.ballUsedByThePlayer = ballChoosedByThePlayer;
    }

    /**
     * set the physical rules of our environment and launch the game
     */
    public void play()
    {
        
    }
    
}
