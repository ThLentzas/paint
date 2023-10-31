import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JPanel;


public class Canvas extends JPanel {
    private Menu menu;
    private Stack<ArrayList> listStack = new Stack<>();
    private Stack<Shape> shapeStack = new Stack<>();
    private Point startingPoint;
    private Color borderColor;
    private Color fillColor;
    private Point clickedPoint;
    private Point startingCopyPoint;
    private Point newPoint;
    private Shape clickedShape;
    private Shape currentShape;
    private Shape copyShape;
    private Shape tmpShape;
    private Shape draggedShape;
    private Shape resizedShape;
    private ArrayList<Point> groupResizePoints = new ArrayList<>();
    private ArrayList<Point> groupMovePoints = new ArrayList<>();
    private ArrayList<Shape> groupShapesRestored = new ArrayList<>();
    private String shapeSelected;
    private int tmpAction = 0;

    public Canvas(Menu menu) {
        this.menu = menu;
        shapeSelected = null;
        currentShape = null;
        copyShape = null;
        tmpShape = null;
        draggedShape = null;
        resizedShape = null;
        addMouseListener(new DrawingListener());
        addMouseMotionListener(new DrawingListener());
        menu.canvas = this;
    }

    class DrawingListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            startingPoint = new Point(e.getX(), e.getY());
            clickedPoint = new Point(e.getX(), e.getY());

            //Not nulling it causes problem with delete after copy being called
            clickedShape = null;
            clickedShape = shapeClicked(clickedPoint);
            currentShape = null;

