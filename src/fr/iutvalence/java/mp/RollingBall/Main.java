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
        Point beginningOfTheSegment = new Point(50, 50);
        Point endingOfTheSegment = new Point(50, 100);

        try
        {
            Segment segmentWhereTheBallCanBeReleased = new Segment(beginningOfTheSegment, endingOfTheSegment);
            System.out.print("segment de la balle créé\n");

            Point beginningOfTheSegment1 = new Point(0, 0);
            Point endingOfTheSegment1 = new Point(100, 0);

            Segment segment1 = new Segment(beginningOfTheSegment1, endingOfTheSegment1);

            Segment[] segmentsOfTheField = null;
            segmentsOfTheField = new Segment[1];
            segmentsOfTheField[0] = segment1;
            System.out.print("map créée\n");

            Map map = new Map(segmentsOfTheField, segmentWhereTheBallCanBeReleased);

            Point componentOfTheVector = new Point(0, 0);
            Vector speedOfTheBall = new Vector(componentOfTheVector);
            Point centerOfTheBallWanted = beginningOfTheSegment;
            int radiusOfTheBallWanted = 10;
            MovingBall ball = new MovingBall(radiusOfTheBallWanted, centerOfTheBallWanted, speedOfTheBall);
            System.out.print("balle créée\n");

            String nameOfThePlayerPlaying = "toto";

            new RollingBallGame(nameOfThePlayerPlaying, map, ball).play();
            System.out.print("le jeu a commencé\n");
        }
        catch (SamePointException e)
        {
            e.printStackTrace();
        }

       
    }

}
