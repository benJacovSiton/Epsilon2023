package com.example.guessthenumber.OnlineMode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.guessthenumber.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoadingActivity extends AppCompatActivity {

    ProgressBar progressBar;
    int id = -420;
    FirebaseDatabase fD;
    boolean findGame = false;
    public static boolean host;
    public static String userInfo;
    public static String hostInfo;
    public static String roomId;
    int pos;
    int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding);

        // פרוגרס בר
        progressBar = findViewById(R.id.progressBar);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(progressBar,"rotation",360);
        objectAnimator.setDuration(1500);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        objectAnimator.start();

        host = false; // משתנה בוליאני שעוקב אחר המארח
        pos = getIntent().getIntExtra("key", -1);
        level = getIntent().getIntExtra("level", -1);


        fD = FirebaseDatabase.getInstance(); // משיג הפנייה לדאטה בייס
        // נכנס לנתיב במאצ'טס ומאזין לשינוי בודד
        fD.getReference("matches").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                // הפנייה לשמירה הלוקאלית
                SharedPreferences sP = getSharedPreferences("wizQuiz", Context.MODE_PRIVATE);

                // מאחזר ערך שלם מה-SharedPreferences בשם "userId" ומקצה אותו למשתנה userId
                int userId = sP.getInt("userId",0);

                // הקוד עובר על הילדים של תמונת המצב של "התאמות".
                for (DataSnapshot data : snapshot.getChildren()){

                    // עבור כל תמונת מצב של ילד, הוא בודק אם המפתח שווה ל"מזהה". אם כן, הוא מאחזר את הערך השלם המתאים ומקצה אותו למשתנה id.
                    if(data.getKey().equals("id"))
                    {
                        id = data.getValue(Integer.class);
                        continue;
                    }
                    // אם המפתח אינו שווה ל-"id", הקוד יוצר ArrayList בשם dataArr .
                    ArrayList<DataSnapshot> dataArr = new ArrayList<>();

                    // לאחר מכן הוא חוזר על הילדים של תמונת המצב הנוכחית ומוסיף כל ילד לרשימת dataArr.
                    for(DataSnapshot data2 : data.getChildren()){
                        dataArr.add(data2);
                    }

                    // הוא בודק אם הערך של dataArr באינדקס 2 שווה לשרשור של מיקום ורמה. אם הערכים שנמצאים בתוך ztype שווים לשרשור
                    if(dataArr.get(2).getValue().equals(pos+""+level)){

                        // אם השחקן שנמצא בחדר זמין למשחק מסומן על ידי איי גדולה
                        if(dataArr.get(0).getValue().equals("A"))
                        {
                            // בתוך מאטצ'ס הוא משיג את הילד נכנס למפתח שלו ומוליד שם ילד נוסף עם עם הערך בתא 0 להיות המפתח והערך שלו מזהה השחקן בכך
                            // מכניס לערך של השחקן הראשון את השחקן
                            fD.getReference("matches").child(data.getKey()).child(dataArr.get(0).getKey()).setValue(userId);
                            // מחזיר את המספר חדר הנוכחי - בדאטה בייס מזהה הוא המזהה היחידי
                            roomId = data.getKey();
                            Toast.makeText(LoadingActivity.this , "FIND GAME" , Toast.LENGTH_SHORT).show();
                            findGame = true;
                            Intent intent = new Intent(LoadingActivity.this , QuizGameOnlineActivity.class);
                            intent.putExtra("key", pos);
                            startActivity(intent);
                            finish();
                            return;
                        }

                        else if (dataArr.get(1).getValue().equals("A"))
                        {
                            // מכניס לערך של השחקן השני את המזהה של השחקן השני
                            fD.getReference("matches").child(data.getKey()).child(dataArr.get(1).getKey()).setValue(userId);
                            roomId = data.getKey();
                            Toast.makeText(LoadingActivity.this , "FIND GAME" , Toast.LENGTH_SHORT).show();
                            // כשהשחקן השני נכנס ניתן לקבוע מי הוא ההוסט ומיהו המארח
                            hostInfo = dataArr.get(0).getKey();
                            userInfo = dataArr.get(1).getKey();
                            findGame = true;
                            Intent intent = new Intent(LoadingActivity.this , QuizGameOnlineActivity.class);
                            intent.putExtra("key", pos);
                            startActivity(intent);
                            finish();
                            return;
                        }
                    }


                }
                // יוצר חדר חדש
                fD.getReference("matches").child("room"+id).setValue(""); // יוצר חדר ריק
                fD.getReference("matches").child("room"+id).child("uId1").setValue(userId); // מכניס לחדר את הילד משתמש מזהה1 וקובע בו את המזהה של השחקן1
                fD.getReference("matches").child("room"+id).child("uId2").setValue("A"); // מכניס לחדר את השחקן השני וקובע בו ערך לפנוי
                fD.getReference("matches").child("room"+id).child("ztype").setValue(pos+""+level); // מכניס לחדר את הפרמטרים לזיהוי הקטגוריה והרמה
                fD.getReference("matches").child("id").setValue(id+1);
                host = true;
                roomId = "room"+id; // מוסיף מזהה לחדר פנוי אחרי

                // מאזין לשינויים אצל השחקן השני
                fD.getReference("matches").child("room"+id).child("uId2").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        // אם נכנס שחקן שני - מבטל את הA  אפשר להתחיל את המשחק
                        if(!snapshot.getValue().equals("A")){
                            Toast.makeText(LoadingActivity.this , "FIND GAME" , Toast.LENGTH_SHORT).show();
                            findGame = true;
                            Intent intent = new Intent(LoadingActivity.this , QuizGameOnlineActivity.class);
                            intent.putExtra("key", pos);
                            startActivity(intent);
                            finish();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(LoadingActivity.this , ""+error, Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                 Toast.makeText(LoadingActivity.this , ""+error, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onBackPressed(){
        fD.getReference("matches").child("room"+id).removeValue();
        finish();
    }

    @Override
    public void onPause() {
        if(!findGame) {
            fD.getReference("matches").child("room"+id).removeValue();
            finish();
        }
        super.onPause();
    }
}