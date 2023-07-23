package com.example.guessthenumber.AI_Mode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
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

import java.util.ArrayList;
import java.util.Random;

public class QuizGameActivity extends AppCompatActivity {

    ImageView quizIv; // אייקון להצגה
    TextView quizQuestionTv; // מציג את השאלה
    TextView quizClock; // שעון ספירה לאחור לסיום השאלה
    EditText quizAnsEt; // תיבת טקסט עבור השחקן להכניס תשובה
    TextView quizAnsTv; // תצוגה של תשובת המחשב בשניות האחרונות לספירה
    TextView quizQuestionNumTv; // הצגת מספר השאלה
    View[] views = new View[10]; // וויו לצביעה
    TextView quizScoreTv1; // הנקודות של השחקן
    TextView quizScoreTv2; // הנקודות של המחשב
    MaterialButton quizButton; // נועל את השאלה של השחקן
    CountDownTimer timer; // לביטול כל השעונים בעת לחיצה על כפתור חזור
    int currentQuestion = 0; // השאלה הנוכחית ברשימה
    AI ai = new AI(); // מופע של המחלקה שמדמה שחקן
    TimerModel timerModel = new TimerModel(); // מופע של מחלקת השעונים שנוצרה למשחק על פי הרמות
    boolean timerFinish = false; // משמש כדי לקבוע אם המשתמש סיפק תשובה בתוך מגבלת הזמן הנתונה או אם פג תוקף הטיימר.
    int pos; // משתנה עבור המידע שמוזרם דרך המעברי דפים משתנה זה מייצג את הקטגוריה שנבחרה לשחק
    ArrayList<Integer>quizIcons = new ArrayList<>(); // רשימה עבור האייקונים
    ArrayList<question>quizQuestions = new ArrayList<>();// רשימה עבור השאלות
    ArrayList<String>wrongQuizQuestions = new ArrayList<>(); // רשימה עבור השאלות השגויות
    LinearLayout linearLayout; // כדי לשנות את הרקע
    int aiScore; // כמות הנקודות שצבר המחשב
    int userScore; // מספר הנקודות שצבר השחקן
    int count = 1; // כאן במקרה השונה מאונליין הוא מאפיין את מספר השאלה לתצוגה
    boolean isFinishQuiz = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_game);

        quizIv = findViewById(R.id.QuizIv);
        quizQuestionTv = findViewById(R.id.QuizTv);
        quizClock = findViewById(R.id.QuizClock);
        quizAnsEt = findViewById(R.id.QuizAnsEt);
        quizAnsTv = findViewById(R.id.QuizAnsTV);
        quizQuestionNumTv = findViewById(R.id.QuizQuestionNumTv);
        views[0] = findViewById(R.id.QuizV1);
        views[1] = findViewById(R.id.QuizV2);
        views[2] = findViewById(R.id.QuizV3);
        views[3] = findViewById(R.id.QuizV4);
        views[4] = findViewById(R.id.QuizV5);
        views[5] = findViewById(R.id.QuizV6);
        views[6] = findViewById(R.id.QuizV7);
        views[7] = findViewById(R.id.QuizV8);
        views[8] = findViewById(R.id.QuizV9);
        views[9] = findViewById(R.id.QuizV10);
        quizScoreTv1 = findViewById(R.id.QuizScoreTv1);
        quizScoreTv2 = findViewById(R.id.QuizScoreTv2);
        quizButton = findViewById(R.id.QuizButton);

        linearLayout = findViewById(R.id.QuizLayout); // כדי לשנות את הרקע

        pos = getIntent().getIntExtra("key", -1); // מעביר את המיקום של הקטגוריה בה המשתמש מעוניין לשחק
        int level = getIntent().getIntExtra("level" , -420); // מעביר את הרמה של המשחק בה המשתמש מעוניין לשחק
        setUpQuizGame();
        loadQuestions();

        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizAnsEt.getText().toString().equals(""))
                    Toast.makeText(QuizGameActivity.this, "לא שכחת משהו ? ", Toast.LENGTH_SHORT).show();

                else{
                    int ansAi = AIQuizAns();
                    int ansUser =  Integer.parseInt(quizAnsEt.getText().toString());
                    timerModel.CancelingTimer(); // מבטל את השעון הנוכחי
                    timerModel.timerGeneral(); // מתחיל אחד חדש
                    roundDefeat(ansAi,ansUser,level);
                }

            }
        });

        timerModel.setTimerListening(new TimerModelInt() {
            @Override
            public void onTick(long sec)
            {
                int ansAi = -1;
                quizClock.setText(sec +"");
                if (sec == 2 && isFinishQuiz == false)
                {
                     ansAi = AIQuizAns();
                    quizAnsTv.setText(ansAi+"");
                }
                else if (sec == 0 && isFinishQuiz == false)
                {
                    roundDefeat(ansAi,-1 , level);
                }

            }

            @Override
            public void onFinish()
            {
                timerFinish = true; // כשהסתיים הסבב לגמרי

            }

        });
        timerModel.timerGeneral(); // הפעולה נקראת כדי להפעיל טיימר חדש. זה מבטיח כי טיימר חדש יופעל לאחר ביטול הקודם או כאשר הטיימר כבר הסתיים.


    }

    private void setUpQuizGame(){

        if(pos == 0)
        {
            SportQuiz sportQuiz = new SportQuiz();
            quizIcons = sportQuiz.setUpSportIcons(this);
            quizQuestions= sportQuiz.setUpSportQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background1);
            linearLayout.setBackground(drawable);
        }
        else if(pos == 1)
        {
            MusicQuiz musicQuiz = new MusicQuiz();
            quizIcons = musicQuiz.setUpMusicIcons(this);
            quizQuestions= musicQuiz.setUpMusicQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background2);
            linearLayout.setBackground(drawable);
        }

        else if(pos == 2)
        {
            CultureQuiz cultureQuiz = new CultureQuiz();
            quizIcons = cultureQuiz.setUpCultureIcons(this);
            quizQuestions= cultureQuiz.setUpCultureQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background3);
            linearLayout.setBackground(drawable);
        }

        else if (pos == 3)
        {
            MoviesAndTvQuiz moviesAndTvQuiz = new MoviesAndTvQuiz();
            quizIcons = moviesAndTvQuiz.setUpMoviesAndTvIcons(this);
            quizQuestions= moviesAndTvQuiz.setUpMoviesAndTvQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background4);
            linearLayout.setBackground(drawable);
        }

        else if (pos == 4)
        {
            BiblicalQuiz biblicalActivity = new BiblicalQuiz();
            quizIcons = biblicalActivity.setUpBiblicalIcons(this);
            quizQuestions= biblicalActivity.setUpBiblicalQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background5);
            linearLayout.setBackground(drawable);
        }

        else if (pos == 5)
        {
            SocialNetworksQuiz socialNetworksQuiz = new SocialNetworksQuiz();
            quizIcons = socialNetworksQuiz.setUpSocialNetworksIcons(this);
            quizQuestions= socialNetworksQuiz.setUpSocialNetworksQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background6);
            linearLayout.setBackground(drawable);
        }

        else if (pos == 6)
        {
            HugeCompaniesQuiz hugeCompaniesQuiz = new HugeCompaniesQuiz();
            quizIcons = hugeCompaniesQuiz.setUpHugeCompaniesIcons(this);
            quizQuestions= hugeCompaniesQuiz.setUpHugeCompaniesQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background7);
            linearLayout.setBackground(drawable);
        }

        else if (pos == 7)
        {
            TechnologyQuiz technologyQuiz = new TechnologyQuiz();
            quizIcons = technologyQuiz.setUpTechnologyIcons(this);
            quizQuestions= technologyQuiz.setUpTechnologyQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background8);
            linearLayout.setBackground(drawable);
        }

        else if (pos == 8)
        {
            WorldwideQuiz worldwideQuiz = new WorldwideQuiz();
            quizIcons = worldwideQuiz.setUpWorldwideIcons(this);
            quizQuestions= worldwideQuiz.setUpWorldwideQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background9);
            linearLayout.setBackground(drawable);
        }

        else if (pos == 9)
        {
            IsraeliQuiz israeliQuiz = new IsraeliQuiz();
            quizIcons = israeliQuiz.setUpIsraeliIcons(this);
            quizQuestions= israeliQuiz.setUpIsraeliQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background10);
            linearLayout.setBackground(drawable);
        }

        else if (pos == 10)
        {
            NotASimpleCalculationQuiz notASimpleCalculation = new NotASimpleCalculationQuiz();
            quizIcons = notASimpleCalculation.setUpNotASimpleCalculationIcons(this);
            quizQuestions= notASimpleCalculation.setUpNotASimpleCalculationQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background11);
            linearLayout.setBackground(drawable);
        }

        else if (pos == 11)
        {
            HistoryQuiz historyActivity = new HistoryQuiz();
            quizIcons = historyActivity.setUpHistoryIcons(this);
            quizQuestions= historyActivity.setUpHistoryQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background12);
            linearLayout.setBackground(drawable);
        }

        else if (pos == 12)
        {
            GuinnessWorldRecordsQuiz guinnessWorldRecordsQuiz = new GuinnessWorldRecordsQuiz();
            quizIcons = guinnessWorldRecordsQuiz.setUpGuinnessWorldRecordsIcons(this);
            quizQuestions= guinnessWorldRecordsQuiz.setUpGuinnessWorldRecordsQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background13);
            linearLayout.setBackground(drawable);
        }

        else if (pos == 13)
        {
            TransportationQuiz transportationQuiz = new TransportationQuiz();
            quizIcons = transportationQuiz.setUpTransportationIcons(this);
            quizQuestions= transportationQuiz.setUpTransportationQuestions();
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.background14);
            linearLayout.setBackground(drawable);
        }

    }


    private int AIQuizAns(){

        Boolean isAnsAi = ai.rightAnsOrNot(); // האם המחשב צדק ?

        int ansAi = -1; // מאתחל את התשובה

        if(isAnsAi) // אם הוגרל שיצא נכון
            ansAi = quizQuestions.get(currentQuestion).getA(); // נקבל את התשובה הנכונה

        else // אם הורגל שלא
            ansAi = ai.wrongGuess(quizQuestions.get(currentQuestion)); // נשלח את השאלה הספציפית כדי לקבל תשובה עם סטייה גדולה או קטנה מהתשובה

        return ansAi;
    }

    private void roundDefeat(int ansAi , int ansUser , int level) {

        if(count < quizQuestions.size()) // כל עוד לא הגיע לשאלה האחרונה
        {
            // מכריע את ניקוד השאלה לפי הרמה
            if(level == 1)
                roundDefeatLevel1(ansAi,ansUser);
            else if(level == 2)
                roundDefeatLevel2(ansAi,ansUser);
            else if (level == 3)
                roundDefeatLevel3(ansAi,ansUser);

            //Toast.makeText(this, "התשובה הנכונה : " + quizQuestions.get(currentQuestion).getA() + " ",Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, "תשובה של המחשב : " + ansAi + " ",Toast.LENGTH_SHORT).show();
            quizScoreTv1.setText("הניקוד שלך :" + userScore);
            quizScoreTv2.setText("הניקוד של היריב :"+ aiScore);
            quizAnsEt.setText("");
            quizAnsTv.setText("");
            loadQuestions(); // טוען את השאלה הבאה

            if(timerFinish == false) // משמע שהטיימר המקורי עדיין רץ ואין צורך לבטל אותו  - זה נעשה כדי למנוע בעיות פוטנציאליות עם מספר טיימרים הפועלים בו זמנית.
                timerModel.CancelingTimer();


            else // כאשר לשחקן לא היה מספיק זמן ללחוץ על הכפתור ולספק תשובה
                timerFinish = false; // מציין שיופעל טיימר חדש.

            timerModel.timerGeneral(); // הפעולה נקראת כדי להפעיל טיימר חדש. זה מבטיח כי טיימר חדש יופעל לאחר ביטול הקודם או כאשר הטיימר כבר הסתיים.

            count++; // מייצג את כמות השאלות שנשאלו

        }

        else // אם הגיע לשאלה האחרונה
        {
            // מכריע את ניקוד השאלה האחרונה
            if(level == 1)
                roundDefeatLevel1(ansAi,ansUser);
            else if(level == 2)
                roundDefeatLevel2(ansAi,ansUser);
            else if (level == 3)
                roundDefeatLevel3(ansAi,ansUser);

            isFinishQuiz = true;
            Intent intent = new Intent(QuizGameActivity.this, EndQuizActivity.class);
            intent.putExtra("scoreUser",userScore);
            intent.putExtra("scoreAi",aiScore);
            intent.putExtra("key",pos);
            intent.putStringArrayListExtra("wrong",wrongQuizQuestions);
            startActivity(intent);
            finish();
        }

    }

    private void roundDefeatLevel1(int ansAi , int ansUser){

        int ans = quizQuestions.get(currentQuestion).getA();

        if(ansUser == -1){
            aiScore += 3;
            wrongQuizQuestions.add(quizQuestions.get(currentQuestion).getQ());
            colorQuestions("red");
        }

        else if (ansUser != ans && ansAi == ans){
            aiScore += 3;
            wrongQuizQuestions.add(quizQuestions.get(currentQuestion).getQ());
            colorQuestions("red");

        }

        else if (ansUser == ans && ansAi != ans){
            userScore += 3;
            colorQuestions("green");
        }


        else if(ansUser == ans && ansAi == ans || ansUser == ansAi ) {
            aiScore += 1;
            userScore += 1;
            colorQuestions("yellow");
        }

        else if (ansUser > ans && ansAi > ans)
        {
            int differenceByUser = ansUser - ans;
            int differenceByAi = ansAi - ans;
            if(differenceByUser > differenceByAi){
                aiScore += 1;
                wrongQuizQuestions.add(quizQuestions.get(currentQuestion).getQ());
                colorQuestions("red");
            }
            else if (differenceByAi > differenceByUser){
                userScore += 1;
                colorQuestions("blue");
            }

        }
        else if (ansUser < ans && ansAi < ans )
        {
            int differenceByUser = ans - ansUser ;
            int differenceByAi = ans - ansAi ;
            if(differenceByUser > differenceByAi){
                aiScore += 1;
                wrongQuizQuestions.add(quizQuestions.get(currentQuestion).getQ());
                colorQuestions("red");
            }
            else if (differenceByAi > differenceByUser){
                userScore += 1;
                colorQuestions("blue");
            }

        }

        else if (ansUser > ans && ansAi < ans )
        {
            int differenceByUser = ansUser - ans;
            int differenceByAi = ans - ansAi ;
            if(differenceByUser > differenceByAi){
                aiScore += 1;
                wrongQuizQuestions.add(quizQuestions.get(currentQuestion).getQ());
                colorQuestions("red");
            }
            else if (differenceByAi > differenceByUser){
                userScore += 1;
                colorQuestions("blue");
            }


        }
        else if (ansUser < ans && ansAi > ans )
        {
            int differenceByUser = ans - ansUser ;
            int differenceByAi = ansAi - ans;
            if(differenceByUser > differenceByAi){
                aiScore += 1;
                wrongQuizQuestions.add(quizQuestions.get(currentQuestion).getQ());
                colorQuestions("red");
            }
            else if (differenceByAi > differenceByUser){
                userScore += 1;
                colorQuestions("blue");
            }

        }
        currentQuestion++;

    }

    private void roundDefeatLevel2(int ansAi , int ansUser){

        int ans = quizQuestions.get(currentQuestion).getA();

        if(ansUser == -1){
            aiScore += 3;
            wrongQuizQuestions.add(quizQuestions.get(currentQuestion).getQ());
            colorQuestions("red");
        }

        else if (ansUser != ans && ansAi == ans){
            aiScore += 3;
            wrongQuizQuestions.add(quizQuestions.get(currentQuestion).getQ());
            colorQuestions("red");

        }

        else if (ansUser == ans && ansAi != ans){
            userScore += 3;
            colorQuestions("green");
        }

        else if(ansUser == ans && ansAi == ans || ansUser == ansAi ){
            colorQuestions("yellow");
        }


        else if (ansUser > ans && ansAi > ans)
        {
            int differenceByUser = ansUser - ans;
            int differenceByAi = ansAi - ans;
            if(differenceByUser > differenceByAi){
                aiScore += 1;
                wrongQuizQuestions.add(quizQuestions.get(currentQuestion).getQ());
                colorQuestions("red");
            }
            else if (differenceByAi > differenceByUser){
                userScore += 1;
                colorQuestions("blue");
            }

        }
        else if (ansUser < ans && ansAi < ans )
        {
            int differenceByUser = ans - ansUser ;
            int differenceByAi = ans - ansAi ;
            if(differenceByUser > differenceByAi){
                aiScore += 1;
                wrongQuizQuestions.add(quizQuestions.get(currentQuestion).getQ());
                colorQuestions("red");
            }
            else if (differenceByAi > differenceByUser){
                userScore += 1;
                colorQuestions("blue");
            }

        }

        else if (ansUser > ans && ansAi < ans )
        {
            int differenceByUser = ansUser - ans;
            int differenceByAi = ans - ansAi ;
            if(differenceByUser > differenceByAi){
                aiScore += 1;
                wrongQuizQuestions.add(quizQuestions.get(currentQuestion).getQ());
                colorQuestions("red");
            }
            else if (differenceByAi > differenceByUser){
                userScore += 1;
                colorQuestions("blue");
            }


        }
        else if (ansUser < ans && ansAi > ans )
        {
            int differenceByUser = ans - ansUser ;
            int differenceByAi = ansAi - ans;
            if(differenceByUser > differenceByAi){
                aiScore += 1;
                wrongQuizQuestions.add(quizQuestions.get(currentQuestion).getQ());
                colorQuestions("red");
            }
            else if (differenceByAi > differenceByUser){
                userScore += 1;
                colorQuestions("blue");
            }

        }
        currentQuestion++;

    }

    private void roundDefeatLevel3(int ansAi , int ansUser){

        int ans = quizQuestions.get(currentQuestion).getA();

         if (ansUser == ans && ansAi != ans){
            userScore += 1;
            colorQuestions("green");
        }
         else if(ansUser != ans && ansAi == ans){
             aiScore += 1;
             colorQuestions("red");
         }
         else if(ansUser == ans && ansAi == ans || ansUser == ansAi ){
             colorQuestions("yellow");
         }
        else{
            colorQuestions("red");
            wrongQuizQuestions.add(quizQuestions.get(currentQuestion).getQ());
        }
        currentQuestion++;


    }

    private void colorQuestions(String color){
        if(color == "green"){
            GradientDrawable borderDrawable = new GradientDrawable();
            borderDrawable.setStroke(2, Color.BLACK);
            borderDrawable.setColor(0xff00ff00);
            views[currentQuestion].setBackground(borderDrawable);
        }
        else if(color == "red"){
            GradientDrawable borderDrawable = new GradientDrawable();
            borderDrawable.setStroke(2, Color.BLACK);
            borderDrawable.setColor(0xffff0000);
            views[currentQuestion].setBackground(borderDrawable);
        }
        else if(color == "blue"){
            GradientDrawable borderDrawable = new GradientDrawable();
            borderDrawable.setStroke(2, Color.BLACK);
            borderDrawable.setColor(0xFF0000FF);
            views[currentQuestion].setBackground(borderDrawable);
        }
        else if(color == "yellow"){
            GradientDrawable borderDrawable = new GradientDrawable();
            borderDrawable.setStroke(2, Color.BLACK);
            borderDrawable.setColor(0xFFFFFF00);
            views[currentQuestion].setBackground(borderDrawable);
        }

    }

    private void loadQuestions() {

        quizQuestionTv.setText(quizQuestions.get(currentQuestion).getQ());
        quizQuestionNumTv.setText((count) + "/" + quizQuestions.size());
        quizIv.setImageResource(quizIcons.get(currentQuestion));
    }

 /*
שיטת onBackPressed() היא עקיפה של פונקציונליות כפתור החזרה באנדרואיד. זה נקרא כאשר כפתור החזרה נלחץ על ידי המשתמש.

בקטע קוד זה, אם המשתנה timerFinish הוא false, זה אומר שהטיימר עדיין פועל. במקרה כזה, השיטה timer.cancel() נקראת כדי לבטל את הטיימר. זה מבטיח שהטיימר יופסק לפני סגירת הפעילות או שהמשתמש יוחזר למסך הקודם.

לאחר ביטול הטיימר (במידת הצורך), שיטת super.onBackPressed() נקראת לבצע את התנהגות ברירת המחדל של כפתור החזרה, שבדרך כלל היא סגירת הפעילות הנוכחית או ניווט חזרה למסך הקודם.

בסך הכל, קטע קוד זה מבטיח שהטיימר מבוטל כראוי לפני היציאה מהפעילות כדי למנוע בעיות פוטנציאליות עם הטיימר שפועל ברקע.
 */

    @Override
    public void onBackPressed()
    {
        if(timerFinish == false)
        {
            timer.cancel();
        }
        super.onBackPressed();

    }
}
