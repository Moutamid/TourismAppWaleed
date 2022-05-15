package com.moutamid.tourismappwaleed.activities;

import static com.moutamid.tourismappwaleed.utils.Stash.toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RatingBar;

import com.moutamid.tourismappwaleed.R;
import com.moutamid.tourismappwaleed.data.Brain;
import com.moutamid.tourismappwaleed.databinding.ActivityPlaceBinding;
import com.moutamid.tourismappwaleed.model.PlaceModel;
import com.moutamid.tourismappwaleed.utils.Constants;
import com.moutamid.tourismappwaleed.utils.Stash;

public class PlaceActivity extends AppCompatActivity {

    private ActivityPlaceBinding b;

    private PlaceModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        b = ActivityPlaceBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        // CHANGE STATUS BAR TO TRANSPARENT
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        String params = getIntent().getStringExtra(Constants.PARAMS);

        switch (params) {
            case Constants.TAJ_MAHAL:
                model = Brain.getTajMahalModel();
                break;
            case Constants.CHRIST_THE_REDEEMER:
                model = Brain.getChristTheRedeemerModel();
                break;
            case Constants.PYRAMIDS_OF_GIZA:
                model = Brain.getGizaModel();
                break;
            case Constants.STONE_HEDGE:
                model = Brain.getStoneModel();
                break;
            case Constants.PETRA:
                model = Brain.getPetraModel();
                break;
            case Constants.FORBIDDEN_CITY:
                model = Brain.getForbiddenCityModel();
                break;
            case Constants.HOLY_MAKKAH:
                model = Brain.getMakkahModel();
                break;
            case Constants.K2_PAKISTAN:
                model = Brain.getK2Model();
                break;

        }

        setValuesOnViews();

        b.backBtnPlace.setOnClickListener(view -> {
            finish();
        });

        b.saveBtnPlace.setOnClickListener(view -> {
            if (model.isSaved) {
                model.isSaved = false;
                b.saveBtnPlace.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                Stash.put(params, false);
            } else {
                model.isSaved = true;
                b.saveBtnPlace.setImageResource(R.drawable.ic_baseline_favorite_24);
                Stash.put(params, true);
            }
        });

        b.imageItem2.setOnClickListener(view -> {
            b.imageItem1.setImageResource(model.image2);
        });

        b.imageItem3.setOnClickListener(view -> {
            b.imageItem1.setImageResource(model.image3);
        });

        b.imageItem4.setOnClickListener(view -> {
            b.imageItem1.setImageResource(model.image4);
        });

        b.descriptionLayout.setOnClickListener(view -> {
            b.reviewsTextView.setTextColor(getResources().getColor(R.color.darkGrey));
            b.reviewsDot.setVisibility(View.GONE);

            b.descriptionTextView.setTextColor(getResources().getColor(R.color.default_pink));
            b.descriptionDot.setVisibility(View.VISIBLE);

            b.description.setVisibility(View.VISIBLE);
            b.descriptionTitle.setVisibility(View.VISIBLE);
            b.ratingLayout.setVisibility(View.GONE);

        });

        b.reviewsLayout.setOnClickListener(view -> {
            b.reviewsTextView.setTextColor(getResources().getColor(R.color.default_pink));
            b.reviewsDot.setVisibility(View.VISIBLE);

            b.descriptionTextView.setTextColor(getResources().getColor(R.color.darkGrey));
            b.descriptionDot.setVisibility(View.GONE);

            b.description.setVisibility(View.GONE);
            b.descriptionTitle.setVisibility(View.GONE);
            b.ratingLayout.setVisibility(View.VISIBLE);
        });

        b.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Stash.put(Constants.RATING_VALUE + model.name, v);
                toast("Success");
            }
        });

        b.openArViewBtn.setOnClickListener(view -> {
            startActivity(new Intent(PlaceActivity.this, ArActivity.class)
            .putExtra(Constants.PARAMS, params));
        });

    }

    private void setValuesOnViews() {

        b.imageItem1.setImageResource(model.image1);
        b.imageItem2.setImageResource(model.image2);
        b.imageItem3.setImageResource(model.image3);
        b.imageItem4.setImageResource(model.image4);

        b.titleTextViewPlace.setText(model.name);
        b.countryTextView.setText(model.country);

        b.descriptionTitle.setText(model.title);
        b.description.setText(model.desc);

        b.ratingBar.setRating(model.rating);

        if (model.isSaved) {
            b.saveBtnPlace.setImageResource(R.drawable.ic_baseline_favorite_24);
        } else {
            b.saveBtnPlace.setImageResource(R.drawable.ic_baseline_favorite_border_24);
        }

    }

}