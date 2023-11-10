import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;


public class MainPanel extends JPanel {

    private final JButton line = new JButton();
    private final JButton oval = new JButton();
    private final JButton circle = new JButton();
    private final JButton rectangle = new JButton();
    private final JButton square = new JButton();
    private final JButton triangle = new JButton();
    private final JButton rightTriangle = new JButton();
    private final JButton parallelogram = new JButton();
    private final JButton rhombus = new JButton();
    private final JButton polygon = new JButton();
    private final JButton hexagon = new JButton();
    private final JButton star = new JButton();
    private final JButton black = new JButton();
    private final JButton grey = new JButton();
    private final JButton red = new JButton();
    private final JButton ruby = new JButton();
    private final JButton orange = new JButton();
    private final JButton yellow = new JButton();
    private final JButton green = new JButton();
    private final JButton turquoise = new JButton();
    private final JButton blue = new JButton();
    private final JButton white = new JButton();
    private final JButton lightGrey = new JButton();
    private final JButton lightBrown = new JButton();
    private final JButton pink = new JButton();
    private final JButton coral = new JButton();
    private final JButton blueGrey = new JButton();
    private final JButton darkSeaGreen = new JButton();
    private final JButton violet = new JButton();
    private final JButton lavender = new JButton();
    private final JButton blank = new JButton();
    private final JButton fillPaint = new JButton();
    private final JButton copy = new JButton();
    private final JButton move = new JButton();
    private final JButton resize = new JButton();
    private final JButton delete = new JButton();
    private final JButton undo = new JButton();
    private final JButton group = new JButton();
    private final JButton clear = new JButton();

    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu file = new JMenu("File");
    private final JMenuItem open = new JMenuItem();
    private final JMenuItem save = new JMenuItem();

    private final JToolBar toolBar = new JToolBar();
    private final JToolBar colorBar = new JToolBar();

    private final ImageIcon blackImage = new ImageIcon("icons\\colors\\Black.jpg");
    private final ImageIcon greyImage = new ImageIcon("icons\\colors\\Grey.png");
    private final ImageIcon redImage = new ImageIcon("icons\\colors\\Red.png");
    private final ImageIcon rubyImage = new ImageIcon("icons\\colors\\Ruby.png");
    private final ImageIcon orangeImage = new ImageIcon("icons\\colors\\Orange.png");
    private final ImageIcon yellowImage = new ImageIcon("icons\\colors\\Yellow.png");
    private final ImageIcon greenImage = new ImageIcon("icons\\colors\\Green.png");
    private final ImageIcon turquoiseImage = new ImageIcon("icons\\colors\\Turquoise.jpg");
    private final ImageIcon blueImage = new ImageIcon("icons\\colors\\Blue.png");
    private final ImageIcon whiteImage = new ImageIcon("icons\\colors\\White.png");
    private final ImageIcon lightGreyImage = new ImageIcon("icons\\colors\\LightGrey.png");
    private final ImageIcon lightBrownImage = new ImageIcon("icons\\colors\\LightBrown.png");
    private final ImageIcon pinkImage = new ImageIcon("icons\\colors\\Pink.png");
    private final ImageIcon coralImage = new ImageIcon("icons\\colors\\Coral.png");
    private final ImageIcon blueGreyImage = new ImageIcon("icons\\colors\\BlueGrey.png");
    private final ImageIcon darkSeaGreenImage = new ImageIcon("icons\\colors\\DarkSeaGreen.png");
    private final ImageIcon violetImage = new ImageIcon("icons\\colors\\Violet.png");
    private final ImageIcon lavenderImage = new ImageIcon("icons\\colors\\Lavender.png");
    private final ImageIcon saveImage = new ImageIcon("icons\\Save.png");
    private final ImageIcon openImage = new ImageIcon("icons\\Open.png");
    private final ImageIcon lineImage = new ImageIcon("icons\\shapes\\Line.jpg");
    private final ImageIcon ovalImage = new ImageIcon("icons\\shapes\\Oval.png");
    private final ImageIcon circleImage = new ImageIcon("icons\\shapes\\Circle.png");
    private final ImageIcon rectangleImage = new ImageIcon("icons\\shapes\\Rectangle.png");
    private final ImageIcon squareImage = new ImageIcon("icons\\shapes\\Square.png");
    private final ImageIcon rightTriangleImage = new ImageIcon("icons\\shapes\\RightTriangle.png");
    private final ImageIcon parallelogramImage = new ImageIcon("icons\\shapes\\Parallelogram.png");
    private final ImageIcon rhombusImage = new ImageIcon("icons\\shapes\\Rhombus.png");
    private final ImageIcon polygonImage = new ImageIcon("icons\\shapes\\Polygon.png");
    private final ImageIcon hexagonImage = new ImageIcon("icons\\shapes\\Hexagon.png");
    private final ImageIcon starImage = new ImageIcon("icons\\shapes\\Star.png");
    private final ImageIcon fillColorImage = new ImageIcon("icons\\FillColor.png");
    private final ImageIcon copyImage = new ImageIcon("icons\\Copy.png");
    private final ImageIcon moveImage = new ImageIcon("icons\\Move.png");
    private final ImageIcon resizeImage = new ImageIcon("icons\\Resize.png");
    private final ImageIcon deleteImage = new ImageIcon("icons\\Delete.png");
    private final ImageIcon undoImage = new ImageIcon("icons\\Undo.png");
    private final ImageIcon groupImage = new ImageIcon("icons\\Group.png");
    private final ImageIcon clearImage = new ImageIcon("icons\\Clear.png");

