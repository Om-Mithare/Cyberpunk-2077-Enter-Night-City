package package1;

public class VisibilityManager {

    UI ui;

    public VisibilityManager(UI userInterface)
    {
        ui = userInterface;
    }

    public void showTitleScreen()
    {
        // Show the title screen
        ui.titleNamePanel.setVisible(true);
        ui.titleDescPanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        //Hide the game screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }

    public void titleToCity()
    {
        // Hide the title screen
        ui.titleNamePanel.setVisible(false);
        ui.titleDescPanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        // Show the game screen
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }
}