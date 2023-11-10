package model.strategyPattern;

//import from our codebase
import model.NumberGuessGame;

public class HighLowStrategy implements PlayStrategy 
{
    private NumberGuessGame game;

    public HighLowStrategy(NumberGuessGame game) 
    {
        this.game = game;
    }

    @Override
    public void play(int geuss) 
    {
        game.setGuess(geuss);

        int difference = geuss - game.getKey();

        if(difference < 0)
        {
            game.progressMessage = "Go Higher!";
        }
        else if(difference == 0)
        {
            game.progressMessage = "You got it! The key was " + game.getKey();
        }
        else
        {
            game.progressMessage = "Go Lower!";
        }
    }
}