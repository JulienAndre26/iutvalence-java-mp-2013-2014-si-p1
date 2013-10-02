package fr.iutvalence.java.mp.RollingBall;

// TODO (fix) add a reference to README.md
/**
 * 
 * Means and rules of the game.
 * @author andrejul
 *
 */
public class RollingBall
{
    // TODO (fix) rename field (more explicit)
    /**
     * the name of the player
     */
    private String a;

    // TODO (fix) rename field (more explicit)
    /**
     * the map
     */
    private Map m;
    
    // TODO (fix) rename field (more explicit)
    /**
     * the ball
     */
    private Ball b;
    
    // TODO (fix) rename field (more explicit)
    /**
     * the score
     */
    private Score s;
    
    // TODO (fix) fix comment. This constructor does not start nothing
    /**
     * Start a game
     * @param a the name of the player
     * @param m the map used by the player
     * @param b the ball choose by the player
     */
    public RollingBall(String a, Map m, Ball b)
    {
        this.a = a;
        this.m = m;
        this.b = b;
    }
    
}
