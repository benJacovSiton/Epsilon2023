package com.example.guessthenumber.quiz;

import android.content.Context;

import com.example.guessthenumber.gameMode.question;

import java.util.ArrayList;
import java.util.Random;

public class NotASimpleCalculationQuiz {

    public ArrayList<Integer> setUpNotASimpleCalculationIcons(Context context){
        ArrayList<Integer> mathIcons = new ArrayList<>();
        for (int i = 1; i <= 14; i++) {
            int resourceId = context.getResources().getIdentifier("math" + i, "drawable", context.getPackageName());
            mathIcons.add(resourceId);
        }
        return setUpRandomNotASimpleCalculationIcons(mathIcons);
    }
    public ArrayList<Integer>setUpRandomNotASimpleCalculationIcons(ArrayList<Integer> notASimpleCalculationIcons){
        ArrayList<Integer>randomNotASimpleCalculationIcons = new ArrayList<>();
        Random random = new Random();
        for(int i = 0 ; i < question.numOfQ ; i++){
            int randoNum = random.nextInt(notASimpleCalculationIcons.size() -1);
            int randomIcon = random.nextInt(notASimpleCalculationIcons.size() - randoNum);
            randomNotASimpleCalculationIcons.add(notASimpleCalculationIcons.get(randomIcon));
            notASimpleCalculationIcons.remove(randomIcon);
        }
        return randomNotASimpleCalculationIcons;
    }

