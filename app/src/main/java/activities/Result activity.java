package com.tracetrail.mobile.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tracetrail.mobile.R;
import com.tracetrail.mobile.models.AnalyzeResult;

public class ResultActivity extends AppCompatActivity {

    public static AnalyzeResult currentResult; // temporary holder for demo
    private TextView reportText, scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        reportText = findViewById(R.id.report_text);
        scoreText = findViewById(R.id.score_text);

        if(currentResult != null) {
            reportText.setText(currentResult.getReport());
            scoreText.setText("Score: " + currentResult.getScore());
        }
    }
}
