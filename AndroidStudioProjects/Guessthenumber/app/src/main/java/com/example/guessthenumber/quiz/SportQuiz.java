package com.example.guessthenumber.quiz;

import com.example.guessthenumber.gameMode.question;

import android.content.Context;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.Random;

public class SportQuiz {
    public ArrayList<Integer> setUpSportIcons(Context context) {
        ArrayList<Integer> sportIcons = new ArrayList<>();
        for (int i = 1; i <= 37; i++) {
            int resourceId = context.getResources().getIdentifier("sport" + i, "drawable", context.getPackageName());
            sportIcons.add(resourceId);
        }
        return setUpRandomSportIcons(sportIcons);
    }

    public ArrayList<Integer>setUpRandomSportIcons(ArrayList<Integer>sportIcons){
        ArrayList<Integer>randomSportIcons = new ArrayList<>();
        Random random = new Random();
        for(int i = 0 ; i < question.numOfQ ; i++){
            int randoNum = random.nextInt(sportIcons.size() -1);
            int randomIcon = random.nextInt(sportIcons.size() - randoNum);
            randomSportIcons.add(sportIcons.get(randomIcon));
            sportIcons.remove(randomIcon);
        }
        return randomSportIcons;
    }

    public ArrayList<question> setUpSportQuestions() {

        ArrayList<question>sportQuestions = new ArrayList<>();
        sportQuestions.add(new question(" בכמה אליפויות זכתה ביתר ירושלים  ? " ,6));
        sportQuestions.add(new question("בכמה גביעי ליגת האלופות זכתה ריאל מדריד ? " ,14)) ;
        sportQuestions.add(new question("בכמה קרבות הפסיד מייק טייסון ? " ,6)) ;
        sportQuestions.add(new question("בכמה מדליות זהב זכה מייקל פלפס ? " ,23));
        sportQuestions.add(new question("בכמה גביעי מדינה זכתה מכבי תל אביב  ? " ,24));
        sportQuestions.add(new question("בכמה גביעי גראנד סלאם זכה רפאל נדאל ? " ,22));
        sportQuestions.add(new question("כמה מדליות זכה יוסיין בולט ? " ,14));
        sportQuestions.add(new question(" כמה אליפויות אירופה זכתה מכבי תל אביב בכדורסל ? " ,6));
        sportQuestions.add(new question("בכמה קרבות הפסיד מוחמד עלי  ? " ,5));
        sportQuestions.add(new question("בכמה כדורי זהב זכה כריסטיאנו רונאלדו ? " ,5));

        sportQuestions.add( new question("בכמה כדורי זהב זכה מסי ? " ,6));
        sportQuestions.add( new question("באיזו שנה התרחש הקרב המפורסם בין מייק טייסון להוליפילד ? " , 1997 ));
        sportQuestions.add( new question("בכמה אליפויות פורמלה 1 זכה לואיס המילטון ? " , 7 ));
        sportQuestions.add( new question("בכמה אליפויות N.B.A זכה בקריירה שלו קובי ברייאנט ? " , 5 ));
        sportQuestions.add( new question("מהו מספר החולצה המזוהה עם רונאלדו ? " , 7 ));
        sportQuestions.add( new question("מהי כמות השערים שיש לנבחרת ישראל במונדיאל ? " , 1 ));
        sportQuestions.add( new question(" מהו המספר שבדרך כלל מזוהה עם שוערי כדורגל ? " , 1 ));
        sportQuestions.add( new question(" לכמה שחקנים מותר לגעת ביד במשחק כדורגל ? " , 2 ));
        sportQuestions.add( new question(" בכמה גביעי מדינה זכתה הפועל ירושלים בכדורסל ? " , 7 ));
        sportQuestions.add( new question(" בכמה מונדיאלים זכתה נבחרת ברזיל ? " , 5 ));

        sportQuestions.add( new question(" כמה דקות מתקיים משחק כדורגל ? " , 90 ));
        sportQuestions.add( new question(" במשחק כדורגל כמה כרטיסים צהובים שווים לכרטיס אדום ? " , 2 ));
        sportQuestions.add( new question(" מהו מספר החולצה המזוהה עם מסי ? " , 10 ));
        sportQuestions.add( new question(" מהו מספר החולצה הגבוה ביותר בכדורגל ? " , 99 ));
        sportQuestions.add( new question(" מהו מספר החולצה הנמוך ביותר בכדורסל ? " , 0 ));
        sportQuestions.add( new question(" בכל כמה שנים מתקיים טורניר היורו ? " , 4 ));
        sportQuestions.add( new question(" בכמה אליפויות גולף זכה טייגר וודס ? " , 15 ));
        sportQuestions.add( new question("  באיזו שנה נכנסה טכנולוגית הVAR למשחקי הכדורגל ?  " , 2017 ));
        sportQuestions.add( new question(" כמה חילופים מתאפשרים במשחק כדורגל ? " , 4 ));
        sportQuestions.add( new question(" באיזו שנה הוקמה ליגת הNBA ? " , 1946 ));


        sportQuestions.add(new question("כמה דקות ערך המשחק טניס הקצר בעולם? ",20));
        sportQuestions.add(new question("כמה שעות ערך המשחק טניס הארוך בעולם? ",11));
        sportQuestions.add(new question("באיזה שנה הומצא שובר שוויון בטניס? ",1965));
        sportQuestions.add(new question("כמה אליפויות גראנד סלאם זכה דון באדג'? ",6));
        sportQuestions.add(new question("באיזו שנה נרשם שיא מהירות ההגשה בטניס אצל גברים? ",2021));
        sportQuestions.add(new question("מה היא מהירות השיא בהגשה בטניס גברים ?" ,262));
        sportQuestions.add(new question("מה הוא ממוצע הגילאים של נערי או נערות כדור בווימבלדון ?" ,15));
        sportQuestions.add(new question("באיזו שנה התקיים משחק הווימבלדון הראשון'? ",1877));
        sportQuestions.add(new question("מה גובה הדשא בטורניר הווימבלדון? ",8));
        sportQuestions.add(new question("באיזו שנה החליטו על השוואת גובה הפרס הכספי בין גברים לנשים בטורניר ווימבלדון? ",2007));
        sportQuestions.add(new question( "כמה טורנירים יש בגראנד סלאם ?" ,4));

        sportQuestions.add(new question("באיזו שנה מדינת ישראל זכתה במדליית כסף באולימפיאדה" ,1992));
        sportQuestions.add(new question("בכמה טורנירי גראנד סלאם זכו הטניסאים אנדי רם וינו ארליך כששיחקו כזוג?" ,3));
        sportQuestions.add(new question("כמה שחקנים נמצאים על המגרש מכל קבוצה במהלך משחק כדורגל? ",11));
        sportQuestions.add(new question("כמה כרטיסים צהובים גוררים השעיה אוטומטית בכדורגל ?" ,5));
        sportQuestions.add(new question("כמה נקודות שווה זריקה חופשית בכדורסל?",1));
        sportQuestions.add(new question("כמה נקודות דרושות כדי לנצח משחק בטניס?",4));
        sportQuestions.add(new question("כמה חורים יש במשחק סטנדרטי של גולף?",18));
        sportQuestions.add(new question("מה המספר המירבי של מקלות גולף אשר ניתן להכניס לתיק במשחק?",14));
        sportQuestions.add(new question("כמה נתיבי שחייה יש בבריכת שחייה אולימפית?",8));
        sportQuestions.add(new question("מה אורך הסטנדרטי של בריכת שחייה אולימפית במטרים?",50));

        sportQuestions.add(new question("כמה טבעות יש בסמל של האולימפיאדה" ,5));
        sportQuestions.add(new question("כמה ענפי ספורט נכללו באולימפיאדת טוקיו 2020" ,33));
        sportQuestions.add(new question("כמה פעמים המשחקים האולימפיים התקיימו בארצות הברית" ,4));
        sportQuestions.add(new question("כמה מדינות השתתפו באולימפיאדת ריו בשנת ב2016 בקיץ" ,206));
        sportQuestions.add(new question("כמה שנים נערכו ה משחקים האולימפיים העתיקים באולימפיאדה ביוון?",1000));
        sportQuestions.add(new question("באיזו שנה מייקל ג'ורדון זכה בפעם הראשונה בטורניר הNBA? ",1991));
        sportQuestions.add(new question("בכמה תארי גראנד סלאם זכתה סרינה וויליאס? ",23));
        sportQuestions.add(new question("באיזו שנה התחרה יוסיין בולט בפעם הראשונה באולימפיאדה? ",2004));
        sportQuestions.add(new question("כמה הקפות מלאות עשה בייב רות במהלך הקריירה שלו? ",714));

        sportQuestions.add(new question("כמה פעמים ניו אינגלד פטריוטס זכו בסופר-בול",6));
        sportQuestions.add(new question("בכמה תארים של טור דה פראנס זכה לאנס ארמסטורנג?",7));
        sportQuestions.add(new question("כמה טאצ'דאונים זרק פייטון מאנינג בקריירה שלו?",539));
        sportQuestions.add(new question("בכמה מדליות אולימפיות זכה גל פרידמון כגולש רוח?",2));
        sportQuestions.add(new question("בכמה משחקים אולימפיים השתתף המתעמל אלכס שטילוב?",3));
        sportQuestions.add(new question("כמה פעמים זכתה קבוצת הכדורסל הישראלית מכבי תל אביב ביורוליג?",6));
        sportQuestions.add(new question("באיזו שנה יעל ארד זכתה במדליית כסף בג'ודו באולימפיאדה?",1992));

        return setUpRandomSportQuestions(sportQuestions);

    }
    public ArrayList<question> setUpRandomSportQuestions(ArrayList<question>sportQuestions) {
        ArrayList<question>randomSportQuestions = new ArrayList<>();
        Random random = new Random();
        for (int i = 0 ; i < question.numOfQ ; i++)
        {
            int randoNum = random.nextInt(sportQuestions.size());
            int randomQuestion = random.nextInt(sportQuestions.size() - randoNum);
            randomSportQuestions.add(sportQuestions.get(randomQuestion));
            sportQuestions.remove(randomQuestion);
        }
        return randomSportQuestions;
    }
}
