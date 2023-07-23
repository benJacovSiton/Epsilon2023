package com.example.guessthenumber.quiz;

import android.content.Context;

import com.example.guessthenumber.gameMode.question;

import java.util.ArrayList;
import java.util.Random;

public class HistoryQuiz {

    public ArrayList<Integer> setUpHistoryIcons(Context context){
        ArrayList<Integer> historyIcons = new ArrayList<>();
        for (int i = 1; i <= 34; i++) {
            int resourceId = context.getResources().getIdentifier("history" + i, "drawable", context.getPackageName());
            historyIcons.add(resourceId);
        }

        return setUpRandomHistoryIcons(historyIcons);
    }
    public ArrayList<Integer>setUpRandomHistoryIcons(ArrayList<Integer> historyIcons){
        ArrayList<Integer>randomHistoryIcons = new ArrayList<>();
        Random random = new Random();
        for(int i = 0 ; i < question.numOfQ ; i++){
            int randoNum = random.nextInt(historyIcons.size() - 1);
            int randomIcon = random.nextInt(historyIcons.size() - randoNum);
            randomHistoryIcons.add(historyIcons.get(randomIcon));
            historyIcons.remove(randomIcon);
        }
        return randomHistoryIcons;
    }


    public ArrayList<question>setUpHistoryQuestions(){

        ArrayList<question>History = new ArrayList<>();
        History.add(new question("מתי נפלה חומת ברלין?", 1989));
        History.add(new question("כמה כוכבים יש בדגל אוסטרליה?", 6));
        History.add(new question("באיזו שנה התרחש אסון צ’רנוביל?", 1986));
        History.add(new question("באיזו שנה נפתחה רישמית תעלת פנמה ?", 1914));
        History.add(new question("באיזו שנה הגיע כריסטופר קולומבוס לאמריקה?", 1492));
        History.add(new question("כמה חתימות יש בהכרזת עצמאות של ארצות הברית?", 56));
        History.add(new question("באיזו שנה החלה מלחמת העולם הראשונה?", 1914));
        History.add(new question("באיזו שנה החלה מלחמת העולם השנייה?", 1939));
        History.add(new question("כמה שנים נמשכה מלחמת מאה השנים?", 116));
        History.add(new question("כמה ימים נמשך קרב ווטרלו?", 1));
        History.add(new question("באיזו שנה התרחשה המהפכה התעשייתית?", 1760));
        History.add(new question("באיזו שנה החלה מלחמת האזרחים בספרד?", 1936));
        History.add(new question("באיזו שנה התרחשה המהפכה הצרפתית?", 1789));
        History.add(new question("באיזו שנה נחתם הסכם וורסאי?", 1871));
        History.add(new question("כמה ימים נמשך המצור על לנינגרד במהלך מלחמת העולם השנייה?", 872));
        History.add(new question("באיזו שנה נפלה טרויה?", 1184));
        History.add(new question("כמה שנים ערכה מלחמת טרויה?", 10));
        History.add(new question("מתי הוקמה ברית המועצות?", 1922));
        History.add(new question("מתי פורקה ברית המועצות?", 1991));
        History.add(new question("כמה שנים נמשך משבר הטילים בקובה?", 13));
        History.add(new question("באיזו מאה החלה תקופת הרנסנס?", 14));
        History.add(new question("באיזו שנה החלה האינקוויזיציה הספרדית?", 1478));
        History.add(new question("באיזו מאה התרחשה המגיפה השחורה?", 14));
        History.add(new question("מתי התגלה הפניצילן?", 1928));
        History.add(new question("באיזו שנה התרחשה השתלת האיברים המוצלחת הראשונה באדם?", 1954));
        History.add(new question("כמה שנים התרחשה המלחמה הקרה?", 45));
        History.add(new question("באיזו שנה התגלה מבנה ה-DNA?", 1953));
        History.add(new question("באיזו שנה הוצעה תורת היחסות הכללית על ידי אלברט איינשטיין?", 1915));
        History.add(new question("באיזו שנה נחנך פסל החירות בניו יורק?", 1886));
        History.add(new question("באיזו שנה נחתה משימת אפולו 11 על הירח?", 1969));
        History.add(new question("מתי הסתיימה מלחמת העולם השנייה?", 1945));
        History.add(new question("באיזו שנה שקעה הספינה טיטניק?", 1912));
        History.add(new question("באיזו שנה הסתיימה המלחמה הקרה?", 1991));
        History.add(new question("באיזו שנה הושלם הטאג’ מאהל?", 1653));
        History.add(new question("כמה נשים היו למלך הנרי השמיני?", 6));
        History.add(new question("באיזו שנה הכריזה ארצות הברית על עצמאות מבריטניה??", 1776));
        History.add(new question("כמה מלחמות עולם היו בסה”כ?", 2));
        History.add(new question("כמה שנים נמשך המצור על מצדה במהלך המלחמה היהודית-רומית הראשונה?", 3));
        History.add(new question("כמה ימים נמשך המצור על לנינגרד במהלך מלחמת העולם השנייה?", 872));
        History.add(new question("באיזה גיל הלכה לעולמה אליזבת השנייה,מלכת אנגליה?", 96));
        History.add(new question("אברהם לינקולין היה נשיא מספר ___ של ארצות הברית", 16));
        History.add(new question("באיזו שנה נרצח אברהם לינקולן?", 1865));
        History.add(new question("באיזו שנה החל טקס פרס נובל לשלום?", 1901));
        History.add(new question("כמה גלי צונאמי היו בעולם נכון ל2023?", 28));
        History.add(new question("באיזו שנה הוקמה בירת ברזיל?", 1960));
        History.add(new question("מתי הסתיים שלטון האפרטהייד בדרום אפריקה?", 1990));
        History.add(new question("כמה מטוסים נחטפו באסון התאומים?", 4));
        History.add(new question("באיזו שנה קרה אסון התאומים?", 2001));
        History.add(new question("כמה אנשים ניספו באסון הטיטניק?", 1514));
        History.add(new question("כמה שנים נמשכה המלחמה הקרה?", 44));
        History.add(new question("באיזו שנה נחתו לראשונה על הירח?", 1969));
        History.add(new question("באיזו שנה התרחשה ההתקפה על פרל הארבור?", 1941));
        History.add(new question("כמה מחבלים לקחו חלק באסון התאומים?", 19));


        return setUpRandomHistoryQuestions(History);
    }
    public ArrayList<question>setUpRandomHistoryQuestions(ArrayList<question>historyQuestions){
        ArrayList<question>randomHistory = new ArrayList<>();
        Random random = new Random();
        for (int i = 0 ; i < question.numOfQ ; i++)
        {
            int randoNum = random.nextInt(historyQuestions.size());
            int randomNumber = random.nextInt(historyQuestions.size() - randoNum);
            randomHistory.add(historyQuestions.get(randomNumber));
            historyQuestions.remove(randomNumber);
        }
        return randomHistory;
    }
}


