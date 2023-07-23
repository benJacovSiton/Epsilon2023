package com.example.guessthenumber.quiz;

import android.content.Context;

import com.example.guessthenumber.gameMode.question;

import java.util.ArrayList;
import java.util.Random;

public class SocialNetworksQuiz {

    public ArrayList<Integer> setUpSocialNetworksIcons(Context context){
        ArrayList<Integer> SocialNetworksIcons = new ArrayList<>();
        for (int i = 1; i <= 23; i++) {
            int resourceId = context.getResources().getIdentifier("socialmedia" + i, "drawable", context.getPackageName());
            SocialNetworksIcons.add(resourceId);
        }

        return setUpRandomSocialNetworksIcons(SocialNetworksIcons);
    }
    public ArrayList<Integer>setUpRandomSocialNetworksIcons(ArrayList<Integer>SocialNetworksIcons){
        ArrayList<Integer>randomSocialNetworksIconsIcons = new ArrayList<>();
        Random random = new Random();
        for(int i = 0 ; i < question.numOfQ ; i++){
            int randoNum = random.nextInt(SocialNetworksIcons.size() - 1);
            int randomIcon = random.nextInt(SocialNetworksIcons.size() - randoNum);
            randomSocialNetworksIconsIcons.add(SocialNetworksIcons.get(randomIcon));
            SocialNetworksIcons.remove(randomIcon);
        }
        return randomSocialNetworksIconsIcons;
    }