            //Copy being called
            if (menu.isCopyClicked()) {
                menu.setShapeSelected(null);
                if (Menu.getGroupList().size() != 0 && !menu.isGroupClicked()) {
                    Point minPoint = Menu.getShapeList().get(0).startingPoint;

                    //We use the shape with the smallest starting point
                    for (Shape a : Menu.getShapeList()) {
                        if (a.startingPoint.x < minPoint.x)
                            minPoint = a.startingPoint;
                    }

                    int distX = clickedPoint.x - minPoint.x;
                    int distY = clickedPoint.y - minPoint.y;

                    for (Shape shape : Menu.getGroupList()) {
                        Point groupStartingPoint = new Point(
                                shape.startingPoint.x + distX,
                                shape.startingPoint.y + distY);
                        Point groupEndingPoint = new Point(
                                shape.endingPoint.x + distX,
                                shape.endingPoint.y + distY);

                        if (shape instanceof Line) {
                            copyShape = new Line(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Line) shape).getBorderColor()
                            );
                        }
                        if (shape instanceof Oval) {
                            copyShape = new Oval(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Oval) shape).getBorderColor(),
                                    ((Oval) shape).getFillColor()
                            );
                        }
                        if (shape instanceof Rectangle) {
                            copyShape = new Rectangle(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Rectangle) shape).getBorderColor(),
                                    ((Rectangle) shape).getFillColor()
                            );
                        }
                        if (shape instanceof Square) {
                            copyShape = new Square(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Square) shape).getBorderColor(),
                                    ((Square) shape).getFillColor()
                            );
                        }
                        if (shape instanceof Circle) {
                            copyShape = new Circle(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Circle) shape).getBorderColor(),
                                    ((Circle) shape).getFillColor()
                            );
                        }
                        if (shape instanceof Triangle) {
                            copyShape = new Triangle(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Triangle) shape).getBorderColor(),
                                    ((Triangle) shape).getFillColor()
                            );
                        }
                        if (shape instanceof RightTriangle) {
                            copyShape = new RightTriangle(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((RightTriangle) shape).getBorderColor(),
                                    ((RightTriangle) shape).getFillColor()
                            );
                        }
                        if (shape instanceof Parallelogram) {
                            copyShape = new Parallelogram(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Parallelogram) shape).getBorderColor(),
                                    ((Parallelogram) shape).getFillColor()
                            );
                        }
                        if (shape instanceof Rhombus) {
                            copyShape = new Rhombus(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Rhombus) shape).getBorderColor(),
                                    ((Rhombus) shape).getFillColor()
                            );
                        }
                        if (shape instanceof Polygon) {
                            copyShape = new Polygon(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Polygon) shape).getBorderColor(),
                                    ((Polygon) shape).getFillColor()
                            );
                        }
                        if (shape instanceof Line) {
                            copyShape = new Line(groupStartingPoint, groupEndingPoint, ((Line) shape).getBorderColor());
                        }
                        if (shape instanceof Oval) {
                            copyShape = new Oval(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Oval) shape).getBorderColor(),
                                    ((Oval) shape).getFillColor()
                            );
                        }
                        if (shape instanceof Rectangle) {
                            copyShape = new Rectangle(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Rectangle) shape).getBorderColor(),
                                    ((Rectangle) shape).getFillColor()
                            );
                        }
                        if (shape instanceof Square) {
                            copyShape = new Square(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Square) shape).getBorderColor(),
                                    ((Square) shape).getFillColor()
                            );
                        }
                        if (shape instanceof Circle) {
                            copyShape = new Circle(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Circle) shape).getBorderColor(),
                                    ((Circle) shape).getFillColor()
                            );
                        }
                        if (shape instanceof Triangle) {
                            copyShape = new Triangle(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Triangle) shape).getBorderColor(),
                                    ((Triangle) shape).getFillColor()
                            );
                        }
                        if (shape instanceof RightTriangle) {
                            copyShape = new RightTriangle(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((RightTriangle) shape).getBorderColor(),
                                    ((RightTriangle) shape).getFillColor()
                            );
                        }
                        if (shape instanceof Parallelogram) {
                            copyShape = new Parallelogram(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Parallelogram) shape).getBorderColor(),
                                    ((Parallelogram) shape).getFillColor()
                            );
                        }
                        if (shape instanceof Rhombus) {
                            copyShape = new Rhombus(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Rhombus) shape).getBorderColor(),
                                    ((Rhombus) shape).getFillColor()
                            );
                        }
                        if (shape instanceof Polygon) {
                            copyShape = new Polygon(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Polygon) shape).getBorderColor(),
                                    ((Polygon) shape).getFillColor()
                            );
                        }
                        if (shape instanceof Hexagon) {
                            copyShape = new Hexagon(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Hexagon) shape).getBorderColor(),
                                    ((Hexagon) shape).getFillColor()
                            );
                        }
                        if (shape instanceof Star) {
                            copyShape = new Star(
                                    groupStartingPoint,
                                    groupEndingPoint,
                                    ((Star) shape).getBorderColor(),
                                    ((Star) shape).getFillColor()
                            );
                        }

                        Menu.getShapeList().add(copyShape);
                    }
                    menu.setCopySelected(false);
                    menu.action++;
                } else {
                    if (tmpShape != null && clickedPoint != null) {
                        int distX = (tmpShape.endingPoint.x - tmpShape.startingPoint.x);
                        int distY = (tmpShape.endingPoint.y - tmpShape.startingPoint.y);
                        //We need the distance between the two points of the selected shape to find the ending point of the copy
                        newPoint = new Point(clickedPoint.x + distX, clickedPoint.y + distY);

                        if (tmpShape instanceof Line) {
                            copyShape = new Line(
                                    clickedPoint,
                                    newPoint,
                                    ((Line) tmpShape).getBorderColor()
                            );
                        }
                        if (tmpShape instanceof Oval) {
                            copyShape = new Oval(
                                    clickedPoint,
                                    newPoint,
                                    ((Oval) tmpShape).getBorderColor(),
                                    ((Oval) tmpShape).getFillColor()
                            );
                        }
                        if (tmpShape instanceof Rectangle) {
                            copyShape = new Rectangle(
                                    clickedPoint,
                                    newPoint,
                                    ((Rectangle) tmpShape).getBorderColor(),
                                    ((Rectangle) tmpShape).getFillColor()
                            );
                        }
                        if (tmpShape instanceof Square) {
                            copyShape = new Square(
                                    clickedPoint,
                                    newPoint,
                                    ((Square) tmpShape).getBorderColor(),
                                    ((Square) tmpShape).getFillColor()
                            );
                        }
                        if (tmpShape instanceof Circle) {
                            copyShape = new Circle(
                                    clickedPoint,
                                    newPoint,
                                    ((Circle) tmpShape).getBorderColor(),
                                    ((Circle) tmpShape).getFillColor()
                            );
                        }
                        if (tmpShape instanceof Triangle) {
                            copyShape = new Triangle(
                                    clickedPoint,
                                    newPoint,
                                    ((Triangle) tmpShape).getBorderColor(),
                                    ((Triangle) tmpShape).getFillColor()
                            );
                        }
                        if (tmpShape instanceof RightTriangle) {
                            copyShape = new RightTriangle(
                                    clickedPoint,
                                    newPoint,
                                    ((RightTriangle) tmpShape).getBorderColor(),
                                    ((RightTriangle) tmpShape).getFillColor()
                            );
                        }
                        if (tmpShape instanceof Parallelogram) {
                            copyShape = new Parallelogram(
                                    clickedPoint,
                                    newPoint,
                                    ((Parallelogram) tmpShape).getBorderColor(),
                                    ((Parallelogram) tmpShape).getFillColor()
                            );
                        }
                        if (tmpShape instanceof Rhombus) {
                            copyShape = new Rhombus(
                                    clickedPoint,
                                    newPoint,
                                    ((Rhombus) tmpShape).getBorderColor(),
                                    ((Rhombus) tmpShape).getFillColor()
                            );
                        }
                        if (tmpShape instanceof Polygon) {
                            copyShape = new Polygon(
                                    clickedPoint,
                                    newPoint,
                                    ((Polygon) tmpShape).getBorderColor(),
                                    ((Polygon) tmpShape).getFillColor()
                            );
                        }
                        if (tmpShape instanceof Hexagon) {
                            copyShape = new Hexagon(
                                    clickedPoint,
                                    newPoint,
                                    ((Hexagon) tmpShape).getBorderColor(),
                                    ((Hexagon) tmpShape).getFillColor()
                            );
                        }
                        if (tmpShape instanceof Star) {
                            copyShape = new Star(
                                    clickedPoint,
                                    newPoint,
                                    ((Star) tmpShape).getBorderColor(),
                                    ((Star) tmpShape).getFillColor()
                            );
                        }

                        menu.setCopySelected(false);
                        Menu.getShapeList().add(copyShape);
                        tmpShape = null;
                        menu.action++;
                    }
                }
                //User selects the shape to be copied
                if (clickedShape != null) {
                    tmpShape = clickedShape;
                }
            }

            if (menu.isMoveClicked())
                menu.setShapeSelected(null);

            if (menu.isResizeClicked())
                menu.setShapeSelected(null);

            if (menu.isGroupClicked()) {
                menu.setShapeSelected(null);
                if (clickedShape != null) {
                    Menu.getGroupList().add(clickedShape);
                }
            }
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Point endingPoint = new Point(e.getX(), e.getY());
            shapeSelected = menu.getShapeSelected();

            if (shapeSelected != null) {
                if (shapeSelected.equals("Line")) {
                    currentShape = new Line(startingPoint, endingPoint, borderColor);
                }
                if (shapeSelected.equals("Oval")) {
                    currentShape = new Oval(startingPoint, endingPoint, borderColor, fillColor);
                }
                if (shapeSelected.equals("Rectangle")) {
                    currentShape = new Rectangle(startingPoint, endingPoint, borderColor, fillColor);
                }
                if (shapeSelected.equals("Square")) {
                    currentShape = new Square(startingPoint, endingPoint, borderColor, fillColor);
                }
                if (shapeSelected.equals("Circle")) {
                    currentShape = new Circle(startingPoint, endingPoint, borderColor, fillColor);
                }
                if (shapeSelected.equals("Triangle")) {
                    currentShape = new Triangle(startingPoint, endingPoint, borderColor, fillColor);
                }
                if (shapeSelected.equals("Right triangle")) {
                    currentShape = new RightTriangle(startingPoint, endingPoint, borderColor, fillColor);
                }
                if (shapeSelected.equals("Parallelogram")) {
                    currentShape = new Parallelogram(startingPoint, endingPoint, borderColor, fillColor);
                }
                if (shapeSelected.equals("Rhombus")) {
                    currentShape = new Rhombus(startingPoint, endingPoint, borderColor, fillColor);
                }
                if (shapeSelected.equals("Polygon")) {
                    currentShape = new Polygon(startingPoint, endingPoint, borderColor, fillColor);
                }
                if (shapeSelected.equals("Hexagon")) {
                    currentShape = new Hexagon(startingPoint, endingPoint, borderColor, fillColor);
                }
                if (shapeSelected.equals("Star")) {
                    currentShape = new Star(startingPoint, endingPoint, borderColor, fillColor);
                }
            }

            shapeSelected = null;

            //Move being called.Exactly the same logic as copy but for move we use set instead of new
            if (menu.isMoveClicked()) {
                menu.setShapeSelected(null);

                if (Menu.getGroupList().size() != 0 && !menu.isGroupClicked()) {
                    //Grouped shapes being moved
                    if (groupMovePoints.size() == 0) {
                        for (Shape s : Menu.getGroupList()) {
                            //Calculating the distance of each point from the current point
                            int startDistX = endingPoint.x - s.startingPoint.x;
                            int startDistY = endingPoint.y - s.startingPoint.y;
                            int endDistX = endingPoint.x - s.endingPoint.x;
                            int endDistY = endingPoint.y - s.endingPoint.y;

                            //All starting points are even numbers on the list
                            //All ending points are odd numbers on the list
                            groupMovePoints.add(new Point(startDistX, startDistY));
                            groupMovePoints.add(new Point(endDistX, endDistY));
                        }
                    }
                    //1 shape in the groupList 2 points in the Move points list
                    //The even points are on the 0, 2, 4... The odd points are on the 1, 3, 5... position of the array List
                    for (int i = 0; i < Menu.getGroupList().size(); i++) {
                        Point groupStartingPoint = new Point(
                                endingPoint.x - groupMovePoints.get(2 * i).x,
                                endingPoint.y - groupMovePoints.get(2 * i).y);
                        Point groupEndingPoint = new Point(endingPoint.x - groupMovePoints.get(2 * i + 1).x,
                                endingPoint.y - groupMovePoints.get(2 * i + 1).y);

                        Menu.getGroupList().get(i).setStartingPoint(groupStartingPoint);
                        Menu.getGroupList().get(i).setEndingPoint(groupEndingPoint);
                    }
                } else {
                    draggedShape = clickedShape;

                    if (draggedShape != null) {
                        int distX = (draggedShape.endingPoint.x - draggedShape.startingPoint.x);
                        int disty = (draggedShape.endingPoint.y - draggedShape.startingPoint.y);
                        Point currentEndingPoint = new Point(e.getX() + distX, e.getY() + disty);

                        draggedShape.setStartingPoint(endingPoint);
                        draggedShape.setEndingPoint(currentEndingPoint);
                    }
                    menu.action++;
                }
            }

            if (menu.isResizeClicked()) {
                menu.setShapeSelected(null);

                if (Menu.getGroupList().size() != 0 && !menu.isGroupClicked()) {
                    if (groupResizePoints.size() == 0) {
                        for (Shape s : Menu.getGroupList()) {
                            int endDistX = endingPoint.x - s.endingPoint.x;
                            int endDistY = endingPoint.y - s.endingPoint.y;
                            groupResizePoints.add(new Point(endDistX, endDistY));
                        }
                    }
                    for (int i = 0; i < groupResizePoints.size(); i++) {
                        Point groupEndingPoint = new Point(
                                endingPoint.x - groupResizePoints.get(i).x,
                                endingPoint.y - groupResizePoints.get(i).y);
                        Menu.getGroupList().get(i).setEndingPoint(groupEndingPoint);
                    }

                } else {
                    resizedShape = clickedShape;
                    if (resizedShape != null) {
                        Point newEndingPoint = new Point(e.getX(), e.getY());
                        resizedShape.setEndingPoint(newEndingPoint);
                    }
                }
                menu.action++;
            }
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            startingPoint = null;
            draggedShape = null;
            resizedShape = null;

            menu.setMoveClicked(false);
            menu.setResizeClicked(false);

            if (currentShape != null) {
                Menu.getShapeList().add(currentShape);
                //shapeColors(currentShape);
                menu.action++;
            }

            if (!groupResizePoints.isEmpty())
                groupResizePoints.clear();

            if (!groupMovePoints.isEmpty())
                groupMovePoints.clear();

            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g1 = (Graphics2D) g;

        borderColor = menu.getTmpColor();
        boolean deleteSelected = menu.isDeleteClicked();
        boolean undoSelected = menu.isUndoClicked();
        boolean loadSelected = menu.isOpenFile();
        boolean clearSelected = menu.isClearClicked();
        boolean fillPaintSelected = menu.isFillPaintClicked();
        g1.setStroke(new BasicStroke(3));
        //Makes the objects smoother
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g1.setRenderingHints(rh);
        //Case:Method was clicked and there is no shape in the canvas
        if (Menu.getShapeList().isEmpty()) {
            menu.setCopySelected(false);
            menu.setMoveClicked(false);
            menu.setResizeClicked(false);
            menu.setDeleteClicked(false);
            menu.setGroupClicked(false);
        }

        //Case:Undo is clicked and there is nothing to undo
        if (undoSelected && shapeStack.isEmpty()) {
            menu.setUndoClicked(false);
        }

        if (undoSelected && listStack.isEmpty()) {
            menu.setUndoClicked(false);
        }

        if (currentShape != null) {
            currentShape.drawShape(g1, currentShape.startingPoint, currentShape.endingPoint);
        }

        if (copyShape != null) {
            copyShape.drawShape(g1, copyShape.startingPoint, copyShape.endingPoint);
        }

        if (draggedShape != null) {
            draggedShape.drawShape(g1, draggedShape.startingPoint, draggedShape.endingPoint);
        }

        if (loadSelected) {
            load();
            menu.setOpenFile(false);
        }

        if (deleteSelected) {
            delete();

            menu.action++;
            menu.setDeleteClicked(false);
            menu.setShapeSelected(null);

            currentShape = null;
            copyShape = null;
        }

        if (undoSelected) {
            undo();
            menu.action++;
            menu.setUndoClicked(false);
            currentShape = null;
        }

        if (clearSelected) {
            clearCanvas();

            menu.setShapeSelected(null);
            menu.setClearClicked(false);
            currentShape = null;
            copyShape = null;

            repaint();
        }

        if (fillPaintSelected) {
            menu.setShapeSelected(null);
            if (borderColor != null && clickedShape != null) {
                clickedShape.setFillColor(borderColor);
            }
        }

        for (Shape s : Menu.getShapeList()) {
            drawingShape(g1, s);
        }
    }

    public void drawingShape(Graphics g, Shape s) {
        s.drawShape(g, s.startingPoint, s.endingPoint);
    }

    public ArrayList<Shape> getGroupShapesRestored() {
        return groupShapesRestored;
    }

    public Stack<ArrayList> getListStack() {
        return listStack;
    }

    public void freePaint() {
        repaint();
    }

    public void remove(Shape s) {
        Menu.getShapeList().remove(s);
    }

    public void defaultCursor() {
        setCursor(null);
    }

    public void load() {
        ObjectInputStream in;
        Shape s;

        try {
            in = new ObjectInputStream(new FileInputStream("Shapes.txt"));

            while ((s = (Shape) in.readObject()) != null) {
                Menu.getShapeList().add(s);
            }

        } catch (EOFException eof) {
            return;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public void delete() {
        if (Menu.getGroupList().size() != 0 && !menu.isGroupClicked()) {
            menu.setShapeSelected(null);

            for (Shape s : Menu.getGroupList()) {
                remove(s);
                groupShapesRestored.add(s);
            }
            listStack.push(groupShapesRestored);
        } else {
            if (clickedShape != null) {
                Menu.getShapeList().remove(clickedShape);
                shapeStack.push(clickedShape);
            }
        }
        repaint();
    }

    public Shape shapeClicked(Point point) {
        Shape q = null;

        for (Shape s : Menu.getShapeList()) {
            if (s.contains(point)) {
                q = s;
                break;
            }
        }
        return q;
    }

    public void undo() {
        if (listStack.size() > 0 && groupShapesRestored.size() != 0) {
            for (Object s : listStack.pop())
                Menu.getShapeList().add((Shape) s);
        } else {
            singleUndo();
        }
    }

    public void clearCanvas() {
        if (!Menu.getShapeList().isEmpty()) {
            Menu.getShapeList().clear();
            menu.action++;
        }
    }

    public void singleUndo() {
        if (shapeStack.size() > 0) {
            Menu.getShapeList().add(shapeStack.pop());
        }
    }

    public void customCursor() {
        Toolkit t1 = Toolkit.getDefaultToolkit();
        Image img = t1.getImage("icons\\FillColor.png");
        Point point = new Point(0, 0);
        Cursor cursor = t1.createCustomCursor(img, point, "Cursor");
        setCursor(cursor);
    }
}
















