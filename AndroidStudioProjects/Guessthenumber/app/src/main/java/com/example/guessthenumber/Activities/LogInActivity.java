package com.example.guessthenumber.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guessthenumber.MainActivity;
import com.example.guessthenumber.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogInActivity extends AppCompatActivity {
    Context context;
    Button logInBtn;
    EditText userNameLogInEt ;
    SharedPreferences sP;
    public static String savedUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        context = this;
        logInBtn = findViewById(R.id.LogInButton);
        userNameLogInEt = findViewById(R.id.UserNameLogInEt);


        // מקבלים הפנייה לשמירה המקומית
        sP = getSharedPreferences("wizQuiz",Context.MODE_PRIVATE);

        // סעיף זה בודק אם קובץ ההעדפות המשותפות מכיל מפתח בשם "userId". אם המפתח קיים, זה אומר שהמשתמש כבר מחובר, והאפליקציה מפעילה את MainActivity ישירות מבלי לעבור את תהליך הכניסה.
        if(sP.contains("userId"))
        {
            savedUsername = sP.getString("nickName", "hello world");
            Intent intent = new Intent(LogInActivity.this, MainActivity.class);
            startActivity(intent);
            finish();

        }

        // במידה ולא קיים ניצור מופע חדש של יוזר באירוע לחיצה
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userNameLogInEt.getText().length() < 7 && userNameLogInEt.getText().length() > 0 )
                    registration();
                else
                    Toast.makeText(LogInActivity.this , "מוגבל עד שישה תווים" , Toast.LENGTH_SHORT).show();

            }
        });

    }
    public void registration(){
        // מקבל הפניה לצומת הבסיס של מסד הנתונים בזמן אמת של Firebase.
        FirebaseDatabase fD = FirebaseDatabase.getInstance();

        // מאזין למיקום מסוים במסד הנתונים ("משתמשים/מזהה") כדי לקרוא ערך בודד. מאזין זה מופעל פעם אחת עם הערך הנוכחי במיקום שצוין.
        fD.getReference("users").child("id").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {  // בתוך onDataChange(), הערך שאוחזר (מזהה המשתמש הנוכחי) גדל, ולאחר מכן הערך המעודכן נשמר בחזרה ל-Firebase Realtime Database.
                int curId = snapshot.getValue(Integer.class); // מחזיר את מזהה המשתמש האחרון הפנוי - מייצר חדש בכל סוף רישום
                SharedPreferences.Editor i = sP.edit(); // מקבל גישה לשמירה המקומית כדי לבצע שינויים - תחת איי
                i.putInt("userId",curId); // מכניס את הערך
                i.apply(); // אוכף את השינויים
                SharedPreferences.Editor j = sP.edit(); // מקבל גישה לשמירה המקומית כדי לבצע שינויים - תחת איי
                j.putString("nickName",userNameLogInEt.getText().toString()); // מכניס את הערך
                j.apply(); // אוכף את השינויים
                fD.getReference("users").child("user"+curId).child("id").setValue(curId); // מכניס את המשתמש החדש באמצעות המזהה שלו לבסיס הנתונים בזמן אמת פיירפבייס
                fD.getReference("users").child("user"+curId).child("nickname").setValue(sP.getString("nickName", "")); // מכניס את המשתמש החדש באמצעות המזהה שלו לבסיס הנתונים בזמן אמת פיירפבייס
                curId++; // מעלה את הערך למזהה של המשתמש הבא
                fD.getReference("users").child("id").setValue(curId);


                // לאחר כל הרישום ניגש לתפריט הראשי
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
                finish();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(LogInActivity.this ,"no internet ", Toast.LENGTH_SHORT).show();
            }
        });

    }
}