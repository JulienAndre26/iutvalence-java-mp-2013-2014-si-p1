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

    /** gravity applied to the ball during a play. */
    public static final Vector GRAVITY_POWER = new Vector(0,-10);

    /** time in air minimum to have a bounce. */
    public static final int TIME_IN_AIR_MIN = 10;

    /** maximum time of a play. */
    public static final double TIME_MAX = 10000;

    /** maximum times that the ball doesn't move (to stop the play if the ball doesn't move). */
    public static final double TIME_OF_STATIC_BALL_MAX = 2;

    /** time to wait to have a real time. */
    public static final double WAITING_TIME = (60/MovingBall.DISPLAY_FREQUENCY)*1000;

    /** the type of display used. */
    private final Display display;

    /** the map used by the player. */
    private final Map map;

    /** the ball used by the player. */
    private MovingBall movingBall;

    /** the typer of player used. */
    private final Player player;

    /** the name of the player. */
    private final String playerName;

    /**
     * RollingBallGame created with three parameters : the name of the player, the
     * map where the player wants to play and the ball the player want to use.
     *
     * @param display the type of display used
     * @param player the type of player used
     * @param playerName the name of the player
     * @param map the map used by the player
     * @param movingBall the ball choose by the player
     */
    public RollingBallGame(Display display, Player player, String playerName, Map map, MovingBall movingBall)
    {
        this.display = display;
        this.player = player;
        this.playerName = playerName;
        this.map = map;
        this.movingBall = movingBall;
    }

    /**
     * method to control the intersection between the ball and the segment.
     *
     * @return segmentArrayOffset
     * offset of the segment array
     */
    private int intersectionBallSegmentControl()
    {
        int segmentArrayOffset = 0;
        while ( (segmentArrayOffset < this.map.getSegmentsOfTheField().length) &&
                !( this.map.getSegmentsOfTheField()[segmentArrayOffset].intersect(this.movingBall) ) )
        {
            segmentArrayOffset++;
        }
        return segmentArrayOffset;
    }

    /**
     * play the game.
     */
    public void play()
    {
        boolean youCanPlay;
        int intersectionControl;
        double time = 0;
        double timeInAir = 0;
        double scoreOfThePlayer = 0;
        double numberOfBounceOfTheBall = 0;
        double numbOfStaticBall = 0;

        this.display.ballCreated();

        youCanPlay = true;

        while (youCanPlay)
        {
            this.display.roundStart(this.movingBall, this.map);

            // Control of the intersection of the ball with the game's field
            intersectionControl = this.intersectionBallSegmentControl();

            this.movingBall.setSpeedVector(this.movingBall.getSpeedVector().sum(GRAVITY_POWER));

            if (intersectionControl == this.map.getSegmentsOfTheField().length)
            {
                timeInAir++;
                this.display.flyingBall(this.movingBall);
            }
            else
            {
                // Control of the vector to apply reacting force only once
                if (this.movingBall.getSpeedVector().getY() <= 0)
                {
                    if (timeInAir > TIME_IN_AIR_MIN)
                    {
                        numberOfBounceOfTheBall++;
                        this.display.bounce();
                    }
                    Vector forceReaction = this.map.getSegmentsOfTheField()[intersectionControl].getReactionPower(this.movingBall);
                    this.display.theBallHits(this.map.getSegmentsOfTheField()[intersectionControl],forceReaction,this.movingBall);
                    this.movingBall.setSpeedVector(this.movingBall.getSpeedVector().sum(forceReaction));
                    timeInAir = 0;
                }
            }

            // Control of the play's time
            if (time == TIME_MAX)
            {
                youCanPlay = false;
            }
            else
            {
                MovingBall nextPositionOfTheBall = new MovingBall( this.movingBall.getRadius(),
                        this.movingBall.nextPositionOfTheBall(), this.movingBall.getSpeedVector() );

                scoreOfThePlayer = (scoreOfThePlayer + this.movingBall.nextPositionOfTheBall().getX()) - this.movingBall.getCenter().getX();

                // stop the game if the ball does not move
                if ( !this.movingBall.getCenter().equals(nextPositionOfTheBall.getCenter()) )
                {
                    numbOfStaticBall = 0;
                }
                else
                {
                    numbOfStaticBall++;
                }

                this.movingBall = nextPositionOfTheBall;

                this.display.roundEnd(this.playerName, scoreOfThePlayer);

                if ( numbOfStaticBall == TIME_OF_STATIC_BALL_MAX )
                {
                    youCanPlay = false;
                    this.display.gameEnd(numberOfBounceOfTheBall, this.playerName, scoreOfThePlayer);
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