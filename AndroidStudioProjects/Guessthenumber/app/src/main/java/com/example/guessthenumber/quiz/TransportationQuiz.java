package com.example.guessthenumber.quiz;

import android.content.Context;

import com.example.guessthenumber.gameMode.question;

import java.util.ArrayList;
import java.util.Random;

public class TransportationQuiz {

    public ArrayList<Integer> setUpTransportationIcons(Context context){
        ArrayList<Integer> transportationIcons = new ArrayList<>();
        for (int i = 1; i <= 17; i++) {
            int resourceId = context.getResources().getIdentifier("transportation" + i, "drawable", context.getPackageName());
            transportationIcons.add(resourceId);
        }

        return setUpRandomTransportationIcons(transportationIcons);
    }
    public ArrayList<Integer>setUpRandomTransportationIcons(ArrayList<Integer>transportationIcons){
        ArrayList<Integer>randomTransportationIcons = new ArrayList<>();
        Random random = new Random();
        for(int i = 0 ; i < question.numOfQ ; i++){
            int randoNum = random.nextInt(transportationIcons.size() -1);
            int randomIcon = random.nextInt(transportationIcons.size() - randoNum);
            randomTransportationIcons.add(transportationIcons.get(randomIcon));
            transportationIcons.remove(randomIcon);
        }
        return randomTransportationIcons;
    }


    public ArrayList<question>setUpTransportationQuestions(){
        ArrayList<question>transportation = new ArrayList<>();  // arr for random Questions in this subject

        transportation.add(new question("באיזו שנה הופעלה הרכבת פחם הראשונה?", 1829));
        transportation.add(new question("באיזו שנה הופעלה הרכבת החשמלית הראשונה?", 1879));
        transportation.add(new question("באיזו שנה שוגרה מעבורת החלל הראשונה?", 1981));
        transportation.add(new question("מה מספרו של הכביש המחבר בין תל אביב לירושלים?", 1));
        transportation.add(new question("מהו אורך הכביש הארוך ביותר בעולם(בקילומטרים)?", 30000 ));
        transportation.add(new question("מהו מספר הכביש הארוך ביותר בישראל ?", 90));
        transportation.add(new question("כמה מקומות יש באוטובוס קומתיים?", 70));
        transportation.add(new question("כמה מקומות יש במטוס נוסעים ממוצע?", 150));
        transportation.add(new question("כמה שעות אורכת הטיסה המסחרית הארוכה ביותר?", 18 ));
        transportation.add(new question("כמה דקות אורכת הטיסה המסחרית הקצרה ביותר?", 2));
        transportation.add(new question("מה הוא גודל הרכב הפרטי הגדול ביותר בעולם - במטרים ?", 15));
        transportation.add(new question("מה הוא גודל הרכב הפרטי בקטן ביותר בעולם - במטרים ?", 2));
        transportation.add(new question("מה היא המהירות המקסימלית האפשרית ביותר ברכבים פרטיים בקמ”ש ? ", 300));
        transportation.add(new question("מה היא המהירות הממוצעת בתחרויות פורמולה 1 בקמ”ש ?", 250));
        transportation.add(new question("כמה עתיקה המכונית העתיקה ביותר בשימוש נכון לשנת  2023? ", 277));
        transportation.add(new question("מה היא השנה בה נכנסה המכונית לשימוש ? ",1886));
        transportation.add(new question("באיזה שנה הוקמה חברת מרצדס-בנץ?", 1926));
        transportation.add(new question("באיזה שנה הוקמה חברת בי אמ וו?", 1913));
        transportation.add(new question("באיזה שנה הוקמה חברת פורשה?", 1909));
        transportation.add(new question("באיזה שנה הוקמה חברת אודי?", 1909));
        transportation.add(new question("באיזה שנה הוקמה חברת בי אמ וו?", 1913));
        transportation.add(new question("באיזה שנה הוקמה חברת בנטלי?", 1951));
        transportation.add(new question("באיזה שנה הוקמה חברת קדילאק?", 1902));
        transportation.add(new question("באיזה שנה הוקמה חברת אלפא רומיאו?", 1910));
        transportation.add(new question("באיזה שנה הוקמה חברת מייבך?", 1913));
        transportation.add(new question("באיזה שנה הוקמה חברת בוגאטי?", 1909));
        transportation.add(new question("באיזה שנה נוסדה פרארי?", 1947));
        transportation.add(new question("באיזה שנה נוסדה למבורגיני?", 1963));
        transportation.add(new question("באיזה שנה נוסדה אסטון מרטין?", 1913));
        transportation.add(new question("באיזה שנה נוסד ג'יפ?", 1941));
        transportation.add(new question("באיזה שנה נוסדה לנד רובר?", 1948));
        transportation.add(new question("באיזה שנה נוסדה מקלארן?", 1952));
        transportation.add(new question("באיזה שנה נוסדה רולס-רויס?", 1906));
        transportation.add(new question("באיזה שנה נוסדה בנטלי?", 1919));
        transportation.add(new question("באיזה שנה נוסדה פורשה?", 1931));
        transportation.add(new question("באיזה שנה נוסדה מזראטי?", 1914));
        transportation.add(new question("באיזה שנה נוסדה סובארו?", 1953));
        transportation.add(new question("באיזו שנה הוצגה המכונית החשמלית הראשונה?", 1884));
        transportation.add(new question("באיזו שנה הוקמה חברת התעופה המסחרית הראשונה?", 1919));
        transportation.add(new question("מהי המהירות המרבית ברכבת המהירה בעולם?", 374));
        transportation.add(new question("כמה גלגלים יש למשאית טיפוסית?", 18));
        transportation.add(new question("מהי קיבולת הנוסעים הממוצעת של אוטובוס עירוני רגיל? ", 40));
        transportation.add(new question("כמה מסלולים יש לשדה התעופה העמוס ביותר בעולם?", 5));
        transportation.add(new question("כמה הילוכים יש בדרך כלל למכונית תיבת הילוכים ידנית רגילה ?", 5));
        transportation.add(new question("מהו גובה השיוט הטיפוסי של מטוס נוסעים מסחרי ברגל??", 35000));
        transportation.add(new question("כמה נוסעים יכולה להכיל אוניית הקרוזים הגדולה בעולם?", 6780));
        transportation.add(new question("כמה מושבים יש במטוס הנוסעים המסחרי הגדול ביותר, Airbus A380?", 853));
        transportation.add(new question("מה אורכה של הרכבת הטרנס-סיבירית בקילומטרים?", 9289));
        transportation.add(new question("כמה שדות תעופה יש בלונדון, אנגליה??", 6));
        transportation.add(new question("מהי קיבולת הנוסעים המקסימלית של רכבת יורוסטאר?", 900));

        return setUpRandomTransportationQuestions(transportation);

    }
    public ArrayList<question> setUpRandomTransportationQuestions(ArrayList<question>transportationQuestions){
        ArrayList<question>randomTransportationQuestions = new ArrayList<>();  // arr for random Questions in this subject
        Random random = new Random();
        for (int i = 0 ; i < question.numOfQ ; i++)
        {
            int randoNum = random.nextInt(transportationQuestions.size());
            int randomNumber = random.nextInt(transportationQuestions.size() - randoNum);
            randomTransportationQuestions.add(transportationQuestions.get(randomNumber));
            transportationQuestions.remove(randomNumber);
        }
        return randomTransportationQuestions;
    }
}
