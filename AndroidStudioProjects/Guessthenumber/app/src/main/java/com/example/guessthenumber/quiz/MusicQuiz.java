package com.example.guessthenumber.quiz;

import android.content.Context;

import com.example.guessthenumber.gameMode.question;

import java.util.ArrayList;
import java.util.Random;

public class MusicQuiz{

    public ArrayList<Integer> setUpMusicIcons(Context context){
        ArrayList<Integer> musicIcons = new ArrayList<>();
        for (int i = 1; i <= 14; i++) {
            int resourceId = context.getResources().getIdentifier("music" + i, "drawable", context.getPackageName());
            musicIcons.add(resourceId);
        }

        return setUpRandomMusicIcons(musicIcons);
    }
    public ArrayList<Integer>setUpRandomMusicIcons(ArrayList<Integer>musicIcons){
        ArrayList<Integer>randomMusicIcons = new ArrayList<>();
        Random random = new Random();
        for(int i = 0 ; i < question.numOfQ ; i++){
            int randoNum = random.nextInt(musicIcons.size() - 1);
            int randomIcon = random.nextInt(musicIcons.size() - randoNum);
            randomMusicIcons.add(musicIcons.get(randomIcon));
            musicIcons.remove(randomIcon);
        }
        return randomMusicIcons;
    }

