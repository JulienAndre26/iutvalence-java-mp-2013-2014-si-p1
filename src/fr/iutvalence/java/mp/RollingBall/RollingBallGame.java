package fr.iutvalence.java.mp.RollingBall;

/**
 * 
 * see readme.md Means and rules of the game.
 * 
 * @author andrejul
 * 
 */
//TODO (FIXED) this class has a duplicate (RollingBall)
public class RollingBallGame
{
    /**
     * the name of the player
     */
    private String nameOfThePlayer;

    /**
     * the map used by the player
     */
    private Map mapUsedByThePlayer;

    /**
     * the ball used by the player
     */
    private MovingBall ballUsedByThePlayer;


    // TODO (FIXED) looks like a local variable

    /**
     * rollingball game created with three parameters : the name of the player, the
     * map where the player wants to play and the ball the player want to use
     * 
     * @param nameOfThePlayerPlaying
     *            the name of the player
     * @param mapChoosedByThePlayer
     *            the map used by the player
     * @param ballChoosedByThePlayer
     *            the ball choose by the player
     */
    public RollingBallGame(String nameOfThePlayerPlaying, Map mapChoosedByThePlayer, MovingBall ballChoosedByThePlayer)
    {
        this.nameOfThePlayer = nameOfThePlayerPlaying;
        this.mapUsedByThePlayer = mapChoosedByThePlayer;
        this.ballUsedByThePlayer = ballChoosedByThePlayer;
    }

    /**
     * play the game
     */
    public void play()
    {
        boolean youCanPlay = true;
        Point gravityPower = new Point(0, -10);
        double time = 0;
        double scoreOfThePlayer = 0;
        System.out.println("welcome " + this.nameOfThePlayer + " !!");

        // TODO (FIXED) rename local variable (more explicit)
        int indiceOfTheSegmentsField;

        while (youCanPlay)
        {
            // Control of the intersection of the ball with the game's field 
            indiceOfTheSegmentsField = 0;
            while ( indiceOfTheSegmentsField < this.mapUsedByThePlayer.getSegmentsOfTheField().length && 
                    !( this.mapUsedByThePlayer.getSegmentsOfTheField()[indiceOfTheSegmentsField].intersect(this.ballUsedByThePlayer) ) )
            {
                indiceOfTheSegmentsField++;
            }
            if (indiceOfTheSegmentsField == this.mapUsedByThePlayer.getSegmentsOfTheField().length)
            {
                System.out.println("vole petite baballe !");
                this.ballUsedByThePlayer.setNewSpeed(gravityPower);
            }
            else
            {
                System.out.println("stop ! tu touches !");
                Point forceReaction = this.mapUsedByThePlayer.getSegmentsOfTheField()[indiceOfTheSegmentsField].getReactionPower(this.ballUsedByThePlayer); 
                System.out.println("R " + this.mapUsedByThePlayer.getSegmentsOfTheField()[indiceOfTheSegmentsField].getReactionPower(this.ballUsedByThePlayer));               
                this.ballUsedByThePlayer.setNewSpeed(gravityPower);
                this.ballUsedByThePlayer.setNewSpeed(forceReaction);
            }

            System.out.println(this.ballUsedByThePlayer);

            // Control of the play's time
            if (time == 100)
            {
                youCanPlay = false;
            }
            else
            {
                MovingBall nextBall = new MovingBall( this.ballUsedByThePlayer.getRadius(), 
                        this.ballUsedByThePlayer.nextPositionOfTheBall(), this.ballUsedByThePlayer.getSpeedVector() );

                scoreOfThePlayer = scoreOfThePlayer + this.ballUsedByThePlayer.nextPositionOfTheBall().getX() - this.ballUsedByThePlayer.getCenter().getX();
                this.ballUsedByThePlayer = nextBall;

                System.out.println("Your current score " + this.nameOfThePlayer + " : " + scoreOfThePlayer + " !!");

                time++;
            }
        }
    }

}
