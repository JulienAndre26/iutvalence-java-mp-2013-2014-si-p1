package fr.iutvalence.java.mp.RollingBall;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainJPanel extends JPanel
{
    private static final long serialVersionUID = -3051649865637553151L;

    private Ball ball;

    private Boolean gameStarts;

    private Map map;

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
                MainJPanel.this.gameStarts = true;
            }
        });

        this.addMouseMotionListener(new MouseMotionListener()
        {

            @Override
            public void mouseDragged(MouseEvent e){}

            @Override
            public void mouseMoved(MouseEvent e)
            {
                int x = e.getX();
                int y = e.getY();

                ball.setCenter(new Point(x,y));

                //				int xa = (int) map.getSegmentWhereTheBallCanBeReleased().getStartingPoint().getX();
                //				int ya = (int) map.getSegmentWhereTheBallCanBeReleased().getStartingPoint().getY();
                //
                //				int xb = (int) map.getSegmentWhereTheBallCanBeReleased().getEndingPoint().getX();
                //				int yb = (int) map.getSegmentWhereTheBallCanBeReleased().getEndingPoint().getY();
                //
                //				if (MainJPanel.this.gameStarts == false)
                //				{
                //					// en partant du principe que A est le point le plus en bas à droite et B le point le plus en haut à gauche
                //					if (x < xa)
                //					{
                //						if (y < ya)
                //						{
                //							ball.setCenter(new Point(xa,ya));
                //						}
                //						if (y > yb)
                //						{
                //							ball.setCenter(new Point(xa,yb));
                //						}
                //						if ((y >= ya) && (y <= yb))
                //						{
                //							ball.setCenter(new Point(xa,y));
                //						}
                //					}
                //
                //					if (x > xb)
                //					{
                //						if (y < ya)
                //						{
                //							ball.setCenter(new Point(xb,ya));
                //						}
                //						if (y > yb)
                //						{
                //							ball.setCenter(new Point(xb,yb));
                //						}
                //						if ((y >= ya) && (y <= yb))
                //						{
                //							ball.setCenter(new Point(xb,y));
                //						}
                //					}
                //
                //					if ( (x >= xa) && (x <= xb) )
                //					{
                //						if (y < ya)
                //						{
                //							ball.setCenter(new Point(x,ya));
                //						}
                //						if (y > yb)
                //						{
                //							ball.setCenter(new Point(x,yb));
                //						}
                //						if ((y >= ya) && (y <= yb))
                //						{
                //							ball.setCenter(new Point(x,y));
                //						}
                //					}
                //				MainJPanel.this.repaint();
                //				}
            }
        });
        this.ball = ball;
        this.map = map;
    }

    private void drawLine(Graphics g, Segment segment)
    {
        g.setColor(Color.RED);
        int xa = (int)segment.getStartingPoint().getX();
        int ya = (int)(Window.DIMENSION.getHeight()-segment.getStartingPoint().getY()-300);
        int xb = (int)segment.getEndingPoint().getX();
        int yb = (int)(Window.DIMENSION.getHeight()-segment.getEndingPoint().getY()-300);
        g.drawLine(xa, ya, xb, yb);
        g.drawLine(xa, ya-1, xb, yb-1);
    }

    private void fillOval(Graphics g, Ball ball)
    {
        g.setColor(Color.CYAN);
        int xa =(int)ball.getCenter().getX();
        int ya =(int)(Window.DIMENSION.getHeight()-this.ball.getCenter().getY()-300);
        int r = (int)this.ball.getRadius();
        g.fillOval(xa, ya, r, r);
    }

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
                Image img = ImageIO.read(new File("C:/Users/user/Desktop/workspace/RollingBallGame/src/Pictures/ball.jpg"));
                g.drawImage(img, (int)this.ball.getCenter().getX(), (int)(Window.DIMENSION.getHeight()-this.ball.getCenter().getY()-300), null);
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

    public void setBall(Ball ball)
    {
        this.ball = ball;
    }

    public void setMap(Map map)
    {
        this.map = map;
    }
}

