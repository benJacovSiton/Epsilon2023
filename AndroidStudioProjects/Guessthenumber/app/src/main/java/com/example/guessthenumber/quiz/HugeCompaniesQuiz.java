package com.example.guessthenumber.quiz;

import android.content.Context;

import com.example.guessthenumber.gameMode.question;

import java.util.ArrayList;
import java.util.Random;

public class HugeCompaniesQuiz {

    public ArrayList<Integer> setUpHugeCompaniesIcons(Context context){
        ArrayList<Integer> hugeCompaniesIcons = new ArrayList<>();
        for (int i = 1; i <= 33; i++) {
            int resourceId = context.getResources().getIdentifier("hugecompanies" + i, "drawable", context.getPackageName());
            hugeCompaniesIcons.add(resourceId);
        }

        return setUpRandomHugeCompaniesIcons(hugeCompaniesIcons);
    }
    public ArrayList<Integer>setUpRandomHugeCompaniesIcons(ArrayList<Integer>hugeCompaniesIcons){
        ArrayList<Integer>randomHugeCompaniesIconsIcons = new ArrayList<>();
        Random random = new Random();
        for(int i = 0 ; i < question.numOfQ ; i++){
            int randoNum = random.nextInt(hugeCompaniesIcons.size() - 1);
            int randomIcon = random.nextInt(hugeCompaniesIcons.size() - randoNum);
            randomHugeCompaniesIconsIcons.add(hugeCompaniesIcons.get(randomIcon));
            hugeCompaniesIcons.remove(randomIcon);
        }
        return randomHugeCompaniesIconsIcons;
    }

    public ArrayList<question> setUpHugeCompaniesQuestions(){
        ArrayList<question>hugeCompanies = new ArrayList<>();
        hugeCompanies.add(new question("באיזו שנה נוסד המבורגר של שגב שוק מחנה יהודה ?", 2018));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Chanel?", 1909));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Gucci?", 1921));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Louis Vuitton?", 1854));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Prada?", 1913));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Versace?", 1978));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Motorola?", 1928));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Nokia?", 1865));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Samsung?", 1938));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Sony?", 1946));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Apple?", 1976));
        hugeCompanies.add(new question("באיזה שנה הוקמה רשת מסעדות McDonald's?", 1940));
        hugeCompanies.add(new question("באיזה שנה הוקמה רשת KFC (Kentucky Fried Chicken)?", 1952));
        hugeCompanies.add(new question("באיזה שנה הוקמה רשת Burger King?", 1953));
        hugeCompanies.add(new question("באיזה שנה הוקמה רשת Subway?", 1965));
        hugeCompanies.add(new question("באיזה שנה הוקמה רשת Taco Bell?", 1962));
        hugeCompanies.add(new question("באיזה שנה הוקמה אוניברסיטת הרווארד?", 1636));
        hugeCompanies.add(new question("באיזה שנה הוקמה אוניברסיטת אוקספורד?", 1096));
        hugeCompanies.add(new question("באיזה שנה הוקמה אוניברסיטת קיימברידג'", 1209));
        hugeCompanies.add(new question("באיזה שנה הוקמה אוניברסיטת סטנפורד?", 1885));
        hugeCompanies.add(new question("באיזה שנה הוקמה אוניברסיטת יייל (Yale University)?", 1701));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Nike?", 1964));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Coca-Cola?", 1886));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Amazon?", 1994));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Google?", 1998));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Facebook?", 2004));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Tesla?", 2003));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Microsoft?", 1975));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת IBM?", 1911));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Intel?", 1968));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Subway?", 1965));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Starbucks?", 1971));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Airbnb?", 2008));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Uber?", 2009));
        hugeCompanies.add(new question("באיזה שנה הוקמה חברת Microsoft?", 1975));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת Walt Disney?", 1923));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת Marvel?", 1939));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת Warner Bros?", 1923));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת Miramax?", 1979));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת Beats של Dr. Dre?", 2008));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת IKEA?", 1943));
        hugeCompanies.add(new question("באיזו שנה הוקמה עיתון The New York Times?", 1851));
        hugeCompanies.add(new question("באיזו שנה הוקמה רשת הטלוויזיה Fox News?", 1996));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת ABC (American Broadcasting Company)?", 1943));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת CBS (Columbia Broadcasting System)?", 1927));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת NBC (National Broadcasting Company)?", 1926));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת HBO (Home Box Office)?", 1972));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת Netflix?", 1997));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת Paramount Pictures?", 1912));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת Warner Bros?", 1923));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת Universal Pictures?", 1912));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת ASUS?", 1989));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת Dell?", 1984));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת Lenovo?", 1984));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת HP (Hewlett-Packard)?", 1939));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת AliExpress?", 2010));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת eBay?", 1995));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת Alibaba?", 1999));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת Wish?", 2010));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת ASOS?", 2000));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת דיסקונט?", 1935 ));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת יס", 1998 ));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת מזרחי טפחות?", 1944 ));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת עלית?", 1933));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת אוסם?", 1942 ));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת תנובה?", 1926));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת שטראוס?", 1939));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת טרה?", 1942 ));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת יוטבתה?", 1962 ));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת רמי לוי?", 1976));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת יוחננוף?", 1988));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת שופרסל?", 1956));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת סופרפארם?", 1978 ));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת הוט?", 2003 ));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת סלקום?", 1994));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת פרטנר(אורנג’)?", 1997));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת פלאפון?", 1986 ));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת כאן 11?", 2017));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת קשת 12?", 1993));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת רשת 13?", 1993));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת קסטרו?", 1933 ));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת פוקס?", 1942 ));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת רנואר?", 1993));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת זארה?", 1963 ));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת ברשקה?", 1998));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת פול אנד בר?", 1991 ));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת בנק הפועלים?", 1921));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת בנק לאומי?", 1902));
        hugeCompanies.add(new question("באיזו שנה הוקמה חברת מכללות אורט?", 1948));

        return setUpRandomHugeCompaniesQuestions(hugeCompanies);


    }
    public ArrayList<question> setUpRandomHugeCompaniesQuestions(ArrayList<question>hugeCompaniesQuestions){
        ArrayList<question>randomHugeCompaniesQuestions = new ArrayList<>();
        Random random = new Random();
        for (int i = 0 ; i < question.numOfQ ; i++)
        {
            int randoNum = random.nextInt(hugeCompaniesQuestions.size());
            int randomNumber = random.nextInt(hugeCompaniesQuestions.size() - randoNum);
            randomHugeCompaniesQuestions.add(hugeCompaniesQuestions.get(randomNumber));
            hugeCompaniesQuestions.remove(randomNumber);
        }
        return randomHugeCompaniesQuestions;

    }
}
