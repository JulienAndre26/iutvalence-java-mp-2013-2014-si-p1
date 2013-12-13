package fr.iutvalence.java.mp.RollingBall;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * graphical display of the game
 *
 * @author andrejul
 *
 */
public class GraphicalDisplay extends JFrame implements Display, Player
{

    public static final Dimension DIMENSION = new Dimension(1024, 728);

    private final MainJPanel pan = new MainJPanel(new Ball(1,new Point(-10,-10)),new Map());

    private final JLabel scoreLabel = new JLabel("Score : ");

    public GraphicalDisplay()
    {
        this.setSize(DIMENSION);
        this.setTitle("Awesome Rolling Ball");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JPanel myFirstPanel = new JPanel();
        myFirstPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.weighty = 0;
        c.ipadx = (int)DIMENSION.getWidth();
        c.ipady = (int)DIMENSION.getHeight()-60;
        c.gridx = 0;
        c.gridy = 0;
        this.getContentPane().add(this.pan, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 1;
        this.scoreLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.getContentPane().add(this.scoreLabel, c);

        this.setVisible(true);
    }

    @Override
    public void ballCreated()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void bounce()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void flyingBall(MovingBall movingBall)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void gameEnd(double numberOfBounces, String playerName, double scoreOfThePlayer)
    {
        this.getScoreLabel().setText("Your final score " + playerName + " : " + ((double)((int)(scoreOfThePlayer*500))/500)
                + " and the number of bounces of your ball : " + (int)numberOfBounces);
    }

    /**
     * method which opens a new window
     * @param playerName
     * unused parameter
     */
    @Override
    public void gameStart(String playerName)
    {
        // TODO Auto-generated method stub

    }

    public JLabel getScoreLabel()
    {
        return this.scoreLabel;
    }

    @Override
    public Point getStartingPoint(Segment segmentWhereTheBallCanBeReleased)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public void go(MovingBall ball, Map map)
    {
        this.pan.setMap(map);
        this.pan.setBall(ball);
        this.pan.repaint();
    }

    @Override
    public void mapCreated()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void roundEnd(String playerName, double scoreOfThePlayer)
    {
        this.getScoreLabel().setText("Your score " + playerName + " : " + ((double)((int)(scoreOfThePlayer*500))/500));
    }

    @Override
    public void roundStart(MovingBall ball, Map map)
    {
        this.go(ball,map);
    }

    @Override
    public void theBallHits(Segment segmentHit, Vector reactPower, MovingBall ballInMove)
    {
        // TODO Auto-generated method stub

    }

}