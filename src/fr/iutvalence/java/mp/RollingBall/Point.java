package fr.iutvalence.java.mp.RollingBall;

/**
 * two integers which define the point.
 *
 * @author andrejul
 */
// TODO (FIXED) maybe it should be better to consider coordinates as doubles
public class Point
{

    /** abscissa of the point. */
    private final double x;

    /** ordered of the point. */
    private final double y;

    /**
     * point created with two defined integers.
     *
     * @param x abscissa of the point
     * @param y ordered of the point
     */
    public Point(double x, double y)
    {
        this.x = (double)((int)(x*500))/500;
        this.y = (double)((int)(y*500))/500;
    }

    /**
     * method equals for the point class.
     * this method returns true if points are equals, otherwise it returns false.
     * @param o an object
     * @return boolean
     */
    @Override
    public boolean equals(Object o)
    {
        if ( o == this )
        {
            return true;
        }

        if ( o == null )
        {
            return false;
        }

        if ( !( o instanceof Point ) )
        {
            return false;
        }

        Point temp = (Point) o;
        return (temp.getX() == this.x) && (temp.getY() == this.y);

    }
    // TODO (FIXED) finish writing comment

    /**
     * method to get the abscissa of the point.
     *
     * @return integer the abscissa of the point
     */
    public double getX()
    {
        return this.x;
    }

    /**
     * method to get the ordered of the point.
     *
     * @return integer the ordered of the point
     */
    public double getY()
    {
        return this.y;
    }

    /**
     * Returns an ASCII representation of the point as ( the abscissa of the point, the ordered of the point ).
     *
     * @return String
     * the ASCII representation of the vector
     */
    @Override
    public String toString()
    {
        return "( " + this.x + ", " + this.y + " )";
    }

}