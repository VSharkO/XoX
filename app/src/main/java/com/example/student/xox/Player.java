package com.example.student.xox;

import java.util.jar.Attributes;

/**
 * Created by vsharko on 09.12.17..
 */

public class Player {
    private String name;
    private Character sign;
    private int numOfWins=0;

    public Player(String name,Character sign) {
        this.name = name;
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public Character getSign() {
        return sign;
    }

    public int getNumOfWins() {
        return numOfWins;
    }

    public void setNumOfWins(int numOfWins) {
        this.numOfWins = numOfWins;
    }
}
