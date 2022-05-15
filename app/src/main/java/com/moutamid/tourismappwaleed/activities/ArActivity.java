package com.moutamid.tourismappwaleed.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;
import com.moutamid.tourismappwaleed.R;
import com.moutamid.tourismappwaleed.data.Brain;
import com.moutamid.tourismappwaleed.databinding.ActivityArBinding;
import com.moutamid.tourismappwaleed.utils.Constants;

import java.util.Objects;

public class ArActivity extends AppCompatActivity {

    private ActivityArBinding b;
    private ArFragment arCam; //object of ArFragment Class

    private int clickNo = 0; //helps to render the 3d model only once when we tap the screen

    public static boolean checkSystemSupport(Activity activity) {

        //checking whether the API version of the running Android >= 24 that means Android Nougat 7.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            String openGlVersion = ((ActivityManager) Objects.requireNonNull(activity.getSystemService(Context.ACTIVITY_SERVICE))).getDeviceConfigurationInfo().getGlEsVersion();

            //checking whether the OpenGL version >= 3.0
            if (Double.parseDouble(openGlVersion) >= 3.0) {
                return true;
            } else {
                Toast.makeText(activity, "App needs OpenGl Version 3.0 or later", Toast.LENGTH_SHORT).show();
                activity.finish();
                return false;
            }
        } else {
            Toast.makeText(activity, "App does not support required Build Version", Toast.LENGTH_SHORT).show();
            activity.finish();
            return false;
        }

    }

    int raw_file = R.raw.taj_mahal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityArBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        String params = getIntent().getStringExtra(Constants.PARAMS);

        switch (params) {
            case Constants.TAJ_MAHAL:
                raw_file = R.raw.taj_mahal;
                break;
            case Constants.CHRIST_THE_REDEEMER:
                raw_file = R.raw.christtheredeemer;
                break;
            case Constants.PYRAMIDS_OF_GIZA:
                raw_file = R.raw.giza;
                break;
            case Constants.STONE_HEDGE:
                raw_file = R.raw.stonehedge;
                break;
            case Constants.PETRA:
                raw_file = R.raw.petra;
                break;
            case Constants.FORBIDDEN_CITY:
                raw_file = R.raw.forbiddencity;
                break;
            case Constants.HOLY_MAKKAH:
                raw_file = R.raw.holymakkah;
                break;
            case Constants.K2_PAKISTAN:
                raw_file = R.raw.k2pakistan;
                break;

        }


        if (checkSystemSupport(this)) {
            //ArFragment is linked up with its respective id used in the activity_main.xml
            arCam = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arCameraArea);

            arCam.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
                clickNo++;
                //the 3d model comes to the scene only when clickNo is one that means once
                if (clickNo == 1) {
                    Anchor anchor = hitResult.createAnchor();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        ModelRenderable.builder()
//                                .setSource(this, R.raw.scene)
                                .setSource(this, raw_file)
                                .setIsFilamentGltf(true)
                                .build()
                                .thenAccept(modelRenderable -> addModel(anchor, modelRenderable))
                                .exceptionally(throwable -> {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                                    builder.setMessage("Something is not right" + throwable.getMessage()).show();
                                    return null;
                                });
                    }

                }

            });

        } else {

            return;

        }


    }

    private void addModel(Anchor anchor, ModelRenderable modelRenderable) {

        AnchorNode anchorNode = new AnchorNode(anchor);
        // Creating a AnchorNode with a specific anchor
        anchorNode.setParent(arCam.getArSceneView().getScene());
        //attaching the anchorNode with the ArFragment
        TransformableNode model = new TransformableNode(arCam.getTransformationSystem());
        model.setParent(anchorNode);
        //attaching the anchorNode with the TransformableNode
        model.setRenderable(modelRenderable);
        //attaching the 3d model with the TransformableNode that is already attached with the node
        model.select();

    }
}