    public ArrayList<question>setUpSocialNetworksQuestions(){

        ArrayList<question>socialNetworks = new ArrayList<>();  // arr for random Questions in this subject

        socialNetworks.add(new question("באיזו שנה נוסד פייסבוק על ידי מארק צוקרברג?", 2004));
        socialNetworks.add(new question("כמה תווים היום מותרים בציוץ בתחילת דרכו של הטוויטר?", 140));
        socialNetworks.add(new question("מתי עלה הסרטון הראשון ביוטיוב?", 2005));
        socialNetworks.add(new question("באיזו שנה ההאשטאג התווסף לטוויטר?", 2007));
        socialNetworks.add(new question("כמה שניות של וידאו ניתן להעלות לטיקטוק?", 60));
        socialNetworks.add(new question("באיזו שנה התווסף ה'סטורי' בסנאפצ'אט?", 2013));
        socialNetworks.add(new question("בשיאו של “מייספייס” בשנת 2008, כמה משתמשים היו במיליון?", 75));
        socialNetworks.add(new question("באיזו שנה נשלח הציוץ הראשון בטוויטר?", 2006));
        socialNetworks.add(new question("כמה עוקבים יש לחשבון האינסטגרם המוביל ביותר עד לשנת 2021?", 405));
        socialNetworks.add(new question("מאיזו שנה היה ניתן להוסיף “ניו-פיד” בפייסבוק?", 2006));
        socialNetworks.add(new question("באיזו שנה נמכרה אינסטגרם לפייסבוק?", 2012));
        socialNetworks.add(new question("כמה תווים ניתן להזין בכותרת בלינקדין?", 220));
        socialNetworks.add(new question("כמה תווים מותרים בטוויט בטוויטר?", 280));
        socialNetworks.add(new question("באיזו שנה נוסף 'Discover' בסנאפצ'אט?", 2015));
        socialNetworks.add(new question("כמה שניות יכולה להיות בסנאפ בסנאפצ'אט?", 10));
        socialNetworks.add(new question("באיזו שנה נוסף 'IGTV' באינסטגרם לסרטוני וידאו ארוכים יותר?", 2018));
        socialNetworks.add(new question("כמה חברים ניתן להוסיף בסנאפצ'אט?", 2500));
        socialNetworks.add(new question("באיזו שנה פורסם הווידאו הראשון של 'YouTube Rewind'?", 2010));
        socialNetworks.add(new question("כמה חברים ניתן להוסיף בסנאפצ'אט?", 2500));
        socialNetworks.add(new question("כמה תווים ניתן להשתמש בסיכום שבלינקדין?", 2000));
        socialNetworks.add(new question("כמה עוקבים (במיליונים) יש לחשבון ההטיקטוק המוביל ביותר עד לשנת 2021?", 100));
        socialNetworks.add(new question("באיזו שנה התווסף “הרילס” באינסטגרם?", 2020));
        socialNetworks.add(new question("באיזו שנה שודר הסרטון הראשון של Facebook Live? ", 2016));
        socialNetworks.add(new question("מתי טוויטר הגדילה את מגבלת התווים לציוצים מ-140 ל-280?'?", 2017));
        socialNetworks.add(new question("באיזו שנה פורסם הסטורי הראשון באינסטגרם?'?", 2016));
        socialNetworks.add(new question("באיזו שנה נוסף כפתור ה 'לייק' לפייסבוק?", 2009));
        socialNetworks.add(new question("באיזו שנה נוסף כפתור ה 'לייק' לטוויטר?", 2015));
        socialNetworks.add(new question("באיזו שנה נוסף כפתור ה 'לייק' לאינסטגרם?", 2016));
        socialNetworks.add(new question("מתי התרחשה השקת חנות האפל סטור של אייפון?", 2008));
        socialNetworks.add(new question("באיזו שנה הגיעה אינסטגרם למיליארד משתמשים?", 2018));
        socialNetworks.add(new question("באיזו שנה נעצרה שירה סאנטנה, מייסדת Musical.ly?", 2020));
        socialNetworks.add(new question("כמה שניות גג אפשר לצפות בסטורי בוואטסאפ?", 30));
        socialNetworks.add(new question("כמה שניות גג אפשר לצפות בסנאפצ’אט?", 10));
        socialNetworks.add(new question("באיזו שנה נוסף כפתור ה'שיתוף' לפייסבוק?", 2004));
        socialNetworks.add(new question("כמה תווים ניתן להשתמש בשם משתמש שבאינסטגרם?", 30));
        socialNetworks.add(new question("כמה אנשים ניתן להוסיף לקבוצה בפייסבוק?", 6000));
        socialNetworks.add(new question("כמה תווים יכול להכיל שם משתמש בטוויטר?", 15));
        socialNetworks.add(new question("באיזו שנה פורסמה התמונה הראשונה באינסטגרם?", 2010));
        socialNetworks.add(new question("כמה תווים יכול להכיל פוסט בפייסבוק?", 63206));
        socialNetworks.add(new question("באיזו שנה הושק יוטיוב?", 2005));
        socialNetworks.add(new question("באיזו שנה נוסד טוויטר?", 2006));
        socialNetworks.add(new question("באיזו שנה הוקמה לינקדאין?", 2002));
        socialNetworks.add(new question("באיזו שנה נוסד סנאפצ'אט?", 2011));
        socialNetworks.add(new question("באיזו שנה נוסד פינטרסט?", 2010));
        socialNetworks.add(new question("באיזו שנה נוסד גוגל+?", 2011));
        socialNetworks.add(new question("באיזו שנה נוסדה רדיט?", 2005));
        socialNetworks.add(new question("באיזו שנה נוסד יוטיוב?", 2005));
        socialNetworks.add(new question("באיזו שנה נוסדה טמבלר?", 2007));
        socialNetworks.add(new question("באיזו שנה נוסד טיק טוק?", 2016));
        socialNetworks.add(new question("באיזו שנה נוסדה וואטסאפ?", 2009));
        socialNetworks.add(new question("באיזו שנה נוסדה סקוויד?", 2017));
        socialNetworks.add(new question("באיזו שנה נוסדה אינסטגרם?", 2010));


        return setUpRandomSocialNetworksQuestions(socialNetworks);


    }
    public ArrayList<question> setUpRandomSocialNetworksQuestions(ArrayList<question>socialNetworksQuestions){
        ArrayList<question>randomSocialNetworks = new ArrayList<>();
        Random random = new Random();
        for (int i = 0 ; i < question.numOfQ ; i++)
        {
            int randoNum = random.nextInt(socialNetworksQuestions.size());
            int randomNumber = random.nextInt(socialNetworksQuestions.size() - randoNum);
            randomSocialNetworks.add(socialNetworksQuestions.get(randomNumber));
            socialNetworksQuestions.remove(randomNumber);
        }
        return randomSocialNetworks;
    }
}
