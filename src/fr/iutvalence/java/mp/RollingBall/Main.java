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

        int lengthOfTheSegment = 20;
        boolean physicalOrNot = true;
        int angleOfTheSegment = 270;
        Point pointOfTheBeginnigOfTheSegment = new Point(50,50);
        
        Segment segmentWhereTheBallCanBeReleased = new Segment(pointOfTheBeginnigOfTheSegment, 
                lengthOfTheSegment, angleOfTheSegment, physicalOrNot);
        
        int lengthOfTheSegment1 = 100;
        boolean physicalOrNot1 = true;
        int angleOfTheSegment1 = 0;
        Point pointOfTheBeginnigOfTheSegment1 = new Point(0,0);
        
        Segment segment1 = new Segment(
                pointOfTheBeginnigOfTheSegment1, lengthOfTheSegment1, 
                angleOfTheSegment1, physicalOrNot1);
        
        Segment[] segmentsOfTheField = null;
        segmentsOfTheField = new Segment[1];
        segmentsOfTheField[0] = segment1;
        
        Map map = new Map(segmentsOfTheField, segmentWhereTheBallCanBeReleased);
       
        Point centerOfTheBallWanted = pointOfTheBeginnigOfTheSegment;
        int radiusOfTheBallWanted = 10;
        Ball ball = new Ball(radiusOfTheBallWanted, centerOfTheBallWanted);
        
        String nameOfThePlayerPlaying = "toto";
        
        new RollingBall(nameOfThePlayerPlaying, map, ball).play();
        System.out.print("kikou");
    }

}
