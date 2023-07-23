package com.example.guessthenumber.quiz;

import android.content.Context;

import com.example.guessthenumber.gameMode.question;

import java.util.ArrayList;
import java.util.Random;

public class WorldwideQuiz {

    public ArrayList<Integer> setUpWorldwideIcons(Context context){
        ArrayList<Integer> worldwideIcons = new ArrayList<>();
        for (int i = 1; i <= 26; i++) {
            int resourceId = context.getResources().getIdentifier("worldwide" + i, "drawable", context.getPackageName());
            worldwideIcons.add(resourceId);
        }

        return setUpRandomWorldwideIcons(worldwideIcons);
    }

    public ArrayList<Integer>setUpRandomWorldwideIcons(ArrayList<Integer> worldwideIcons){
        ArrayList<Integer>randomWorldwideIcons = new ArrayList<>();
        Random random = new Random();
        for(int i = 0 ; i < question.numOfQ ; i++){
            int randoNum = random.nextInt(worldwideIcons.size() -1);
            int randomIcon = random.nextInt(worldwideIcons.size() - randoNum);
            randomWorldwideIcons.add(worldwideIcons.get(randomIcon));
            worldwideIcons.remove(randomIcon);
        }
        return worldwideIcons;
    }

    public ArrayList<question>setUpWorldwideQuestions() {
        ArrayList<question>worldwide = new ArrayList<>();

        worldwide.add(new question("כמה יבשות יש בעולם?", 7));
        worldwide.add(new question("כמה אזורי זמן יש בעולם?", 24));
        worldwide.add(new question("כמה מדינות יש בארצות הברית?", 50));
        worldwide.add(new question("כמה מחוזות יש בקנדה?", 10));
        worldwide.add(new question("אורכו של נהר הנילוס בקילומטרים?", 6650));
        worldwide.add(new question("כמה אזורי זמן מכסה קנדה?", 6));
        worldwide.add(new question("כמה גובהו של מגדל בורג ח'ליפה בדובאי, במטרים?", 828));
        worldwide.add(new question("כמה מדינות יש באוסטרליה?", 6));
        worldwide.add(new question("כמה מדינות יש באירופה?", 44));
        worldwide.add(new question("כמה מדינות יש באפריקה?", 54));
        worldwide.add(new question("מהו אורכו של נהר המיסיסיפי בארצות הברית בקילומטרים?", 3730));
        worldwide.add(new question("מהו עומקו של האוקיינוס האטלנטי במקום העמוק ביותר, במעמקי מריאנה?", 10928));
        worldwide.add(new question("מהו ההיקף הקו האמצעי בכדור הארץ בקילומטרים?", 40075));
        worldwide.add(new question("כמה איים יש באוקיינוס השקט?", 25000));
        worldwide.add(new question("כמה איים יש באוקיינוס ההודי?", 2000));
        worldwide.add(new question("כמה איים יש באוקיינוס האטלנטי?", 900));
        worldwide.add(new question("כמה איים יש באוקיינוס הדרומי?", 4));
        worldwide.add(new question("כמה מדינות יש באזור הקריביים?", 13));
        worldwide.add(new question("כמה מדינות יש באזור הבלקאנים?", 12));
        worldwide.add(new question("מהו אורך נהר האמזונס בקילומטרים?", 6992));
        worldwide.add(new question("כמה מדינות יש באיזור הים התיכון?", 21));
        worldwide.add(new question("מכמה פסלי ראש של נשיאים בנוי הר ראשמור", 4));
        worldwide.add(new question("כמה כוכבים יש בשדרת הכוכבים שבהוליווד נכון ל2023 ? ", 2700));
        worldwide.add(new question("כמה מדינות נמצאות בחלקו הדרומי של קו המשווה ? ", 39 ));
        worldwide.add(new question("כמה מדינות נמצאות בחלקו הצפוני של קו המשווה ? ", 157 ));
        worldwide.add(new question("בישראל, בניין המגורים הגבוה ביותר הוא מגדל אזור התעשייה בתל אביב, מה הוא גובהו במטרים ?", 235));
        worldwide.add(new question("מה הוא אורכו של מסלול הנדידה הארוך ביותר של הציפורים בקילומטרים  ?", 44000));
        worldwide.add(new question("מה אורכו של הכביש הפאן-אמריקאי, המסלול הארוך ביותר שניתן לעשות ברכב, בקילומטרים?", 48270));
        worldwide.add(new question("כמה ימים ארך מסעו של כריסטופר קולומבוס לגילוי ארצות הברית?", 70));
        worldwide.add(new question("באיזו שנה יצא כריסטופר קולומבוס למסע שלו לגלות את ארצות הברית? ",1492));
        worldwide.add(new question("כמה אנשי צוות היו במסעו של כריסטופר קולומבוס ? ",80));
        worldwide.add(new question("מהו השטח של משולש ברמודה בקילומטרים רבועים?", 1300000));
        worldwide.add(new question("כמה גבוהים הפסלים באי הפסחא במטרים ? ", 4));
        worldwide.add(new question("כמה אורכה החומה הסינית בקילומטרים?",21196));
        worldwide.add(new question("כמה מדינות בעולם  יש ללא גישה לים?", 44));
        worldwide.add(new question("מה הגובה של הביג בן בלונדון במטרים?", 96));
        worldwide.add(new question( "מה גודלו של ארמון בקינגהאם במטרים?, ",108));
        worldwide.add(new question("מה הגודל של הטאג' מאהל במטרים?", 42));
        worldwide.add(new question("מהו גובהו של מאצ'ו פיצ'ו במטרים??", 2430));
        worldwide.add(new question("  מה גודלה של הכנרת בקמר?", 166));
        worldwide.add(new question("מה גובהו של הר האוורסט?", 8849));
        worldwide.add(new question("כמה הרים יש עם קו גובה מעל 7,200 מטרים?", 109));
        worldwide.add(new question("כמה אוקיינוסים יש בעולם?", 5));
        worldwide.add(new question("כמה מדינות יש בעולם?", 195));
        worldwide.add(new question("כמה איים גדולים יש סביב הוואי?", 8));
        worldwide.add(new question("כמה נפשות יש בקריית הוותיקן נכון לשנת 2021?", 811));
        worldwide.add(new question("לכמה מדינות יש עדיין שילינג כמטבע?", 4));
        worldwide.add(new question("באיזו שנה הוקם הפארק הלאומי הראשון בעולם?", 1872));
        worldwide.add(new question("לכמה טריטוריות מחולקת קנדה?", 3));
        worldwide.add(new question("כמה משטח כדור הארך מכוסה על ידי האוקיינוס באחוזים?", 71));
        worldwide.add(new question("בכמה אוקיינוסים עובר קו המשווה?", 3));
        worldwide.add(new question("כמה מדינות הן חלק מהאיחוד האירופי?", 27));
        worldwide.add(new question("כמה איים יש סביב יפן?", 6852));
        worldwide.add(new question("כמה הרי געש פעילים יש בהוואי?", 5));
        worldwide.add(new question("כמה איים יש בפיליפינים?", 7641));
        worldwide.add(new question("מה גובהו של מגדל אייפל במטרים?", 330));
        worldwide.add(new question("באיזו זווית נמצא מגדל פיזה אם מעגלים למעלה?", 4));
        worldwide.add(new question("כמה איים מרכזיים מרכיבים את גלפגוס?", 19));
        worldwide.add(new question("כמה מחוזות יש בארגנטינה?", 24));
        worldwide.add(new question("כמה ערים יש בישראל?", 82));
        worldwide.add(new question("כמה איים יש במלדיביים?", 1192));
        worldwide.add(new question("מה הגובה שנחשב לאזור המוות בהר האוורסט במטרים?", 8000));
        worldwide.add(new question("באיזה מקום משובצת מונאקו בסדר מבחינת המדינה הקטנה בעולם?", 2));
        worldwide.add(new question("מה מיקומה של אינדוניאזיה מבחינת גודל אוכלוסייה?", 4));
        worldwide.add(new question("כמה מדינות ריבוניות יש באירופה?", 50));
        worldwide.add(new question(" מה אורכו של שביל ישראל?", 1041));
        worldwide.add(new question(" כמה קיבוצים יש בעמק יזרעאל?", 15));
        worldwide.add(new question(" מה גובהו של הר מירון?", 1208));
        worldwide.add(new question(" כמה מדברים יש בעולם?", 24));
        worldwide.add(new question(" מה אורכה של החומה הגדולה של סין בקילומטרים?", 21196));
        worldwide.add(new question(" כמה פלאי טבע של העולם יש?", 7));

        return setUpRandomWorldwideQuestions(worldwide);

    }
    public ArrayList<question>setUpRandomWorldwideQuestions(ArrayList<question>worldwideQuestions){
        ArrayList<question>randomWorldwide = new ArrayList<>();
        Random random = new Random();
        for (int i = 0 ; i < question.numOfQ ; i++)
        {
            int randoNum = random.nextInt(worldwideQuestions.size());
            int randomNumber = random.nextInt(worldwideQuestions.size() - randoNum);
            randomWorldwide.add(worldwideQuestions.get(randomNumber));
            worldwideQuestions.remove(randomNumber);
        }
        return randomWorldwide;
    }

    }
