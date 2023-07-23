package com.example.guessthenumber.category;

/*
לסיכום, ממשק ה-categoryRecyclerViewInterface מגדיר חוזה לטיפול באירועי לחיצה על פריט ב-RecyclerView.
זה מחייב את המחלקה המיישמת לספק מימוש עבור שיטת onItemClick,
אשר תיקרא כאשר נלחץ על פריט ב-RecyclerView. זה מאפשר לבצע התאמה אישית ופעולות ספציפיות על סמך אירועי הלחיצה על הפריט.
 */

public interface categoryRecyclerViewInterface {
    void onItemClick(int position);
}
