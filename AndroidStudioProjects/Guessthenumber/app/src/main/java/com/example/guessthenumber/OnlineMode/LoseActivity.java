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

public class LoseActivity extends AppCompatActivity {

    TextView titleTv , scoreTv , wrongTv , battleTv;
    MaterialButton retireButton;
    ImageView imgIv;

    FirebaseDatabase firebaseDatabase;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);


        Boolean isHost = getIntent().getBooleanExtra("isHost",false);
        String roomId = getIntent().getStringExtra("roomId");
        int score = getIntent().getIntExtra("s",-420);
        String wrongList = getIntent().getStringExtra("wrongList");
        setup(score , wrongList);

//        if(isHost){
//            firebaseDatabase.getReference("matches").
//                    child(roomId).removeValue();
//        }

        retireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoseActivity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void setup(int score , String wrongList){

        titleTv = findViewById(R.id.onlineLoseHeadlineEndQuizTV);
        imgIv = findViewById(R.id.onlineLoseEndQuizIV);
        retireButton = findViewById(R.id.onlineLoseImpressedBtn);
        scoreTv = findViewById(R.id.onlineLoseRightAnsEndQuizTv);
        battleTv = findViewById(R.id.onlineLoseOrWinEndQuizTv);
        wrongTv = findViewById(R.id.onlineLoseWrongsAnsEndQuizTv);
        titleTv.setText(loserEndQuizText());
        scoreTv.setText(score + "");
        battleTv.setText(EndQuizOnlineActivity.scores+" ");
        imgIv.setImageResource(loserEndQuizImg());
        wrongTv.setText(wrongList+"");
        random = new Random();

    }

    private int loserEndQuizImg() {
        Random random = new Random();
        int randomIcon = random.nextInt(12)+1;
        int resourceId = getResources().getIdentifier("loser" + randomIcon, "drawable", this.getPackageName());
        return resourceId;
    }


    private String loserEndQuizText(){
        ArrayList<String> loserText = new ArrayList<>();
        loserText.add("יכל להיות גרוע...תראה את התמונה למטה");
        loserText.add("זאת לא בושה להפסיד לסלבדור");
        loserText.add("לפעמים גם זה קורה");
        loserText.add("שחקן ספסל");
        loserText.add("תעשה עוד כמה סבבים נגד המחשב ותחזור");
        Random random = new Random();
        int randomText = random.nextInt(loserText.size());
        return loserText.get(randomText);
    }
}