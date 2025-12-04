package com.tracetrail.mobile.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tracetrail.mobile.R;
import com.tracetrail.mobile.api.ApiClient;
import com.tracetrail.mobile.api.AnalyzeService;
import com.tracetrail.mobile.models.AnalyzeRequest;
import com.tracetrail.mobile.models.AnalyzeResult;
import com.tracetrail.mobile.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnalyzeActivity extends AppCompatActivity {

    private EditText inputField;
    private Button submitButton;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze);

        inputField = findViewById(R.id.input_field);
        submitButton = findViewById(R.id.submit_button);
        session = new SessionManager(this);

        submitButton.setOnClickListener(v -> submitAnalysis());
    }

    private void submitAnalysis() {
        String text = inputField.getText().toString().trim();
        if(text.isEmpty()) {
            Toast.makeText(this, "Enter text or URL to analyze", Toast.LENGTH_SHORT).show();
            return;
        }

        AnalyzeService analyzeService = ApiClient.getClient().create(AnalyzeService.class);
        AnalyzeRequest request = new AnalyzeRequest(text);

        String token = "Bearer " + session.getToken();

        analyzeService.analyze(token, request).enqueue(new Callback<AnalyzeResult>() {
            @Override
            public void onResponse(Call<AnalyzeResult> call, Response<AnalyzeResult> response) {
                if(response.isSuccessful() && response.body() != null) {
                    AnalyzeResult result = response.body();
                    // Pass result to ResultActivity
                    ResultActivity.currentResult = result;
                    startActivity(new android.content.Intent(AnalyzeActivity.this, ResultActivity.class));
                } else {
                    Toast.makeText(AnalyzeActivity.this, "Analysis failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AnalyzeResult> call, Throwable t) {
                Toast.makeText(AnalyzeActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
