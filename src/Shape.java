import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;


public abstract class Shape implements Serializable {
    protected Point startingPoint;
    protected Point endingPoint;
    protected Color borderColor;
    protected Color fillColor;

    public Shape(Point start, Point end, Color borderColor, Color fillColor) {
        startingPoint = start;
        endingPoint = end;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    public abstract boolean contains(Point pointClicked);

    public int calculate(Point startingPoint, Point endingPoint) {
        return (int)Math.sqrt((startingPoint.x - endingPoint.x) * (startingPoint.x - endingPoint.x)
                + (startingPoint.y - endingPoint.y) * (startingPoint.y - endingPoint.y));
    }

    public abstract void drawShape(Graphics g, Point startingPoint, Point endingPoint);

    public void setStartingPoint(Point startingPoint) {
        this.startingPoint = startingPoint;
    }
    public void setEndingPoint(Point endingPoint) {
        this.endingPoint = endingPoint;
    }
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
    public Color getBorderColor() { return borderColor; }
    public Color getFillColor() { return fillColor; }
}

