package com.example.guessthenumber.quiz;

import android.content.Context;

import com.example.guessthenumber.gameMode.question;

import java.util.ArrayList;
import java.util.Random;

public class IsraeliQuiz {

    public ArrayList<Integer> setUpIsraeliIcons(Context context){
        ArrayList<Integer> israeliIcons = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            int resourceId = context.getResources().getIdentifier("israel" + i, "drawable", context.getPackageName());
            israeliIcons.add(resourceId);
        }

        return israeliIcons;
    }

    public ArrayList<question>setUpIsraeliQuestions() {

        ArrayList<question> israeli = new ArrayList<>();
       israeli.add(new question("מתי בנימין נתניהו הפך לראש ממשלה בפעם הראשונה?", 1996));
       israeli.add(new question("זלמר שזר היה נשיא המדינה מספר?", 3));
       israeli.add(new question("כמה שנים כיהן יצחק נבון כנשיא?", 5));
       israeli.add(new question("באיזה שנה גולדה מאיר הפכה לראשת ממשלה?", 1969));
       israeli.add(new question("כמה שנים כיהנה גולדה מאיר כראשת ממשלה?", 5));
       israeli.add(new question("באיזו שנה התרחש הפיצוץ של גשר אצל בירושלים?", 1946));
       israeli.add(new question("באיזו שנה התרחש הפיצוץ של מלון סבויה בתל אביב?", 1946));
       israeli.add(new question("באיזו שנה התרחש הפיצוץ של אוטובוס צפירים בחיפה?", 2003));
       israeli.add(new question("באיזו שנה התרחש הפיצוץ של אוטובוס 14 בירושלים?", 2011));
       israeli.add(new question("באיזו שנה יצא לאור המילון הראשון של מילון בן יהודה?", 1908));
       israeli.add(new question("כמה נשיאים היו למדינת ישראל עד היום?", 10));
       israeli.add(new question("באיזה שנה נסע יצחק רבין למסע השלום?", 1994));
       israeli.add(new question("כמה ראשי ממשלה היו למדינת ישראל עד היום?", 14));
       israeli.add(new question("באיזו שנה נרצח יצחק רבין?", 1995));
       israeli.add(new question("באיזו שנה חתם יצחק רבין ויאסר ערפאת על ההסכמים באוסלו?", 1993));
       israeli.add(new question("כמה שנים משה דיין היה נשיא מדינת ישראל?", 5));
       israeli.add(new question("באיזו שנה הוקמה מדינת ישראל?", 1948));
       israeli.add(new question("כמה שנים שימש ראובן ריבלין כנשיא מדינת ישראל?", 7));
       israeli.add(new question("באיזה שנה נסע מנחם בגין לביקור בגרמניה?", 1972));
       israeli.add(new question("כמה שנים משה שרת היה נשיא מדינת ישראל?", 5));
       israeli.add(new question("באיזו שנה נסע מנחם בגין לביקור בצרפת?", 1965));
       israeli.add(new question("באיזו שנה חתם מנחם בגין ואנואר סאדאת על ההסכמים בקמפ דיויד?", 1978));
       israeli.add(new question("כמה שנים שימש שמעון פרס כנשיא מדינת ישראל?", 7));
       israeli.add(new question("כמה שנים משה עולם היה נשיא מדינת ישראל?", 10));
       israeli.add(new question("באיזו שנה נפטר אריאל שרון?", 2014));
       israeli.add(new question("כמה ערי קודש יש בישראל?", 4));
       israeli.add(new question("מה מספר הכביש הארוך ביותר בישראל?", 90));
       israeli.add(new question("באיזו שנה הוקמה פתח תקווה?", 1878));
       israeli.add(new question("באיזו שנה הוקמה תל אביב?", 1909));
       israeli.add(new question("כמה ערים יש במחוז הדרום של ישראל?", 12));
       israeli.add(new question("כמה גשרים בינעירוניים המיועדים להולכי רגל יש בישראל?", 40));
       israeli.add(new question("באיזו שנה שי עגנון זכה בפרס נובל?", 1966));
       israeli.add(new question("מה אורך כהונת נשיא המדינה בשנים?", 7));
       israeli.add(new question("כמה שופטים בבית המשפט העליון?", 15));
       israeli.add(new question("על איזה שטר מופיע שאול טשרניחובסקי?", 50));
       israeli.add(new question("משה שרת היה ראש הממשלה ה-?", 2));
       israeli.add(new question("כמה עליות היו לפני קום המדינה?", 5));
       israeli.add(new question("מאיזו שנה כיהן משה דיין כשר הביטחון?", 1976));
       israeli.add(new question("כמה שעות ארכה הישיבה הארוכה ביותר במליאת הכנסת?", 66));
       israeli.add(new question("כמה שנים כיהן שמעון פרס כחבר כנסת?", 47));
       israeli.add(new question("רונן בר הינו ראש השבכ ה- ?", 14));
       israeli.add(new question("כמה ראשי מוסד היו נכון לשנת 2023?", 13));
       israeli.add(new question("כמה שנים כיהן מאיר דגן כראש המוסד?", 9));
       israeli.add(new question("באיזו שנה אילן רמון נפטר ביחד עם אנשי הצוו שתלו במעברות?", 2003));
       israeli.add(new question("באיזו שנה עלה המרגל אלי כהן לארץ ישראל?", 1957));
       israeli.add(new question("באיזו שנה כינס בינימין זאב הרצל את הקונגרס הציוני העולמי הראשון?", 1897));
       israeli.add(new question("כמה אוניברסיטאות יש בארץ ישראל?", 10));
       israeli.add(new question("כמה מכללות אקדמיות יש בארץ ישראל?", 48));
       israeli.add(new question("באיזו שנה נפטר דויד בן גוריון?", 1973));
       israeli.add(new question("באיזו שנה עלתה חנה סנש לישראל?", 1939));
       israeli.add(new question("כמה פעמים כיהן יצחק נבון בתור חבר כנסת?", 2));
       israeli.add(new question("כמה נשים מכהנות בכנסת 2023?", 30));
       israeli.add(new question("באיזו שנה התרחשה מלחמת יום הכיפורים?", 1973));
       israeli.add(new question("מיום הקמתה, כמה מלחמות נלחמה מדינת ישראל?", 7));
       israeli.add(new question("כמה אינתיפאדות היו בארץ ישראל?", 2));
       israeli.add(new question("באיזו שנה הוקמה ירושלים החדשה?", 1860));
       israeli.add(new question("באיזו שנה הוקמה התנועה הציונית?", 1897));
       israeli.add(new question("באיזו שנה חוקק החוק הראשון,חוק היסוד?", 1958));
       israeli.add(new question("כמה רשויות קיימות במדינת ישראל?", 257));
       israeli.add(new question("כמה מפכלים היו למדינת ישראל נכון ל2023?", 19));
       israeli.add(new question("מתי הוקמה פלוגת החילוץ הראשונה בצהל?", 2003));
       israeli.add(new question("מה הפרופיל הרפואי הגבוה ביותר?", 97));
       israeli.add(new question("מתי רפאל איתן נפטר?", 2004));
       israeli.add(new question("מתי התרחש מבצע קדש?", 1956));
       israeli.add(new question("מתי התרחש מבצע צוק איתן?", 2014));
       israeli.add(new question("כמה קצינים חברים בפורום מטכל?", 24));
       israeli.add(new question("כמה רמטכלים החלו את שירותם בחטיבת הצנחנים?", 8));
       israeli.add(new question("כמה זרועות יש בצהל?", 3));
       israeli.add(new question("כמה אגפים של המטה הכללי יש בצהל?", 6));
       israeli.add(new question("באיזה שנה הוקם צהל?", 1948));
       israeli.add(new question("כמה שנים כיהן יעקב דורי כרמטכל?", 1));
       israeli.add(new question("כמה שנים כיהן בני גנץ כרמטכל?", 4));
       israeli.add(new question("באיזה תאריך נחתמה הסכמת השלום עם מצרים?", 26));
       israeli.add(new question("באיזו שנה התרחש מבצע עופרת יצוקה בעזה?", 2008));
       israeli.add(new question("באיזו שנה התרחש מבצע צוק איתן בעזה " , 2014));
       israeli.add(new question("באיזו שנה הוקמה יחידת סיירת מטכל?", 1954));
       israeli.add(new question("כמה פיקודים יש בצהל?", 6));
       israeli.add(new question("מה מספר היחידה לאיסוף מודיעין אותות ופענוח צפנים השייכת לאגף המודיעין?", 8200));
       israeli.add(new question("באיזו שנה הוקמה יחידת דובר צהל?", 1948));
       israeli.add(new question("באיזו שנה התרחש מבצע 'מבצע שלמה' בסיני?", 1956));
       israeli.add(new question("באיזו שנה התרחשה מבצע 'מבצע בינואר' בלבנון?", 1978));
       israeli.add(new question("באיזו שנה התרחשה מבצע 'מבצע אנטבה' בלבנון?", 1996));
       israeli.add(new question("באיזו שנה התרחש מבצע 'מבצע סוף הדרך' בלבנון?", 2006));
       israeli.add(new question("באיזו שנה הפך אהוד ברק לרמטכל?", 1991));
       israeli.add(new question("באיזו שנה שאול מופז ירד מתפקידו כרמטכל?", 2002));
       israeli.add(new question("באיזו שנה הפך אביב כוכבי לרמטכל?", 2019));
       israeli.add(new question("באיזו שנה התרחש מבצע שומר חומות?", 2021));
       israeli.add(new question("באיזו שנה התרחש מבצע מגן וחץ?", 2023));
       israeli.add(new question("באיזו שנה התרחשה מבצע 'מבצע ענבל' בלבנון?", 2000));
       israeli.add(new question("כמה יחידות סיירת גולני יש בצהל?", 2));
       israeli.add(new question("באיזו שנה התרחשה מבצע 'מבצע בוער' בסיני?", 1955));
       israeli.add(new question("באיזו שנה התרחשה מבצע 'מבצע סולם השמש' בסיני?", 1954));
       israeli.add(new question("באיזו שנה הוקמה יחידת חיל הנחל?", 1953));

       return setUpRandomIsraeliQuestions(israeli);

    }

    public ArrayList<question>setUpRandomIsraeliQuestions(ArrayList<question>israeliQuestions){
        ArrayList<question>randomIsraeli = new ArrayList<>();
        Random random = new Random();
        for (int i = 0 ; i < question.numOfQ ; i++)
        {
            int randoNum = random.nextInt(israeliQuestions.size());
            int randomNumber = random.nextInt(israeliQuestions.size() - randoNum);
            randomIsraeli.add(israeliQuestions.get(randomNumber));
            israeliQuestions.remove(randomNumber);
        }
        return randomIsraeli;
    }
}

