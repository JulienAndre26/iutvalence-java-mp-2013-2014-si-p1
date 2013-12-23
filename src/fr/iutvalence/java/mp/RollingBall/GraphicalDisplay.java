package fr.iutvalence.java.mp.RollingBall;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


// TODO: Auto-generated Javadoc
/**
 * GUI of the game.
 *
 * @author andrejul
 */
public class GraphicalDisplay extends JFrame implements Display, Player
{
    /** The Constant DIMENSION. */
    public static final Dimension DIMENSION = new Dimension(1024, 728);

    /** The pan. */
    private final MainJPanel pan = new MainJPanel(new Ball(1,new Point(-10,-10)),new Map());

    /** The score label. */
    private final JLabel scoreLabel = new JLabel("Score : ");

    /** The menu bar. */
    private final JMenuBar menuBar = new JMenuBar();

    /** The fichier. */
    private final JMenu fichier = new JMenu("Fichier");

    /** The edition. */
    private final JMenu edition = new JMenu("Edition");

    /** The quitter. */
    private final JMenuItem quitter = new JMenuItem("Quitter");

    /** The lancer. */
    private final JMenuItem lancer = new JMenuItem("Lancer");

    /** The arreter. */
    private final JMenuItem arreter = new JMenuItem("Arrêter");

    /** The a propos. */
    private final JMenuItem aPropos = new JMenuItem("A propos");

    /** The jeu. */
    private boolean jeu = true;

    /** The t. */
    private Thread t;

    /**
     * Instantiates a new graphical display.
     */
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

        this.fichier.add(this.lancer);

        this.fichier.add(this.arreter);

        this.fichier.add(this.quitter);

        this.edition.add(this.aPropos);

