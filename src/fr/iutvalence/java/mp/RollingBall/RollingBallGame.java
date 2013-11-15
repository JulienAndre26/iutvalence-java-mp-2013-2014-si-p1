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
     * rollingball game created with three parameters : the name of the player, the
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
    public void play()
    {
        boolean youCanPlay = true;
        int intersectionControl;
        // TODO (FIXED) declare hard-coded values as constants
        double time = 0;
        double timeInAir = 0;
        double scoreOfThePlayer = 0;
        double numberOfBounceOfTheBall = 0;
        double numbOfStaticBall = 0;
        System.out.println("welcome " + this.playerName + " !!");

        while (youCanPlay)
        {
            // TODO (FIXED) extract intersection code to a private method
            // Control of the intersection of the ball with the game's field 

            intersectionControl = intersectionBallSegmentControl();

            this.movingBall.setSpeedVector(this.movingBall.getSpeedVector().sum(GRAVITY_POWER));

            if (intersectionControl == this.map.getSegmentsOfTheField().length)
            {
                timeInAir++;
                System.out.println("vole petite baballe !");
            }
            else
            {
                // Control of the vector to apply reacting force only once
                if (this.movingBall.getSpeedVector().getY() <= 0)
                {
                    if (timeInAir > 6)
                    {
                        numberOfBounceOfTheBall++;
                        System.out.println("boing !");
                    }
                    timeInAir = 0;
                    System.out.println("stop ! tu touches !");
                    Vector forceReaction = this.map.getSegmentsOfTheField()[intersectionControl].getReactionPower(this.movingBall);
                    System.out.println(this.map.getSegmentsOfTheField()[intersectionControl]);
                    System.out.println("R " + forceReaction);
                    this.movingBall.setSpeedVector(this.movingBall.getSpeedVector().sum(forceReaction));
                }
            }

            System.out.println(this.movingBall);

            // Control of the play's time

            // TODO (FIXED) declare hard-coded values as constants
            // TODO (FIXED) this if-else can be reduced to a single assignment            
            if (time == TIME_MAX)
            {
                youCanPlay = false;
            }

            MovingBall nextPositionOfTheBall = new MovingBall( this.movingBall.getRadius(),
                    this.movingBall.nextPositionOfTheBall(), this.movingBall.getSpeedVector() );

            scoreOfThePlayer = scoreOfThePlayer + this.movingBall.nextPositionOfTheBall().getX() - this.movingBall.getCenter().getX();

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

            System.out.println("Your current score " + this.playerName + " : " + (int)scoreOfThePlayer + " !!");

            if ( numbOfStaticBall == TIME_OF_STATIC_BALL_MAX )
            {
                youCanPlay = false;
                System.out.println("La balle ne bouge plus :(\n--> end of the play");
                System.out.println("La balle a rebondit " + (int)(numberOfBounceOfTheBall) + " fois ! :p");
                System.out.println("Your final score " + this.playerName + " : " + (int)scoreOfThePlayer + " !!");
            }   
            time++;            
        }
    }

}
