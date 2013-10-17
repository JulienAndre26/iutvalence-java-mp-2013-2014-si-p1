package fr.iutvalence.java.mp.RollingBall;

// TODO (think bout it) it seems easier to consider a segment as defined by 2 points
/**
 * 
 * piece of the physical field
 * @author andrejul
 *
 */
public class Segment
{
    /**
     * starting point
     */
    private Point startingPoint;
    
    /**
     * length of the segment
     */
    private int length;
    
    /**
     * angle of the segment
     */
    private int angle;
    
    // TODO (fix) detail the notion of "physical" (maybe in class comment)
    /**
     * boolean which will decide if the segment is physical or not
     */
    private boolean isPhysical;
    
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
        this.startingPoint = pointOfTheBeginnigOfTheSegment;
        this.length = lengthOfTheSegment;
        this.angle = angleOfTheSegment;
        this.isPhysical = physicalOrNot;
    }
}
