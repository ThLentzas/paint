import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Star extends Shape {
    private final int[] starArrayX = new int[10];
    private final int[] starArrayY = new int[10];

    public Star(Point start, Point end, Color borderColor, Color fillColor) {
        super(start, end, borderColor, fillColor);
    }

    @Override
    public boolean contains(Point pointClicked) {
        // All possibilities in 4 quaternions
        return (pointClicked.x > startingPoint.x && pointClicked.x < endingPoint.x && pointClicked.y > startingPoint.y && pointClicked.y < endingPoint.y)
                || (pointClicked.x > startingPoint.x && pointClicked.x < endingPoint.x && pointClicked.y < startingPoint.y && pointClicked.y > endingPoint.y) ||
                (pointClicked.x < startingPoint.x && pointClicked.x > endingPoint.x && pointClicked.y < startingPoint.y && pointClicked.y > endingPoint.y)
                || (pointClicked.x < startingPoint.x && pointClicked.x > endingPoint.x && pointClicked.y > startingPoint.y && pointClicked.y < endingPoint.y);}

    @Override
    public void drawShape(Graphics g, Point startingPoint, Point endingPoint) {

        int xDifference = endingPoint.x - startingPoint.x;
        int yDifference = endingPoint.y - startingPoint.y;

        starArrayX[0] = startingPoint.x + (xDifference / 2);
        starArrayX[1] = startingPoint.x + ((13 * xDifference) / 20);
        starArrayX[2] = startingPoint.x + xDifference;
        starArrayX[3] = startingPoint.x + ((7 * xDifference) / 10);
        starArrayX[4] = startingPoint.x + ((8 * xDifference) / 10);
        starArrayX[5] = startingPoint.x + (xDifference / 2);
        starArrayX[6] = startingPoint.x + ((2 * xDifference) / 10);
        starArrayX[7] = startingPoint.x + ((3 * xDifference) / 10);
        starArrayX[8] = startingPoint.x;
        starArrayX[9] = startingPoint.x + ((7 * xDifference) / 20);

        starArrayY[0] = startingPoint.y;
        starArrayY[1] = startingPoint.y + ((4 * yDifference) / 10);
        starArrayY[2] = startingPoint.y + ((4 * yDifference) / 10);
        starArrayY[3] = startingPoint.y + ((6 * yDifference) / 10);
        starArrayY[4] = startingPoint.y + yDifference;
        starArrayY[5] = startingPoint.y + ((8 * yDifference) / 10);
        starArrayY[6] = startingPoint.y + yDifference;
        starArrayY[7] = startingPoint.y + ((6 * yDifference) / 10);
        starArrayY[8] = startingPoint.y + ((4 * yDifference) / 10);
        starArrayY[9] = startingPoint.y + ((4 * yDifference) / 10);

        if(borderColor == null) {
            borderColor = Color.black;
            g.setColor(Color.black);
        }
        else {
            g.setColor(borderColor);
        }
        g.drawPolygon(starArrayX, starArrayY, 10);

        if(fillColor != null) {
            g.setColor(fillColor);
            g.fillPolygon(starArrayX, starArrayY, 10);
            g.setColor(borderColor);
            g.drawPolygon(starArrayX, starArrayY, 10);
        }
    }
}
