package view.statePattern;

//import from our codebase
import view.ApplicationWindow;

//import from java libraries
import java.awt.Graphics2D;

public interface GameState 
{
    void goNext(ApplicationWindow context);
    void updateWindow();
    void updateCanvas(Graphics2D graphics2D);
}