package com.example.nikhil.glide_gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<Photo> myList;
    static int z;
    int k;

    List<Photo> last ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.rv_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //Creating RecyclerView Adapter

      //  RV_Adapter adapter = new RV_Adapter(this,List<p>)

    //    recyclerView.setAdapter();



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

                last = new ArrayList<>();

               recyclerView.setAdapter(new RV_Adapter(MainActivity.this,userr.g));



                myList  = response.body();

                 z= myList.size();

                  k = z;

             //   Log.d("nameKing",userr.get(0).getName());
               Log.d("Size in : ",Integer.toString(z));
               // List<Url> urlls = userr;
              //  recyclerView.setAdapter(new RV_Adapter(this,userr));

                // Please note the *Error*
                // recyclerView.setAdapter(this,userr);

/*
                int size = userr.size();

                for (int i=0;i<size;i++)
                {

                    Log.d("Name",userr.get(i).getName());
                    Log.d("Url",userr.get(i).getUrl().getSmall());

                }
*/

            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Something went wrong", Toast.LENGTH_LONG).show();


            }
        });



     //   Log.d("nameKing",userr.get(0).getName());
        Log.d("Size is : ",Integer.toString(k));

       // int y= myList.size();

     //   Log.d("Length of mylist Y",Integer.toString(y));
        //


        recyclerView.setAdapter(new RV_Adapter(this,myList));
        
    }
}
