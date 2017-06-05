package com.liger.grace.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Liger on 2017/5/10 16:47.
 */

public interface GitHubClient {

    @GET("users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(@Path("user") String user);

}
