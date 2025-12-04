package com.tracetrail.mobile.api;

import com.tracetrail.mobile.models.LoginRequest;
import com.tracetrail.mobile.models.SignupRequest;
import com.tracetrail.mobile.models.TokenResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {
    @POST("api/login")
    Call<TokenResponse> login(@Body LoginRequest loginRequest);

    @POST("api/signup")
    Call<TokenResponse> signup(@Body SignupRequest signupRequest);
}
