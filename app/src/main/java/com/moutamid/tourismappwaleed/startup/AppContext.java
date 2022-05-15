package com.moutamid.tourismappwaleed.startup;

import android.app.Application;

import com.moutamid.tourismappwaleed.utils.Stash;

public class AppContext extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stash.init(this);
    }
}
