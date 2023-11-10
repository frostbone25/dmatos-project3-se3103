package model;

//import from our codebase
import model.strategyPattern.HighLowStrategy;
import model.strategyPattern.PlayStrategy;
import view.statePattern.GameState;
import view.statePattern.GameStateInit;

//import from java libraries
import java.util.Random;

public class NumberGuessGame 
{
    public static final int MAX_KEY = 100;

    private int key;
    private int geuss;
    private boolean showKeyOn;
    private int attempts;
    public String progressMessage;

    private GameState state;
    private PlayStrategy strategy;

    public NumberGuessGame()
    {
        key = -1;
        geuss = -1;
        showKeyOn = false;
        attempts = 0;
        setStrategy(new HighLowStrategy(this));
        setState(new GameStateInit());

        System.out.println("NumberGuessGame: constructor");
    }

    public void start()
    {
        key = generateNewKey();
        geuss = -1;
        attempts = 0;
        progressMessage = null;

        System.out.println("NumberGuessGame: start");
    }

    private int generateNewKey()
    {
        Random random = new Random();
        int newKey;

        do
        {
            newKey = random.nextInt(MAX_KEY + 1);
        } 
        while(newKey == key);

        System.out.println("NumberGuessGame: generateNewKey");

        return newKey;
    }

    public void play(int geuss)
    {
        ++attempts;

        strategy.play(geuss);

        System.out.println("NumberGuessGame: play");
    }

    public int getAttempts()
    {
        System.out.println("NumberGuessGame: getAttempts");
        return attempts;
    }

    public void setAttempts(int attempts)
    {
        this.attempts = attempts;
        System.out.println("NumberGuessGame: setAttempts");
    }

    public PlayStrategy getStrategy()
    {
        System.out.println("NumberGuessGame: getStrategy");
        return strategy;
    }

    public void setStrategy(PlayStrategy strategy)
    {
        this.strategy = strategy;
        System.out.println("NumberGuessGame: setStrategy");
    }

    public GameState getState()
    {
        System.out.println("NumberGuessGame: getState");
        return state;
    }

    public void setState(GameState state)
    {
        this.state = state;
        System.out.println("NumberGuessGame: setState");
    }

    public boolean isShowKeyOn()
    {
        System.out.println("NumberGuessGame: isShowKeyOn");
        return showKeyOn;
    }

    public void setShowKeyOn(boolean showKeyOn)
    {
        this.showKeyOn = showKeyOn;
        System.out.println("NumberGuessGame: setShowKeyOn");
    }

    public int getGuess()
    {
        System.out.println("NumberGuessGame: getGuess");
        return geuss;
    }

    public void setGuess(int guess)
    {
        this.geuss = guess;
        System.out.println("NumberGuessGame: setGuess");
    }

    public int getKey()
    {
        System.out.println("NumberGuessGame: getKey");
        return key;
    }

    public void setKey(int key)
    {
        this.key = key;
        System.out.println("NumberGuessGame: setKey");
    }

    @Override
    public String toString()
    {
        return String.format("key(%d) guess(%d) attempts(%d)", key, geuss, attempts);
    }
}
