package fr.iutvalence.java.mp.RollingBall;

/**
 * initialization of the game
 * 
 * @author andrejul
 *
 */
public class Player
{
    /**
     * method to initialize the game
     * 
     * @return RollingBallGame
     *                  the game initialized
     */
    public static RollingBallGame initialize()
    {
        Point beginningOfTheSegment = new Point(50, 25);
        Point endingOfTheSegment = new Point(50, 50);

        Point beginningOfTheSegment1 = new Point(0, 10);
        Point endingOfTheSegment1 = new Point(100, -10);
        
        Point beginningOfTheSegment2 = new Point(100, -10);
        Point endingOfTheSegment2 = new Point(150, 30);
        
        Point beginningOfTheSegment3 = new Point(0, 10);
        Point endingOfTheSegment3 = new Point(0, 100);
        
        Point beginningOfTheSegment4 = new Point(150, 30);
        Point endingOfTheSegment4 = new Point(150, 100);
        
        Point beginningOfTheSegment5 = new Point(0, 100);
        Point endingOfTheSegment5 = new Point(150, 100);
        
        Vector speedOfTheBall = new Vector(0, 0);
        Point centerOfTheBallWanted = beginningOfTheSegment;
        int radiusOfTheBallWanted = 10;
        
        Segment segmentWhereTheBallCanBeReleased;
        
        try
        {
            segmentWhereTheBallCanBeReleased = new Segment(beginningOfTheSegment, endingOfTheSegment);
            
            Segment segment1 = new Segment(beginningOfTheSegment1, endingOfTheSegment1);

            Segment segment2 = new Segment(beginningOfTheSegment2, endingOfTheSegment2);

            Segment segment3 = new Segment(beginningOfTheSegment3, endingOfTheSegment3);

            Segment segment4 = new Segment(beginningOfTheSegment4, endingOfTheSegment4);

            Segment segment5 = new Segment(beginningOfTheSegment5, endingOfTheSegment5);
            
            Segment[] segmentsOfTheField = null;
            segmentsOfTheField = new Segment[5];
            segmentsOfTheField[0] = segment1;
            segmentsOfTheField[1] = segment2;
            segmentsOfTheField[2] = segment3;
            segmentsOfTheField[3] = segment4;
            segmentsOfTheField[4] = segment5;
            System.out.println("map créée");
            
            Map map = new Map(segmentsOfTheField, segmentWhereTheBallCanBeReleased);
            
            MovingBall ball = new MovingBall(radiusOfTheBallWanted, centerOfTheBallWanted, speedOfTheBall);
            System.out.println("balle créée");
            
            String nameOfThePlayerPlaying = "toto";
            
            RollingBallGame theGame = new RollingBallGame(nameOfThePlayerPlaying, map, ball);
            
            return theGame;
        }
        catch (NullVectorException e)
        {
            e.printStackTrace();
        }
        return null; 
    }
}
