package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    UI ui = new UI();
    TransitionManager transitionManager = new TransitionManager(ui);
    ChoiceHandler choiceHandler = new ChoiceHandler();
    Story story = new Story(this, ui, transitionManager);
    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
    public static void main(String[] args) {
        new Game();
    }
    public Game() {

        ui.createTheUI(choiceHandler);
        story.playerSetup();
        transitionManager.showTitleScreen();
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String userChoice = event.getActionCommand();
            switch (userChoice) {
                case "start": transitionManager.titleScreenToGame();story.storyBegins(); break;
                case "C1": story.selectPosition(nextPosition1); break;
                case "C2": story.selectPosition(nextPosition2);break;
                case "C3": story.selectPosition(nextPosition3);break;
                case "C4": story.selectPosition(nextPosition4);break;
            }

        }

    }
}