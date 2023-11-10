package view.statePattern;

//import from our codebase
import controller.Application;
import view.ApplicationWindow;

//import from java libraries
import java.awt.Font;
import java.awt.Graphics2D;

public class GameStateInit implements GameState 
{
    @Override
    public void goNext(ApplicationWindow context) 
    {
        context.setGameState(new GameStatePlaying());
    }

    @Override
    public void updateWindow() 
    {
        Application.applicationWindow.newGameButton.setEnabled(true);
        Application.applicationWindow.numberField.setEnabled(false);
        Application.applicationWindow.highLowButton.setEnabled(true);
        Application.applicationWindow.closerAwayButton.setEnabled(true);
        Application.applicationWindow.showKeyButton.setEnabled(true);
        Application.applicationWindow.applicationCanvas.repaint();
    }

    @Override
    public void updateCanvas(Graphics2D graphics2D) 
    {
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 16));
        
        String message = "Press <New Game> button to start";
        graphics2D.drawString(message, 50, 150);
    }
}