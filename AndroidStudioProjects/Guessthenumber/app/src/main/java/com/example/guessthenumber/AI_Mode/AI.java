package com.example.guessthenumber.AI_Mode;

import com.example.guessthenumber.gameMode.question;

import java.util.Random;

public class AI {

    Random rnd;

    public AI() {
        this.rnd = new Random();
    }

    public Boolean rightAnsOrNot(){ // מגריל אם המחשב צודק או טועה
       return 1 == rnd.nextInt(3); // מחזיר אמת או שקר - המספר שהוגרל מחזיר 1 משמע צדק
    }


    // כל זה למען הדינמיות של תשובות המחשב
    public int wrongGuess(question question){
        int value = rnd.nextInt(5)+1;
        int numAns = 0;
        int temp = rnd.nextInt(2);
        if(temp == 0){
            numAns = question.getA() - value;
            return numAns;
        }
        numAns = question.getA() + value;
        return numAns;

    }


}
