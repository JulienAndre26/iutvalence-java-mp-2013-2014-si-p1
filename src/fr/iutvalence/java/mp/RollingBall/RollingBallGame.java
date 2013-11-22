package fr.iutvalence.java.mp.RollingBall;

/**
 * 
 * see readme.md Means and rules of the game.
 * 
 * @author andrejul
 * 
 */
public class RollingBallGame
{
    /**
     * maximum time of a play
     */
    public final static double TIME_MAX = 10000;

    /**
     * maximum times that the ball doesn't move (to stop the play if the ball doesn't move) 
     */
    public final static double TIME_OF_STATIC_BALL_MAX = 2;

    /**
     * time to wait to have a real time
     */
    public final static double WAITING_TIME = (60/MovingBall.DISPLAY_FREQUENCY)*1000;

    /**
     * gravity applied to the ball during a play
     */
    public final static Vector GRAVITY_POWER = new Vector(0,-10);

    /**
     * the name of the player
     */
    private String playerName;

    /**
     * the map used by the player
     */
    private Map map;

    /**
     * the ball used by the player
     */
    private MovingBall movingBall;

    /**
     * RollingBallGame created with three parameters : the name of the player, the
     * map where the player wants to play and the ball the player want to use
     * 
     * @param playerName
     *            the name of the player
     * @param map
     *            the map used by the player
     * @param movingBall
     *            the ball choose by the player
     */
    public RollingBallGame(String playerName, Map map, MovingBall movingBall)
    {
        this.playerName = playerName;
        this.map = map;
        this.movingBall = movingBall;
    }

    /**
     * method to control the intersection between the ball and the segment
     * @return segmentArrayOffset
     *                  offset of the segment array
     */
    private int intersectionBallSegmentControl()
    {
        int segmentArrayOffset = 0;
        while ( segmentArrayOffset < this.map.getSegmentsOfTheField().length && 
                !( this.map.getSegmentsOfTheField()[segmentArrayOffset].intersect(this.movingBall) ) )
        {
            segmentArrayOffset++;
        }
        return segmentArrayOffset;
    }

    /**
     * play the game
     */
    public static void play()
    {
        RollingBallGame theGame = Player.initialize(); 
        boolean youCanPlay;
        int intersectionControl;
        double time = 0;
        double timeInAir = 0;
        double scoreOfThePlayer = 0;
        double numberOfBounceOfTheBall = 0;
        double numbOfStaticBall = 0;

        if (theGame == null)
        {
            youCanPlay = false;
        }
        else
        {           
            youCanPlay = true;
            Display.gameStart(theGame.playerName);
        }        

        while (youCanPlay)
        {
            // Control of the intersection of the ball with the game's field 
            intersectionControl = theGame.intersectionBallSegmentControl();

            theGame.movingBall.setSpeedVector(theGame.movingBall.getSpeedVector().sum(GRAVITY_POWER));

            if (intersectionControl == theGame.map.getSegmentsOfTheField().length)
            {
                timeInAir++;
                Display.flyingBall(theGame.movingBall);
            }
            else
            {
                // Control of the vector to apply reacting force only once
                if (theGame.movingBall.getSpeedVector().getY() <= 0)
                {
                    if (timeInAir > 6)
                    {
                        numberOfBounceOfTheBall++;
                        Display.bounce();
                    }
                    timeInAir = 0;
                    Vector forceReaction = theGame.map.getSegmentsOfTheField()[intersectionControl].getReactionPower(theGame.movingBall);
                    Display.theBallHits(theGame.map.getSegmentsOfTheField()[intersectionControl],forceReaction,theGame.movingBall);
                    theGame.movingBall.setSpeedVector(theGame.movingBall.getSpeedVector().sum(forceReaction));
                }
            }

            // Control of the play's time
            if (time == TIME_MAX)
            {
                youCanPlay = false;
            }
            else
            {
                MovingBall nextPositionOfTheBall = new MovingBall( theGame.movingBall.getRadius(),
                        theGame.movingBall.nextPositionOfTheBall(), theGame.movingBall.getSpeedVector() );

                scoreOfThePlayer = scoreOfThePlayer + theGame.movingBall.nextPositionOfTheBall().getX() - theGame.movingBall.getCenter().getX();

                // stop the game if the ball does not move
                if ( !theGame.movingBall.getCenter().equals(nextPositionOfTheBall.getCenter()) )
                {
                    numbOfStaticBall = 0;
                }
                else
                {
                    numbOfStaticBall++;
                }

                theGame.movingBall = nextPositionOfTheBall;

                Display.roundEnd(theGame.playerName, scoreOfThePlayer);

                if ( numbOfStaticBall == TIME_OF_STATIC_BALL_MAX )
                {
                    youCanPlay = false;
                    Display.gameEnd(numberOfBounceOfTheBall, theGame.playerName, scoreOfThePlayer);
                }   
                time++;

                // a wait to make the time match more with reality
                try
                {
                    Thread.sleep((long)WAITING_TIME);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

}
