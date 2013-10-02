package fr.iutvalence.java.mp.RollingBall;

// TODO (fix) remove unused imports
import java.util.*;
/**
 * 
 * the map is the field where the ball will roll
 * @author andrejul
 *
 */
public class Map
{
    // TODO (fix) rename field (more explicit)
    /**
     * physical pieces of the field
     */
    private Segment seg[];
    
    // TODO (fix) rename field (more explicit)
    /**
     * line where the ball can be released
     */
    private Segment begin;
    
    // TODO (fix) write a "real" comment
    /**
     * field of a play
     * @param seg physical pieces of the field
     * @param begin line where the ball can be released
     */
    public Map(Segment seg[], Segment begin)
    {
        this.seg = seg;
        this.begin = begin;
    }
}
