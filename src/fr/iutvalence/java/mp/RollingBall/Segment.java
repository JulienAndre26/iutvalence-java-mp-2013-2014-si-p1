package fr.iutvalence.java.mp.RollingBall;


// TODO (FIXED) rewrite comment (not really understandable)
/**
 * a segment is a piece of the game's field.
 * 
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
    private Point endingPoint;

    // TODO (FIXED) fix comment (obsolete)

    /**
     * a segment is created with two Points
     * 
     * @param beginningOfTheSegment
     *            beginning of the segment
     * @param endingOfTheSegment
     *            length of the segment
     * @throws SamePointException
     *            if beginningOfTheSegment and endingOfTheSegment are equals
     */
    public Segment(Point beginningOfTheSegment, Point endingOfTheSegment) throws SamePointException
    {
        if ( beginningOfTheSegment.equals(endingOfTheSegment) )
        {
            throw new SamePointException();
        }
        else
        {
            this.startingPoint = beginningOfTheSegment;
            this.endingPoint = endingOfTheSegment;
        }
    }

    /**
     * method to get the ending point of the segment
     * 
     * @return Point the ending point of the segment
     */
    public Point getStartingPoint()
    {
        return this.startingPoint;
    }

    /**
     * method to get the ending point of the segment
     * 
     * @return Point the ending point of the segment
     */
    public Point getEndingPoint()
    {
        return this.endingPoint;
    }

    /**
     * method to set up the ending point of the segment
     * 
     * @param endingPoint
     *            the new ending point wanted
     */
    public void setEndingPoint(Point endingPoint)
    {
        this.endingPoint = endingPoint;
    }

    /**
     * method to get the middle point of a segment
     * 
     * @return Point
     *            the middle Point
     */
    public Point getMiddlePoint()
    {
        return new Point( ( this.startingPoint.getX() + this.endingPoint.getX() ) / 2, 
                ( this.startingPoint.getY() + this.endingPoint.getY() ) / 2);
    }

    /**
     * method to get the length of a segment
     * @return Double
     *              the length of a segment
     */
    public Double getLength()
    {
        double l;
        l = Math.sqrt( ( this.endingPoint.getX() - this.startingPoint.getX() ) * ( this.endingPoint.getX() - this.startingPoint.getX() )
                + ( this.endingPoint.getY() - this.startingPoint.getY() ) * ( this.endingPoint.getY() - this.startingPoint.getY() ) );
        return l;
    }

    /**
     * method to get the component point which characterize the reacting power
     * 
     * @return Point
     *            the component point of the reacting power
     */
    public Point getReactionPower(MovingBall movingBall)
    {
        Point middlePoint = this.getMiddlePoint();
        double l = this.getLength();
        double x;
        double y;
        double B;

        if ( this.endingPoint.getY() == this.startingPoint.getY() )
        {
            if ( this.endingPoint.getX() > this.startingPoint.getX() )
            {
                return new Point( middlePoint.getX()-l, middlePoint.getY() );
            }
            else if ( this.endingPoint.getX() < this.startingPoint.getX() )
            {
                return new Point( middlePoint.getX()+l, middlePoint.getY() );
            }
        }

        if ( this.endingPoint.getX() == this.startingPoint.getX() )
        {
            if ( this.endingPoint.getY() > this.startingPoint.getY() )
            {
                return new Point( middlePoint.getX(), middlePoint.getY()+l );
            }
            else if ( this.endingPoint.getY() < this.startingPoint.getY() )
            {
                return new Point( middlePoint.getX(), middlePoint.getY()-l );
            }
        }

        B = Math.atan( ( this.endingPoint.getY() - this.startingPoint.getY() ) / ( this.endingPoint.getX() - this.startingPoint.getX() ) ) + Math.PI/2;

        x = l * Math.cos(B) + middlePoint.getX();
        y = l * Math.sin(B) + middlePoint.getY();

        return new Point ( x, y );
    }


    /**
     * method which tests if a ball is on(/in) a segment
     * 
     * @param currentBall
     *            the ball we test
     * @return return a boolean, if yes : the ball is on a segment, otherwise
     *         it's out of a segment of the map
     */
    public boolean intersect(Ball currentBall)
    {
        boolean isIntersect;
        double a;
        double b;
        double c;
        double r;
        double x1Ball;
        double y1Ball;

        double x2Segment;
        double y2Segment;

        double x3Segment;
        double y3Segment;

        r = currentBall.getRadius();
        x1Ball = currentBall.getCenter().getX();
        y1Ball = currentBall.getCenter().getY();

        x2Segment = this.startingPoint.getX();
        y2Segment = this.startingPoint.getY();

        x3Segment = this.endingPoint.getX();
        y3Segment = this.endingPoint.getY();

        a = (x3Segment - x2Segment) * (x3Segment - x2Segment) + (y3Segment) * (y2Segment);
        b = 2 * ((x3Segment - x2Segment) * (x2Segment - x1Ball) + (y3Segment - y2Segment) * (y2Segment - y1Ball));
        c = x2Segment * x2Segment + y2Segment * y2Segment + x1Ball * x1Ball + y1Ball * y1Ball - 2
                * (x2Segment * x1Ball + y2Segment * y1Ball) - r * r;

        if (b * b - 4 * a * c < 0)
        {
            isIntersect = false;
        }
        else
        {
            isIntersect = true;
        }
        return isIntersect;
    }

    // TODO (FIXED) finish writing comment
    /**
     * Returns an ASCII representation of the segment as [ starting point of the segment, ending point of the segment ]
     * @return String
     *              the ASCII representation of the segment
     */
    public String toString()
    {
        return "[ " + this.startingPoint + ", " + this.endingPoint + " ]";
    }
}
