package com.moutamid.tourismappwaleed.utils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Constants {
    public static final String IS_LOGGED_IN = "isloggedin";
    public static final String NULL = "null";
    public static final String RATING_VALUE = "ratingvalue";

    public static final String TAJ_MAHAL = "tajmahal";
    public static final String CHRIST_THE_REDEEMER = "christtheredeemer";
    public static final String PYRAMIDS_OF_GIZA = "giza";
    public static final String STONE_HEDGE = "stonehedge";
    public static final String PETRA = "petra";
    public static final String FORBIDDEN_CITY = "forbiddencity";
    public static final String HOLY_MAKKAH = "makkah";
    public static final String K2_PAKISTAN = "k2pakistan";
    public static final String PARAMS = "params";

    public static FirebaseAuth auth() {
        return FirebaseAuth.getInstance();
    }

    public static DatabaseReference databaseReference() {
        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("TourismWaleedApp");
        db.keepSynced(true);
        return db;
    }
}
