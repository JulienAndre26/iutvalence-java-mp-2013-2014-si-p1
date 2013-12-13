package fr.iutvalence.java.mp.RollingBall;

/**
 *
 * the map is the field where the ball will roll
 *
 * @author andrejul
 *
 */
public class Map
{
    /**
     * physical segments of the field, where the ball an roll
     */
    private Segment[] segmentsOfTheField;

    /**
     * segment from where the ball can be released
     */
    private Segment segmentWhereTheBallCanBeReleased;

    public Map()
    {
        Point point = new Point(-10,-10);
        Point point1 = new Point(-11,-11);
        Segment segment1;
        try
        {
            segment1 = new Segment(point,point1);
            Segment[] segmentsOfTheField = null;
            segmentsOfTheField = new Segment[1];
            segmentsOfTheField[0] = segment1;
            this.segmentsOfTheField = segmentsOfTheField;
            this.segmentWhereTheBallCanBeReleased = segment1;
        }
        catch (SamePointException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * map created with two defined parameters : a set of segments and a segment
     * where the ball can be released
     *
     * @param segmentsOfTheField
     * physical pieces of the field
     * @param segmentWhereTheBallCanBeReleased
     * line where the ball can be released
     */
    public Map(Segment[] segmentsOfTheField, Segment segmentWhereTheBallCanBeReleased)
    {
        this.segmentsOfTheField = segmentsOfTheField;
        this.segmentWhereTheBallCanBeReleased = segmentWhereTheBallCanBeReleased;
    }

    /**
     * get the segments of the field
     *
     * @return Segments[] segments of the field
     */
    public Segment[] getSegmentsOfTheField()
    {
        return this.segmentsOfTheField;
    }

    /**
     * get the segment where the ball can be released
     *
     * @return Segment segment where the ball can be released
     */
    public Segment getSegmentWhereTheBallCanBeReleased()
    {
        return this.segmentWhereTheBallCanBeReleased;
    }
}