    public ArrayList<question>setUpNotASimpleCalculationQuestions(){

        ArrayList<question>mathematics = new ArrayList<>();
        mathematics.add(new question("מהו התוצאה של חמישה כפול שמונה?", 40));
        mathematics.add(new question("מהו השורש הריבועי של 169?", 13));
        mathematics.add(new question("מהו סכום המספרים 2468 ו-1357?", 3825));
        mathematics.add(new question("מהו השורש הריבועי של 100?", 10));
        mathematics.add(new question("מהו התוצאה של 12 חזקת 2 ?", 144));
        mathematics.add(new question("כמה יש במכפלה של 12 ו-12?", 144));
        mathematics.add(new question("מהו סכום המספרים 9876 ו-5432?", 15308));
        mathematics.add(new question("מהו השורש הריבועי של 225?", 15));
        mathematics.add(new question("כמה יש במכפלה של 11 ו-11?", 121));
        mathematics.add(new question("מהו התוצאה של 15 חזקת 3 ?", 3375));
        mathematics.add(new question("כמה יש במכפלה של 13 ו-13?", 169));
        mathematics.add(new question("מהו סכום המספרים 8765 ו-4321?", 13086));
        mathematics.add(new question("מהו השורש הריבועי של 144?", 12));
        mathematics.add(new question("כמה יש במכפלה של 14 ו-14?", 196));
        mathematics.add(new question("מהו התוצאה של 18 חזקת 2 ?", 324));
        mathematics.add(new question("כמה יש במכפלה של 15 ו-15?", 225));
        mathematics.add(new question("מהו סכום המספרים 5432 ו-9876?", 15308));
        mathematics.add(new question("מהו השורש הריבועי של 400?", 20));
        mathematics.add(new question("כמה יש במכפלה של 16 ו-16?", 256));
        mathematics.add(new question("מהי התוצאה של 20 חזקת 3 ?", 8000));
        mathematics.add(new question("מהי הסכום של 345 ו-567?", 912));
        mathematics.add(new question("מהי ההפרש בין 789 ל-243?", 546));
        mathematics.add(new question("כמה יש במכפלה של 24 ו-15?", 360));
        mathematics.add(new question("מהו התוצאה של 845 מחולק ב-5?", 169));
        mathematics.add(new question("מהו השורש הריבועי של 961?", 31));
        mathematics.add(new question("כמה יש ב-345 פחות 187?", 158));
        mathematics.add(new question("מהי המכפלה של 57 ו-19?", 1083));
        mathematics.add(new question("כמה יש במכפלה של 12 ו-8?", 96));
        mathematics.add(new question("מהי התוצאה של 819 מחולק ב-9?", 91));
        mathematics.add(new question("מהו השורש הריבועי של 625?", 25));
        mathematics.add(new question("כמה יש ב-526 פחות 137?", 389));
        mathematics.add(new question("מהי המכפלה של 47 ו-13?", 611));
        mathematics.add(new question("כמה יש במכפלה של 17 ו-16?", 272));
        mathematics.add(new question("מהי התוצאה של 729 מחולק ב-9?", 81));
        mathematics.add(new question("כמה יש ב-427 פחות 215?", 212));
        mathematics.add(new question("מהי המכפלה של 35 ו-28?", 980));
        mathematics.add(new question("כמה יש במכפלה של 25 ו-12?", 300));
        mathematics.add(new question("מהי התוצאה של 1,240 מחולק ב-4?", 310));
        mathematics.add(new question("מהו השורש הריבועי של 484?", 22));
        mathematics.add(new question("כמה יש ב-648 פחות 312?", 336));
        mathematics.add(new question("מהי המכפלה של 39 ו-21?", 819));
        mathematics.add(new question("כמה יש במכפלה של 29 ו-17?", 493));
        mathematics.add(new question("מהי התוצאה של 864 מחולק ב-6?", 144));
        mathematics.add(new question("מהי הסכום של 521 ו-379?", 900));
        mathematics.add(new question("כמה יש במכפלה של 34 ו-26?", 884));
        mathematics.add(new question("מהי התוצאה של 1,258 מחולק ב-2?", 629));
        mathematics.add(new question("מהו השורש הריבועי של 576?", 24));
        mathematics.add(new question("כמה יש ב-839 פחות 421?", 418));
        mathematics.add(new question("מהי המכפלה של 45 ו-11?", 495));
        mathematics.add(new question("כמה יש במכפלה של 19 ו-23?", 437));
        mathematics.add(new question("מהי התוצאה של 1,200 מחולק ב-3?", 400));
        mathematics.add(new question("מהו השורש הריבועי של 625?", 25));
        mathematics.add(new question("כמה יש ב-967 פחות 568?", 399));
        mathematics.add(new question("מהי המכפלה של 32 ו-27?", 864));
        mathematics.add(new question("כמה יש במכפלה של 18 ו-25?", 450));
        mathematics.add(new question("מהי התוצאה של 1,836 מחולק ב-6?", 306));
        mathematics.add(new question("כמה יש ב-782 פחות 296?", 486));
        mathematics.add(new question("מהי המכפלה של 37 ו-14?", 518));
        mathematics.add(new question("כמה יש במכפלה של 21 ו-19?", 399));
        mathematics.add(new question("מהי התוצאה של 1,200 מחולק ב-4?", 300));
        mathematics.add(new question("מהו השורש הריבועי של 400?", 20));
        mathematics.add(new question("כמה יש ב-675 פחות 293?", 382));
        mathematics.add(new question("מהי המכפלה של 24 ו-32?", 768));
        mathematics.add(new question("כמה יש במכפלה של 15 ו-28?", 420));
        mathematics.add(new question("מהי התוצאה של 1,800 מחולק ב-6?", 300));
        mathematics.add(new question("כמה יש ב-892 פחות 362?", 530));
        mathematics.add(new question("מהי המכפלה של 42 ו-13?", 546));
        mathematics.add(new question("כמה יש במכפלה של 16 ו-18?", 288));
        mathematics.add(new question("מהי התוצאה של 2,550 מחולק ב-6?", 425));
        mathematics.add(new question("כמה יש ב-729 פחות 418?", 311));
        mathematics.add(new question("מהי המכפלה של 23 ו-12?", 276));
        mathematics.add(new question("כמה יש במכפלה של 14 ו-27?", 378));
        mathematics.add(new question("מהי התוצאה של 2,400 מחולק ב-8?", 300));
        mathematics.add(new question("מהו השורש הריבועי של 576?", 24));
        mathematics.add(new question("כמה יש ב-862 פחות 537?", 325));
        mathematics.add(new question("מהי המכפלה של 31 ו-17?", 527));
        mathematics.add(new question("כמה יש במכפלה של 22 ו-19?", 418));
        mathematics.add(new question("מהי התוצאה של 3,240 מחולק ב-9?", 360));
        mathematics.add(new question("כמה יש ב-954 פחות 642?", 312));
        mathematics.add(new question("מהי המכפלה של 27 ו-16?", 432));
        mathematics.add(new question("כמה יש במכפלה של 21 ו-25?", 525));
        mathematics.add(new question("מהי התוצאה של 3,600 מחולק ב-6?", 600));
        mathematics.add(new question("כמה יש ב-1,024 פחות 314?", 710));
        mathematics.add(new question("מהי המכפלה של 38 ו-14?", 532));
        mathematics.add(new question("כמה יש במכפלה של 17 ו-21?", 357));
        mathematics.add(new question("מהי התוצאה של 2,760 מחולק ב-8?", 345));
        mathematics.add(new question("כמה יש ב-925 פחות 417?", 508));
        mathematics.add(new question("מהי המכפלה של 41 ו-13?", 533));
        mathematics.add(new question("כמה יש במכפלה של 24 ו-26?", 624));
        mathematics.add(new question("מהי התוצאה של 2,160 מחולק ב-9?", 240));
        mathematics.add(new question("כמה יש ב-1,245 פחות 543?", 702));

        return setUpRandomNotASimpleCalculationQuestions(mathematics);
    }

    public ArrayList<question>setUpRandomNotASimpleCalculationQuestions(ArrayList<question>notASimpleCalculationQuestions){
        ArrayList<question>randomNotASimpleCalculation= new ArrayList<>();
        Random random = new Random();
        for (int i = 0 ; i < question.numOfQ ; i++)
        {
            int randoNum = random.nextInt(notASimpleCalculationQuestions.size());
            int randomNumber = random.nextInt(notASimpleCalculationQuestions.size() - randoNum);
            randomNotASimpleCalculation.add(notASimpleCalculationQuestions.get(randomNumber));
            notASimpleCalculationQuestions.remove(randomNumber);
        }
        return randomNotASimpleCalculation;
    }


}