    public MainPanel() {
        //Rescaling images and making buttons transparent
        Image openScaled = openImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        open.setIcon(new ImageIcon(openScaled));
        open.setText("Open");


        Image saveScaled = saveImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        save.setIcon(new ImageIcon(saveScaled));
        save.setText("Save");

        Image lineScaled = lineImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        line.setIcon(new ImageIcon(lineScaled));
        line.setToolTipText("Line");

        Image ovalScaled = ovalImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        oval.setIcon(new ImageIcon(ovalScaled));
        oval.setToolTipText("Oval");

        Image circleScaled = circleImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        circle.setIcon(new ImageIcon(circleScaled));
        circle.setToolTipText("Circle");

        Image squareScaled = squareImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        square.setIcon(new ImageIcon(squareScaled));
        square.setToolTipText("Square");

        Image rectangleScaled = rectangleImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        rectangle.setIcon(new ImageIcon(rectangleScaled));
        rectangle.setToolTipText("Rectangle");

        ImageIcon triangleImage = new ImageIcon("icons\\shapes\\Triangle.png");
        Image triangleScaled = triangleImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        triangle.setIcon(new ImageIcon(triangleScaled));
        triangle.setToolTipText("Triangle");

        Image rightTriangleScaled = rightTriangleImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        rightTriangle.setIcon(new ImageIcon(rightTriangleScaled));
        rightTriangle.setToolTipText("Right triangle");

        Image parallelogramScaled = parallelogramImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        parallelogram.setIcon(new ImageIcon(parallelogramScaled));
        parallelogram.setToolTipText("Parallelogram");

        Image rhombusScaled = rhombusImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        rhombus.setIcon(new ImageIcon(rhombusScaled));
        rhombus.setToolTipText("Rhombus");

        Image polygonScaled = polygonImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        polygon.setIcon(new ImageIcon(polygonScaled));
        polygon.setToolTipText("Polygon");

        Image hexagonScaled = hexagonImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        hexagon.setIcon(new ImageIcon(hexagonScaled));
        hexagon.setToolTipText("Hexagon");

        Image starScaled = starImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        star.setIcon(new ImageIcon(starScaled));
        star.setToolTipText("Star");

        Image blackScaled = blackImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        black.setIcon(new ImageIcon(blackScaled));
        black.setToolTipText("Black");
        black.setOpaque(false);
        black.setBorderPainted(false);

        Image greyScaled = greyImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        grey.setIcon(new ImageIcon(greyScaled));
        grey.setToolTipText("Grey");
        grey.setOpaque(false);
        grey.setBorderPainted(false);
        grey.setMargin(new Insets(0, 0 , 0 ,0));

        Image redScaled = redImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        red.setIcon(new ImageIcon(redScaled));
        red.setToolTipText("Red");
        red.setOpaque(false);
        red.setBorderPainted(false);
        red.setMargin(new Insets(0, 0 , 0 ,0));

        Image rubyScaled = rubyImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ruby.setIcon(new ImageIcon(rubyScaled));
        ruby.setToolTipText("Ruby");
        ruby.setOpaque(false);
        ruby.setBorderPainted(false);
        ruby.setMargin(new Insets(0, 0 , 0 ,0));

        Image orangeScaled = orangeImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        orange.setIcon(new ImageIcon(orangeScaled));
        orange.setToolTipText("Orange");
        orange.setOpaque(false);
        orange.setBorderPainted(false);
        orange.setMargin(new Insets(0, 0 , 0 ,0));

        Image yellowScaled = yellowImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        yellow.setIcon(new ImageIcon(yellowScaled));
        yellow.setToolTipText("Yellow");
        yellow.setOpaque(false);
        yellow.setBorderPainted(false);
        //Margins to center image correctly when there is borderPainted
        yellow.setMargin(new Insets(0, 0, 0 ,0));

        Image greenScaled = greenImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        green.setIcon(new ImageIcon(greenScaled));
        green.setToolTipText("Green");
        green.setOpaque(false);
        green.setBorderPainted(false);
        green.setMargin(new Insets(0, 0 , 0 ,0));

        Image turquoiseScaled = turquoiseImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        turquoise.setIcon(new ImageIcon(turquoiseScaled));
        turquoise.setToolTipText("Turquoise");
        turquoise.setOpaque(false);
        turquoise.setBorderPainted(false);
        turquoise.setMargin(new Insets(0, 0 , 0 ,0));

        Image blueScaled = blueImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        blue.setIcon(new ImageIcon(blueScaled));
        blue.setToolTipText("Blue");
        blue.setOpaque(false);
        blue.setBorderPainted(false);
        blue.setMargin(new Insets(0, 0 , 0 ,0));

        Image whiteScaled = whiteImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        white.setIcon(new ImageIcon(whiteScaled));
        white.setToolTipText("White");
        white.setOpaque(false);
        white.setBorderPainted(false);
        white.setMargin(new Insets(0, 0 , 0 ,0));

        Image lightGreyScaled = lightGreyImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lightGrey.setIcon(new ImageIcon(lightGreyScaled));
        lightGrey.setToolTipText("Light grey");
        lightGrey.setOpaque(false);
        lightGrey.setBorderPainted(false);
        lightGrey.setMargin(new Insets(0, 0 , 0 ,0));

        Image lightBrownScaled = lightBrownImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lightBrown.setIcon(new ImageIcon(lightBrownScaled));
        lightBrown.setToolTipText("Light brown");
        lightBrown.setOpaque(false);
        lightBrown.setBorderPainted(false);
        lightBrown.setMargin(new Insets(0, 0 , 0 ,0));

        Image pinkScaled = pinkImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        pink.setIcon(new ImageIcon(pinkScaled));
        pink.setToolTipText("Pink");
        pink.setOpaque(false);
        pink.setBorderPainted(false);
        pink.setMargin(new Insets(0, 0 , 0 ,0));

        Image coralScaled = coralImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        coral.setIcon(new ImageIcon(coralScaled));
        coral.setToolTipText("Coral");
        coral.setOpaque(false);
        coral.setBorderPainted(false);
        coral.setMargin(new Insets(0, 0 , 0 ,0));

        Image blueGreyScaled = blueGreyImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        blueGrey.setIcon(new ImageIcon(blueGreyScaled));
        blueGrey.setToolTipText("Blue grey");
        blueGrey.setOpaque(false);
        blueGrey.setBorderPainted(false);
        blueGrey.setMargin(new Insets(0, 0 , 0 ,0));

        Image darkSeaGreenScaled = darkSeaGreenImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        darkSeaGreen.setIcon(new ImageIcon(darkSeaGreenScaled));
        darkSeaGreen.setToolTipText("Dark sea green");
        darkSeaGreen.setOpaque(false);
        darkSeaGreen.setBorderPainted(false);
        darkSeaGreen.setMargin(new Insets(0, 0 , 0 ,0));

        Image violetScaled = violetImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        violet.setIcon(new ImageIcon(violetScaled));
        violet.setToolTipText("Violet");
        violet.setOpaque(false);
        violet.setBorderPainted(false);
        violet.setMargin(new Insets(0, 0 , 0 ,0));

        Image lavenderScaled = lavenderImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        lavender.setIcon(new ImageIcon(lavenderScaled));
        lavender.setToolTipText("Lavender");
        lavender.setOpaque(false);
        lavender.setBorderPainted(false);
        lavender.setMargin(new Insets(0, 0 , 0 ,0));

        Image blankScaled;
        blankScaled = blackImage.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        blank.setIcon(new ImageIcon(blankScaled));
        blank.setOpaque(false);
        blank.setBorderPainted(false);
        blank.setVerticalTextPosition(SwingConstants.BOTTOM);
        blank.setHorizontalTextPosition(SwingConstants.CENTER);
        blank.setText("Color");

        Image fillColorScaled = fillColorImage.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        fillPaint.setIcon(new ImageIcon(fillColorScaled));
        fillPaint.setOpaque(false);
        fillPaint.setBorderPainted(false);
        fillPaint.setText("Fill");
        fillPaint.setToolTipText("Paint the body of your shapes");

        Image copyScaled = copyImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        copy.setIcon(new ImageIcon(copyScaled));
        copy.setOpaque(false);
        copy.setBorderPainted(false);
        copy.setText("Copy");
        copy.setToolTipText("Select the shape and click on the canvas to copy it");

        Image moveScaled = moveImage.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        move.setIcon(new ImageIcon(moveScaled));
        move.setOpaque(false);
        move.setBorderPainted(false);
        move.setText("Move");
        move.setToolTipText("Use the drag and drop method");

        Image resizeScaled = resizeImage.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
        resize.setIcon(new ImageIcon(resizeScaled));
        resize.setOpaque(false);
        resize.setBorderPainted(false);
        resize.setText("Resize");
        resize.setToolTipText("Resize the selected shape");

        Image deleteScaled = deleteImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        delete.setIcon(new ImageIcon(deleteScaled));
        delete.setOpaque(false);
        delete.setBorderPainted(false);
        delete.setText("Delete");
        delete.setToolTipText("Select the shape to be deleted");

        Image undoScaled = undoImage.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        undo.setIcon(new ImageIcon(undoScaled));
        undo.setOpaque(false);
        undo.setBorderPainted(false);
        undo.setText("Undo");
        undo.setToolTipText("Restore your last deleted shape");

        Image groupScaled = groupImage.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        group.setIcon(new ImageIcon(groupScaled));
        group.setOpaque(false);
        group.setBorderPainted(false);
        group.setText("Group");
        group.setToolTipText("Select and group shapes together");

        Image clearScaled = clearImage.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        clear.setIcon(new ImageIcon(clearScaled));
        clear.setOpaque(false);
        clear.setBorderPainted(false);
        clear.setText("Clear");
        clear.setToolTipText("Clear your canvas");

        file.add(open);
        file.add(save);

        menuBar.add(file);
        menuBar.add(Box.createHorizontalStrut(10));

        colorBar.setLayout(new GridBagLayout());
        GridBagConstraints gbc =  new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0 ,0 );

