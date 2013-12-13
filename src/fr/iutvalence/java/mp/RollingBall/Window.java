package fr.iutvalence.java.mp.RollingBall;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JFrame
{
    public static final Dimension DIMENSION = new Dimension(1024, 728);

    private final MainJPanel pan = new MainJPanel(new Ball(1,new Point(-10,-10)),new Map());

    private final JLabel scoreLabel = new JLabel("Score : ");

    public Window()
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

    public JLabel getScoreLabel()
    {
        return this.scoreLabel;
    }

    public void go(MovingBall ball, Map map)
    {
        this.pan.setMap(map);
        this.pan.setBall(ball);
        this.pan.repaint();
    }

    public void test()
    {
        Ball ball = new Ball(10,new Point(0,0));

        for (int i=0;i<Window.DIMENSION.getWidth();i+=10)
        {
            int j = 0;
            while (j<Window.DIMENSION.getHeight())
            {
                ball = new Ball(10,new Point(i,j));
                j+=10;
                this.pan.setBall(ball);

                this.pan.repaint();

                try
                {
                    Thread.sleep(20);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}