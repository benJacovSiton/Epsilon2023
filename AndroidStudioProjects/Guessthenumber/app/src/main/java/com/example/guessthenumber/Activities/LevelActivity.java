package com.example.guessthenumber.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guessthenumber.OnlineMode.LoadingActivity;
import com.example.guessthenumber.AI_Mode.QuizGameActivity;
import com.example.guessthenumber.R;
import com.example.guessthenumber.gameMode.TimerModel;

public class LevelActivity extends AppCompatActivity {
    TimerModel timerModel;
    int pos;
    Boolean isOnline;
    private ImageView EasyLevel;
    private ImageView MediumLevel;
    private ImageView HardLevel;
    private TextView slowLevelTv , midLevelTv , fastLevelTv;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        EasyLevel = findViewById(R.id.EasyLevelIv);
        slowLevelTv = findViewById(R.id.SlowLevelTv);
        MediumLevel = findViewById(R.id.MediumLevelIv);
        midLevelTv = findViewById(R.id.RegLevelTv);
        HardLevel = findViewById(R.id.HardLevelIv);
        fastLevelTv = findViewById(R.id.SpeedLevelTv);

        timerModel = new TimerModel();
        pos = getIntent().getIntExtra("key", -1); // משיג את הקטגוריה על ידי מיקום באירוע לחיצה
        isOnline = getIntent().getBooleanExtra("online",false); // משיג האם השחקן נכנס ממצב מחשב או אונליין

        // כל האירועי לחיצה פה לשני אלמנטים מכל סוג האייקון והכותרת המלווה אותה
        // האירוע לחיצה יעביר מידע עבור הרמה שבה השחקן מעוניין לשחק והאם מדובר בשחקן אונליין
        // מלווה בדיאלוג שמציג את המידע על הרמה בה משחקים אם מדובר נגד המחשב וישירות למשחק עצמו אונליין
        EasyLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerModel.setLevel(1);
                if (isOnline)
                    startQuiz(1);
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LevelActivity.this);
                    builder.setMessage(" חוקי המשחק 20 שניות לכל שאלה \n תיקו = נקודה ויצבע בצהוב \n ניחוש קרוב = 2 נקודות ויצבע בכחול \n דיוק = 3 נקודות ויצבע בירוק \n וכמובן טעות מוחלטת = 0 נקודות נצבע באדום");
                    builder.setPositiveButton("הבנתי", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startQuiz(1);
                        }
                    });
                    builder.setNegativeButton("ויתרתי", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
             }
            });

        slowLevelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerModel.setLevel(1);
                if (isOnline)
                    startQuiz(1);
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LevelActivity.this);
                    builder.setMessage(" חוקי המשחק 20 שניות לכל שאלה \n תיקו = נקודה ויצבע בצהוב \n ניחוש קרוב = 2 נקודות ויצבע בכחול \n דיוק = 3 נקודות ויצבע בירוק \n וכמובן טעות מוחלטת = 0 נקודות נצבע באדום");
                    builder.setPositiveButton("הבנתי", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startQuiz(1);
                        }
                    });
                    builder.setNegativeButton("ויתרתי", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });



        MediumLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerModel.setLevel(2);
                if (isOnline)
                    startQuiz(2);
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LevelActivity.this);
                    builder.setMessage(" חוקי המשחק 15 שניות לכל שאלה \n ניחוש קרוב = 2 נקודות ויצבע בכחול \n דיוק = 3 נקודות ויצבע בירוק \n וכמובן טעות מוחלטת = 0 נקודות ויצבע באדום");
                    builder.setPositiveButton("הבנתי", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startQuiz(2);
                        }
                    });
                    builder.setNegativeButton("ויתרתי", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

        midLevelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerModel.setLevel(2);
                if (isOnline)
                    startQuiz(2);
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LevelActivity.this);
                    builder.setMessage(" חוקי המשחק 20 שניות לכל שאלה \n תיקו = נקודה ויצבע בצהוב \n ניחוש קרוב = 2 נקודות ויצבע בכחול \n דיוק = 3 נקודות ויצבע בירוק \n וכמובן טעות מוחלטת = 0 נקודות נצבע באדום");
                    builder.setPositiveButton("הבנתי", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startQuiz(1);
                        }
                    });
                    builder.setNegativeButton("ויתרתי", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

        HardLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerModel.setLevel(3);
                if (isOnline)
                    startQuiz(3);
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LevelActivity.this);
                    builder.setMessage(" חוקי המשחק 10 שניות לכל שאלה דיוק = 3 נקודות ויצבע בירוק \n וכמובן טעות מוחלטת = 0 נקודות ויצבע באדום");
                    builder.setPositiveButton("הבנתי", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startQuiz(3);
                        }
                    });
                    builder.setNegativeButton("ויתרתי", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

        fastLevelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timerModel.setLevel(3);
                if (isOnline)
                    startQuiz(3);
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LevelActivity.this);
                    builder.setMessage(" חוקי המשחק 20 שניות לכל שאלה \n תיקו = נקודה ויצבע בצהוב \n ניחוש קרוב = 2 נקודות ויצבע בכחול \n דיוק = 3 נקודות ויצבע בירוק \n וכמובן טעות מוחלטת = 0 נקודות נצבע באדום");
                    builder.setPositiveButton("הבנתי", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startQuiz(1);
                        }
                    });
                    builder.setNegativeButton("ויתרתי", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });


    }

    // הפעולה מנתבת את השחקן ע"פ סוג המשחק ומעבירה לאקטיבי הנבחר מידע הכרחי כמו הקטגוריה והרמה
    private void startQuiz(int level){

        if(isOnline){
            Intent intent = new Intent(LevelActivity.this , LoadingActivity.class);
            intent.putExtra("key", pos);
            intent.putExtra("level", level);
            startActivity(intent);
        }

        else {

            Intent intentCategory = new Intent(LevelActivity.this ,QuizGameActivity.class);
            intentCategory.putExtra("key", pos);
            intentCategory.putExtra("level", level);
            startActivity(intentCategory);
        }

    }
    // באופן כללי, יישום זה מבטיח שכל CountDownTimer מתמשך נעצר כראוי ומשאבים משתחררים כאשר הפעילות מושמדת, מונע בעיות פוטנציאליות ושמירה על ההתנהגות הרצויה של האפליקציה.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
