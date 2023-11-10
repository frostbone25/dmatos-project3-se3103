package model.strategyPattern;

//import from our codebase
import model.NumberGuessGame;

public class CloserAwayStrategy implements PlayStrategy 
{
    private NumberGuessGame game;

    public CloserAwayStrategy(NumberGuessGame game) 
    {
        this.game = game;
    }

    @Override
    public void play(int geuss) 
    {
        int previousGeussDifference = Math.abs(game.getKey() - game.getGuess());
        int newGeussDifference = Math.abs(game.getKey() - geuss);

        game.setGuess(geuss);

        if(newGeussDifference - previousGeussDifference < 0)
        {
            game.progressMessage = "Getting closer";
        }
        else
        {
            game.progressMessage = "Not getting closer";
        }
    }
}