        this.initMenu();
        this.setVisible(true);
    }

    /**
     * Inits the menu.
     */
    private void initMenu()
    {
        //Menu fichier
        this.fichier.add(this.lancer);
        this.arreter.setEnabled(false);
        this.fichier.add(this.arreter);

        //Ajout du listener pour lancer l'animation
        this.lancer.addActionListener(new StartAnimationListener());
        this.fichier.add(this.lancer);

        //Ajout du listener pour arrêter l'animation
        this.arreter.addActionListener(new StopAnimationListener());
        this.arreter.setEnabled(false);
        this.fichier.add(this.arreter);

        this.fichier.addSeparator();
        //Pour quitter l'application
        this.quitter.addActionListener(new ActionListener()
        {
            public void actionPerfomed(ActionEvent event)
            {
                System.exit(0);
            }

            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                // TODO Auto-generated method stub

            }
        });
        this.fichier.add(this.quitter);

        //Menu edition
        this.edition.add(this.aPropos);

        //Ajout de ce que doit faire le A propos
        this.aPropos.addActionListener(new ActionListner()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                JOptionPane jop = new JOptionPane();
                String mess = "Bonjour";
                JOptionPane.showMessageDialog(null, mess, "Edition", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        this.edition.add(this.aPropos);

        //Ajout des menus sur la barre des menus
        this.menuBar.add(this.fichier);
        this.menuBar.add(this.edition);

        //Ajout de la barre des menus sur la fenêtre
        this.setJMenuBar(this.menuBar);
    }

    /* (non-Javadoc)
     * @see fr.iutvalence.java.mp.RollingBall.Display#ballCreated()
     */
    @Override
    public void ballCreated()
    {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see fr.iutvalence.java.mp.RollingBall.Display#bounce()
     */
    @Override
    public void bounce()
    {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see fr.iutvalence.java.mp.RollingBall.Display#flyingBall(fr.iutvalence.java.mp.RollingBall.MovingBall)
     */
    @Override
    public void flyingBall(MovingBall movingBall)
    {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see fr.iutvalence.java.mp.RollingBall.Display#gameEnd(double, java.lang.String, double)
     */
    @Override
    public void gameEnd(double numberOfBounces, String playerName, double scoreOfThePlayer)
    {
        this.getScoreLabel().setText("Your final score " + playerName + " : " + ((double)((int)(scoreOfThePlayer*500))/500)
                + " and the number of bounces of your ball : " + (int)numberOfBounces);
    }

    /* (non-Javadoc)
     * @see fr.iutvalence.java.mp.RollingBall.Display#gameStart(double, java.lang.String, double)
     */
    @Override
    public void gameStart(String playerName)
    {
        // TODO Auto-generated method stub

    }

    /**
     * Gets the score label.
     *
     * @return the score label
     */
    public JLabel getScoreLabel()
    {
        return this.scoreLabel;
    }

    /* (non-Javadoc)
     * @see fr.iutvalence.java.mp.RollingBall.Player#getStartingPoint(fr.iutvalence.java.mp.RollingBall.Segment)
     */
    @Override
    public Point getStartingPoint(Segment segmentWhereTheBallCanBeReleased)
    {
        //        try
        //        {
        //            // this.wait();
        //        }
        //        catch (InterruptedException e)
        //        {
        //            // TODO Auto-generated catch block
        //            e.printStackTrace();
        //        }
        return this.pan.getBall().getCenter();
    }

    /**
     * method go which set the new ball and the new map we have to display.
     *
     * @param ball the ball
     * @param map the map
     */
    public void go(MovingBall ball, Map map)
    {
        this.pan.setMap(map);
        this.pan.setBall(ball);
        this.pan.repaint();
    }

    /* (non-Javadoc)
     * @see fr.iutvalence.java.mp.RollingBall.Display#mapCreated()
     */
    @Override
    public void mapCreated()
    {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see fr.iutvalence.java.mp.RollingBall.Display#roundEnd(java.lang.String, double)
     */
    @Override
    public void roundEnd(String playerName, double scoreOfThePlayer)
    {
        this.getScoreLabel().setText("Your score " + playerName + " : " + ((double)((int)(scoreOfThePlayer*500))/500));
    }

    /* (non-Javadoc)
     * @see fr.iutvalence.java.mp.RollingBall.Display#roundStart(fr.iutvalence.java.mp.RollingBall.MovingBall, fr.iutvalence.java.mp.RollingBall.Map)
     */
    @Override
    public void roundStart(MovingBall ball, Map map)
    {
        this.go(ball,map);
    }

    /* (non-Javadoc)
     * @see fr.iutvalence.java.mp.RollingBall.Display#theBallHits(fr.iutvalence.java.mp.RollingBall.Segment, fr.iutvalence.java.mp.RollingBall.Vector, fr.iutvalence.java.mp.RollingBall.MovingBall)
     */
    @Override
    public void theBallHits(Segment segmentHit, Vector reactPower, MovingBall ballInMove)
    {
        // TODO Auto-generated method stub

    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args)
    {
        GraphicalDisplay GraphDisp = new GraphicalDisplay();
    }

    /**
     * The Class BoutonListner.
     */
    public class BoutonListner implements ActionListner
    {

        /** The job. */
        private JOptionPane job;

        /**
         * Action performed.
         *
         * @param arg0 the arg0
         */
        public void actionPerformed(ActionEvent arg0)
        {
            JOptionPane jop = new JOptionPane();
            int option = this.job.showConfirmDialog(null, "Voulez-vous lancer le jeu?", "Lancement du jeu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if ( option == JOptionPane.OK_OPTION)
            {
                GraphicalDisplay.this.lancer.setEnabled(false);
                GraphicalDisplay.this.arreter.setEnabled(true);
                GraphicalDisplay.this.jeu = true;
                GraphicalDisplay.this.t = new Thread(new PlayJeu());
                GraphicalDisplay.this.t.start();
            }
        }
    }

    /**
     * The Class PlayJeu.
     */
    public class PlayJeu implements Runnable
    {

        /* (non-Javadoc)
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run()
        {
            GraphicalDisplay.this.go(null, null);
        }
    }
}