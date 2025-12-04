package com.tracetrail.mobile.api;

import com.tracetrail.mobile.models.AnalyzeRequest;
import com.tracetrail.mobile.models.AnalyzeResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Header;

public interface AnalyzeService {
    @POST("api/analyze")
    Call<AnalyzeResult> analyze(
        @Header("Authorization") String token,
        @Body AnalyzeRequest request
    );
}
