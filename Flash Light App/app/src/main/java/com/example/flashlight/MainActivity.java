package com.example.flashlight;

import android.content.Context;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;


public class MainActivity extends AppCompatActivity {

    private CameraManager cameraManager;
    private String cameraId;
    private boolean isFlashOn = false;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_title_layout);


        toggleButton = findViewById(R.id.toggle_button);
        cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

        try {
            cameraId = cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        // Check if the device has a camera flash
        boolean hasFlash = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if (!hasFlash) {
            // Disable the circular button if there is no flashlight
            toggleButton.setEnabled(false);
        }

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isFlash) {
                try {
                    if (isFlashOn) {
                        // Turn off flashlight
                        cameraManager.setTorchMode(cameraId, false);
                        toggleButton.setBackground(getResources().getDrawable(R.drawable.circular_button_off)); // Set background to off color
                        isFlashOn = false;
                    } else {
                        // Turn on flashlight
                        cameraManager.setTorchMode(cameraId, true);
                        toggleButton.setBackground(getResources().getDrawable(R.drawable.circular_button_on));// Set background to on color
                        isFlashOn = true;
                    }
                } catch (CameraAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Turn off flashlight when the app is closed
        if (isFlashOn) {
            try {
                cameraManager.setTorchMode(cameraId, false);
                toggleButton.setBackgroundResource(R.drawable.circular_button_off); // Set background to off color
                isFlashOn = false;
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
