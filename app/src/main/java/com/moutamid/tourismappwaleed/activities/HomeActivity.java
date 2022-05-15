package com.moutamid.tourismappwaleed.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.moutamid.tourismappwaleed.databinding.ActivityHomeBinding;
import com.moutamid.tourismappwaleed.startup.SplashActivity;
import com.moutamid.tourismappwaleed.utils.Constants;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        b = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        if (Constants.auth().getCurrentUser() == null) {
            startActivity(new Intent(HomeActivity.this, SplashActivity.class));
            finish();
            return;
        }

        b.cardTajMahal.setOnClickListener(view -> {
            startActivity(new Intent(this, PlaceActivity.class)
                    .putExtra(Constants.PARAMS, Constants.TAJ_MAHAL));
        });

        b.cardChrist.setOnClickListener(view -> {
            startActivity(new Intent(this, PlaceActivity.class)
                    .putExtra(Constants.PARAMS, Constants.CHRIST_THE_REDEEMER));
        });

        b.cardGiza.setOnClickListener(view -> {
            startActivity(new Intent(this, PlaceActivity.class)
                    .putExtra(Constants.PARAMS, Constants.PYRAMIDS_OF_GIZA));
        });

        b.cardStone.setOnClickListener(view -> {
            startActivity(new Intent(this, PlaceActivity.class)
                    .putExtra(Constants.PARAMS, Constants.STONE_HEDGE));
        });

        b.cardPetra.setOnClickListener(view -> {
            startActivity(new Intent(this, PlaceActivity.class)
                    .putExtra(Constants.PARAMS, Constants.PETRA));
        });

        b.cardForbidden.setOnClickListener(view -> {
            startActivity(new Intent(this, PlaceActivity.class)
                    .putExtra(Constants.PARAMS, Constants.FORBIDDEN_CITY));
        });

        b.cardMakkah.setOnClickListener(view -> {
            startActivity(new Intent(this, PlaceActivity.class)
                    .putExtra(Constants.PARAMS, Constants.HOLY_MAKKAH));
        });

        b.cardMountain.setOnClickListener(view -> {
            startActivity(new Intent(this, PlaceActivity.class)
                    .putExtra(Constants.PARAMS, Constants.K2_PAKISTAN));
        });

        b.searchEtHome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().isEmpty()){



                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

}