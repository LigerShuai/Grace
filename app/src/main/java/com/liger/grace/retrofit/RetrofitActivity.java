package com.liger.grace.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.liger.grace.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Liger on 2017/5/10 16:58.
 */

public class RetrofitActivity extends AppCompatActivity {

    @BindView(R.id.activity_retro_lv)
    ListView mListView;

    String API_BASE_URL = "https://api.github.com/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);

        /*Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        GitHubClient gitHubClient = retrofit.create(GitHubClient.class);*/
        GitHubClient gitHubClient = ServiceGenerator.createService(GitHubClient.class);
        Call<List<GitHubRepo>> call = gitHubClient.reposForUser("LigerShuai");

        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                List<GitHubRepo> repos = response.body();
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
