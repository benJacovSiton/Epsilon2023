package com.example.guessthenumber.category;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guessthenumber.R;

import java.util.ArrayList;
/*
מחלקת RecyclerView.Adapter היא מחלקה בסיס המסופקת על ידי מסגרת Android להטמעת מתאמים מותאמים אישית עבור RecyclerViews.
על ידי הרחבת מחלקה זו, מחלקת ה-categoryAdapter יורשת את השיטות והפונקציונליות הדרושים ליצירה וניהול של RecyclerView.

categoryAdapter.MyViewHolder מתייחס למחלקה ViewHolder הספציפית למחלקה של categoryAdapter. זוהי מחלקה פנימית המוגדרת בקטגוריית המתאם.
על ידי מתן מחלקת MyViewHolder כפרמטר הסוג, מחלקת ה-categoryAdapter מציינת שהיא תשתמש במחלקה זו של ViewHolder כדי להחזיק הפניות לתצוגות בכל פריט של RecyclerView.

לסיכום, השורה חותמת המחלקה מצהירה על מחלקת מתאם לקטגוריה , מה שמציין שהיא מרחיבה את מחלקת RecyclerView.Adapter
ומציינת את מחלקת ה-ViewHolder הספציפית MyViewHolder שתשמש בהתאמה זו
 */
public class categoryAdapter extends RecyclerView.Adapter<categoryAdapter.MyViewHolder> { // תת מחלקה של  RecyclerView.Adapter מספקת לה
    Context context;
    ArrayList<category> categoryModels; // רשימה של אלמנטים שיוצגו על המסך בתוך הריסקל  - אייקון ושם
    private final categoryRecyclerViewInterface categoryRecyclerViewInterface; // ממשק המגדיר שיטת התקשרות החוזרות לטיפול בהקלקות פריטים ב-RecyclerView.
    /*
     context מקבל את האקטיבי בה מומש הריסקל וויו
     categoryModels מקבל את רשימת המידע שיוצג בכל רכיב בתוך הריסקל
     categoryRecyclerViewInterface פרמטר זה הוא ממשק המגדיר שיטה להתקשרות חזרה לטיפול באירועי לחיצה על פריט בריסקל וויו. הממשק מאפשר תקשורת בין המתאם לרכיב  שמיישם את הממשק.
     */
    public categoryAdapter(Context context, ArrayList<category> categoryModels, categoryRecyclerViewInterface categoryRecyclerViewInterface) {
        this.context = context;
        this.categoryModels = categoryModels;
        this.categoryRecyclerViewInterface = categoryRecyclerViewInterface;
    }

    // יצירת רכיב חדש על ידי הפריסה המוגדרת ב (category_row.xml)
    @NonNull
    @Override
    public categoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.category_row,parent,false);
        return new categoryAdapter.MyViewHolder(view ,categoryRecyclerViewInterface);

    }

    // שיטה זו נקראת לאגד נתונים לתצוגות בתוך הרכיב . הוא מגדיר את הכותרת והסמל של הקטגוריה במיקום שצוין ברשימה.
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.title.setText(categoryModels.get(position).getTitle());
        holder.icon.setImageResource(categoryModels.get(position).getIcon());
    }

    // שיטה זו מחזירה את המספר הכולל של פריטים ב-RecyclerView, אשר נקבע על פי גודל רשימת המודלים של הקטגוריה.
    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    // מחלקת MyViewHolder מספקת דרך להחזיק הפניות לתצוגות של פריט ב-RecyclerView ביעילות. זה גם מאפשר לצרף מאזיני קליקים לפריטים, ולאפשר אינטראקציה עם פריטי RecyclerView
    public static class MyViewHolder extends RecyclerView.ViewHolder{ // שורה זו מכריזה על המחלקה ViewHolder כמחלקה פנימית סטטית בתוך מחלקת המתאם של הקטגוריה. זה מרחיב את RecyclerView.ViewHolder, שהוא מחלקה בסיסית שמסופקת על ידי מסגרת RecyclerView.
        TextView title;
        ImageView icon;
        public MyViewHolder(@NonNull View itemView , categoryRecyclerViewInterface recyclerViewInterface) { // הבנאי מקבל את  View itemView כשView מייצג את תצוגת האב הגבוהה ביותר המכילה את כל התצוגות האחרות בפריסה
            super(itemView); // מילת המפתח סופר משמשת לקריאת הבנאי של מחלקת העל

            title = itemView.findViewById(R.id.mainTv); //category_row מקשר בין המידע לרכיב עבור כל אלמנט שהוגדר לתצוגה ב
            icon = itemView.findViewById(R.id.mainIv); //category_row מקשר בין המידע לרכיב עבור כל אלמנט שהוגדר לתצוגה ב

            // זה מגדיר מאזין קליקים ב-itemView, המייצג את תצוגת השורש של הפריט. כאשר הפריט נלחץ, הקוד בתוך המאזין יבוצע.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // התנאי המקונן הזה בודק אם ממשק recyclerView אינו null, ומבטיח שסופק מופע ממשק חוקי.
                    if(recyclerViewInterface != null){

                        int pos = getAdapterPosition(); // שורה זו מאחזרת את המיקום של הפריט שנלחץ בתוך המתאם.

                        if(pos != RecyclerView.NO_POSITION){  // תנאי זה בודק אם המיקום תקף ואינו שווה ל-RecyclerView.NO_POSITION, המציין מיקום לא חוקי.
                            recyclerViewInterface.onItemClick(pos); // שורה זו מפעילה את שיטת onItemClick של ה-recyclerViewInterface, ומעבירה את מיקום הפריט שנלחץ כארגומנט.
                            // המטרה של זה היא להודיע לצרכן של המתאם על לחיצה על פריט ולאפשר להם לבצע פעולה כלשהי על סמך אירוע הקליק.
                        }

                    }
                }
            });

        }
    }
}

