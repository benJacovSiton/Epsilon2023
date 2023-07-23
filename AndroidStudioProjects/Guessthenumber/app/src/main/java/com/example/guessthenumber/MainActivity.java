package com.example.guessthenumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.guessthenumber.Activities.LevelActivity;
import com.example.guessthenumber.Activities.LogInActivity;
import com.example.guessthenumber.category.category;
import com.example.guessthenumber.category.categoryAdapter;
import com.example.guessthenumber.category.categoryRecyclerViewInterface;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements categoryRecyclerViewInterface {

    categoryAdapter categoryAdapter;
    ArrayList<category> categoryModels;
    RecyclerView categoryRecyclerView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryRecyclerView = findViewById(R.id.main_Rv);

        toolbar = findViewById(R.id.mainToolBar);
        setSupportActionBar(toolbar);


        categoryModels = new ArrayList<>();
        setUpMain();

        // this context = מילת מפתח מתייחסת למופע הנוכחי של המחלקה אקטיבי שבו קוד זה מבוצע.
        //  categoryAdapter = זה מתייחס לרשימה של אובייקטי הקטגוריה שיוצגו ב-ריסקל וויו. זה מועבר כפרמטר למתאם כדי לאכלס את הנתונים.
        // this categoryRecyclerViewInterface = פרמטר לטיפול באירועי לחיצה על פריט בריסקל וויו
        categoryAdapter = new categoryAdapter(this, categoryModels, this);

        // מתאם אחראי לספק את הנתונים שיוצגו ב-RecyclerView וליצירת התצוגות המתאימות לכל פריט במערך הנתונים. על ידי הגדרת מתאם,
        // אתה מחבר את הריסקל וויו למתאם ומאפשר לו להציג את הנתונים בצורה מובנית
        categoryRecyclerView.setAdapter(categoryAdapter);

        // מנהל הפריסה קובע כיצד הפריטים ב-RecyclerView יהיו מסודרים וממוקמים.
        categoryRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        getSupportActionBar().setTitle(LogInActivity.savedUsername +" ברוך/ה השב/ה לאפסילון 2023" );


    }
    // הפעולה מחברת בין האייקונים לשמות הקטגוריה על ידי יצירת רשימה שמכילה אובייקט מסוג קטגוריה שמכיל את המידע שיוצג בריסקל וויו
    private void setUpMain() {
        String[] titles =  getResources().getStringArray(R.array.categoryOptions);
        int [] icons = {R.drawable.sport , R.drawable.music ,  R.drawable.culture , R.drawable.netflix ,
                         R.drawable.religion , R.drawable.socialmedia ,  R.drawable.corporations ,  R.drawable.techone , R.drawable.world , R.drawable.israel
                        , R.drawable.math , R.drawable.archeology ,  R.drawable.guinness ,  R.drawable.transport };

        for (int i = 0; i < titles.length ; i ++)
            categoryModels.add(new category(titles[i],icons[i]));


    }
    // יורשת את הממשק של ממשק - משמע חייבת לממש את אירוע הלחיצה
    // הפעולה מקבלת את המיקום של האלמנט משמע קטגוריה שנלחצה
    // מטרת הפעולה להעביר איזו קטגוריה נבחרה לשחק
    @Override
    public void onItemClick(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("אתה רוצה לשחק אונליין או נגד המחשב ? ");
        builder.setPositiveButton("אונליין", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this , LevelActivity.class);
                intent.putExtra("key", position); // מעביר את מיקום - נושא הטרוויה
                intent.putExtra("online", true); // מעביר שזה אונליין
                startActivity(intent);
            }
        });
        builder.setNegativeButton("מחשב", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this , LevelActivity.class);
                intent.putExtra("key", position); // כנ"ל
                intent.putExtra("online", false); // כנ"ל
                startActivity(intent);
            }
        });
        builder.show();

    }


}


