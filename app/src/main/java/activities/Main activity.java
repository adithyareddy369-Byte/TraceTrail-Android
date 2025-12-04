package com.tracetrail.mobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.tracetrail.mobile.R;
import com.tracetrail.mobile.utils.SessionManager;

public class MainActivity extends AppCompatActivity {

    private Button analyzeButton, historyButton, logoutButton;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        analyzeButton = findViewById(R.id.analyze_button);
        historyButton = findViewById(R.id.history_button);
        logoutButton = findViewById(R.id.logout_button);

        session = new SessionManager(this);

        analyzeButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AnalyzeActivity.class));
        });

        historyButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ResultActivity.class));
        });

        logoutButton.setOnClickListener(v -> {
            session.clearToken();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        });
    }
}
