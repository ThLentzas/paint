import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Polygon extends Shape {
    private final int[] polygonArrayX = new int[5];
    private final int[] polygonArrayY = new int[5];

    public Polygon(Point start, Point end, Color borderColor, Color fillColor) {
        super(start, end, borderColor, fillColor);
    }

    @Override
    public boolean contains(Point pointClicked) {
        return (pointClicked.x > startingPoint.x && pointClicked.x < endingPoint.x && pointClicked.y > startingPoint.y && pointClicked.y < endingPoint.y)
                || (pointClicked.x > startingPoint.x && pointClicked.x < endingPoint.x && pointClicked.y < startingPoint.y && pointClicked.y > endingPoint.y) ||
                (pointClicked.x < startingPoint.x && pointClicked.x > endingPoint.x && pointClicked.y < startingPoint.y && pointClicked.y > endingPoint.y)
                || (pointClicked.x < startingPoint.x && pointClicked.x > endingPoint.x && pointClicked.y > startingPoint.y && pointClicked.y < endingPoint.y);}


    @Override
    public void drawShape(Graphics g, Point startingPoint, Point endingPoint) {
        polygonArrayX[0] = startingPoint.x + (Math.abs(startingPoint.x - endingPoint.x) / 2);
        polygonArrayX[1] = endingPoint.x - (Math.abs(startingPoint.x - endingPoint.x) / 8); ;
        polygonArrayX[2] = endingPoint.x - (Math.abs(startingPoint.x - endingPoint.x) / 4);
        polygonArrayX[3] = startingPoint.x + (Math.abs(startingPoint.x - endingPoint.x) / 4) ;
        polygonArrayX[4] = startingPoint.x + (Math.abs(startingPoint.x - endingPoint.x) / 8);;

        polygonArrayY[0] = startingPoint.y;
        polygonArrayY[1] = startingPoint.y + Math.abs(startingPoint.y - endingPoint.y) / 3;
        polygonArrayY[2] = endingPoint.y;
        polygonArrayY[3] = endingPoint.y;
        polygonArrayY[4] = startingPoint.y + Math.abs(startingPoint.y - endingPoint.y) / 3;

        if(borderColor == null) {
            borderColor = Color.black;
            g.setColor(Color.black);
        } else {
            g.setColor(borderColor);
        }
        g.drawPolygon(polygonArrayX, polygonArrayY, 5);

        if(fillColor != null) {
            g.setColor(fillColor);
            g.fillPolygon(polygonArrayX, polygonArrayY, 5);
            g.setColor(borderColor);
            g.drawPolygon(polygonArrayX, polygonArrayY, 5);
        }
    }
}
