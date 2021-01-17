package com.chance.simpleperceptron;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        //TextView tvThresholdValue = findViewById(R.id.tv_threshold_value);
        //tvThresholdValue.append(Double.toString(Perceptron.THRESHOLD_VALUE));

        EditText etThresholdValue = findViewById(R.id.et_threshold_value);
        etThresholdValue.setText(Double.toString(Perceptron.THRESHOLD_VALUE));

        EditText etCorrectRate = findViewById(R.id.et_correct_rate_value);
        etCorrectRate.setText("0.01");
    }
}
