import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public class Line extends Shape{

    public Line(Point start, Point end, Color borderColor) {
        super(start, end, borderColor, null);
    }

    @Override
    public boolean contains(Point pointClicked) {
        //<= Calculates even if you miss click and the point is very close to the line
        return (calculate(startingPoint, pointClicked) + calculate(endingPoint, pointClicked)
                <= calculate(startingPoint, endingPoint));
    }

    @Override
    public void drawShape(Graphics g, Point start, Point end) {
        if (borderColor == null) {
            borderColor = Color.black;
            g.setColor(Color.black);
        } else {
            g.setColor(borderColor);
        }
        g.drawLine(start.x, start.y, end.x, end.y);
    }

}
