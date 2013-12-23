package fr.iutvalence.java.mp.RollingBall;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * The Class MainJPanel which contains the map and the ball of the game.
 */
public class MainJPanel extends JPanel
{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3051649865637553151L;

    /** The ball. */
    private Ball ball;

    /** The game starts. */
    private Boolean gameStarts;

    /** The map. */
    private Map map;

    /**
     * Instantiates a new main j panel.
     *
     * @param ball the ball
     * @param map the map
     */
    public MainJPanel(final Ball ball, final Map map)
    {
        this.gameStarts = false;
        this.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e){}

            @Override
            public void mouseEntered(MouseEvent e){}

            @Override
            public void mouseExited(MouseEvent e){}

            @Override
            public void mousePressed(MouseEvent e){}

            @Override
            public void mouseReleased(MouseEvent e)
            {
                System.out.println("t'as clické");
                MainJPanel.this.gameStarts = true;
                //    this.notify();
            }
        });

        this.addMouseMotionListener(new MouseMotionListener()
        {

            @Override
            public void mouseDragged(MouseEvent e){}

            @Override
            public void mouseMoved(MouseEvent e)
            {
                System.out.println("t'as bougé");
                int x = e.getX();
                int y = e.getY();

                ball.setCenter(new Point(x,y));

                int xa = (int) map.getSegmentWhereTheBallCanBeReleased().getStartingPoint().getX();
                int ya = (int) map.getSegmentWhereTheBallCanBeReleased().getStartingPoint().getY();

                int xb = (int) map.getSegmentWhereTheBallCanBeReleased().getEndingPoint().getX();
                int yb = (int) map.getSegmentWhereTheBallCanBeReleased().getEndingPoint().getY();

                if (MainJPanel.this.gameStarts == false)
                {
                    // en partant du principe que A est le point le plus en bas à droite et B le point le plus en haut à gauche
                    if (x < xa)
                    {
                        if (y < ya){ball.setCenter(new Point(xa,ya));}
                        if (y > yb){ball.setCenter(new Point(xa,yb));}
                        if ((y >= ya) && (y <= yb)){ball.setCenter(new Point(xa,y));}
                    }

                    if (x > xb)
                    {
                        if (y < ya){ball.setCenter(new Point(xb,ya));}
                        if (y > yb){ball.setCenter(new Point(xb,yb));}
                        if ((y >= ya) && (y <= yb)){ball.setCenter(new Point(xb,y));}
                    }

                    if ( (x >= xa) && (x <= xb) )
                    {
                        if (y < ya){ball.setCenter(new Point(x,ya));}
                        if (y > yb){ball.setCenter(new Point(x,yb));}
                        if ((y >= ya) && (y <= yb)){ball.setCenter(new Point(x,y));}
                    }
                    MainJPanel.this.repaint();
                }
            }
        });
        this.ball = ball;
        this.map = map;
    }

    /**
     * Draw a line with only 2 parameters.
     *
     * @param g the graphical object
     * @param segment the segment
     */
    private void drawLine(Graphics g, Segment segment)
    {
        g.setColor(Color.RED);
        int xa = (int)segment.getStartingPoint().getX();
        int ya = (int)(GraphicalDisplay.DIMENSION.getHeight()-segment.getStartingPoint().getY()-300);
        int xb = (int)segment.getEndingPoint().getX();
        int yb = (int)(GraphicalDisplay.DIMENSION.getHeight()-segment.getEndingPoint().getY()-300);
        g.drawLine(xa, ya, xb, yb);
        g.drawLine(xa, ya-1, xb, yb-1);
    }

    /**
     * Display a fill oval with only 2 parameters.
     *
     * @param g the graphical object
     * @param ball the ball
     */
    private void fillOval(Graphics g, Ball ball)
    {
        g.setColor(Color.CYAN);
        int xa =(int)ball.getCenter().getX();
        int ya =(int)(GraphicalDisplay.DIMENSION.getHeight()-this.ball.getCenter().getY()-300);
        int r = (int)this.ball.getRadius();
        g.fillOval(xa, ya, r, r);
    }

    /**
     * Gets the ball.
     *
     * @param ball the ball
     * @return the ball
     */
    public Ball getBall()
    {
        return this.ball;
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        for (int i = 0;i<this.map.getSegmentsOfTheField().length;i++)
        {
            this.drawLine(g, this.map.getSegmentsOfTheField()[i]);
        }

        if (this.ball.getRadius() == 15)
        {
            try
            {
                Image img = ImageIO.read(new File("G:/Workspace/iutvalence-java-mp-2013-2014-si-p1/pictures/ball.jpg"));
                g.drawImage(img, (int)this.ball.getCenter().getX(), (int)(GraphicalDisplay.DIMENSION.getHeight()-this.ball.getCenter().getY()-300), null);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            this.fillOval(g, this.ball);
        }
    }

    /**
     * Sets the ball.
     *
     * @param ball the new ball
     */
    public void setBall(Ball ball)
    {
        this.ball = ball;
    }

    /**
     * Sets the map.
     *
     * @param map the new map
     */
    public void setMap(Map map)
    {
        this.map = map;
    }
}

