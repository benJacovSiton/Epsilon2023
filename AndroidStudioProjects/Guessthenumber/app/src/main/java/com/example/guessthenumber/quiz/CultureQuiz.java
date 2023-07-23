package com.example.guessthenumber.quiz;

import android.content.Context;

import com.example.guessthenumber.gameMode.question;

import java.util.ArrayList;
import java.util.Random;

public class CultureQuiz {
    public ArrayList<Integer> setUpCultureIcons(Context context){
        ArrayList<Integer> CultureIcons = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            int resourceId = context.getResources().getIdentifier("culture" + i, "drawable", context.getPackageName());
            CultureIcons.add(resourceId);
        }

        return setUpRandomCultureIcons(CultureIcons);
    }
    public ArrayList<Integer>setUpRandomCultureIcons(ArrayList<Integer> cultureIcons){
        ArrayList<Integer>randomCultureIcons = new ArrayList<>();
        Random random = new Random();
        for(int i = 0 ; i < question.numOfQ ; i++){
            int randoNum = random.nextInt(cultureIcons.size() - 1);
            int randomIcon = random.nextInt(cultureIcons.size() - randoNum);
            randomCultureIcons.add(cultureIcons.get(randomIcon));
            cultureIcons.remove(randomIcon);
        }
        return randomCultureIcons;
    }

    public ArrayList<question>setUpCultureQuestions(){

        ArrayList<question>culture = new ArrayList<>();
        culture.add(new question("באיזו שנה צייר דה וינצ'י את האדם הוויטרובי?", 1490));
        culture.add(new question("בכמה מיליוני דולר נמכר הציור היקר ביותר בהיסטוריה?", 450));
        culture.add(new question("כמה מושבים יש במקום התיאטרון הגדול ביותר בעולם?", 6000));
        culture.add(new question("באיזו שנה צוירה התמונה האייקונית של פרידה קאהלו?", 1939));
        culture.add(new question("באיזו שנה הוקם התיאטרון הראשון לצפייה בסרטים?", 1895));
        culture.add(new question("כמה אמנים השתתפו בפסטיבל וודסטוק הראשון?", 32));
        culture.add(new question("באיזו שנה התקיים ההופעה האחרונה של הביטלס על גג?", 1969));
        culture.add(new question("כמה מושבים יש באלברט הול המפורסם באנגליה?", 5272));
        culture.add(new question("באיזו שנה נולד הצייר קדישמן?", 1932));
        culture.add(new question("כמה גובה הפסל של המלך דוד?", 5));
        culture.add(new question("באיזו שנה נוצר פסל המלך דוד?", 1504));
        culture.add(new question("באיזו שנה הוקמה חברת וולט דיסני?", 1923));
        culture.add(new question("באיזו שנה הוקמה היורו דיסני ?", 1992));
        culture.add(new question("באיזו שנה הוקם וורלד דיסני?", 1955));
        culture.add(new question("כמה מוזיקאים השתתפו בהופעה הגדולה ביותר בהיסטוריה?", 6000));
        culture.add(new question("באיזו שנת התצלום המפורסם של צ'ה ג'אוורה ?", 1960));
        culture.add(new question("באיזו שנה צייר ליאונרדו דה וינצ'י את המונה ליזה?", 1503));
        culture.add(new question("מהי קיבולת הישיבה המקסימלית של בית האופרה של סידני?", 2679));
        culture.add(new question("באיזו שנה צייר וינסנט ואן גוך את ליל כוכבים'", 1889));
        culture.add(new question("כמה מערכות יש במחזה 'המלט' של שייקספיר", 5));
        culture.add(new question("כמה קלידים יש בפסנתר סטנדרטי?", 88));
        culture.add(new question("באיזו שנה כתב ויליאם שייקספיר את 'רומיאו ויוליה'?", 1597));
        culture.add(new question("בכמה פרסי אוסקר זכתה מריל סטריפ??", 3));
        culture.add(new question("כמה ספרים יש בטרילוגיית 'שר הטבעות' של טולקין?", 3));
        culture.add(new question("באיזו שנה נערך טקס פרסי הגראמי הראשון?", 1959));
        culture.add(new question("באיזו שנה צייר פבלו פיקאסו את יצירתו המפורסמת גרניקה?", 1937));
        culture.add(new question("באיזה שנה נולד פאבלו פיקאסו?", 1881));
        culture.add(new question("מתי הלך לעולמו וינסנט ואן גוך?", 1890));
        culture.add(new question("באיזו שנה מיכל אנג'לו צייר את תקרת קפלת הסיסטינה?", 1508));
        culture.add(new question("באיזו שנה נולד רמברנדט ואן ריין?", 1606));
        culture.add(new question("מתי הלך לעולומו קלוד מונה?", 1926));
        culture.add(new question("באיזו שנה נולד וולפגנג אמדאוס מוצרט?", 1756));
        culture.add(new question("מתי מת לודוויג ואן בטהובן?", 1827));
        culture.add(new question("באיזו שנה הולחן האופרה 'לה טראוויאטה' על ידי ג'וזפה ורדי?", 1853));
        culture.add(new question("באיזו מאה החלה תקופת הרנסאנס?", 14));
        culture.add(new question("באיזו מאה הסתיימה תקופת הרנסאנס?", 17));
        culture.add(new question("באיזו שנה מיכל אנג'לו חקק את פסל דוד?", 1504));
        culture.add(new question("באיזו שנה נולד ליאונרדו דה וינצ'י?", 1452));
        culture.add(new question("מתי הלך לעולמו פאבלו פיקאסו?", 1973));
        culture.add(new question("באיזו שנה נוצר ציור 'ליל הכוכבים' של וינסנט ואן גוך?", 1889));
        culture.add(new question("באיזו שנה נולד סלבדור דאלי?", 1904));
        culture.add(new question("מתי מתה פרידה קאהלו?", 1954));
        culture.add(new question("באיזו שנה נכתב המחזה 'המלך ליר' על ידי ויליאם שייקספיר?", 1600));
        culture.add(new question("באיזו שנה נולד יוהאן סבסטיאן באך?", 1685));
        culture.add(new question("מתי לודוויג ואן בטהובן הלחין את סימפונייתו התשיעית?", 1824));
        culture.add(new question("באיזו שנה הולחנה האופרה 'נישואי פיגארו' על ידי וולפגנג אמדאוס מוצרט?", 1786));
        culture.add(new question("באיזו שנה התחילה תקופת הבארוק במוזיקה?", 1600));
        culture.add(new question("מתי הסתיימה תקופת הבארוק במוזיקה?", 1750));
        culture.add(new question("באיזו שנה נוצר הפסל 'דוד' של ג'יאן לורנצו ברניני?", 1623));
        culture.add(new question("באיזו שנה נולד הנרי מאטיס?", 1869));
        culture.add(new question("מתי פאבלו פיקאסו צייר את היצירה המופת 'גרניקה'?", 1937));
        culture.add(new question("באיזו שנה הלחין צ'ייקובסקי את הבלט 'אגם הברבורים'?", 1875));
        culture.add(new question("באיזו שנה נולד דייגו ולסקס?", 1599));
        culture.add(new question("מתי וינסנט ואן גוך צייר את 'גרגרי השמש'?", 1888));
        culture.add(new question("באיזו שנה נוצר הציור 'הסעודה האחרונה' של ליאונרדו דה וינצ'י?", 1498));
        culture.add(new question("באיזו שנה צוייר 'לה דמואזל האוויני' של פאבלו פיקאסו?", 1907));
        culture.add(new question("מתי מת ג'קסון פולוק?", 1956));
        culture.add(new question("באיזו שנה נכתב המחזה 'מקבת' על ידי ויליאם שייקספיר?", 1606));
        culture.add(new question("באיזו שנה נולד יוהאנס ורמיר?", 1632));
        culture.add(new question("מתי מת קלוד דביסי?", 1918));
        culture.add(new question("באיזו שנה הולחנה האופרה 'כרמן' של ז'ורז' ביזה?", 1875));
        culture.add(new question("באיזו שנה התחילה תקופת הרומנטיקה במוזיקה?", 1800));
        culture.add(new question("מתי הסתיימה תקופת הרומנטיקה במוזיקה?", 1910));
        culture.add(new question("באיזו שנה נוצרה הפסל 'המחשבה' של אוגוסט רודן?", 1902));
        culture.add(new question("באיזו שנה נולדה ג'ורג'יה אוקיף?", 1887));
        culture.add(new question("מתי סלבדור דאלי צייר את 'תמידות הזיכרון'?", 1931));
        culture.add(new question("באיזו שנה חבר ג'אקומו פוצ'יני את האופרה 'לה בוהם'?", 1896));
        culture.add(new question("באיזו שנה נולד סנדרו בוטיצלי?", 1445));
        culture.add(new question("מתי פרידה קאהלו ציירה את 'שתי הפרידות'?", 1939));
        culture.add(new question("באיזו שנה נוצר הציור 'לידתו של ונוס' של סנדרו בוטיצלי?", 1485));
        culture.add(new question("באיזו שנה נולד קלוד מונה?", 1840));
        culture.add(new question("מתי מת אנרי מאטיס?", 1954));
        culture.add(new question("באיזו שנה נכתב המחזה 'החלום ליל קיץ' על ידי ויליאם שייקספיר?", 1595));
        culture.add(new question("באיזו שנה נולד אדואר מאנה?", 1832));
        culture.add(new question("מתי לודוויג ואן בטהובן הלחין את סימפונייתו החמישית?", 1808));
        culture.add(new question("באיזו שנה הולחנה האופרה 'החלוץ הקסם' של וולפגנג אמדאוס מוצרט?", 1791));
        culture.add(new question("באיזו שנה התחילה תקופת הקלאסיקה במוזיקה?", 1750));
        culture.add(new question("מתי הסתיימה תקופת הקלאסיקה במוזיקה?", 1820));
        culture.add(new question("באיזו שנה נוצר הפסל פייטה של מיכלאנג'לו?", 1499));
        culture.add(new question("באיזו שנה נולדה פרידה קאהלו?", 1907));
        culture.add(new question("מתי וינסנט ואן גוך צייר 'איריסים'?", 1889));
        culture.add(new question("באיזו שנה כתב ריצ'רד וגנר את האופרה 'טריסטן ויזולדה'?", 1859));
        culture.add(new question("באיזו שנה נולד קרבאג'יו?", 1571));
        culture.add(new question("מתי מת סלבדור דאלי?", 1989));

        return setUpRandomCultureQuestions(culture);
    }
    public ArrayList<question>setUpRandomCultureQuestions(ArrayList<question>cultureQuestions){
        ArrayList<question>randomCulture = new ArrayList<>();
        Random random = new Random();
        for (int i = 0 ; i < question.numOfQ ; i++)
        {
            int randoNum = random.nextInt(cultureQuestions.size());
            int randomNumber = random.nextInt(cultureQuestions.size() - randoNum);
            randomCulture.add(cultureQuestions.get(randomNumber));
            cultureQuestions.remove(randomNumber);
        }
        return randomCulture;
    }
}
