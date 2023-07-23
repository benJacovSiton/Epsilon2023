package com.example.guessthenumber.quiz;

import android.content.Context;

import com.example.guessthenumber.gameMode.question;

import java.util.ArrayList;
import java.util.Random;

public class TechnologyQuiz {

    public ArrayList<Integer> setUpTechnologyIcons(Context context){
        ArrayList<Integer> technologyIcons = new ArrayList<>();
        for (int i = 1; i <= 18; i++) {
            int resourceId = context.getResources().getIdentifier("technology" + i, "drawable", context.getPackageName());
            technologyIcons.add(resourceId);
        }

        return setUpRandomTechnologyIcons(technologyIcons);
    }
    public ArrayList<Integer>setUpRandomTechnologyIcons(ArrayList<Integer>technologyIcons){
        ArrayList<Integer>randomTechnologyIconsIcons = new ArrayList<>();
        Random random = new Random();
        for(int i = 0 ; i < question.numOfQ ; i++){
            int randoNum = random.nextInt(technologyIcons.size() -1);
            int randomIcon = random.nextInt(technologyIcons.size() - randoNum);
            randomTechnologyIconsIcons.add(technologyIcons.get(randomIcon));
            technologyIcons.remove(randomIcon);
        }
        return randomTechnologyIconsIcons;
    }

