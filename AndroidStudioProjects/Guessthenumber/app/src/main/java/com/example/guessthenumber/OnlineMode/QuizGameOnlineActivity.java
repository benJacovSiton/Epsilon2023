package com.example.guessthenumber.OnlineMode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guessthenumber.R;
import com.example.guessthenumber.gameMode.TimerModel;
import com.example.guessthenumber.gameMode.TimerModelInt;
import com.example.guessthenumber.gameMode.question;
import com.example.guessthenumber.quiz.BiblicalQuiz;
import com.example.guessthenumber.quiz.CultureQuiz;
import com.example.guessthenumber.quiz.GuinnessWorldRecordsQuiz;
import com.example.guessthenumber.quiz.HistoryQuiz;
import com.example.guessthenumber.quiz.HugeCompaniesQuiz;
import com.example.guessthenumber.quiz.IsraeliQuiz;
import com.example.guessthenumber.quiz.MoviesAndTvQuiz;
import com.example.guessthenumber.quiz.MusicQuiz;
import com.example.guessthenumber.quiz.NotASimpleCalculationQuiz;
import com.example.guessthenumber.quiz.SocialNetworksQuiz;
import com.example.guessthenumber.quiz.SportQuiz;
import com.example.guessthenumber.quiz.TechnologyQuiz;
import com.example.guessthenumber.quiz.TransportationQuiz;
import com.example.guessthenumber.quiz.WorldwideQuiz;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class QuizGameOnlineActivity extends AppCompatActivity {

    ImageView quizIv; // אייקון שמלווה את השאלה
    TextView quizQuestionTv; // מציג את מספר השאלה מתוך
    TextView quizClock; // שעון השאלה
    EditText quizAnsEt; // תיבת קלט לתשובה
    TextView quizQuestionNumTv; // מציג את השאלה
    View[] views = new View[10]; // רכיבי הצביעה
    TextView quizScoreTv1; // מציג את הניקוד הנוכחי של השחקן באונליין
    MaterialButton quizButton; // כפתור נעילה
    FirebaseDatabase fD; // הפנייה לבסיס נתונים זמן אמת פיירבייס
    ArrayList<Integer> quizIcons = new ArrayList<>(); // רשימה עבור האייקונים לתצוגה
    ArrayList<question> quizQuestions = new ArrayList<>(); // רשימת השאלות בגלגול
    ArrayList<String> wrongQuizQuestions = new ArrayList<>(); // רשימה עבור כל השאלות שהשחקן אינו ידע אותן
    LinearLayout linearLayout; // עבור רקע אישי לכל קטגוריה
    boolean timerFinish = false; // מייצג סיום שאלה על ידי קטיעה של הטיימר על ידי לחיצה או סיומו
    int pos; // משתנה עבור המידע שמוזרם דרך המעברי דפים משתנה זה מייצג את הקטגוריה שנבחרה לשחק
    boolean isFinishLoading = false; // משתנה בוליאני שמצייג האם המשחק נגמר - כלומר נגמרו השאלות לטעינה
    CountDownTimer timer; // לביטול כל השעונים בעת לחיצה על כפתור חזור
    int currentQuestion; // מייצג את השאלה הנוכחית כהצגה מספרית
    int ansUser = 0; // משתנה שמכיל את תשובתו של כל שחקן בכל שאלה
    int score = 0; // הניקוד שכל אחד מהשחקנים צבר
    int count = 0; // מייצג את מיקום השאלה הנוכחית ברשימה
    int colorIndex = 0; // מייצג את האינדק לצביעה של הוויו
    Boolean isPrees = false; // מייצג האם השחקן נעל את התשובה שלו
    Boolean isFinishTimer = false; // למעקב אחרי הטיימרים
    SharedPreferences sharedPreferences; // הפנייה לשמירה המקומית

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_game_online);

        setUp(); // מחבר בין כל הרכיבים למשתנים

        TimerModel timerModel = new TimerModel(); // מופע של מחלקת השעונים שנוצרה למשחק על פי הרמות

        sharedPreferences = getSharedPreferences("wizQuiz", Context.MODE_PRIVATE); // הפנייה לשמירה המקומית

        fD = FirebaseDatabase.getInstance(); // הפנייה לפיירבייס זמן אמת

        pos = getIntent().getIntExtra("key", -1); // מקבל את מיקום הקטגוריה כדי לדעת לטעון את השאלות האייקונים והרקע המתאים
        setUpQuizGame(); // מאתחל את השאלות והאייקונים הרלוונטים

        // התנאים שניהם מתקיימים למען התחלת המשחק מכתחילה - שני השחקנים חייבים להימצא בחדר כדי לגשת לאקיטיבי הזה
        // זה שהתחבר ראשון ידוע כהמארח מוביל לפרמוט השאלות ומתחיל את הסבב
        if (LoadingActivity.host) { // אם התחבר המארח
            String q = parseQuestions();
            fD.getReference("matches").child(LoadingActivity.roomId).child("questions").setValue(q); // נכניס את השאלה בצורה פורמט
            fD.getReference("matches").child(LoadingActivity.roomId).child("zzu1finish").setValue(false);  // ניצור ילד בוליאני שמציין האם המשתמש הראשון סיים
            fD.getReference("matches").child(LoadingActivity.roomId).child("zzu2finish").setValue(false); // ניצור ילד בוליאני שמציין האם המשתמש השני סיים

            //Toast.makeText(QuizGameOnlineActivity.this , "HOST" , Toast.LENGTH_SHORT).show();
            loadQuestions(); // טוען את השאלה ובכך מתחיל את המשחק עבור המארח

        } else { // אם התחבר המשתמש השני - זה קורה סימונטלי
            // מאזין לשיניים בבסיס נתונים במקום של השאלות המפורמטות - מכיוון שפורמטו על ידי המארח יופעל המאזין
            // השאלות המפורמטות עוברות דרך הפיירבייס - למען אחידות השאלות שיוצגו למשתמש
            fD.getReference("matches").child(LoadingActivity.roomId).child("questions").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.getValue() != null && isFinishLoading == false) { // טעינה לשחקן השני
                        isFinishLoading = true;
                        quizQuestions = parseStrToQuestions(snapshot.getValue(String.class)); // ממיר את השאלות מהצורה המפורמטת שעברה דרך הבסיס נתונים בזמן אמת חזרה לרשימה של אובייקט מסוג שאלה
                        loadQuestions(); // טוען את השאלה עבור השחקן השני ובכך מתחיל את המשחק עבור השחקן השני
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(QuizGameOnlineActivity.this, "" + error, Toast.LENGTH_SHORT).show();
                }
            });
        }

        // מאזין עבור לחיצה על נעילת שאלה
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizAnsEt.getText().toString().equals(""))
                    Toast.makeText(QuizGameOnlineActivity.this, "לא שכחת משהו ? ", Toast.LENGTH_SHORT).show();
                else {
                    ansUser = Integer.parseInt(quizAnsEt.getText().toString());
                    quizAnsEt.setText("");
                    isPrees = true;
                    timerModel.CancelingTimer(); // מבטל את השעון הנוכחי
                    timerFinish = true; // כשהסתיים הסבב לגמרי
                    timerModel.timerGeneral(); // מתחיל אחד חדש
                    loadQuestions(); // צדק/טעה/ניקוד/לא/שאלה הבאה
                }

            }
        });


        timerModel.setTimerListening(new TimerModelInt() {

            @Override
            public void onTick(long sec) {

                quizClock.setText(sec + "");
                if (sec == 0 && !isFinishTimer) {
                    timerModel.timerGeneral(); // מתחיל מחדש את השעון
                    ColorAns("yellow");
                    quizAnsEt.setText("");
                    wrongQuizQuestions.add(quizQuestions.get(count).getQ()); // לא הספיק לענות זה לא ידע
                    count += 1; // מטפס מעלה כאן ובבדיקה של האם נלחץ מניע את מיקום השאלה ברשימה
                    loadQuestions();// לא הספיק להגיב/שאלה הבאה
                }
            }

            @Override
            public void onFinish() {
                timerFinish = true; // כשהסתיים הסבב לגמרי
            }
        });
        timerModel.timerGeneral();
    }

    private void setUp() {

        linearLayout = findViewById(R.id.OnlineQuizLayout); // כדי לשנות את הרקע בהתאם לקטגוריה
        quizIv = findViewById(R.id.OnlineQuizIv);
        quizQuestionTv = findViewById(R.id.OnlineQuizTv);
        quizClock = findViewById(R.id.OnlineQuizClock);
        quizAnsEt = findViewById(R.id.OnlineQuizAnsEt);
        quizQuestionNumTv = findViewById(R.id.OnlineQuizQuestionNumTv);
        views[0] = findViewById(R.id.OnlineQuizV1);
        views[1] = findViewById(R.id.OnlineQuizV2);
        views[2] = findViewById(R.id.OnlineQuizV3);
        views[3] = findViewById(R.id.OnlineQuizV4);
        views[4] = findViewById(R.id.OnlineQuizV5);
        views[5] = findViewById(R.id.OnlineQuizV6);
        views[6] = findViewById(R.id.OnlineQuizV7);
        views[7] = findViewById(R.id.OnlineQuizV8);
        views[8] = findViewById(R.id.OnlineQuizV9);
        views[9] = findViewById(R.id.OnlineQuizV10);
        quizScoreTv1 = findViewById(R.id.OnlineQuizScoreTv1);
        quizButton = findViewById(R.id.OnlineQuizButton);
    }

    private void setUpQuizGame() {

        if (pos == 0) {
            SportQuiz sportQuiz = new SportQuiz();
            quizIcons = sportQuiz.setUpSportIcons(this);
            quizQuestions = sportQuiz.setUpSportQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background1);
            linearLayout.setBackground(drawable);
        } else if (pos == 1) {
            MusicQuiz musicQuiz = new MusicQuiz();
            quizIcons = musicQuiz.setUpMusicIcons(this);
            quizQuestions = musicQuiz.setUpMusicQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background2);
            linearLayout.setBackground(drawable);
        } else if (pos == 2) {
            CultureQuiz cultureQuiz = new CultureQuiz();
            quizIcons = cultureQuiz.setUpCultureIcons(this);
            quizQuestions = cultureQuiz.setUpCultureQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background3);
            linearLayout.setBackground(drawable);
        } else if (pos == 3) {
            MoviesAndTvQuiz moviesAndTvQuiz = new MoviesAndTvQuiz();
            quizIcons = moviesAndTvQuiz.setUpMoviesAndTvIcons(this);
            quizQuestions = moviesAndTvQuiz.setUpMoviesAndTvQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background4);
            linearLayout.setBackground(drawable);
        } else if (pos == 4) {
            BiblicalQuiz biblicalActivity = new BiblicalQuiz();
            quizIcons = biblicalActivity.setUpBiblicalIcons(this);
            quizQuestions = biblicalActivity.setUpBiblicalQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background5);
            linearLayout.setBackground(drawable);
        } else if (pos == 5) {
            SocialNetworksQuiz socialNetworksQuiz = new SocialNetworksQuiz();
            quizIcons = socialNetworksQuiz.setUpSocialNetworksIcons(this);
            quizQuestions = socialNetworksQuiz.setUpSocialNetworksQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background6);
            linearLayout.setBackground(drawable);
        } else if (pos == 6) {
            HugeCompaniesQuiz hugeCompaniesQuiz = new HugeCompaniesQuiz();
            quizIcons = hugeCompaniesQuiz.setUpHugeCompaniesIcons(this);
            quizQuestions = hugeCompaniesQuiz.setUpHugeCompaniesQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background7);
            linearLayout.setBackground(drawable);
        } else if (pos == 7) {
            TechnologyQuiz technologyQuiz = new TechnologyQuiz();
            quizIcons = technologyQuiz.setUpTechnologyIcons(this);
            quizQuestions = technologyQuiz.setUpTechnologyQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background8);
            linearLayout.setBackground(drawable);
        } else if (pos == 8) {
            WorldwideQuiz worldwideQuiz = new WorldwideQuiz();
            quizIcons = worldwideQuiz.setUpWorldwideIcons(this);
            quizQuestions = worldwideQuiz.setUpWorldwideQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background9);
            linearLayout.setBackground(drawable);
        } else if (pos == 9) {
            IsraeliQuiz israeliQuiz = new IsraeliQuiz();
            quizIcons = israeliQuiz.setUpIsraeliIcons(this);
            quizQuestions = israeliQuiz.setUpIsraeliQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background10);
            linearLayout.setBackground(drawable);
        } else if (pos == 10) {
            NotASimpleCalculationQuiz notASimpleCalculation = new NotASimpleCalculationQuiz();
            quizIcons = notASimpleCalculation.setUpNotASimpleCalculationIcons(this);
            quizQuestions = notASimpleCalculation.setUpNotASimpleCalculationQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background11);
            linearLayout.setBackground(drawable);
        } else if (pos == 11) {
            HistoryQuiz historyActivity = new HistoryQuiz();
            quizIcons = historyActivity.setUpHistoryIcons(this);
            quizQuestions = historyActivity.setUpHistoryQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background12);
            linearLayout.setBackground(drawable);
        } else if (pos == 12) {
            GuinnessWorldRecordsQuiz guinnessWorldRecordsQuiz = new GuinnessWorldRecordsQuiz();
            quizIcons = guinnessWorldRecordsQuiz.setUpGuinnessWorldRecordsIcons(this);
            quizQuestions = guinnessWorldRecordsQuiz.setUpGuinnessWorldRecordsQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background13);
            linearLayout.setBackground(drawable);
        } else if (pos == 13) {
            TransportationQuiz transportationQuiz = new TransportationQuiz();
            quizIcons = transportationQuiz.setUpTransportationIcons(this);
            quizQuestions = transportationQuiz.setUpTransportationQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background14);
            linearLayout.setBackground(drawable);
        }

    }

    private void checkQ() {

        if (quizQuestions.get(count).getA() == ansUser) {
            //Toast.makeText(QuizGameOnlineActivity.this, "You're right", Toast.LENGTH_SHORT).show();
            score += 1;
            quizScoreTv1.setText("הניקוד שלך : " + score);
            ColorAns("green");
        } else {
            ColorAns("red");
            wrongQuizQuestions.add(quizQuestions.get(count).getQ());
        }

        count++;

    }

    private void loadQuestions() {

        if (isPrees) // אם השחקן נעל את התשובה שלו
            checkQ(); // ישלח לבדיקה ובמידת הצורך ניקוד ויעלה את ערך השאלה ברשימה

        // בשונה מתחילת המשחק שקורה סימונטלי כאן זה על פי קצב ההתקדמות של כל אחד משני השחקנים
        if (currentQuestion == quizQuestions.size()) { // אם המשחק נגמר - קורה כשאשר השחקן מסיים בזמנו את המשחק

            Intent intent1 = new Intent(QuizGameOnlineActivity.this, EndQuizOnlineActivity.class);
            String wrongParse = ""; // מפרמט את השאלות שאין לך מושג
            if (LoadingActivity.host) { // מנוות את פרטי המארח לידעו בפיירבייס
                wrongParse = parseWrongQuestionsAns();
                fD.getReference("matches").child(LoadingActivity.roomId).child("zzu1finish").setValue(true);
                fD.getReference("matches").child(LoadingActivity.roomId).child("zzu1score").setValue(score);
                fD.getReference("matches").child(LoadingActivity.roomId).child("zzu1wrongQuestions").setValue(wrongParse);

            } else { // מנוות את פרטי השחקן המתארח
                wrongParse = parseWrongQuestionsAns();
                fD.getReference("matches").child(LoadingActivity.roomId).child("zzu2finish").setValue(true);
                fD.getReference("matches").child(LoadingActivity.roomId).child("zzu2score").setValue(score);
                fD.getReference("matches").child(LoadingActivity.roomId).child("zzu2wrongQuestions").setValue(wrongParse);
            }
            isFinishTimer = true; // סוגר את השעון
            intent1.putExtra("score", score); // מעביר את הניקוד של השחקן הנוכחי
            intent1.putExtra("wrongParse", wrongParse); // ואת השאלות שאין לו מושג בצורה מפורמטת
            startActivity(intent1);
            finish();

        } else { // כל עוד המשחק נמשך

            quizQuestionTv.setText(quizQuestions.get(count).getQ()); // מעדכן אינדקס שאלה
            quizQuestionNumTv.setText(count + 1 + "/" + question.numOfQ); // מעדכו מספר שאלה
            quizIv.setImageResource(quizIcons.get(count)); // מעדכן תמונה
            isPrees = false; // מאפס את ערכו של הלחצן
            currentQuestion++; // מייצג את המיקום של השאלה הנוכחית להצגה ולא ברשימה
        }

    }

    // מפרמט את השאלות שכל אחד מהשחקנים לא ידע לענות עליהן
    private String parseWrongQuestionsAns() {
        String res = "";
        int j = 1;
        for (int i = 0; i < wrongQuizQuestions.size(); i++) {
            res += j + " : " + wrongQuizQuestions.get(i) + "\n";
            j++;
        }
        return res;
    }

    // הרעיון עובד בצורה כזאת שיש רשימה מטיפוס שאלה עם שאלות רנדומליות השאלות מפורמטות לסטרינג והמחרוזת נשמרת בפיירבייס למען זה ששני השחקנים יקבלו את אותן השאלות והסדר
    // לאחר שהשחקנים עברו את שלב החדר הרשימה של כל אחד מהן נטענת חזרה בשאלות המופרמטות חזרה לרשימה מטיפוס שאלות

    // מפרמט את השאלות של הקטגוריה למחרוזת שתועבר בפיירבייס לשחקנים
    private String parseQuestions() {
        String ret = "";
        for (int i = 0; i < quizQuestions.size(); i++) {
            ret += quizQuestions.get(i).getQ() + ";" + quizQuestions.get(i).getA() + ";";
        }
        return ret;
    }

    // מפרמט חזרה את המחרוזת שמשרשרת את כל השאלות אל תוך רשימה של אובייקטים מטיפוס שאלה
    private ArrayList<question> parseStrToQuestions(String q) {
        ArrayList<question> ret = new ArrayList<>(); // אתחול של הרשימה המפורמטת
        int i = q.indexOf(";"); // נקודה פיסק זאת הפרדה בין שאלה לתשובה מכל אובייקט
        while (i != -1) { // כל עוד יש עוד אובייקט משורשר
            String question = q.substring(0, i); //  השאלה שווה מהאינדקס הראשון עד לנקודה פסיק אבל היא לא תכלל על ידי הסאבסטירנג
            q = q.substring(i + 1); // מאחרי ההפרדה על הסוף פחות אחד כך שהוא לא כולל את הנקודה פסיק
            i = q.indexOf(";"); // מעדכן את האינדקס שבו נמצא ההמשך כלומר התשובה
            int ans = Integer.parseInt(q.substring(0, i));
            q = q.substring(i + 1);
            i = q.indexOf(";"); // ימצא את האינדקס של ההפרדה הבאה או יכריז על סיום במינוס אחד
            ret.add(new question(question, ans)); // מכניס את הרשימה המפורמטת את השאלה והתשובה שחולצו מהלולאה
        }
        return ret; // מחזיר את הרשימה בצורתה האובייקטית
    }

    // מקבלת צבע עפ ההכרעה על השאלה וצובעת את הוויו
    private void ColorAns(String color) {
        if (colorIndex <= 9) {
            if (color == "green") {
                GradientDrawable borderDrawable = new GradientDrawable();
                borderDrawable.setStroke(2, Color.BLACK);
                borderDrawable.setColor(0xff00ff00);
                views[colorIndex].setBackground(borderDrawable);
            } else if (color == "yellow") {
                GradientDrawable borderDrawable = new GradientDrawable();
                borderDrawable.setStroke(2, Color.BLACK);
                borderDrawable.setColor(0xFFFFFF00);
                views[colorIndex].setBackground(borderDrawable);

            } else if (color == "red") {
                GradientDrawable borderDrawable = new GradientDrawable();
                borderDrawable.setStroke(2, Color.BLACK);
                borderDrawable.setColor(0xffff0000);
                views[colorIndex].setBackground(borderDrawable);
            }
        }
        colorIndex += 1;
    }


    @Override
    public void onBackPressed() {
        if (timerFinish == false) {
            timer.cancel();
        }
        super.onBackPressed();

    }
}