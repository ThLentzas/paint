import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Rectangle extends Shape {
    public Rectangle(Point start, Point end, Color borderColor, Color fillColor) {
        super(start, end, borderColor, fillColor);
    }

    @Override
    public void drawShape(Graphics g, Point start, Point end) {
        int distX = Math.min(start.x, end.x);
        int distY = Math.min(start.y, end.y);
        int dist1 = Math.abs(start.x - end.x);
        int dist2 = Math.abs(start.y - end.y);


        //Weird interaction with how swing works when color is null
        if(borderColor == null) {
            g.setColor(Color.black);
        }
        else {
            g.setColor(borderColor);
        }
        g.drawRoundRect(distX, distY, dist1, dist2, 16, 16);
        if(fillColor != null) {
            g.setColor(fillColor);
            g.fillRoundRect(distX, distY, dist1, dist2, 16, 16);
            g.setColor(borderColor);
            g.drawRoundRect(distX, distY, dist1, dist2, 16, 16);
        }
    }
    // All possibilities in 4 quaternions
    public boolean contains(Point pointClicked) {
        return (pointClicked.x > startingPoint.x && pointClicked.x < endingPoint.x && pointClicked.y > startingPoint.y && pointClicked.y < endingPoint.y)
                || (pointClicked.x > startingPoint.x && pointClicked.x < endingPoint.x && pointClicked.y < startingPoint.y && pointClicked.y > endingPoint.y) ||
                (pointClicked.x < startingPoint.x && pointClicked.x > endingPoint.x && pointClicked.y < startingPoint.y && pointClicked.y > endingPoint.y)
                || (pointClicked.x < startingPoint.x && pointClicked.x > endingPoint.x && pointClicked.y > startingPoint.y && pointClicked.y < endingPoint.y);
    }

}
