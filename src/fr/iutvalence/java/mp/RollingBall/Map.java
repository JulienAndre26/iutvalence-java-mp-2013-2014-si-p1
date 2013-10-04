package fr.iutvalence.java.mp.RollingBall;

// TODO (FIXED) remove unused imports

/**
 * 
 * the map is the field where the ball will roll
 * @author andrejul
 *
 */
public class Map
{
    // TODO (FIXED) rename field (more explicit)
    /**
     * physical pieces of the field
     */
    private Segment segmentsOfTheField[];
    
    // TODO (FIXED) rename field (more explicit)
    /**
     * line where the ball can be released
     */
    private Segment segmentWhereTheBallCanBeReleased;
    
    // TODO (FIXED) write a "real" comment
    /**
     * map created with two defined parameters : a set of segments
     * and a segment where the ball can be released
     * @param segmentsOfTheField physical pieces of the field
     * @param segmentWhereTheBallCanBeReleased line where the ball can be
     *        released
     */
    public Map(Segment segmentsOfTheField[], 
                                Segment segmentWhereTheBallCanBeReleased)
    {
        this.segmentsOfTheField = segmentsOfTheField;
        this.segmentWhereTheBallCanBeReleased = 
                                        segmentWhereTheBallCanBeReleased;
    }
}
