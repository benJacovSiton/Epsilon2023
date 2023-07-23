package com.example.guessthenumber.AI_Mode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guessthenumber.MainActivity;
import com.example.guessthenumber.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Random;

public class EndQuizActivity extends AppCompatActivity {

    TextView scoreTv , wrongsTv , subtitleTv , titleTv  , aiScoreTv;
    MaterialButton retireButton;
    ImageView playerIcon , aiIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_quiz);

        titleTv = findViewById(R.id.TitleEndQuizTv);
        subtitleTv = findViewById(R.id.HeadlineEndQuizTV);
        playerIcon = findViewById(R.id.EndQuizIV);
        scoreTv = findViewById(R.id.RightAnsEndQuizTv);
        aiIcon = findViewById(R.id.RightAnsAiEndQuizIv);
        aiScoreTv = findViewById(R.id.RightAnsAiEndQuizTv);
        wrongsTv = findViewById(R.id.WrongsAnsEndQuizTv);
        retireButton = findViewById(R.id.RetireButton);

        int scoreUser = getIntent().getIntExtra("scoreUser",0);
        int scoreAI = getIntent().getIntExtra("scoreAi",0);
        ArrayList<String>wrongs = getIntent().getStringArrayListExtra("wrong");

        if(scoreUser > scoreAI)
        {
            titleTv.setText("ניצחון מסחרר");
            subtitleTv.setText(championEndQuizText());
            scoreTv.setText(scoreUser+"");
            aiScoreTv.setText(scoreAI+"");
            playerIcon.setImageResource(ChampionEndQuizImg());
            aiIcon.setImageResource(R.drawable.brokenai);

        }

        else if(scoreUser == scoreAI){
            titleTv.setText("תיקו מכובד");
            subtitleTv.setText("לכו לפנדלים");
            scoreTv.setText(scoreUser+"");
            aiScoreTv.setText(scoreAI+"");
            playerIcon.setImageResource(R.drawable.ticoaipic);
            aiIcon.setImageResource(R.drawable.halfai);
        }

        else
        {
            titleTv.setText("כישלון מוחץ");
            subtitleTv.setText(loserEndQuizText());
            scoreTv.setText(scoreUser+"");
            aiScoreTv.setText(scoreAI+"");
            playerIcon.setImageResource(loserEndQuizImg());
            aiIcon.setImageResource(R.drawable.fixai);
        }

         String wrongsText = parseWrongs(wrongs);

        scoreTv.setText(scoreUser+"");
        wrongsTv.setText("השאלות שלא ידעת את התשובות שלהן במדוייק :  "+"\n"+wrongsText);

        retireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndQuizActivity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    // הפעולה מחזירה מחרוזת מפורמטת של השאלות שהמשתמש לא ידע את התשובות עליהן
    private String parseWrongs(ArrayList wrongs){
        String text = "";
        int j = 1;
        for (int i = 0; i < wrongs.size(); i++){
            text += j + ": " + wrongs.get(i).toString() +"\n";
            j += 1;
        }
        return text;
    }

    // דואג לתצוגה רנדומלית של תמונה למפסיד
    private int loserEndQuizImg() {
        Random random = new Random();
        int randomIcon = random.nextInt(14)+1;
        int resourceId = getResources().getIdentifier("loser" + randomIcon, "drawable", this.getPackageName());
        return resourceId;
    }

    // דואג לברכה למפסיד
    private String loserEndQuizText(){
        ArrayList<String> loserText = new ArrayList<>();
        loserText.add("יכל להיות גרוע...תראה את התמונה למטה");
        loserText.add("זאת לא בושה להפסיד לסלבדור");
        loserText.add("לפעמים גם זה קורה");
        loserText.add(" טיפ : פעם הבאה עם chatGpt פתוח");
        Random random = new Random();
        int randomText = random.nextInt(loserText.size());
        return loserText.get(randomText);
    }

    private int ChampionEndQuizImg(){
        Random random = new Random();
        int randomIcon = random.nextInt(10)+1;
        int resourceId = getResources().getIdentifier("champion" + randomIcon, "drawable", this.getPackageName());
        return resourceId;
    }

    private String championEndQuizText(){
       ArrayList<String> championText = new ArrayList<>();
       championText.add("איש העולם הגדול");
       championText.add("אתה יכול להחליף את הצ'ייסר");
       championText.add("לנצח זה לא דבר חשוב זה הדבר היחידי שחשוב");
       championText.add("המלך שומר על תואר");
       championText.add("ברכות ניצחת את הבינה מלאכותית");


        Random random = new Random();
        int randomText = random.nextInt(championText.size());
        return championText.get(randomText);
    }


}