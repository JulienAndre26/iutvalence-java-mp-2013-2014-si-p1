package fr.iutvalence.java.mp.RollingBall;


/**
 * a segment is a piece of the game's field.
 * 
 * @author andrejul
 * 
 */
public class Segment
{
    /**
     * bounce factor of the segment
     */
    public final static double BOUNCE_FACTOR = 1.29;
    
    /**
     * starting point
     */
    private Point startingPoint;

    /**
     * length of the segment
     */
    private Point endingPoint;

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
     * method to get the component point which characterizes the reacting power
     * @param movingBall
     *            the ball which hits the segment
     * @return Point
     *            the component point of the reacting power
     */
    public Vector getReactionPower(MovingBall movingBall)
    {
        double length = movingBall.getSpeedVector().getLength();

        if ( this.endingPoint.getY() == this.startingPoint.getY() )
        {
            if ( this.endingPoint.getX() > this.startingPoint.getX() )
            {
                return new Vector( 0, length * BOUNCE_FACTOR );
            }
            else if ( this.endingPoint.getX() < this.startingPoint.getX() )
            {
                return new Vector( 0, -length * BOUNCE_FACTOR );
            }
        }

        if ( this.endingPoint.getX() == this.startingPoint.getX() )
        {
            if ( this.endingPoint.getY() > this.startingPoint.getY() )
            {
                return new Vector( -length * BOUNCE_FACTOR, 0 );
            }
            else if ( this.endingPoint.getY() < this.startingPoint.getY() )
            {
                return new Vector( length * BOUNCE_FACTOR, 0 );
            }
        }

        double beta = Math.atan( ( this.endingPoint.getY() - this.startingPoint.getY() ) / ( this.endingPoint.getX() - this.startingPoint.getX() ) ) + Math.PI/2;

        double x = length * BOUNCE_FACTOR * Math.cos(beta);
        double y = length * BOUNCE_FACTOR * Math.sin(beta);

        return new Vector( x, y );
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
        
        double r = currentBall.getRadius();
        double cxBall = currentBall.getCenter().getX();
        double cyBall = currentBall.getCenter().getY();

        double axSegment = this.startingPoint.getX();
        double aySegment = this.startingPoint.getY();

        double bxSegment = this.endingPoint.getX();
        double bySegment = this.endingPoint.getY();

        double a = (bxSegment - axSegment) * (bxSegment - axSegment) + (bySegment - aySegment) * (bySegment - aySegment);
        double b = 2 * ((bxSegment - axSegment) * (axSegment - cxBall) + (bySegment - aySegment) * (aySegment - cyBall));
        double c = axSegment * axSegment + aySegment * aySegment + cxBall * cxBall + cyBall * cyBall - 2 * (axSegment * cxBall + aySegment * cyBall) - r * r;

        if (b * b - 4 * a * c < 0)
        {
            isIntersect = false;
        }
        else
        {
            double d = ( ( (cxBall - axSegment) * (bxSegment - axSegment) + (cyBall - aySegment) * (bySegment - aySegment) ) / 
                    ( (bxSegment - axSegment) * (bxSegment - axSegment) + (bySegment - aySegment) * (bySegment - aySegment) ) );
            if (d >= 0 && d <= 1)
            {
                isIntersect = true;
            }
            else
            {
                isIntersect = false;
            }
        }
        return isIntersect;
    }

    /**
     * Returns an ASCII representation of the segment as [ starting point of the segment, ending point of the segment ]
     * @return String
     *              the ASCII representation of the segment
     */
    public String toString()
    {
        return "S[ " + this.startingPoint + ", " + this.endingPoint + " ]";
    }
}
