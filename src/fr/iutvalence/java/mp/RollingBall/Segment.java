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
     */
    public Segment(Point beginningOfTheSegment, Point endingOfTheSegment)
    {
        this.startingPoint = beginningOfTheSegment;
        this.endingPoint = endingOfTheSegment;
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
     * method to get the component point which characterize the reacting power
     * 
     * @return Point
     *            the middle Point
     */
    public Point getReactionPower(MovingBall movingBall)
    {
        double lenghOfTheSegment;

        double xa;
        double ya;

        double xb;
        double yb;        

        xa = this.startingPoint.getX();
        ya = this.startingPoint.getY();

        xb = this.endingPoint.getX();
        yb = this.endingPoint.getY();

        lenghOfTheSegment = Math.sqrt((xb-xa)*(xb-xa)+(yb-ya)*(yb-ya));
        // Finir la fonction
        return new Point( ( this.startingPoint.getX() + this.endingPoint.getX() ) / 2, 
                ( this.startingPoint.getY() + this.endingPoint.getY() ) / 2);
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
