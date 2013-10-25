package fr.iutvalence.java.mp.RollingBall;

/**
 * 
 * two integers which define the point
 * 
 * @author andrejul
 * 
 */
public class Point
{

    /**
     * abscissa of the point
     */
    private int x;

    /**
     * ordered of the point
     */
    private int y;

    /**
     * point created with two defined integers
     * 
     * @param x
     *            abscissa of the point
     * @param y
     *            ordered of the point
     */
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * method to get the abscissa of the point
     * 
     * @return integer the abscissa of the point
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * method to get the ordered of the point
     * 
     * @return integer the ordered of the point
     */
    public int getY()
    {
        return this.y;
    }    

    /**
     * method to add two points
     * 
     * @param point
     *              the Point we want to add to the current Point
     * @return Point
     *              the resulting Point
     */
    public Point addPoint(Point point)
    {
        return new Point(this.x+point.x,this.y+point.y);
    }
    
    // TODO (FIXED) consider overriding toString to return an ASCII representation of the point
    // e.g. (x,y)
    /**
     * method to get the parameters of the Point to String
     * 
     * @return String
     *              parameters of the Point
     */
    public String toString()
    {
        return "(" + this.x + "," + this.y + ")";
    }

}