    public ArrayList<question>setUpTechnologyQuestions(){
        ArrayList<question>technology = new ArrayList<>();
        technology.add(new question("באיזו שנה יצא האייפון הראשון?", 2007));
        technology.add(new question("כמה מגה פיקסלים יש למצלמה הקדמית של iPhone 13 Pro?", 12));
        technology.add(new question("באיזו שנה הוזן לראשונה לשוק העכבר למחשב?", 1968));
        technology.add(new question("כמה ביטים יש בבייט?", 8));
        technology.add(new question("באיזו שנה יצאה הגרסה הראשונה של Windows?", 1985));
        technology.add(new question("באיזו שנה התבצעה ההצגה הראשונה של האינטרנט העולמי?", 1991));
        technology.add(new question("כמה ליבות יש למעבד Intel i7?", 8));
        technology.add(new question("באיזו שנה יצאה לראשונה לשוק מצלמה דיגיטלית?", 1990));
        technology.add(new question("כמה מקשים יש במקלדת סטנדרטית?", 104));
        technology.add(new question("באיזו שנה יצאה הגרסה הראשונה של Android?", 2008));
        technology.add(new question("באיזו שנה התבצע הטיסה הניסיונית הראשונה והמוצלחת של רקטת Falcon 1 של SpaceX?", 2008));
        technology.add(new question("באיזו שנה הושקה לראשונה מדפסת 3D?", 2009));
        technology.add(new question("באיזו שנה יצאה לאור לראשונה הגרסה הראשונה של מיקרוסופט אופיס?", 1989));
        technology.add(new question("באיזו שנה התבצע הטיסה הראשונה המוצלחת של מטוס האחים ורייט?", 1903));
        technology.add(new question("כמה גיגה-בייט יש בטרה-בייט?", 1024));
        technology.add(new question("באיזו שנה הושקה לראשונה משחק הווידאו המסחרי, Pong?", 1972));
        technology.add(new question("כמה צבעים יכול להציג מסך 8 ביט?", 256));
        technology.add(new question("באיזו שנה נחתה לראשונה החללית Apollo 11 על פני הירח?", 1969));
        technology.add(new question("באיזו שנה הושקו לראשונה משקפי מציאות וירטואלית?", 2016));
        technology.add(new question("באיזו שנה הושק לראשונה נגן תקליטורים דיגיטלי?", 1982));
        technology.add(new question("באיזו שנה יצאה הגרסה הראשונה של דפדפן האינטרנט Mozilla Firefox?", 2004));
        technology.add(new question("באיזו שנה התבצעה הטיסה הניסיונית הראשונה והמוצלחת של חללית SpaceX Dragon?", 2010));
        technology.add(new question("כמה כפתורים יש בעכבר מחשב סטנדרטי?", 3));
        technology.add(new question("באיזו שנה יצאה לראשונה הגרסה הראשונה של שפת התכנות Java?", 1995));
        technology.add(new question("כמה צבעים יכול להציג מסך 12 ביט צבע?", 4096));
        technology.add(new question("באיזו שנה הושקה לראשונה מצלמת וידאו דיגיטלית מסחרית?", 1983));
        technology.add(new question("באיזו שנה יצאה לראשונה הגרסה הראשונה של מערכת ההפעלה macOS?", 2001));
        technology.add(new question("באיזו שנה התבצע הטיסה הראשונה המסחרית של החללית Columbia?", 1981));
        technology.add(new question("באיזו שנה יצאה לראשונה  מערכת הגיימינג Microsoft Xbox?", 2001));
        technology.add(new question("באיזו שנה יצאה לראשונה הגרסה הראשונה של דפדפן האינטרנט Google Chrome?", 2008));
        technology.add(new question("באיזו שנה הושק לראשונה נגן DVD מסחרי?", 1996));
        technology.add(new question("באיזו שנה יצאה לראשונה הגרסה הראשונה של מערכת ההפעלה Windows XP?", 2001));
        technology.add(new question("באיזו שנה יצאה לראשונה הגרסה הראשונה של דפדפן האינטרנט Internet Explorer?", 1995));
        technology.add(new question("באיזו שנה יצאה לראשונה הגרסה הראשונה של טלוויזיה צבעונית?", 1954));
        technology.add(new question("באיזו שנה הושקה לראשונה מערכת ההפעלה Linux?", 1991));
        technology.add(new question("באיזו שנה נוצר המחשב האישי?", 1975));
        technology.add(new question("כמה מיליארד יחידות של אייפון נמכרו עד לשנת 2021?", 2500));
        technology.add(new question("באיזו שנה הוקמה חברת Apple?", 1976));
        technology.add(new question("באיזו שנה יצאה לראשונה מכונת הדפוס הראשונה?", 1439));
        technology.add(new question("באיזו שנה יצאה לראשונה מערכת ההפעלה Windows 10?", 2015));
        technology.add(new question("באיזו שנה הוקמה חברת Microsoft?", 1975));
        technology.add(new question("באיזו שנה התרחשה השקת הדיסקט הראשון?", 1971));
        technology.add(new question("באיזו שנה הוקמה חברת IBM?", 1911));
        technology.add(new question("באיזו שנה הוקמה חברת Intel?", 1968));
        technology.add(new question("באיזו שנה הוקמה חברת Nvidia?", 1993));
        technology.add(new question("באיזו שנה יצאה לראשונה המחשב הקוונטי?", 1981));
        technology.add(new question("באיזו שנה הוקמה חברת SAP?", 1972));
        technology.add(new question("באיזו שנה יצאה לראשונה מערכת ההפעלה Windows 7?", 2009));
        technology.add(new question("באיזו שנה הוקמה חברת Amazon?", 1994));
        technology.add(new question("באיזו שנה הושק אייפון 14 פרו?", 2022));
        technology.add(new question("באיזו שנה הושק הגלקסי הראשון?", 2010));
        technology.add(new question("באיזו שנה הושק הגלקסי הראשון", 2010));
        technology.add(new question("באיזו שנה יצאה לראשונה הטכנולוגיה של פיקסלי התמונה?", 1982));
        technology.add(new question("כמה גיגה-בייטים יש בטרה-בייט?", 1000));
        technology.add(new question("באיזו שנה הושק גלקסי S9?", 2018));
        technology.add(new question("באיזו שנה הושק גלקסי S7?", 2016));
        technology.add(new question("באיזו שנה הושק האייפד הראשון?", 2010));
        technology.add(new question("באיזו שנה הושק העט לאייפד?", 2015));
        technology.add(new question("באיזו שנה הושקו האיירפודס לראשונה?", 2016));
        technology.add(new question("באיזו שנה הושק גוגל פיקסל הראשון", 2013));
        technology.add(new question("באיזו שנה הומצאו המסכי מגע?", 1965));
        technology.add(new question("באיזו שנה הומצא הסמארטפון?", 1992));
        technology.add(new question("באיזו שנה הומצאו הכרטיסי זיכרון?", 1969));
        technology.add(new question("באיזו שנה הומצאה טכנולוגיית NFC?", 2002));
        technology.add(new question("באיזו שנה הומצא דיסק Blu-ray?", 1995));
        technology.add(new question("באיזו שנה הומצאה טכנולוגיית Wi-Fi?", 1997));
        technology.add(new question("באיזו שנה הומצאה טכנולוגיית QR Code?", 1994));
        technology.add(new question("באיזו שנה הומצאה טכנולוגיית GPS?", 1973));
        technology.add(new question("באיזו שנה הומצאה טכנולוגיית USB?", 1996));
        technology.add(new question("באיזו שנה הומצא רובוט הבית הראשון?", 1996));
        technology.add(new question("באיזו שנה הומצאה טכנולוגיית QR Code?", 1994));
        technology.add(new question("באיזו שנה הומצאה טכנולוגיית GPS?", 1973));
        technology.add(new question("באיזו שנה הומצאה טכנולוגיית USB?", 1996));

        return setUpRandomTechnologyQuestions(technology);
    }
    public ArrayList<question> setUpRandomTechnologyQuestions(ArrayList<question>technoQuestions){
        ArrayList<question>randomTechnology = new ArrayList<>();
        Random random = new Random();
        for (int i = 0 ; i < question.numOfQ ; i++)
        {
            int randoNum = random.nextInt(technoQuestions.size());
            int randomNumber = random.nextInt(technoQuestions.size() - randoNum);
            randomTechnology.add(technoQuestions.get(randomNumber));
            technoQuestions.remove(randomNumber);
        }
        return randomTechnology;
    }
}
