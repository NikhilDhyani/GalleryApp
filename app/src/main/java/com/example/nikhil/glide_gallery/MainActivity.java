package com.example.nikhil.glide_gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();

        
    }

    private void initViews() {

        recyclerView = findViewById(R.id.rv_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        //recyclerView.setAdapter(getApplicationContext(),userr);
        loadJson();

    }

    private void loadJson() {


        //todo 5: Retrofit instance

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(Api.base_url)
                .addConverterFactory(GsonConverterFactory.create()).build();


        //todo 6: API

        Api api = retrofit.create(Api.class);

        //todo  7: Call method

        Call<List<Photo>> call = api.getPhotos();

        //todo 8: Calling our API

        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {

                //todo 9: This is our userr object

                List<Photo> userr  = response.body();

                recyclerView.setAdapter(new RV_Adapter(MainActivity.this,userr));




                // Log.d("Name",userr.get(0).getName());
                // Log.d("Url",userr.get(0).getUrl().getSmall());


            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Something went wrong", Toast.LENGTH_LONG).show();


            }
        });



    }
}
