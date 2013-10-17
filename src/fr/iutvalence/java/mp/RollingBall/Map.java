package fr.iutvalence.java.mp.RollingBall;


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
    private Segment[] segmentsOfTheField;
    
    /**
     * line where the ball can be released
     */
    private Segment segmentWhereTheBallCanBeReleased;
    
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
