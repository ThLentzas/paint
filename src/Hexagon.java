import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Hexagon extends Shape {
    private final int[] hexagonArrayX = new int[6];
    private final int[] hexagonArrayY = new int[6];
    public Hexagon(Point start, Point end, Color borderColor, Color fillColor) {
        super(start, end, borderColor, fillColor);
    }

    @Override
    public boolean contains(Point pointClicked) {
        return (pointClicked.x > startingPoint.x && pointClicked.x < endingPoint.x && pointClicked.y > startingPoint.y && pointClicked.y < endingPoint.y)
                || (pointClicked.x > startingPoint.x && pointClicked.x < endingPoint.x && pointClicked.y < startingPoint.y && pointClicked.y > endingPoint.y) ||
                (pointClicked.x < startingPoint.x && pointClicked.x > endingPoint.x && pointClicked.y < startingPoint.y && pointClicked.y > endingPoint.y)
                || (pointClicked.x < startingPoint.x && pointClicked.x > endingPoint.x && pointClicked.y > startingPoint.y && pointClicked.y < endingPoint.y);
    }

    @Override
    public void drawShape(Graphics g, Point startingPoint, Point endingPoint) {
        hexagonArrayX[0] = startingPoint.x + (Math.abs(startingPoint.x - endingPoint.x) / 2);
        hexagonArrayX[1] = endingPoint.x;
        hexagonArrayX[2] = endingPoint.x;
        hexagonArrayX[3] = startingPoint.x + (Math.abs(startingPoint.x - endingPoint.x) / 2);
        hexagonArrayX[4] = startingPoint.x;
        hexagonArrayX[5] = startingPoint.x;

        hexagonArrayY[0] = startingPoint.y;
        hexagonArrayY[1] = startingPoint.y + Math.abs(startingPoint.y - endingPoint.y) / 3;
        hexagonArrayY[2] = startingPoint.y + 2 * (Math.abs(startingPoint.y - endingPoint.y) / 3);
        hexagonArrayY[3] = endingPoint.y;
        hexagonArrayY[4] = startingPoint.y + 2 * (Math.abs(startingPoint.y - endingPoint.y) / 3);
        hexagonArrayY[5] = startingPoint.y + Math.abs(startingPoint.y - endingPoint.y) / 3;

        if(borderColor == null) {
            borderColor = Color.black;
            g.setColor(Color.black);
        } else {
            g.setColor(borderColor);
        }
        g.drawPolygon(hexagonArrayX, hexagonArrayY, 6);

        if(fillColor != null) {
            g.setColor(fillColor);
            g.fillPolygon(hexagonArrayX, hexagonArrayY, 6);
            g.setColor(borderColor);
            g.drawPolygon(hexagonArrayX, hexagonArrayY, 6);
        }
    }
}