        gbc.gridx = 0;
        gbc.gridy = 0;
        colorBar.add(line, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        colorBar.add(oval, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        colorBar.add(circle, gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        colorBar.add(rectangle, gbc);
        gbc.gridx = 4;
        gbc.gridy = 0;
        colorBar.add(square, gbc);
        gbc.gridx = 5;
        gbc.gridy = 0;
        colorBar.add(triangle, gbc);
        //Adding a blank box for separation between colors and shapes
        colorBar.add(Box.createHorizontalStrut(20));
        gbc.gridx = 7;
        gbc.gridy = 0;
        colorBar.add(black, gbc);
        gbc.gridx = 8;
        gbc.gridy = 0;
        colorBar.add(grey, gbc);
        gbc.gridx = 9;
        gbc.gridy = 0;
        colorBar.add(red, gbc);
        gbc.gridx = 10;
        gbc.gridy = 0;
        colorBar.add(ruby, gbc);
        gbc.gridx = 11;
        gbc.gridy = 0;
        colorBar.add(orange, gbc);
        gbc.gridx = 12;
        gbc.gridy = 0;
        colorBar.add(yellow, gbc);
        gbc.gridx = 13;
        gbc.gridy = 0;
        colorBar.add(green, gbc);
        gbc.gridx = 14;
        gbc.gridy = 0;
        colorBar.add(turquoise, gbc);
        gbc.gridx = 15;
        gbc.gridy = 0;
        colorBar.add(blue, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        colorBar.add(rightTriangle, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        colorBar.add(parallelogram, gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        colorBar.add(rhombus, gbc);
        gbc.gridx = 3;
        gbc.gridy = 1;
        colorBar.add(polygon, gbc);
        gbc.gridx = 4;
        gbc.gridy = 1;
        colorBar.add(hexagon, gbc);
        gbc.gridx = 5;
        gbc.gridy = 1;
        colorBar.add(star, gbc);
        colorBar.add(Box.createHorizontalStrut(20));
        gbc.gridx = 7;
        gbc.gridy = 1;
        colorBar.add(white, gbc);
        gbc.gridx = 8;
        gbc.gridy = 1;
        colorBar.add(lightGrey, gbc);
        gbc.gridx = 9;
        gbc.gridy = 1;
        colorBar.add(lightBrown, gbc);
        gbc.gridx = 10;
        gbc.gridy = 1;
        colorBar.add(pink, gbc);
        gbc.gridx = 11;
        gbc.gridy = 1;
        colorBar.add(coral, gbc);
        gbc.gridx = 12;
        gbc.gridy = 1;
        colorBar.add(blueGrey, gbc);
        gbc.gridx = 13;
        gbc.gridy = 1;
        colorBar.add(darkSeaGreen, gbc);
        gbc.gridx = 14;
        gbc.gridy = 1;
        colorBar.add(violet, gbc);
        gbc.gridx = 15;
        gbc.gridy = 1;
        colorBar.add(lavender, gbc);
        colorBar.setFloatable(false);

        toolBar.setFloatable(false);
        toolBar.add(blank);
        toolBar.add(fillPaint);
        toolBar.add(copy);
        toolBar.add(move);
        toolBar.add(resize);
        toolBar.add(delete);
        toolBar.add(undo);
        toolBar.add(group);
        toolBar.add(clear);
        toolBar.add(Box.createHorizontalStrut(20));
    }

    public JMenuBar getMenuBar() { return menuBar; }
    public JToolBar getToolBar() { return toolBar; }
    public JToolBar getColorBar() { return colorBar; }
    public JMenuItem getOpen() { return open; }
    public JMenuItem getSave() { return save; }
    public JButton getLine() { return line; }
    public JButton getOval() { return oval; }
    public JButton getCircle() { return circle; }
    public JButton getRectangle() { return rectangle; }
    public JButton getSquare() { return square; }
    public JButton getTriangle() { return triangle; }
    public JButton getRightTriangle() { return rightTriangle; }
    public JButton getParallelogram() { return parallelogram; }
    public JButton getRhombus() { return rhombus; }
    public JButton getPolygon() { return polygon; }
    public JButton getHexagon() { return hexagon; }
    public JButton getStar() { return star; }
    public JButton getBlack() { return black; }
    public JButton getGrey() { return grey; }
    public JButton getRed() { return red; }
    public JButton getRuby() { return ruby; }
    public JButton getOrange() { return orange; }
    public JButton getYellow() { return yellow; }
    public JButton getGreen() { return green; }
    public JButton getTurquoise() { return turquoise; }
    public JButton getBlue() { return blue; }
    public JButton getWhite() { return white; }
    public JButton getLightGrey() { return lightGrey; }
    public JButton getLightBrown() { return lightBrown; }
    public JButton getPink() { return pink; }
    public JButton getCoral() { return coral; }
    public JButton getBlueGrey() { return blueGrey; }
    public JButton getDarkSeaGreen() { return darkSeaGreen; }
    public JButton getViolet() { return violet; }
    public JButton getLavender() { return lavender; }
    public JButton getBlank() { return blank; }
    public JButton getFillPaint() { return fillPaint; }
    public JButton getCopy() { return copy; }
    public JButton getMove() { return move; }
    public JButton getResize() { return resize; }
    public JButton getDelete() { return delete; }
    public JButton getUndo() { return undo; }
    public JButton getGroup() { return group; }
    public JButton getClear() { return clear; }
    public ImageIcon getBlackImage() { return blackImage; }
    public ImageIcon getGreyImage() { return greyImage; }
    public ImageIcon getRedImage() { return redImage; }
    public ImageIcon getRubyImage() { return rubyImage; }
    public ImageIcon getOrangeImage() { return orangeImage; }
    public ImageIcon getYellowImage() { return yellowImage; }
    public ImageIcon getGreenImage() { return greenImage; }
    public ImageIcon getTurquoiseImage() { return turquoiseImage; }
    public ImageIcon getBlueImage() { return blueImage; }
    public ImageIcon getWhiteImage() { return whiteImage; }
    public ImageIcon getLightGreyImage() { return lightGreyImage; }
    public ImageIcon getLightBrownImage() { return lightBrownImage; }
    public ImageIcon getPinkImage() { return pinkImage; }
    public ImageIcon getCoralImage() { return coralImage; }
    public ImageIcon getBlueGreyImage() { return blueGreyImage; }
    public ImageIcon getDarkSeaGreenImage() { return darkSeaGreenImage; }
    public ImageIcon getVioletImage() { return violetImage; }
    public ImageIcon getLavenderImage() { return lavenderImage; }
}
