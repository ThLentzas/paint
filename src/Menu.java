import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Menu extends JPanel {
    private final MainPanel mainPanel;
    private String shapeSelected;
    private static final ArrayList<Shape> shapeList = new ArrayList<>();
    private static final ArrayList<Shape> groupList = new ArrayList<>();
    private Color tmpColor = null;
    private boolean fillPaintClicked = false;
    private boolean openFile = false;
    private boolean copyClicked = false;
    private boolean moveClicked = false;
    private boolean resizeClicked = false;
    private boolean deleteClicked = false;
    private boolean undoClicked = false;
    private boolean groupClicked = false;
    private boolean clearClicked = false;
    public int action = 0;
    public Canvas canvas;

    public Menu(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        //Adding action listeners for each button
        mainPanel.getOpen().addActionListener(new ShapeClicked());
        mainPanel.getSave().addActionListener(new ShapeClicked());
        mainPanel.getLine().addActionListener(new ShapeClicked());
        mainPanel.getOval().addActionListener(new ShapeClicked());
        mainPanel.getCircle().addActionListener(new ShapeClicked());
        mainPanel.getRectangle().addActionListener(new ShapeClicked());
        mainPanel.getSquare().addActionListener(new ShapeClicked());
        mainPanel.getTriangle().addActionListener(new ShapeClicked());
        mainPanel.getRightTriangle().addActionListener(new ShapeClicked());
        mainPanel.getParallelogram().addActionListener(new ShapeClicked());
        mainPanel.getRhombus().addActionListener(new ShapeClicked());
        mainPanel.getPolygon().addActionListener(new ShapeClicked());
        mainPanel.getHexagon().addActionListener(new ShapeClicked());
        mainPanel.getStar().addActionListener(new ShapeClicked());
        mainPanel.getBlack().addActionListener(new ColorSelected());
        mainPanel.getGrey().addActionListener(new ColorSelected());
        mainPanel.getRed().addActionListener(new ColorSelected());
        mainPanel.getRuby().addActionListener(new ColorSelected());
        mainPanel.getOrange().addActionListener(new ColorSelected());
        mainPanel.getYellow().addActionListener(new ColorSelected());
        mainPanel.getGreen().addActionListener(new ColorSelected());
        mainPanel.getTurquoise().addActionListener(new ColorSelected());
        mainPanel.getBlue().addActionListener(new ColorSelected());
        mainPanel.getWhite().addActionListener(new ColorSelected());
        mainPanel.getLightGrey().addActionListener(new ColorSelected());
        mainPanel.getLightBrown().addActionListener(new ColorSelected());
        mainPanel.getPink().addActionListener(new ColorSelected());
        mainPanel.getCoral().addActionListener(new ColorSelected());
        mainPanel.getBlueGrey().addActionListener(new ColorSelected());
        mainPanel.getDarkSeaGreen().addActionListener(new ColorSelected());
        mainPanel.getViolet().addActionListener(new ColorSelected());
        mainPanel.getLavender().addActionListener(new ColorSelected());
        mainPanel.getFillPaint().addActionListener(new MethodSelected());
        mainPanel.getCopy().addActionListener(new MethodSelected());
        mainPanel.getMove().addActionListener(new MethodSelected());
        mainPanel.getResize().addActionListener(new MethodSelected());
        mainPanel.getDelete().addActionListener(new MethodSelected());
        mainPanel.getUndo().addActionListener(new MethodSelected());
        mainPanel.getGroup().addActionListener(new MethodSelected());
        mainPanel.getClear().addActionListener(new MethodSelected());

        setLayout(new BorderLayout());
        add(mainPanel.getMenuBar(),BorderLayout.WEST);
        add(mainPanel.getColorBar(),BorderLayout.CENTER);
        add(mainPanel.getToolBar(),BorderLayout.EAST);
    }

    public void save(ArrayList<Shape> shapeList) {
        ObjectOutputStream out;
        try {
            out =  new ObjectOutputStream(new FileOutputStream("Shapes.txt"));
            for (Shape s : shapeList) {
                out.writeObject(s);
            }
            action = 0;
            out.flush();
            out.close();

        } catch(FileNotFoundException fnf) {
            System.out.println("File not found");
        } catch(IOException ioe) {
            System.out.println("Error with I/O processes") ;
        }
    }

    class ShapeClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object object = e.getSource();
            setFillPaintClicked(false);
            canvas.defaultCursor();

            if (object == mainPanel.getLine()) {
                shapeSelected = "Line";
            } else if (object == mainPanel.getOval()) {
                shapeSelected = "Oval";
            } else if (object == mainPanel.getCircle()) {
                shapeSelected = "Circle";
            } else if (object == mainPanel.getRectangle()) {
                shapeSelected = "Rectangle";
            } else if (object == mainPanel.getSquare()) {
                shapeSelected = "Square";
            } else if (object == mainPanel.getTriangle()) {
                shapeSelected = "Triangle";
            } else if (object == mainPanel.getRightTriangle()) {
                shapeSelected = "Right triangle";
            } else if (object == mainPanel.getParallelogram()) {
                shapeSelected = "Parallelogram";
            } else if (object == mainPanel.getRhombus()) {
                shapeSelected = "Rhombus";
            } else if (object == mainPanel.getPolygon()) {
                shapeSelected = "Polygon";
            } else if (object == mainPanel.getHexagon()) {
                shapeSelected = "Hexagon";
            } else if (object == mainPanel.getStar()) {
                shapeSelected = "Star";
            }

            if(object instanceof JMenuItem) {
                String buttonPressed = ((JMenuItem) object).getText();
                if (buttonPressed.equals("Open")) {
                    openFile = true;
                    canvas.freePaint();
                }
                if (buttonPressed.equals("Save"))
                    save(Menu.shapeList);
            }
        }
    }

    class ColorSelected implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Image blankScaled;
            Object object = e.getSource();

            if(object == mainPanel.getBlack()) {
                tmpColor = Color.black;
                blankScaled = mainPanel.getBlackImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
            else if(object == mainPanel.getGrey()) {
                tmpColor = new Color(169, 169, 169);
                blankScaled = mainPanel.getGreyImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
            else if(object == mainPanel.getRed()) {
                tmpColor = new Color(178, 34, 34);
                blankScaled = mainPanel.getRedImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
            else if(object == mainPanel.getRuby()) {
                tmpColor = new Color(134, 26, 34);
                blankScaled = mainPanel.getRubyImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
            else if (object == mainPanel.getOrange()) {
                tmpColor = new Color(255, 127, 80);
                blankScaled = mainPanel.getOrangeImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
            else if (object == mainPanel.getYellow()) {
                tmpColor = new Color(240, 230, 140);
                blankScaled = mainPanel.getYellowImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
            else if (object == mainPanel.getGreen()) {
                tmpColor = new Color(50, 205, 50);
                blankScaled = mainPanel.getGreenImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
            else if(object == mainPanel.getTurquoise()) {
                tmpColor = new Color(0, 150, 255);
                blankScaled = mainPanel.getTurquoiseImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
            else if(object == mainPanel.getBlue()) {
                tmpColor = new Color(24, 0, 255);
                blankScaled = mainPanel.getBlueImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
            else if(object == mainPanel.getWhite()) {
                tmpColor = Color.WHITE;
                blankScaled = mainPanel.getWhiteImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
            else if(object == mainPanel.getLightGrey()) {
                tmpColor = new Color(197,199,196);
                blankScaled = mainPanel.getLightGreyImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
            else if(object == mainPanel.getLightBrown()) {
                tmpColor = new Color(155,103,60);
                blankScaled = mainPanel.getLightBrownImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
            else if(object == mainPanel.getPink()) {
                tmpColor = Color.pink;
                blankScaled = mainPanel.getPinkImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
            else if(object == mainPanel.getCoral()) {
                tmpColor = new Color(248,131, 121);
                blankScaled = mainPanel.getCoralImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
            else if(object == mainPanel.getBlueGrey()) {
                tmpColor = new Color(115, 147, 179);
                blankScaled = mainPanel.getBlueGreyImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
            else if(object == mainPanel.getDarkSeaGreen()) {
                tmpColor = new Color(143,188, 143);
                blankScaled = mainPanel.getDarkSeaGreenImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
            else if(object == mainPanel.getViolet()) {
                tmpColor = new Color(147,112,219);
                blankScaled = mainPanel.getVioletImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
            else if (object == mainPanel.getLavender()) {
                tmpColor = new Color(187, 190, 254);
                blankScaled = mainPanel.getLavenderImage().getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
                mainPanel.getBlank().setIcon(new ImageIcon(blankScaled));
            }
        }
    }

    class MethodSelected implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            Object object = event.getSource();
            if(object == mainPanel.getFillPaint()) {
                fillPaintClicked = true;
                canvas.customCursor();
            }
            else if (object == mainPanel.getCopy()) {
                setFillPaintClicked(false);
                canvas.defaultCursor();
                copyClicked = true;
            }
            else if(object == mainPanel.getMove()) {
                setFillPaintClicked(false);
                canvas.defaultCursor();
                moveClicked = true;
            }
            else if(object == mainPanel.getResize()) {
                setFillPaintClicked(false);
                canvas.defaultCursor();
                resizeClicked = true;
            }
            else if (object == mainPanel.getDelete()) {
                setFillPaintClicked(false);
                canvas.defaultCursor();
                deleteClicked = true;
            }
            else if(object == mainPanel.getUndo()) {
                setFillPaintClicked(false);
                canvas.defaultCursor();
                undoClicked = true;
                canvas.freePaint();
            }
            //Case1:Group button was clicked and user adds shapes to the list
            //Case2:User already added shapes to the list and wants to stop
            //Case3:There are some shapes in the list and the user needs to add new ones
            else if(object == mainPanel.getGroup()) {
                setFillPaintClicked(false);
                canvas.defaultCursor();
                if(!groupClicked && groupList.isEmpty()) {
                    groupClicked = true;
                    JOptionPane.showMessageDialog(
                            null,
                            "Select your shapes and click Group again!");
                }
                else if(groupClicked && !groupList.isEmpty()) {
                    groupClicked = false;
                    JOptionPane.showMessageDialog(
                            null,
                            "Shapes have been grouped! When you are done with manipulating your shapes " +
                            "click Group again to reset!");
                }
                else if(!groupClicked) {
                    groupList.clear();
                    JOptionPane.showMessageDialog(null, "Group has been reset!");
                    canvas.getGroupShapesRestored().clear();
                    canvas.getListStack().clear();
                }
            }
            else if(object == mainPanel.getClear()) {
                setFillPaintClicked(false);
                canvas.defaultCursor();
                clearClicked = true;
                canvas.freePaint();
            }
        }
    }

    public boolean isOpenFile() { return openFile; }
    public boolean isFillPaintClicked() { return fillPaintClicked;}
    public boolean isCopyClicked() { return copyClicked; }
    public boolean isMoveClicked() { return moveClicked; }
    public boolean isResizeClicked() {return resizeClicked; }
    public boolean isDeleteClicked() { return deleteClicked; }
    public boolean isUndoClicked() { return undoClicked; }
    public boolean isGroupClicked() { return groupClicked; }
    public boolean isClearClicked() { return clearClicked; }
    public void setShapeSelected(String shapeSelected) { this.shapeSelected = shapeSelected; }
    public void setOpenFile(boolean openFile) { this.openFile = openFile;}
    public void setFillPaintClicked(boolean fillPaintClicked) { this.fillPaintClicked = fillPaintClicked; }
    public void setCopySelected(boolean copyClicked) { this.copyClicked = copyClicked; }
    public void setMoveClicked(boolean moveClicked) { this.moveClicked = moveClicked;}
    public void setResizeClicked(boolean resizeClicked) { this.resizeClicked = resizeClicked; }
    public void setDeleteClicked(boolean deleteClicked) { this.deleteClicked = deleteClicked; }
    public void setUndoClicked(boolean undoClicked) { this.undoClicked = undoClicked; }
    public void setGroupClicked(boolean groupClicked) { this.groupClicked = groupClicked; }
    public void setClearClicked(boolean clearClicked) { this.clearClicked = clearClicked; }
    public static ArrayList<Shape> getShapeList() { return shapeList; }
    public static ArrayList<Shape> getGroupList() { return groupList; }
    public String getShapeSelected() { return shapeSelected; }
    public Color getTmpColor() { return tmpColor; }
}