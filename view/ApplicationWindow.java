package view;

//import from our codebase
import controller.Application;
import controller.ExitButtonListener;
import controller.NewGameButtonListener;
import controller.NumberEnterListener;
import controller.ShowKeyButtonListener;
import controller.StrategySelectionListener;
import model.strategyPattern.CloserAwayStrategy;
import model.strategyPattern.HighLowStrategy;
import view.statePattern.GameState;
import view.statePattern.GameStateInit;

//import from java libraries
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ApplicationWindow extends JFrame
{
    public static final String highLowAction = "High/Low";
    public static final String closerAwayAction = "Closer/Away";

    public ApplicationCanvas applicationCanvas;

    public JTextField numberField;
    public JRadioButton highLowButton;
    public JRadioButton closerAwayButton;

    public JCheckBox showKeyButton;
    public JButton newGameButton;
    public JButton exitButton;

    private GameState state = new GameStateInit();

    public void initalize()
    {
        Container contentPane = getContentPane();
        applicationCanvas = new ApplicationCanvas();
        contentPane.add(applicationCanvas, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(3, 1));
        contentPane.add(southPanel, BorderLayout.SOUTH);

        JPanel numberPanel = new JPanel();
        southPanel.add(numberPanel);
        numberPanel.setBorder(new TitledBorder("Your Guess"));
        numberPanel.add(new JLabel("Enter (0 - 100)"));
        numberField = new JTextField(10);
        numberPanel.add(numberField);
        numberField.addActionListener(new NumberEnterListener());

        JPanel strategyPanel = new JPanel();
        strategyPanel.setBorder(new TitledBorder("Select strategy"));
        highLowButton = new JRadioButton(highLowAction, Application.numberGuessGame.getStrategy() instanceof HighLowStrategy);
        closerAwayButton = new JRadioButton(closerAwayAction, Application.numberGuessGame.getStrategy() instanceof CloserAwayStrategy);
        strategyPanel.add(highLowButton);
        strategyPanel.add(closerAwayButton);
        southPanel.add(strategyPanel);
        
        StrategySelectionListener strategySelectionListener = new StrategySelectionListener();
        highLowButton.addActionListener(strategySelectionListener);
        closerAwayButton.addActionListener(strategySelectionListener);

        ButtonGroup strategyGroup = new ButtonGroup();
        strategyGroup.add(highLowButton);
        strategyGroup.add(closerAwayButton);

        JPanel actionPanel = new JPanel();
        southPanel.add(actionPanel);
        showKeyButton = new JCheckBox("show key");
        showKeyButton.addItemListener(new ShowKeyButtonListener());
        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new NewGameButtonListener());
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ExitButtonListener());

        actionPanel.add(showKeyButton);
        actionPanel.add(newGameButton);
        actionPanel.add(exitButton);

        updateWindow();
    }

    public void goNextState() 
    {
        state.goNext(this);
    }

    public GameState getGameState() 
    {
        return state;
    }

    public void setGameState(GameState state) 
    {
        this.state = state;
    }
    
    public void updateWindow()
    {
        state.updateWindow();
        applicationCanvas.repaint();
    }
}
