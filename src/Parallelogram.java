import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Parallelogram extends Shape{
    private final int[] parallelogramArrayX = new int[4];
    private final int[] parallelogramArrayY = new int[4];
    public Parallelogram(Point start, Point end, Color borderColor, Color fillColor) {
        super(start, end, borderColor, fillColor);
    }

    @Override
    public boolean contains(Point pointClicked) {
        return (pointClicked.x > startingPoint.x && pointClicked.x < endingPoint.x && pointClicked.y > startingPoint.y && pointClicked.y < endingPoint.y)
                || (pointClicked.x > startingPoint.x && pointClicked.x < endingPoint.x && pointClicked.y < startingPoint.y && pointClicked.y > endingPoint.y)
                || (pointClicked.x < startingPoint.x && pointClicked.x > endingPoint.x && pointClicked.y < startingPoint.y && pointClicked.y > endingPoint.y)
                || (pointClicked.x < startingPoint.x && pointClicked.x > endingPoint.x && pointClicked.y > startingPoint.y && pointClicked.y < endingPoint.y);
    }

    @Override
    public void drawShape(Graphics g, Point startingPoint, Point endingPoint) {

        parallelogramArrayX[0] = startingPoint.x + 7 * (Math.abs(startingPoint.x - endingPoint.x) / 14);
        parallelogramArrayX[1] = endingPoint.x + 3 * (Math.abs(startingPoint.x - endingPoint.x) / 8);
        parallelogramArrayX[2] = endingPoint.x - (Math.abs(startingPoint.x - endingPoint.x) / 12);
        parallelogramArrayX[3] = startingPoint.x;

        parallelogramArrayY[0] = startingPoint.y;
        parallelogramArrayY[1] = startingPoint.y;
        parallelogramArrayY[2] = endingPoint.y;
        parallelogramArrayY[3] = endingPoint.y;

        if (borderColor == null) {
            borderColor = Color.black;
            g.setColor(Color.black);
        } else {
            g.setColor(borderColor);
        }
        g.drawPolygon(parallelogramArrayX, parallelogramArrayY, 4);

        if (fillColor != null) {
            g.setColor(fillColor);
            g.fillPolygon(parallelogramArrayX, parallelogramArrayY, 4);
            g.setColor(borderColor);
            g.drawPolygon(parallelogramArrayX, parallelogramArrayY, 4);
        }
    }
}

