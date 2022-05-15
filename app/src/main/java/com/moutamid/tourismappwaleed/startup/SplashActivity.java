package com.moutamid.tourismappwaleed.startup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.moutamid.tourismappwaleed.activities.RegistrationActivity;
import com.moutamid.tourismappwaleed.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        b.startbtn.setOnClickListener(view -> {
            startActivity(new Intent(SplashActivity.this, RegistrationActivity.class));
        });
    }
}