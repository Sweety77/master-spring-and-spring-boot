package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.PacmanGame;

public class App01GamingBasicJava {

    public static void main(String[] args) {

        // var is type inference keyword introduced in Java 10 -> allows compiler to infer the type of the variable based on the value assigned.


        /*
        Here to Introduce another game we need to do a lot of changes in code So, for that reason  may take some meore type
         */

//        var game = new MarioGame();
//        var game = new SuperContraGame();
        var game = new PacmanGame();

        var gameRunner = new GameRunner(game);

        gameRunner.run();
    }
}