    public ArrayList<question> setUpMusicQuestions(){
        ArrayList<question>musicQuestions = new ArrayList<>();
        musicQuestions.add(new question(" כמה אלבומים הוציא מאיר אריאל  ? " ,8));
        musicQuestions.add(new question(" כמה אלבומים הוציא בוב מארלי  ? " ,16));
        musicQuestions.add(new question(" כמה חברים בלהקת העל הרד הוט צ'ילי פפרס  ? " ,4));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום Californication של להקת העל הרד הוט צ'ילי פפרס  ? " ,1999));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום המופת Blood Sugar Sex Magik של להקת העל הרד הוט צ'ילי פפרס  ? " ,1991));
        musicQuestions.add(new question(" כמה אלבומים הוציאו הלהקה הדלתות  ? " ,9));
        musicQuestions.add(new question(" באיזה גיל נפטר מאיר אריאל  ? " ,57));
        musicQuestions.add(new question(" באיזה גיל נפטר בוב מארלי  ? " ,36));
        musicQuestions.add(new question(" באיזו שנה נפטר אריק אינשטיין  ? " ,2013));
        musicQuestions.add(new question(" באיזו שנה נפטר בוב מארלי  ? " ,1981));
        musicQuestions.add(new question(" באיזו שנה הוציאו להקת פינק פלויד את האלבום הנצחי הצד האפל של הירח  ? " ,1973));
        musicQuestions.add(new question(" באיזו שנה הוציאו להקת פינק פלויד את האלבום הקונספט הייחודי החומה  ? " ,1979));
        musicQuestions.add(new question(" באיזו שנה הוציאו להקת פינק פלויד את האלבום Wish You Were Here  ? " ,1975));
        musicQuestions.add(new question(" באיזו שנה הוציאו להקת פינק פלויד את האלבום Atom Heart Mother  ? " ,1970));
        musicQuestions.add(new question(" באיזו שנה הוציאו להקת פינק פלויד את האלבום The Piper at the Gates of Dawn  ? " ,1967));
        musicQuestions.add(new question(" כמה אלבומים הוציאו להקת פינק פלויד  ? " ,15));
        musicQuestions.add(new question(" כמה חברי להקה הרכיבו את להקת פינק פלויד  ? " ,4));
        musicQuestions.add(new question(" כמה אלבומים הוציאו הביטלס  ? " ,13));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום הראשון של הביטלס Please Please Me  ? " ,1963));
        musicQuestions.add(new question(" כמה חברי להקה היו בביטלס  ? " ,4));
        musicQuestions.add(new question(" באיזו שנה התפרקו הביטלס  ? " ,1970));
        musicQuestions.add(new question(" באיזו שנה התרחש היום שבו המוזיקה מתה(התרסקות המטוס של באדי הולי)  ? " ,1959));
        musicQuestions.add(new question(" באיזו שנה נרצח הזמר האגדי ג'ון לנון  ? " ,1980));
        musicQuestions.add(new question(" באיזו שנה נרצח זמר הסול האגדי מרווין גיי על ידי אביו  ? " ,1984));
        musicQuestions.add(new question(" באיזה גיל מת הגיטריסט הנודע ג'ימי הנדריקס  ? " ,27));
        musicQuestions.add(new question(" באיזה גיל מת החלוץ רוברט ג'ונסון  ? " ,27));
        musicQuestions.add(new question(" באיזה גיל מת מלך הלטאות ג'ים מוריסון  ? " ,27));
        musicQuestions.add(new question(" באיזה גיל מתה הזמרת האייקונית ג'ניס ג'ופלין  ? " ,27));
        musicQuestions.add(new question(" באיזה גיל מתה הזמרת האייקונית איימי ויינהאוס  ? " ,27));
        musicQuestions.add(new question(" באיזה גיל מת מלך הגראנג' קורט קוביין  ? " ,27));
        musicQuestions.add(new question(" באיזה שנה יצא האלבום הלבן של הביטלס  ? " ,1968));
        musicQuestions.add(new question(" באיזה שנה יצא האלבום Abbey Road של הביטלס  ? " ,1969 ));
        musicQuestions.add(new question(" באיזה שנה יצא האלבום הצוללת הצהובה של הביטלס  ? " ,1969 ));
        musicQuestions.add(new question(" באיזה גיל מת הזמר האהוב מאק מילר  ? " ,26));
        musicQuestions.add(new question(" באיזה גיל מת הזמר האהוד ג'וס וורלד  ? " ,21));
        musicQuestions.add(new question(" באיזה גיל נרצח בביתו הזמר האהוב פופ סמוק  ? " ,20));
        musicQuestions.add(new question(" באיזו שנה נרצח טופאק  ? " ,1996));
        musicQuestions.add(new question(" באיזו שנה התחיל טופאק את הקריירה  ? " ,1987));
        musicQuestions.add(new question(" באיזו שנה נרצח ביגי  ? " ,1997));
        musicQuestions.add(new question(" באיזו שנה התחיל ביגי את הקריירה  ? " ,1993));
        musicQuestions.add(new question(" אלבום מפורסם של בוב דילן highway  ? " ,61));
        musicQuestions.add(new question(" אלבום של ביונסה  ? " ,4));
        musicQuestions.add(new question(" אלבום של אדל בשנת 2011  ? " ,21));
        musicQuestions.add(new question(" אלבום של אדל בשנת 2008  ? " ,19));
        musicQuestions.add(new question(" אלבום של וואן הילן  ? " ,5150));
        musicQuestions.add(new question(" אלבום של פארל ג'ם  ? " ,10));
        musicQuestions.add(new question("  אלבום של וו טאנג קלאן Chambers_ ? " ,36));
        musicQuestions.add(new question(" אלבום של קנייה ווסט s & Heartbreak_ ? " ,808));
        musicQuestions.add(new question(" באיזו שנה יצא אלבומה האייקוני Nevermind של להקת נירוונה ? " ,1991));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום העל הזמני Sgt. Pepper's Lonely Hearts Club Band של להקת הביטלס  ? " ,1967));
        musicQuestions.add(new question(" באיזו שנה נפטר לאונרד כהן ? " ,2016));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום הראשון של לאונרד כהן ? " ,1967));
        musicQuestions.add(new question(" באיזו שנה יצא אלבומו הראשון Infinite של אמינם ? " ,1996));
        musicQuestions.add(new question(" באיזו שנה יצא אלבומו הראשון Doggystyle של סנופ דוג ? " ,1993));
        musicQuestions.add(new question(" באיזו שנה יצא אלבומו הראשון Thank Me Later של דרייק ? " ,2010));
        musicQuestions.add(new question(" באיזו שנה יצא אלבום הלהיט after hours של הזמר דה וויקנד ? " ,2013));
        musicQuestions.add(new question(" באיזו שנה יצא אלבומו הראשון של המלך אלוויס פרסלי ? " ,1956));
        musicQuestions.add(new question(" באיזו שנה נפטר המלך אלוויס פרסלי ? " ,1977));
        musicQuestions.add(new question(" באיזו גיל נפטר המלך אלוויס פרסלי ? " ,42));
        musicQuestions.add(new question(" באיזו שנה יצא אלבומו הראשון של הבוס ברוס ספרינגסטין ? " ,1973));
        musicQuestions.add(new question(" באיזו שנה יצא אלבום הלהיט Astroworld של הזמר האהוב טראוויס סקוט ? " ,2018));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום Blonde של הזמר האחד והיחיד פרנק אושן ? " ,2016));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום Channel ORANGE של הזמר האחד והיחיד פרנק אושן ? " ,2012));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום Swimming של הזמר מאק מילר ? " ,2018));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום Circles של הזמר מאק מילר ? " ,2020));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום טונהפארק של טונה ? " ,2020));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום גם זה יעבור של טונה ? " ,2015));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום המזרח הפרוע של טונה ? " ,2021));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום ועכשיו לחלק האינטרגלקטי של טונה ? " ,2019));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום ועכשיו לחלק האומנותי של רביד פלוטניק ? " ,2019));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום תוך כדי תנועה של רביד פלוטניק ? " ,2021));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום הראשון Sadnecessary של מילקי צ'אנס ? " ,2018));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום השני Blossom  של מילקי צ'אנס ? " ,2017));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום השלישי Mind The Moon של מילקי צ'אנס ? " ,2019));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום הרביעי Trip Tape של מילקי צ'אנס ? " ,2021));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום הרביעי Trip Tape II של מילקי צ'אנס ? " ,2022));
        musicQuestions.add(new question(" כמה חברים בלהקה מילקי צ'אנס  ? " ,2));
        musicQuestions.add(new question(" באיזו שנה יצא האלבום הראשון של הלהקה מרסדס בנד  ? " ,2004));

        return setUpRandomMusicQuestions(musicQuestions);
    }
    public ArrayList<question> setUpRandomMusicQuestions(ArrayList<question>musicQuestions){
        ArrayList<question>randomMusicQuestions = new ArrayList<>();
        Random random = new Random();
        for (int i = 0 ; i < question.numOfQ ; i++)
        {
            int randoNum = random.nextInt(musicQuestions.size());
            int randomQuestion = random.nextInt(musicQuestions.size() - randoNum);
            randomMusicQuestions.add(musicQuestions.get(randomQuestion));
            musicQuestions.remove(randomQuestion);
        }

        return randomMusicQuestions;
    }
}
