package fr.iutvalence.java.mp.RollingBall;

/**
 * 
 * main class of the rollingball game
 * 
 * @author andrejul
 * 
 */
public class Main
{
    /**
     * start a play of the rollingball game
     * 
     * @param args
     *            undefined reference
     */
    public static void main(String[] args)
    {
        Display display = new Display();

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
        Point centerOfTheBallWanted = new Point(0,0);
        int radiusOfTheBallWanted = 10;

        try
        {
            Segment segmentWhereTheBallCanBeReleased = new Segment(beginningOfTheSegment, endingOfTheSegment);
            
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
            display.mapCreated();

            Map map = new Map(segmentsOfTheField, segmentWhereTheBallCanBeReleased);

            String nameOfThePlayerPlaying = "toto";

            MovingBall ball = new MovingBall(radiusOfTheBallWanted, centerOfTheBallWanted, speedOfTheBall);
            
            RollingBallGame theGame = new RollingBallGame(nameOfThePlayerPlaying, map, ball);
            theGame.play();
        }
        catch (NullVectorException e)
        {
            e.printStackTrace();
        }
    }    
}
