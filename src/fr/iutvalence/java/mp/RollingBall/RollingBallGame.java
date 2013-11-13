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
     * play the game
     */
    public void play()
    {
        boolean youCanPlay = true;
        
        // TODO (fix) declare hard-coded values as constants
        Point gravityPower = new Point(0, -10);        
        double time = 0;
        double scoreOfThePlayer = 0;
        System.out.println("welcome " + this.playerName + " !!");

        int segmentArrayOffset;

        while (youCanPlay)
        {
            // TODO (refactor) extract intersection code to a private method
            // Control of the intersection of the ball with the game's field 
            segmentArrayOffset = 0;
            while ( segmentArrayOffset < this.map.getSegmentsOfTheField().length && 
                    !( this.map.getSegmentsOfTheField()[segmentArrayOffset].intersect(this.movingBall) ) )
            {
                segmentArrayOffset++;
            }
            if (segmentArrayOffset == this.map.getSegmentsOfTheField().length)
            {
                System.out.println("vole petite baballe !");
                this.movingBall.setNewSpeed(gravityPower);
            }
            else
            {
                System.out.println("stop ! tu touches !");
                Point forceReaction = this.map.getSegmentsOfTheField()[segmentArrayOffset].getReactionPower(this.movingBall); 
                System.out.println("R " + this.map.getSegmentsOfTheField()[segmentArrayOffset].getReactionPower(this.movingBall));               
                this.movingBall.setNewSpeed(gravityPower);
                this.movingBall.setNewSpeed(forceReaction);
            }

            System.out.println(this.movingBall);

            // Control of the play's time
            
            // TODO (fix) declare hard-coded values as constants
            // TODO (think about it) this if-else can be reduced to a single assignment            
            if (time == 100)
            {
                youCanPlay = false;
            }
            else
            {
                MovingBall nextBall = new MovingBall( this.movingBall.getRadius(), 
                        this.movingBall.nextPositionOfTheBall(), this.movingBall.getSpeedVector() );

                scoreOfThePlayer = scoreOfThePlayer + this.movingBall.nextPositionOfTheBall().getX() - this.movingBall.getCenter().getX();
                this.movingBall = nextBall;

                System.out.println("Your current score " + this.playerName + " : " + scoreOfThePlayer + " !!");

                time++;
            }
        }
    }

}
