import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class PaintFrame extends JFrame {

    public PaintFrame() {
        super("Paint");

        setSize(1150,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);
        MainPanel d = new MainPanel();
        Menu menu = new Menu(d);
        Canvas drawingCanvas = new Canvas(menu);

        ImageIcon paintImage = new ImageIcon("icons\\Paint.png");
        setIconImage(paintImage.getImage());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //If some action happened in our canvas and the user didn't click save before exiting
                if (menu.action != 0) {
                    String[] options = {"Save", "Don't Save", "Cancel"};
                    int choice = JOptionPane.showOptionDialog(null, "Do you want to save changes?", "Paint",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);

                    if (choice == 0) {
                        menu.save(Menu.getShapeList());
                        System.exit(0);
                    }
                    else if (choice == 1) {
                        System.exit(0);
                    }
                }
                else
                    System.exit(0);

            }
        });

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(menu, BorderLayout.PAGE_START);
        pane.add(drawingCanvas, BorderLayout.CENTER);
        setVisible(true);
    }


}
