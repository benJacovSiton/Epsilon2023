package com.example.guessthenumber.quiz;

import android.content.Context;

import com.example.guessthenumber.gameMode.question;

import java.util.ArrayList;
import java.util.Random;

public class BiblicalQuiz {

    public ArrayList<Integer> setUpBiblicalIcons(Context context){
        ArrayList<Integer> biblicalIcons = new ArrayList<>();
        for (int i = 1; i <= 28; i++) {
            int resourceId = context.getResources().getIdentifier("religion" + i, "drawable", context.getPackageName());
            biblicalIcons.add(resourceId);
        }

        return setUpRandomBiblicalIcons(biblicalIcons);
    }
    public ArrayList<Integer>setUpRandomBiblicalIcons(ArrayList<Integer> biblicalIcons){
        ArrayList<Integer>randomBiblicalIcons = new ArrayList<>();
        Random random = new Random();
        for(int i = 0 ; i < question.numOfQ ; i++){
            int randoNum = random.nextInt(biblicalIcons.size() - 1);
            int randomIcon = random.nextInt(biblicalIcons.size() - randoNum);
            randomBiblicalIcons.add(biblicalIcons.get(randomIcon));
            biblicalIcons.remove(randomIcon);
        }
        return randomBiblicalIcons;
    }

    public ArrayList<question>setUpBiblicalQuestions(){
        ArrayList<question>bible = new ArrayList<>();

        bible.add(new question("כמה פעמים מוזכרת עשרת הדברות בתנך?", 2));
        bible.add(new question("באיזה יום ברא ה' את שמש, ירח וכוכבים?", 4));
        bible.add(new question("באיזה יום ברא ה' את החיות במים והעופות?", 5));
        bible.add(new question("באיזה יום ברא ה' את השמיים והארץ, אור וחושך, לילה ויום?", 1));
        bible.add(new question("באיזה יום ברא ה' את הרקיע והאטמוספירה מסביב לכדור הארץ?", 2));
        bible.add(new question("באיזה יום ברא ה' את היבשה הצמחים והעצים?", 3));
        bible.add(new question("באיזה יום ברא ה' את החיות ואת אדם וחווה?", 6));
        bible.add(new question("כמה שנים בני ישראל הלכו במדבר?", 40));
        bible.add(new question("כמה שנים חי משה רבנו?", 120));
        bible.add(new question("כמה נשים היו יעקב?", 4));
        bible.add(new question("כמה בנים היו ליעקב?", 12));
        bible.add(new question("כמה שנים נמשכה מלכות דוד?", 420));
        bible.add(new question("כמה ילדים היו לשלמה המלך?", 3));
        bible.add(new question("כמה נשים היו לשלמה המלך?", 700));
        bible.add(new question("כמה חומשי תורה יש?", 5));
        bible.add(new question("כמה ספרים יש בתנך?", 24));
        bible.add(new question("כמה חלקים יש בספר דניאל?", 12));
        bible.add(new question("כמה אנשים נמצאים בתיבת נח במסוף המבול?", 8));
        bible.add(new question("כמה ימים ירד המבול בתקופת תיבת נוח?", 40));
        bible.add(new question("כמה פסוקים יש בספר בראשית?", 1534));
        bible.add(new question("כמה ילדים היו ליוסף בסוף חייו?", 2));
        bible.add(new question("כמה שנים חי יעקב?", 147));
        bible.add(new question("כמה ימים היה משה על הר סיני לקבל את התורה?", 40));
        bible.add(new question("כמה מלכים שלטו ביהודה לאחר חורבן הבית הראשון?", 11));
        bible.add(new question("כמה פעמים מוזכר השם משיח בתנך?", 0));
        bible.add(new question("כמה נביאים היו בתקופת בית ראשון?", 19));
        bible.add(new question("כמה כהנים הובילו את עם ישראל מהמדבר עד ארץ ישראל?", 2));
        bible.add(new question("כמה מאות בני ישראל יצאו ממצרים ביציאת מצרים?", 600000));
        bible.add(new question("כמה ימים ירד המבול בתקופת תיבת נח?", 40));
        bible.add(new question("כמה נביאות מוזכרות בתנך?", 7));
        bible.add(new question("כמה שנים היה משה במדבר עם בני ישראל?", 40));
        bible.add(new question("כמה פרקים יש בספר משלי?", 31));
        bible.add(new question("כמה פרקים יש בספר עמוס?", 9));
        bible.add(new question("כמה פרקים יש בספר תהילים?", 150));
        bible.add(new question("כמה אנשים מבני ישראל נלכדו על ידי פלשתים?", 4000));
        bible.add(new question("כמה פלשתים נהרגו על ידי שמשון?", 3000));
        bible.add(new question("כמה זמן עמד על תלו בית המקדש השני על פי חזל?", 420));
        bible.add(new question("כמה שנים לקח לבנות את בית המקדש הראשון?", 7));
        bible.add(new question("כמה פרקים יש בספר בראשית?", 50));
        bible.add(new question("כמה מגילות יש בספר תנך?", 5));
        bible.add(new question("כמה כיסאות היו בבית המקדש הראשון?", 1));
        bible.add(new question("כמה מכות מצרים מוזכרות בספר תנך?", 10));
        bible.add(new question("כמה שנים כיהן שמואל הנביא כשופט על ישראל?", 12));
        bible.add(new question("כמה פרקים יש בספר שיר השירים?", 8));
        bible.add(new question("באיזו שנה חזרו בני ישראל ממצרים (לפנהס)?", 1312));
        bible.add(new question("כמה שנים מלך שאול על ישראל?", 42));
        bible.add(new question("כמה פרקים יש בספר מלכים ב?", 25));
        bible.add(new question("כמה שנים חי מתושלח?", 969));
        bible.add(new question("מתי היה חורבן בית המקדש הראשון?", 586));
        bible.add(new question("כמה ילדים הולידה רחל ליעקב?", 2));
        bible.add(new question("כמה מלכים היו בשבט בני יהודה בממלכת יהודה?", 20));
        bible.add(new question("כמה שנים מלך שלמה על ממלכת ישראל?", 40));
        bible.add(new question("כמה פרקים יש בספר יהושע?", 24));
        bible.add(new question("כמה שנים מלך אחאב על ממלכת ישראל?", 22));
        bible.add(new question("כמה מלכים היו בממלכת יהודה לאחר חורבן הבית השני?", 4));
        bible.add(new question("כמה מספרי נביאים ארוכים יש בתנך?", 3));
        bible.add(new question("כמה פרקים יש בספר דברי הימים?", 29));
        bible.add(new question("כמה נשיאים היו לבית דוד?", 2));
        bible.add(new question("כמה פרקים יש בספר שמואל?", 31));
        bible.add(new question("כמה חודשים נמשך מלחמת עשרת הראשונים?", 6));
        bible.add(new question("כמה נשים היו לאברהם אבינו?", 3));
        bible.add(new question("כמה שנים חי אדם?", 930));
        bible.add(new question("כמה שנים חי אברהם אבינו?", 175));
        bible.add(new question("כמה ימים חלפו מאז יציאת ישראל ממצרים עד מתן תורה?", 50));
        bible.add(new question("כמה שנים מלך דוד על ממלכת ישראל?", 40));
        bible.add(new question("כמה שנים מלך ירבעם על ממלכת ישראל?", 22));
        bible.add(new question("כמה פרקים יש בספר ירמיהו?", 52));
        bible.add(new question("כמה פרקים יש בספר ישעיהו?", 66));
        bible.add(new question("כמה מלכים ממשפחת בית אחאב היו במלכות ישראל?", 5));
        bible.add(new question("כמה שנים חי נח?", 950));
        bible.add(new question("כמה פרקים יש בספר יואל?", 3));
        bible.add(new question("כמה שנים חי יצחק?", 180));
        bible.add(new question("כמה מלכים שלטו בישראל בימי בית ראשון?", 19));
        bible.add(new question("כמה פרקים יש בספר יחזקאל?", 48));
        bible.add(new question("כמה פרקים יש בספר דניאל?", 12));

        return setUpRandomBiblicalQuestions(bible);



    }

    public ArrayList<question>setUpRandomBiblicalQuestions(ArrayList<question>biblicalQuestions){
        ArrayList<question>randomBiblical = new ArrayList<>();
        Random random = new Random();
        for (int i = 0 ; i < question.numOfQ ; i++)
        {
            int randoNum = random.nextInt(biblicalQuestions.size());
            int randomNumber = random.nextInt(biblicalQuestions.size() - randoNum);
            randomBiblical.add(biblicalQuestions.get(randomNumber));
            biblicalQuestions.remove(randomNumber);
        }
        return randomBiblical;
    }
}
