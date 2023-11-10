package controller;

//import from our codebase
import model.strategyPattern.CloserAwayStrategy;
import model.strategyPattern.HighLowStrategy;
import view.ApplicationWindow;

//import from java libraries
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StrategySelectionListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        String actionCommand = actionEvent.getActionCommand();

        switch(actionCommand)
        {
            case ApplicationWindow.highLowAction:
                Application.numberGuessGame.setStrategy(new HighLowStrategy(Application.numberGuessGame));
                break;
            case ApplicationWindow.closerAwayAction:
                Application.numberGuessGame.setStrategy(new CloserAwayStrategy(Application.numberGuessGame));
                break;
        }
    }
}