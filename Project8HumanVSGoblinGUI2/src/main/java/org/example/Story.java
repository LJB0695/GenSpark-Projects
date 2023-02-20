package org.example;

public class Story {
    //This class will handle dialogue in the game.
    Game game;
    UI ui;
    TransitionManager transitionManager;
    Human human = new Human();
    Goblin goblin = new Goblin();
    int diamond;
    public Story(Game g, UI userInterface, TransitionManager tm) {
        game = g;
        ui = userInterface;
        transitionManager = tm;

    }

    public void playerSetup() {
        human.health = 15;
        ui.healthNumberLabel.setText("" + human.health);
        human.currentWeapon = new Sword();
        ui.weaponNameLabel.setText(human.currentWeapon.name);
        diamond = 0;

    }
    public void selectPosition(String nextPosition){
        switch (nextPosition) {
            case "townGate": storyBegins(); break;
            case "talkToGuard": talkToGuard(); break;
            case "attackTheGuard": attackTheGuard(); break;
            case "crossRoad" : goToCrossRoad(); break;
            case "north": goNorth(); break;
            case "east": goEast(); break;
            case "west": goWest(); break;
            case "fight": fight(); break;
            case "playerAttacks": playerAttacks(); break;
            case "goblinAttacks" : goblinAttacks(); break;
            case "win": win(); break;
            case "lose": lose(); break;
            case "mainMenu": mainMenu(); break;
            case "ending" : ending(); break;
        }
    }

    public void storyBegins() {
        ui.mainTextArea.setText("You arrive at the front gate of a town. \n A guard asks what you are doing?");
        ui.choice1.setText("Talk to the guard.");
        ui.choice2.setText("Attack the guard.");
        ui.choice3.setText("Go to the cross road.");
        ui.choice4.setText("");

        game.nextPosition1 = "talkToGuard";
        game.nextPosition2 = "attackTheGuard";
        game.nextPosition3 = "crossRoad";
        game.nextPosition4 = "";
    }
    public void talkToGuard() {
        if(diamond == 0){
            ui.mainTextArea.setText("Hello sir, There is a giant goblin in the forest.\n Can you kill it for us and save the town?");
            ui.choice1.setText("Back");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "townGate";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        } else if (diamond == 1) {
            ending();
        }



    }
    public void attackTheGuard(){
        ui.mainTextArea.setText("The guard almost killed you, your health decreased by 5.");
        human.health = human.health - 5;
        ui.healthNumberLabel.setText("" + human.health);
        ui.choice1.setText("Back");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "townGate";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }
    public void goToCrossRoad(){
        ui.mainTextArea.setText("You arrive at a cross road.\n Going South will bring you back to town.\n Which direction do you choose?");
        ui.choice1.setText("Go North");
        ui.choice2.setText("Go East");
        ui.choice3.setText("Go South");
        ui.choice4.setText("Go West");

        game.nextPosition1 = "north";
        game.nextPosition2 = "east";
        game.nextPosition3 = "townGate";
        game.nextPosition4 = "west";

    }
    public void goNorth() {
        ui.mainTextArea.setText("You found a treasure chest with a health serum inside!\n You health increased by 5!");
        human.health = human.health + 5;
        ui.healthNumberLabel.setText("" + human.health);
        ui.choice1.setText("Go back to the cross road");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void goEast() {
        int i = new java.util.Random().nextInt(26) + 1;
        if (i <= 10) {
            ui.mainTextArea.setText("You've stumbled upon a bow and arrow! \n This is your new weapon.");
            human.currentWeapon = new BowAndArrow();
        }else if (i <= 20) {
            ui.mainTextArea.setText("You've stumbled upon a battle axe! Your weapon is now a battle axe.");
            human.currentWeapon = new BattleAxe();
        } else {
            ui.mainTextArea.setText("You've stumbled upon a War Hammer! Your weapon is now a War Hammer.");
            human.currentWeapon = new WarHammer();
        }
        ui.weaponNameLabel.setText(human.currentWeapon.name);
        ui.choice1.setText("Go back to the cross road");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void goWest() {
        int i = new java.util.Random().nextInt(100) + 1;
        if (i < 75){
            goblin = new GiantGoblin();
        }else {
            goblin = new SuperGoblin();
        }

        ui.mainTextArea.setText("You've ran into the " + goblin.name + " !\n What will you do?");
        ui.choice1.setText("Fight!");
        ui.choice2.setText("Run!");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "fight";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void fight() {
        ui.mainTextArea.setText(goblin.name + " 's health is : " + goblin.health + " .");
        ui.choice1.setText("Attack!");
        ui.choice2.setText("Run!");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "playerAttacks";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }
    public void playerAttacks() {
        int humanDamage = new java.util.Random().nextInt(human.currentWeapon.damage);
        ui.mainTextArea.setText("You attacked the " + goblin.name + " and damaged it for : " + humanDamage);
        goblin.health = goblin.health - humanDamage;
        ui.choice1.setText("Goblin attacks!");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if(goblin.health > 0) {
            game.nextPosition1 = "goblinAttacks";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        } else if(goblin.health < 0) {
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

    }

    public void goblinAttacks() {
        int goblinDamage = new java.util.Random().nextInt(goblin.attack);
        ui.mainTextArea.setText("The goblin attacked you for " + goblinDamage + " damage!");
        human.health = human.health - goblinDamage;
        ui.healthNumberLabel.setText("" + human.health);
        ui.choice1.setText("Goblin attacks!");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (human.health > 0) {
            game.nextPosition1 = "fight";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        } else if (human.health < 0) {
            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        }

    }

    public void win() {
        ui.mainTextArea.setText("You killed the " + goblin.name + " and obtained a diamond!");
        diamond = 1;
        ui.choice1.setText("Go back to the cross road.");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void lose() {
        ui.mainTextArea.setText("You are dead! The goblin killed you.\n GAME OVER");
        diamond = 1;
        ui.choice1.setText("Go to the main menu");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "mainMenu";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void ending() {
        ui.mainTextArea.setText("Guard: You killed the goblin and grabbed the diamond!\n You may enter the town and have unlimited gold!\n Game over");
        ui.choice1.setVisible(false);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);

    }

    public void mainMenu() {
        playerSetup();
        transitionManager.showTitleScreen();
    }





}
