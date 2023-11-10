package controller;

//import from java libraries
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButtonListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent actionEvent) 
    {
        Application.numberGuessGame.start();
        Application.applicationWindow.goNextState();
        Application.applicationWindow.updateWindow();
    }
}
