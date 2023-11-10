package view.statePattern;

//import from our codebase
import controller.Application;
import view.ApplicationWindow;

//import from java libraries
import java.awt.Font;
import java.awt.Graphics2D;

public class GameStateDone implements GameState 
{
    @Override
    public void goNext(ApplicationWindow context) 
    {
        context.setGameState(new GameStateInit());
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

        String message1 = String.format("%d is correct! (Attempts = %d)", Application.numberGuessGame.getKey(), Application.numberGuessGame.getAttempts());
        String message2 = "Press <New Game> to Play Again!";

        graphics2D.drawString(message1, 50, 100);
        graphics2D.drawString(message2, 50, 150);
    }
}