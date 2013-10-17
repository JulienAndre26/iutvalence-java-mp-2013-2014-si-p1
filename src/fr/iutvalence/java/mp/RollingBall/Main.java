package fr.iutvalence.java.mp.RollingBall;

/**
 * 
 * main class of the rollingball game
 * @author andrejul
 *
 */
public class Main
{ 
    /**
     * start a play of the rollingball game
     * @param args undefined reference 
     */
    public static void main(String[] args)
    {
        boolean physicalOrNot = false;
        Point beginingOfTheSegment = new Point(50,50);
        Point endingOfTheSegment = new Point(50,100);

        Segment segmentWhereTheBallCanBeReleased = new Segment(beginingOfTheSegment, 
                endingOfTheSegment, physicalOrNot);

        boolean physicalOrNot1 = true;
        Point beginingOfTheSegment1 = new Point(0,0);
        Point endingOfTheSegment1 = new Point(100,0);

        Segment segment1 = new Segment(
                beginingOfTheSegment1, endingOfTheSegment1, physicalOrNot1);

        Segment[] segmentsOfTheField = null;
        segmentsOfTheField = new Segment[1];
        segmentsOfTheField[0] = segment1;

        Map map = new Map(segmentsOfTheField, segmentWhereTheBallCanBeReleased);

        Point centerOfTheBallWanted = beginingOfTheSegment;
        int radiusOfTheBallWanted = 10;
        Ball ball = new Ball(radiusOfTheBallWanted, centerOfTheBallWanted);

        String nameOfThePlayerPlaying = "toto";

        new RollingBall(nameOfThePlayerPlaying, map, ball).play();
        System.out.print("kikou");
    }

}
