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
        try
        {
            Point beginningOfTheSegment = new Point(50, 20);
            Point endingOfTheSegment = new Point(50, 50);

            Segment segmentWhereTheBallCanBeReleased = new Segment(beginningOfTheSegment, endingOfTheSegment);
            System.out.println("segment de la balle créé");

            Point beginningOfTheSegment1 = new Point(0, 10);
            Point endingOfTheSegment1 = new Point(100, -10);

            Segment segment1 = new Segment(beginningOfTheSegment1, endingOfTheSegment1);
            
            Point beginningOfTheSegment2 = new Point(100, -10);
            Point endingOfTheSegment2 = new Point(150, 30);

            Segment segment2 = new Segment(beginningOfTheSegment2, endingOfTheSegment2);
            
            Point beginningOfTheSegment3 = new Point(0, 10);
            Point endingOfTheSegment3 = new Point(0, 100);

            Segment segment3 = new Segment(beginningOfTheSegment3, endingOfTheSegment3);
            
            Point beginningOfTheSegment4 = new Point(150, 30);
            Point endingOfTheSegment4 = new Point(150, 100);

            Segment segment4 = new Segment(beginningOfTheSegment4, endingOfTheSegment4);
            
            Point beginningOfTheSegment5 = new Point(0, 100);
            Point endingOfTheSegment5 = new Point(150, 100);

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

            Vector speedOfTheBall = new Vector(0, 0);
            Point centerOfTheBallWanted = beginningOfTheSegment;
            int radiusOfTheBallWanted = 10;
            MovingBall ball = new MovingBall(radiusOfTheBallWanted, centerOfTheBallWanted, speedOfTheBall);
            System.out.println("balle créée");

            String nameOfThePlayerPlaying = "toto";

            RollingBallGame theGame = new RollingBallGame(nameOfThePlayerPlaying, map, ball);
            System.out.println("le jeu commence !!");
            theGame.play();
        }
        catch (NullVectorException e)
        {
            e.printStackTrace();
        }       
    }

}
