package org.example;

public class TransitionManager {

    UI ui;
    public TransitionManager(UI ui1) {
        ui = ui1;
    }

    public void showTitleScreen() {
        //Shows the title screen:
        ui.namePanel.setVisible(true);
        ui.startButton.setVisible(true);

        //Hide Game Screen:
        ui.mainTextArea.setVisible(false);
        ui.choicePanel.setVisible(false);
        ui.playerPanel.setVisible(false);

    }

    public void titleScreenToGame() {
        //Hides the title screen:
        ui.namePanel.setVisible(false);
        ui.startButton.setVisible(false);

        //Shows Game Screen:
        ui.mainTextArea.setVisible(true);
        ui.choicePanel.setVisible(true);
        ui.playerPanel.setVisible(true);

    }
}
