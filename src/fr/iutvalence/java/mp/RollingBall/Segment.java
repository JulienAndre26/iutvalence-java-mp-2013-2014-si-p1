package fr.iutvalence.java.mp.RollingBall;

/**
 * 
 * piece of the physical field
 * @author andrejul
 *
 */
public class Segment
{
    /**
     * beginning of the segment
     */
    private Point p;
    
    /**
     * length of the segment
     */
    private int l;
    
    /**
     * angle of the segment
     */
    private int a;
    
    /**
     * boolean which will decide if the segment is physical or not
     */
    private boolean f;
    
    /**
     * a simple segment
     * @param p beginning of the segment
     * @param l length of the segment
     * @param a angle of the segment
     * @param f boolean which will decide if the segment is physical or not
     */
    public Segment(Point p, int l, int a, boolean f)
    {
        this.p = p;
        this.l = l;
        this.a = a;
        this.f = f;
    }
}
