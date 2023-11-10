package view.statePattern;

//import from our codebase
import controller.Application;
import view.ApplicationWindow;

//import from java libraries
import java.awt.Font;
import java.awt.Graphics2D;

public class GameStatePlaying implements GameState 
{
    @Override
    public void goNext(ApplicationWindow context) 
    {
        context.setGameState(new GameStateDone());
    }

    @Override
    public void updateWindow() 
    {
        Application.applicationWindow.newGameButton.setEnabled(false);
        Application.applicationWindow.numberField.setEnabled(true);
        Application.applicationWindow.highLowButton.setEnabled(false);
        Application.applicationWindow.closerAwayButton.setEnabled(false);
        Application.applicationWindow.applicationCanvas.repaint();
    }

    @Override
    public void updateCanvas(Graphics2D graphics2D) 
    {
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 16));

        String promptString;

        if(Application.numberGuessGame.isShowKeyOn())
        {
            var keyString = String.format("(Key: %d)", Application.numberGuessGame.getKey());
            graphics2D.drawString(keyString, 50, 100);
        }

        if(Application.numberGuessGame.getGuess() >= 0)
        {
            promptString = String.format("Your Guess: %d (Attempts: %d)", Application.numberGuessGame.getGuess(), Application.numberGuessGame.getAttempts());
        }
        else
        {
            promptString = "Enter your guess";
        }

        graphics2D.drawString(promptString, 50, 150);

        if(Application.numberGuessGame.progressMessage != null)
        {
            graphics2D.drawString(Application.numberGuessGame.progressMessage, 100, 200);
        }
    }
}