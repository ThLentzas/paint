import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class RightTriangle extends Shape {
    private final int[] triangleArrayX = new int[3];
    private final int[] triangleArrayY = new int[3];

    public RightTriangle(Point start, Point end, Color borderColor, Color fillColor) {
        super(start, end, borderColor, fillColor);
    }

    @Override
    public boolean contains(Point pointClicked) {
        return (pointClicked.x > startingPoint.x && pointClicked.x < endingPoint.x && pointClicked.y > startingPoint.y && pointClicked.y < endingPoint.y)
                || (pointClicked.x > startingPoint.x && pointClicked.x < endingPoint.x && pointClicked.y < startingPoint.y && pointClicked.y > endingPoint.y)
                || (pointClicked.x < startingPoint.x && pointClicked.x > endingPoint.x && pointClicked.y < startingPoint.y && pointClicked.y > endingPoint.y)
                || (pointClicked.x < startingPoint.x && pointClicked.x > endingPoint.x && pointClicked.y > startingPoint.y && pointClicked.y < endingPoint.y);}


    @Override
    public void drawShape(Graphics g, Point startingPoint, Point endingPoint) {
        triangleArrayX[0] = startingPoint.x;
        triangleArrayX[1] = endingPoint.x;
        triangleArrayX[2] = startingPoint.x;

        triangleArrayY[0] = startingPoint.y;
        triangleArrayY[1] = endingPoint.y;
        triangleArrayY[2] = endingPoint.y;

        if(borderColor == null) {
            borderColor = Color.black;
            g.setColor(Color.black);
        } else {
            g.setColor(borderColor);
        }
        g.drawPolygon(triangleArrayX, triangleArrayY, 3);

        if(fillColor != null) {
            g.setColor(fillColor);
            g.fillPolygon(triangleArrayX, triangleArrayY, 3);
            g.setColor(borderColor);
            g.drawPolygon(triangleArrayX, triangleArrayY, 3);
        }
    }
}

