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
    private Point pointOfTheBeginnigOfTheSegment;
    
    /**
     * length of the segment
     */
    private int lengthOfTheSegment;
    
    /**
     * angle of the segment
     */
    private int angleOfTheSegment;
    
    /**
     * boolean which will decide if the segment is physical or not
     */
    private boolean physicalOrNot;
    
    /**
     * segment created with four defined parameters : a point, a length, 
     * an angle and a boolean
     * @param pointOfTheBeginnigOfTheSegment beginning of the segment
     * @param lengthOfTheSegment length of the segment
     * @param angleOfTheSegment angle of the segment
     * @param physicalOrNot boolean which will decide if the segment is 
     *        physical or not
     */
    public Segment(Point pointOfTheBeginnigOfTheSegment, int lengthOfTheSegment,
                                int angleOfTheSegment, boolean physicalOrNot)
    {
        this.pointOfTheBeginnigOfTheSegment = pointOfTheBeginnigOfTheSegment;
        this.lengthOfTheSegment = lengthOfTheSegment;
        this.angleOfTheSegment = angleOfTheSegment;
        this.physicalOrNot = physicalOrNot;
    }
}
