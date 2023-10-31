import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Rhombus extends Shape{
    private final int[] rhombusArrayX = new int[4];
    private final int[] rhombusArrayY = new int[4];

    public Rhombus(Point start, Point end, Color borderColor, Color fillColor) {
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

        rhombusArrayX[0] = startingPoint.x + (Math.abs(startingPoint.x - endingPoint.x) / 2);
        rhombusArrayX[1] = endingPoint.x;
        rhombusArrayX[2] = startingPoint.x + (Math.abs(startingPoint.x - endingPoint.x) / 2);
        rhombusArrayX[3] = startingPoint.x;

        rhombusArrayY[0] = startingPoint.y;
        rhombusArrayY[1] = startingPoint.y + Math.abs(startingPoint.y - endingPoint.y) / 2;
        rhombusArrayY[2] = endingPoint.y;
        rhombusArrayY[3] = startingPoint.y + Math.abs(startingPoint.y - endingPoint.y) / 2;

        if (borderColor == null) {
            borderColor = Color.black;
            g.setColor(Color.black);
        } else {
            g.setColor(borderColor);
        }
        g.drawPolygon(rhombusArrayX, rhombusArrayY, 4);

        if (fillColor != null) {
            g.setColor(fillColor);
            g.fillPolygon(rhombusArrayX, rhombusArrayY, 4);
            g.setColor(borderColor);
            g.drawPolygon(rhombusArrayX, rhombusArrayY, 4);
        }
    }
}


