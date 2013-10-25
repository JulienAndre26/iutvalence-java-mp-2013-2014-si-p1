package fr.iutvalence.java.mp.RollingBall;

import java.math.*;

/**
 * piece of the physical field the notion of "physical" : if the segment is
 * physical (true), the ball will not go through the segment, otherwise it will
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


    /**
     * segment created with four defined parameters : a point, a length, an
     * angle and a boolean
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
        int a;
        int b;
        int c;
        int r;
        int x1Ball;
        int y1Ball;

        int x2Segment;
        int y2Segment;

        int x3Segment;
        int y3Segment;

        r = currentBall.getRadius();
        x1Ball = currentBall.getMiddlePoint().getX();
        y1Ball = currentBall.getMiddlePoint().getY();

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

    // TODO (FIXED) consider overriding toString to return an ASCII representation of the segment
    // it can rely on the toString method overridden in Point

    /**
     * method to get the parameters of the Segment to String
     * 
     * @return String
     *              parameters of the Segment
     */
    public String toString()
    {
        return "[" + this.startingPoint + "," + this.endingPoint + "]";
    }
}
