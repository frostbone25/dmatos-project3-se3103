package view;

//import from our codebase
import controller.Application;

//import from java libraries
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ApplicationCanvas extends JPanel
{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;

    public ApplicationCanvas()
    {
        Dimension windowDimensions = new Dimension(WIDTH, HEIGHT);
        setPreferredSize(windowDimensions);
    }

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D)graphics;
        Application.applicationWindow.getGameState().updateCanvas(graphics2D);
    }
}
