import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Circle extends Shape{

    public Circle(Point start, Point end, Color borderColor,  Color fillColor) {
        super(start, end, borderColor, fillColor);
    }

    @Override
    public boolean contains(Point pointClicked) {
        // All possibilities in 4 quaternions
        return (pointClicked.x > startingPoint.x && pointClicked.x < endingPoint.x && pointClicked.y > startingPoint.y && pointClicked.y < endingPoint.y)
                || (pointClicked.x > startingPoint.x && pointClicked.x < endingPoint.x && pointClicked.y < startingPoint.y && pointClicked.y > endingPoint.y) ||
                (pointClicked.x < startingPoint.x && pointClicked.x > endingPoint.x && pointClicked.y < startingPoint.y && pointClicked.y > endingPoint.y)
                || (pointClicked.x < startingPoint.x && pointClicked.x > endingPoint.x && pointClicked.y > startingPoint.y && pointClicked.y < endingPoint.y);
    }

    @Override
    public void drawShape(Graphics g, Point start, Point end) {
        //Circle distance between two points
        int diameter = (int) Math.sqrt((end.y - start.y) * (end.y - start.y) + (start.x - end.x) *
                (start.x - end.x));
        int distX = Math.min(start.x, end.x);
        int distY = Math.min(start.y, end.y);

        if(borderColor == null) {;
            borderColor = Color.black;
            g.setColor(Color.black);
        }
        else {
            g.setColor(borderColor);
        }
        g.drawOval(distX, distY, diameter, diameter);

        if(fillColor != null) {
            g.setColor(fillColor);
            g.fillOval(distX, distY, diameter, diameter);
            g.setColor(borderColor);
            g.drawOval(distX, distY, diameter, diameter);
        }
    }
}

