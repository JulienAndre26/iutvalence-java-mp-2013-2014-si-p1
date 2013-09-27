package fr.iutvalence.java.mp.RollingBall;

import java.util.*;
/**
 * 
 * the map is the field where the ball will roll
 * @author andrejul
 *
 */
public class Map
{
    /**
     * physical pieces of the field
     */
    private Segment seg[];
    
    /**
     * line where the ball can be released
     */
    private Segment begin;
    
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
