package fr.iutvalence.java.mp.RollingBall;

/**
 * 
 * Means and rules of the game.
 * @author andrejul
 *
 */
public class RollingBall
{
    /**
     * the name of the player
     */
    private String a;
    
    /**
     * the map
     */
    private Map m;
    
    /**
     * the ball
     */
    private Ball b;
    
    /**
     * the score
     */
    private Score s;
    
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
