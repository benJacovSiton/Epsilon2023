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

public class TieActivity extends AppCompatActivity {
    TextView titleTv , scoreTv ,battleTv , wrongTv;
    MaterialButton retireButton;
    ImageView imgIv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tie);

        int score = getIntent().getIntExtra("s2",-420);
        String wrongList = getIntent().getStringExtra("wrongList2");
        setup(score , wrongList);


        retireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TieActivity.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void setup(int score , String wrongList){

        titleTv = findViewById(R.id.onlineTieHeadlineEndQuizTV);
        imgIv = findViewById(R.id.onlineTieEndQuizIV);
        retireButton = findViewById(R.id.onlineTieImpressedBtn);
        scoreTv = findViewById(R.id.onlineTieRightAnsEndQuizTv);
        battleTv = findViewById(R.id.onlineTieEndQuizTv);
        wrongTv = findViewById(R.id.onlineTieWrongsAnsEndQuizTv);
        titleTv.setText("  ניפגש בגומלין ? ");
        battleTv.setText(EndQuizOnlineActivity.scores+"");
        scoreTv.setText(score + "");
        wrongTv.setText(wrongList+"");

    }
}