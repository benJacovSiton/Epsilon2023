package com.example.guessthenumber.OnlineMode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.guessthenumber.Activities.LogInActivity;
import com.example.guessthenumber.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EndQuizOnlineActivity extends AppCompatActivity {
    ProgressBar progressBar;
    FirebaseDatabase firebaseDatabase;
    Boolean finishGame = false;
    public static String scores = ""; // סטרינג שמשרשר אליו את תוצאת הסיום של שני השחקנים יוצג באופן משותף למשתמשים

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_quiz_online);

       setUpProgressBar();

        firebaseDatabase = FirebaseDatabase.getInstance(); // הפנייה לבסיס נתונים זמן אמת פיירבייס

        String s = "zzu2finish"; // מאתחל במתארח

        //Toast.makeText(EndQuizOnlineActivity.this , ""+ QuizGameOnlineActivity.vs, Toast.LENGTH_SHORT).show();

        if(!LoadingActivity.host){ // מתקן במידת הצורך
            s = "zzu1finish";
        }
        // תנאי שעוטף את הכל - כל עוד לא נגמר המשחק עבור השחקן
        // בתוך התנאי ישנו מאזין לשינויים בערך הבוליאני שאם אחד השחקנים סיים ושינה את ערכו לאמת
        // המנגנון עובד בצורה שהוא קולט פרטים על אחד השחקנים ומתקן במידה וזה לא השחקן שסיים על ידי בדיקתו כהמארח ותיקונו לכזה
        // לאחר מכן יש מאזין לאירוע שינוי אצל השחקן שעוד לא סיים
        // כששני השחקנים מסיימים מתבצעת בדיקה של הנקודות של כל שחקן אל מול התוצאה האחרת מהבסיס נתונים ומעבירה לאקטיבי המתאים את הנקודות ע"פ הבדיקה
        firebaseDatabase.getReference("matches").
                child(LoadingActivity.roomId).child(s).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(!finishGame){ // כל עוד לא נגמר המשחק
                            if(snapshot.getValue(Boolean.class)) { // אם הערך השתנה לאמת - כלומר השחקן הראשון סיים את המשחק
                                finishGame = true;
                                String s1 = "zzu1score"; // מנווט אל הניקוד של המתארח
                                if (LoadingActivity.host)  // מתקן במידת הצורך
                                    s1 = "zzu2score";

                                // מאזין לשינויים בכתובת החדשה בבסיס נתונים ומשאיר את החיצוני להאזין לשינוי בשחקן שלא סיים
                                firebaseDatabase.getReference("matches").
                                        child(LoadingActivity.roomId).child(s1).addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                int score = getIntent().getIntExtra("score", -420); // משיג את ערך הנקודות שהועברו בין הדפים
                                                String wrongs = getIntent().getStringExtra("wrongParse"); // משיג את השאלות שאין לו מושג בצורה מפורמטת שעברה בין הדפים
                                                scores = score +  " : " + snapshot.getValue(Integer.class) ; // משרשר לכל שחקן את הנקודות שהוא צבר לעומת מה שקיים בסיס נתונים
                                                if (snapshot.getValue(Integer.class) > score ) {
                                                    String s4 = wrongs;
                                                    Toast.makeText(EndQuizOnlineActivity.this , "הפסיד" , Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(EndQuizOnlineActivity.this, LoseActivity.class);
                                                    intent.putExtra("roomId", LoadingActivity.roomId);
                                                    intent.putExtra("isHost", LoadingActivity.host);
                                                    intent.putExtra("s",score); // מעביר את התוצאה שלו שהתקבלה מהעבר דף של השחקן
                                                    intent.putExtra("wrongList",s4); // שולח את המחרוזת של השאלות שאין לך מושג
                                                    startActivity(intent);
                                                    finish();
                                                } else if (snapshot.getValue(Integer.class) == score) {
                                                    //Toast.makeText(EndQuizOnlineActivity.this, "תיקו", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(EndQuizOnlineActivity.this, TieActivity.class);
                                                    intent.putExtra("roomId", LoadingActivity.roomId);
                                                    intent.putExtra("isHost", LoadingActivity.host);
                                                    intent.putExtra("s2",snapshot.getValue(Integer.class)); // הערך הנוכחי או התוצאה עצמה שווים
                                                    intent.putExtra("wrongList2",getIntent().getStringExtra("wrongParse"));
                                                    startActivity(intent);
                                                    finish();
                                                } else {

                                                    Toast.makeText(EndQuizOnlineActivity.this , "ניצחון" , Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(EndQuizOnlineActivity.this, WinActivity.class);
                                                    intent.putExtra("roomId", LoadingActivity.roomId);
                                                    intent.putExtra("isHost", LoadingActivity.host);
                                                    intent.putExtra("s1",score); // מעביר את התוצאה שלו שהתקבלה מהעבר דף של השחקן
                                                    intent.putExtra("wrongList",wrongs);  // שולח את המחרוזת של השאלות שאין לך מושג
                                                    startActivity(intent);
                                                    finish();
                                                }

                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError error) {
                                                Toast.makeText(EndQuizOnlineActivity.this , ""+error , Toast.LENGTH_SHORT).show();
                                            }
                                        });
                            }

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(EndQuizOnlineActivity.this , ""+error , Toast.LENGTH_SHORT).show();
                    }
                });




    }

    private void setUpProgressBar() {
        // פרוגרס בר
        progressBar = findViewById(R.id.progressBarEnd);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(progressBar,"rotation",360);
        objectAnimator.setDuration(1500);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        objectAnimator.start();
    }


}
