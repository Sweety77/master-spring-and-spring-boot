package com.in28minutes.learn_spring_framework.game;

public class GameRunner {
//    MarioGame game;
//SuperContraGame game;

    private GamingConsole game;

/*    public GameRunner(MarioGame game) {
        this.game = game;
    }*/

    /*public GameRunner(SuperContraGame game) {
        this.game = game;
    }*/

    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running Game :" +game.toString());
        game.up();
        game.left();
        game.right();
        game.down();
    }
}
