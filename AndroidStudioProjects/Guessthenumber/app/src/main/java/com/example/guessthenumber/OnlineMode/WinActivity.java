package com.example.guessthenumber.OnlineMode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guessthenumber.MainActivity;
import com.example.guessthenumber.R;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;

public class WinActivity extends AppCompatActivity {

    TextView titleTv , scoreTv ,battleTv,  wrongTv;
    MaterialButton retireButton;
    ImageView imgIv;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);


        Boolean isHost = getIntent().getBooleanExtra("isHost",false);
        String roomId = getIntent().getStringExtra("roomId");
        int score = getIntent().getIntExtra("s1",-420);
        String wrongList = getIntent().getStringExtra("wrongList");
        setup(score , wrongList );

        firebaseDatabase = FirebaseDatabase.getInstance();

        if(isHost){
            firebaseDatabase.getReference("matches").
                    child(roomId).removeValue();
        }

        retireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WinActivity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    private void setup(int score , String wrongList ){

        titleTv = findViewById(R.id.onlineWinHeadlineEndQuizTV);
        imgIv = findViewById(R.id.onlineWinEndQuizIV);
        retireButton = findViewById(R.id.onlineImpressedBtn);
        scoreTv = findViewById(R.id.onlineWinRightAnsEndQuizTv);
        battleTv = findViewById(R.id.onlineWinOrLoseEndQuizTv);
        wrongTv = findViewById(R.id.onlineWinWrongsAnsEndQuizTv);
        titleTv.setText(championEndQuizText());
        battleTv.setText(EndQuizOnlineActivity.scores+"");
        scoreTv.setText(score + "");
        imgIv.setImageResource(ChampionEndQuizImg());
        wrongTv.setText(wrongList+"");

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
        championText.add("מרחף כמו פרפר עוקץ כמו דבורה");
        championText.add("רוק סטאר של טרוויה");

        Random random = new Random();
        int randomText = random.nextInt(championText.size());
        return championText.get(randomText);
    }

}