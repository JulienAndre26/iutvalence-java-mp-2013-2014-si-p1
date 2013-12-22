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
     * undefined reference
     */
    public static void main(String[] args)
    {
        //  ConsoleDisplay display = new ConsoleDisplay();
        GraphicalDisplay display = new GraphicalDisplay();
        PlayerFixed player = new PlayerFixed();

        Point beginningOfTheSegment = new Point(10, 100);
        Point endingOfTheSegment = new Point(10, 90);

        Point beginningOfTheSegment1 = new Point(5, 80);
        Point endingOfTheSegment1 = new Point(30, 75);

        Point beginningOfTheSegment2 = new Point(30, 65);
        Point endingOfTheSegment2 = new Point(40, 70);

        Point beginningOfTheSegment3 = new Point(40, 70);
        Point endingOfTheSegment3 = new Point(65, 65);

        Point beginningOfTheSegment4 = new Point(70, 60);
        Point endingOfTheSegment4 = new Point(90, 40);

        Point beginningOfTheSegment5 = new Point(90, 40);
        Point endingOfTheSegment5 = new Point(130, 35);

        Point beginningOfTheSegment6 = new Point(135,30);
        Point endingOfTheSegment6 = new Point(135,10);

        Point beginningOfTheSegment7 = new Point(136, 10);
        Point endingOfTheSegment7 = new Point(300, 10);

        Point beginningOfTheSegment8 = new Point(300, 10);
        Point endingOfTheSegment8 = new Point(300, 300);

        Vector speedOfTheBall = new Vector(0, 0);
        Point centerOfTheBallWanted = new Point(0,0);
        //int radiusOfTheBallWanted = 15;
        int radiusOfTheBallWanted = 10;

        try
        {
            Segment segmentWhereTheBallCanBeReleased = new Segment(beginningOfTheSegment, endingOfTheSegment);

            Segment segment1 = new Segment(beginningOfTheSegment1, endingOfTheSegment1);

            Segment segment2 = new Segment(beginningOfTheSegment2, endingOfTheSegment2);

            Segment segment3 = new Segment(beginningOfTheSegment3, endingOfTheSegment3);

            Segment segment4 = new Segment(beginningOfTheSegment4, endingOfTheSegment4);

            Segment segment5 = new Segment(beginningOfTheSegment5, endingOfTheSegment5);

            Segment segment6 = new Segment(beginningOfTheSegment6, endingOfTheSegment6);

            Segment segment7 = new Segment(beginningOfTheSegment7, endingOfTheSegment7);

            Segment segment8 = new Segment(beginningOfTheSegment8, endingOfTheSegment8);

            Segment[] segmentsOfTheField = null;
            segmentsOfTheField = new Segment[8];
            segmentsOfTheField[0] = segment1;
            segmentsOfTheField[1] = segment2;
            segmentsOfTheField[2] = segment3;
            segmentsOfTheField[3] = segment4;
            segmentsOfTheField[4] = segment5;
            segmentsOfTheField[5] = segment6;
            segmentsOfTheField[6] = segment7;
            segmentsOfTheField[7] = segment8;

            display.mapCreated();
            Map map = new Map(segmentsOfTheField, segmentWhereTheBallCanBeReleased);

            String nameOfThePlayerPlaying = "toto";

            MovingBall ball = new MovingBall(radiusOfTheBallWanted, centerOfTheBallWanted, speedOfTheBall);

            RollingBallGame theGame = new RollingBallGame(display, player, nameOfThePlayerPlaying, map, ball);
            theGame.play();
        }
        catch (SamePointException e)
        {
            e.printStackTrace();
        }
    }
}