package com.example.guessthenumber.quiz;

import android.content.Context;

import com.example.guessthenumber.gameMode.question;

import java.util.ArrayList;
import java.util.Random;

public class GuinnessWorldRecordsQuiz {

    public ArrayList<Integer> setUpGuinnessWorldRecordsIcons(Context context) {
        ArrayList<Integer> guinnessWorldRecordsIcons = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int resourceId = context.getResources().getIdentifier("guinnessrecords" + i, "drawable", context.getPackageName());
            guinnessWorldRecordsIcons.add(resourceId);
        }

        return guinnessWorldRecordsIcons;
    }

    public ArrayList<question>setUpGuinnessWorldRecordsQuestions(){

        ArrayList<question>guinnessWorldRecords = new ArrayList<>();

        guinnessWorldRecords.add(new question("מהו ארכו של הזקן האנושי ביותר בסנטימטרים?", 244));
        guinnessWorldRecords.add(new question("מהו גובהו של האדם הגבוה ביותר החי בסנטימטרים?", 251));
        guinnessWorldRecords.add(new question("מהו מספר הנקניקיות המרבי שנאכל במשך 10 דקות? ", 75));
        guinnessWorldRecords.add(new question("מהו הקפיצה האנכית הגבוהה ביותר של אדם במטרים ?", 122));
        guinnessWorldRecords.add(new question("מהו קוטר הפיצה הגדולה ביותר שנעשתה במטרים?", 37));
        guinnessWorldRecords.add(new question("מהו הציור היקר ביותר שנמכר אי פעם במיליארדי דולרים?", 4));
        guinnessWorldRecords.add(new question("מהו המהירות הגבוהה ביותר שהושגה על ידי כלי רכב קרקעי במיילים לשעה?", 1227));
        guinnessWorldRecords.add(new question("מהו משך הקריירה הארוך ביותר של שחקן כדורגל מקצועי בשנים?", 33));
        guinnessWorldRecords.add(new question("מהו אורך השן האנושית הארוכה ביותר שהוסרה במילימטרים?", 37));
        guinnessWorldRecords.add(new question("מהו הגיל הגבוה ביותר של אדם שטפס את הר האוורסט?", 80));
        guinnessWorldRecords.add(new question("מהו משך הזמן הארוך ביותר של איזון על רגל אחת על ידי אדם בשעות?", 76));
        guinnessWorldRecords.add(new question("מהו מספר השפות הגבוה ביותר שאדם מדבר באופן שוטף ברמה שליטה?", 50));
        guinnessWorldRecords.add(new question("מהו מספר השכיבות שמיכה הגבוה ביותר במשך שעה?", 27352));
        guinnessWorldRecords.add(new question("מהו מספר הספרים הגבוה ביותר שנקראו על ידי אדם בשנה אחת?", 451));
        guinnessWorldRecords.add(new question("מהו המרחק הארוך ביותר שהולך יחף ברגליים על לגו במטרים?", 32));
        guinnessWorldRecords.add(new question("מהו מספר המשחקים בשחמט ששוחקו בו זמנית על ידי אדם אחד?", 523));
        guinnessWorldRecords.add(new question("מהו מספר הבלונים הגבוה ביותר שנופחו בדקה אחת?", 60));
        guinnessWorldRecords.add(new question("מהו מספר הספרות הגבוה ביותר של פי שנזכרות על ידי אדם?", 70000));
        guinnessWorldRecords.add(new question("מהו הזמן הארוך ביותר שבו רקד אדם באופן מתמיד בשעות?", 123));
        guinnessWorldRecords.add(new question("מהו הזמן הארוך ביותר שבו הוחזקה ישיבת פלאנק על ידי אדם בשעות?", 8));
        guinnessWorldRecords.add(new question("מהו מספר הפשיטות ידיים על כפות ידיים ביד אחת הגבוה ביותר במשך דקה אחת?", 79));
        guinnessWorldRecords.add(new question("מהו המרחק הארוך ביותר שנסע באופניים במשך 24 שעות בקילומטרים?", 1209));
        guinnessWorldRecords.add(new question("מהו מספר המילים הגבוה ביותר שהוקלדו בדקה אחת על מקלדת?", 212));
        guinnessWorldRecords.add(new question("מהי תוחלת החיים הארוכה ביותר שנרשמה בשנים האחרונות?", 122));
        guinnessWorldRecords.add(new question("כמה פירסינג היה לאליין דיווידסון כדי לקבוע את שיא האישה הכי פירסינג?", 9800));
        guinnessWorldRecords.add(new question("כמה בלוני אוויר חם שוגרו בו זמנית כדי לקבוע את השיא של איסוף הבלונים הגדול ביותר?", 433));
        guinnessWorldRecords.add(new question("בכמה בלונים השתמשו כדי לקבוע את השיא של פסל הבלונים הגדול ביותר?", 507000));
        guinnessWorldRecords.add(new question("מהו הזמן המהיר ביותר לרוץ מרתון על ידי אדם בשעות?", 2));
        guinnessWorldRecords.add(new question("כמה אנשים השתתפו בשיעור היוגה הגדול ביותר?", 35985));
        guinnessWorldRecords.add(new question("כמה כלבים השתתפו בשיעור היוגה לכלבים הגדול ביותר?", 267));
        guinnessWorldRecords.add(new question("כמה אנשים השתתפו באירוע הדומינו מזרן האנושי הגדול ביותר?", 1200));
        guinnessWorldRecords.add(new question("מה שיא הסלטות הרצופות שבוצע?", 36));
        guinnessWorldRecords.add(new question("מה שיא סיבובי הולה הופ הרצופים?", 166));
        guinnessWorldRecords.add(new question("מהי ההליכה הגבוהה ביותר שתועדה על חבל דק במטרים?", 1305));
        guinnessWorldRecords.add(new question("מה שיא הכדורים שאדם ליהט ברציפות?", 13));
        guinnessWorldRecords.add(new question("מהו גובהו של האיש הנמוך ביותר בעולם במילימטרים?", 546));
        guinnessWorldRecords.add(new question("מהו גובהו של האיש הגבוה ביותר בעולם במילימטרים?", 251));
        guinnessWorldRecords.add(new question("מה היה גילו של האיש המבוגר ביותר ששירת בצבא?", 85));
        guinnessWorldRecords.add(new question("מה אורכו של הסוס נדנדה הגדול ביותר בעולם בסמ?", 760));
        guinnessWorldRecords.add(new question("מתי התרחש השיעור הגדול ביותר בעולם?", 2014));
        guinnessWorldRecords.add(new question("באיזו שנה יוצרה החלווה הגדולה ביותר בעולם?", 2009));
        guinnessWorldRecords.add(new question("מה מספר הימים הרב ביותר שאדם היה קבור מתחת לאדמה?", 10));
        guinnessWorldRecords.add(new question("בכמה אחוזים מהגוף מקועקעים אצל האישה עם הכי הרבה קעקועים בעולם?", 95));
        guinnessWorldRecords.add(new question("מה מספר הקשיים המירבי שהוכנס לפה של אדם?", 400));
        guinnessWorldRecords.add(new question("מה גילו של האדם הצעיר ביותר שטיפס על הר האוורסט?", 13));

        return setUpRandomGuinnessWorldRecordsQuestions(guinnessWorldRecords);
    }

    public ArrayList<question>setUpRandomGuinnessWorldRecordsQuestions(ArrayList<question>guinnessWorldRecordsQuestions){
        ArrayList<question>randomGuinnessWorldRecords = new ArrayList<>();
        Random random = new Random();
        for (int i = 0 ; i < question.numOfQ ; i++)
        {
            int randoNum = random.nextInt(guinnessWorldRecordsQuestions.size());
            int randomNumber = random.nextInt(guinnessWorldRecordsQuestions.size() - randoNum);
            randomGuinnessWorldRecords.add(guinnessWorldRecordsQuestions.get(randomNumber));
            guinnessWorldRecordsQuestions.remove(randomNumber);
        }
        return randomGuinnessWorldRecords;
    }
}
