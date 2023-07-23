package com.example.guessthenumber.quiz;

import android.content.Context;

import com.example.guessthenumber.gameMode.question;

import java.util.ArrayList;
import java.util.Random;

 public class MoviesAndTvQuiz{

        public ArrayList<Integer> setUpMoviesAndTvIcons(Context context){
            ArrayList<Integer> moviesAndTvIcons = new ArrayList<>();
            for (int i = 1; i <= 37; i++) {
                int resourceId = context.getResources().getIdentifier("moviesandtv" + i, "drawable", context.getPackageName());
                moviesAndTvIcons.add(resourceId);
            }
            return setUpRandoMoviesAndTvIcons(moviesAndTvIcons);
        }
        public ArrayList<Integer>setUpRandoMoviesAndTvIcons(ArrayList<Integer>moviesAndTvIcons){
            ArrayList<Integer>randomMoviesAndTvIconsIcons = new ArrayList<>();
            Random random = new Random();
            for(int i = 0 ; i < question.numOfQ ; i++){
                int randoNum = random.nextInt(moviesAndTvIcons.size() - 1);
                int randomIcon = random.nextInt(moviesAndTvIcons.size() - randoNum);
                randomMoviesAndTvIconsIcons.add(moviesAndTvIcons.get(randomIcon));
                moviesAndTvIcons.remove(randomIcon);
            }
            return randomMoviesAndTvIconsIcons;
        }


        public ArrayList<question> setUpMoviesAndTvQuestions(){
            ArrayList<question>moviesAndTv = new ArrayList<>();
            moviesAndTv.add(new question("כמה סרטי אינדיאנה ג'ונס יש נכון לשנת 2023?", 5));
            moviesAndTv.add(new question("כמה סרטי ג’יימס בונד יש נכון לשנת 2023?", 25));
            moviesAndTv.add(new question("כמה סרטי מהיר ועצבני יש נכון לשנת 2023?", 10));
            moviesAndTv.add(new question("כמה סרטי שליחות קטלנית יש נכון לשנת 2023?", 5));
            moviesAndTv.add(new question("באיזו שנה שודר הפרק הראשון של השיר שלנו?", 2004));
            moviesAndTv.add(new question("כמה פרקים יש לסדרה השיר שלנו?", 361));
            moviesAndTv.add(new question("מתי יצא הסרט הראשון של הארי פוטר?", 2001));
            moviesAndTv.add(new question("כמה סרטים יש להארי פוטר?", 8));
            moviesAndTv.add(new question("מתי יצא הסרט האחרון של הארי פוטר?", 2011));
            moviesAndTv.add(new question("בן כמה היה ברוס לי במותו?", 1973));
            moviesAndTv.add(new question("באיזו שנה נהרג בנו של ברוס לי ברנדון לי בתאונה על סט הצילומים?", 1993));
            moviesAndTv.add(new question("באיזו שנה נהרג בתאונת דרכים השחקן פול ווקר?", 2013));
            moviesAndTv.add(new question("כמה סרטים יש לנוקמים?", 4));
            moviesAndTv.add(new question("כמה סרטים היו ליחידת המתאבדים?", 2));
            moviesAndTv.add(new question("כמה סרטים ביים כריסטופר נולאן לגיבור העל באטמן?", 3));
            moviesAndTv.add(new question("כמה סרטים ביים טרנטינו נכון לשנת 2023?", 10));
            moviesAndTv.add(new question("כמה סרטים ביים רוברט רודריגז נכון לשנת 2023?", 28));
            moviesAndTv.add(new question("השלם את שם סרט של טרנטינו __ השנואים?", 8));
            moviesAndTv.add(new question("השלם את שם הסרט של דיוויד פינצ'ר__ חטאים?", 7));
            moviesAndTv.add(new question("באיזו שנה הוקרן הסרט “פורסט ג’אמפ”?", 1994));
            moviesAndTv.add(new question("באיזו שנה הוקרן הסרט “חומות של תקווה”?", 1994));
            moviesAndTv.add(new question("כמה סרטים יש לרוקי סילבסטר סטאלון?", 6));
            moviesAndTv.add(new question("כמה סרטים יש לרמבו סילבסטר סטאלון?", 5));
            moviesAndTv.add(new question("באיזו שנה הוקרן הסרט ביג לבובסקי?", 1998));
            moviesAndTv.add(new question("כמה סרטים ביים רוברט רודריגז לקומיקס של פרנק מילר עיר החטאים?", 2));
            moviesAndTv.add(new question("השלם את שם הסרט: ___ גוונים של אפור?", 50));
            moviesAndTv.add(new question("כמה סרטים יש למגודלים של אדם סנדלר?", 2));
            moviesAndTv.add(new question("כמה סרטי שיתופי פעולה יש בין החברים הטובים סת’ רוגן לג’יימס פרנקו?", 3));
            moviesAndTv.add(new question("כמה דמויות ראשיות יש בסרט הטוב הרע והמכוער?", 3));
            moviesAndTv.add(new question("כמה גנבים עם שמות חסויים כצבעים יש בכלבי אשמורת?", 6));
            moviesAndTv.add(new question("באיזו שנה הוקרן הסרט “הסרט הזאב מוול סטרייט”?", 2013));
            moviesAndTv.add(new question("זהה את הסרט : “this is sparta”?", 300));
            moviesAndTv.add(new question("באיזו שנה יצא הסרט הפועל בית שאן סרט מלחמה?", 1996));
            moviesAndTv.add(new question("השלם את השם של הסרט : __ אצבעות מצידון ", 2));
            moviesAndTv.add(new question("השלם את השם של הסרט : קוקו בן __  ", 19));
            moviesAndTv.add(new question("באיזו שנה יצא הסרט זוהר", 1993));
            moviesAndTv.add(new question("באיזו שנה יצא הסרט מכתוב (גיא עמיר וחנן סביון)", 2017));
            moviesAndTv.add(new question("באיזו שנה יצא הסרט מחילה (גיא עמיר וחנן סביון)", 2019));
            moviesAndTv.add(new question("בן כמה היה בנג’מין באטן כשהוא נולד?", 5));
            moviesAndTv.add(new question("שם של סרט פוקר מפורסם? ", 21));
            moviesAndTv.add(new question("השלם את השם של הסרט : דיזינגוף __  ", 99));
            moviesAndTv.add(new question("כמה סרטי אסקימו לימון היו בסך הכל  ", 9));
            moviesAndTv.add(new question("מתי יצא הסרט הראשון של אסקימו לימון ", 1978));
            moviesAndTv.add(new question("באיזו שנה יצא הסרט “אלכס חולה אהבה”", 1986));
            moviesAndTv.add(new question("כמה סרטים ביים היצ’קוק", 23));
            moviesAndTv.add(new question("השלם את השם של הסרט : אודיסיאה בחלל :__  ", 2001));
            moviesAndTv.add(new question("כמה גלולות הציעו לניאו במטריקס", 2));
            moviesAndTv.add(new question("השלם את שם הסרט : עליבאבא ו__ השודדים", 40));
            moviesAndTv.add(new question("השלם את שם הסרט : ___ כלבים וגנבים", 101));
            moviesAndTv.add(new question("באיזו שנה יצא הסרט טיטאניק", 1997));
            moviesAndTv.add(new question("באיזו שנה יצא הסרט הראשון של בת הים הקטנה", 1989));
            moviesAndTv.add(new question("השלם את שם הסרט : ___ ג’אמפ סטרייט", 21));
            moviesAndTv.add(new question("סדרת אקשן מיתולוגית מרשת פוקס ששודרה בין השניים 2000-2010 בעלת שתי ספרות בלבד", 24));
            moviesAndTv.add(new question("כמה עונות היו לסדרה חברים", 10));
            moviesAndTv.add(new question("כמה עונות היו לסדרה אבודים", 6));
            moviesAndTv.add(new question("מתי שודר הפרק הראשון של חברים", 1994));
            moviesAndTv.add(new question("כמה מהדמויות הראשיות בסדרה חברים היו נשים", 3));
            moviesAndTv.add(new question("כמה מהדמויות הראשיות בסדרה חברים היו גברים", 3));
            moviesAndTv.add(new question("כמה עונות היו לסדרה ילדי האנרכיה", 7));
            moviesAndTv.add(new question("כמה עונות היו לסדרה הסופרנוס", 6));
            moviesAndTv.add(new question("כמה עונות היו לסדרה הגדולה בכל הזמנים, שובר שורות", 5));
            moviesAndTv.add(new question("מהי שנת הבכורה של הסדרה הגדולה בכל הזמנים, שובר שורות", 2008));
            moviesAndTv.add(new question("באיזו שנה נגמרה סדרת המופת, שובר שורות", 2013));
            moviesAndTv.add(new question("כמה עונות היו לסדרה נמלטים", 5));
            moviesAndTv.add(new question(" באיזו שנה שודר הפרק הראשון של נמלטים", 2005));
            moviesAndTv.add(new question("בכמה אחים עוסקת הסדרה נמלטים", 2));
            moviesAndTv.add(new question("כמה חברי משפחה מרכיבים את משפחת סימפסון", 5));
            moviesAndTv.add(new question("כמה חברי משפחה מרכיבים את משפחת גריפין בסדרה פמילי גאי", 5));
            moviesAndTv.add(new question("כמה חברי משפחה מרכיבים את משפחת סאנצ’ס בסדרה ריק ומורטי", 5));
            moviesAndTv.add(new question("כמה עונות יש לסדרה ריק ומורטי נכון ל2023", 6));
            moviesAndTv.add(new question("מהו מספר הטיסה של המטוס המפורסם מהסדרה אבודים", 815));
            moviesAndTv.add(new question("מהו המספר טיסה של המטוס בסדרה מניפסט", 828));
            moviesAndTv.add(new question("מה היה מספר הנוסעים בטיסה בסדרה מניפסט", 191));
            moviesAndTv.add(new question("כמה עונות היו לסדרה דקסטר", 8));
            moviesAndTv.add(new question("כמה עונות היו לסדרה פארגו", 4));
            moviesAndTv.add(new question("כמה גיבורי על ראשיים יש לסדרה הבנים", 7));
            moviesAndTv.add(new question("כמה דמויות ראשיות יש בסדרה עספור", 4));
            moviesAndTv.add(new question("באיזו שנה הוקרנה לראשונה הסדרה בני אור", 2021));
            moviesAndTv.add(new question("בכמה בני נוער עוסקת הסדרה בני אור", 7));
            moviesAndTv.add(new question("באיזו שנה מתרחשת הסדרה בני אור", 2001));
            moviesAndTv.add(new question("העיר שבה מתרחשת הסדרה בני אור הינה, באר __", 7));
            moviesAndTv.add(new question("כמה עונות יש לסדרה אופוריה האמריקאית נכון לשנת 2023", 2));
            moviesAndTv.add(new question("בכמה גברים עוסקת הסדרה רמזור ", 3));
            moviesAndTv.add(new question("בכמה ממלכויות עיקריות עוסקת הסדרה משחקי הכס ", 9));
            moviesAndTv.add(new question("כמה עונות היו למשחקי הכס ", 8));
            moviesAndTv.add(new question("באיזו שנה שודר הפרק הראשון של משחקי הכס", 2011));
            moviesAndTv.add(new question(" פרקים היו לסדרה חברים", 236));
            moviesAndTv.add(new question("השלם את שם הסדרה : ___ העם ___", 11));
            moviesAndTv.add(new question("בכמה גנבים עוסקת העונה הראשונה של בית הנייר", 8));
            moviesAndTv.add(new question("כמה פרקים היו לסדרה הכי גדולה בכל הזמנים שובר שורות", 62));
            moviesAndTv.add(new question("כמה עונות היו לסדרה על טבעי", 15));
            moviesAndTv.add(new question("כמה פרקים היו לסדרה על טבעי", 327));
            moviesAndTv.add(new question("בכמה אחים עוסקת הסדרה על טבעי", 2));
            moviesAndTv.add(new question("כמה עונות היו לסדרה אימפריית הפשע", 5));
            moviesAndTv.add(new question("כמה חברים מונים את הפמלייה בסדרה הפמלייה", 4));
            moviesAndTv.add(new question("כמה עונות היו לסדרה הפמלייה", 8));
            moviesAndTv.add(new question("כמה דמויות ראשיות יש בסדרה קומיונטי", 7));
            moviesAndTv.add(new question("כמה דמויות ראשיות יש בסדרה איך פגשתי את אמא", 5));
            moviesAndTv.add(new question("כמה משתתפים היו בסדרה משחקי הדיונון", 456));
            moviesAndTv.add(new question("בכמה חברות עוסקת הסדרה סקס והעיר הגדולה", 4));


            return setUpRandomMoviesAndTvQuestions(moviesAndTv);



        }
        public ArrayList<question> setUpRandomMoviesAndTvQuestions(ArrayList<question>moviesAndTvQuestions){
            ArrayList<question>randomMoviesAndTvQuestionsQuestions = new ArrayList<>();
            Random random = new Random();
            for (int i = 0 ; i < question.numOfQ ; i++)
            {
                int randoNum = random.nextInt(moviesAndTvQuestions.size());
                int randomQuestion = random.nextInt(moviesAndTvQuestions.size() - randoNum);
                randomMoviesAndTvQuestionsQuestions.add(moviesAndTvQuestions.get(randomQuestion));
                moviesAndTvQuestions.remove(randomQuestion);
            }
            return randomMoviesAndTvQuestionsQuestions;
        }
    }

