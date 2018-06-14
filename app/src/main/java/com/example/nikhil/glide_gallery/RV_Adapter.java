package com.example.nikhil.glide_gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by NIKHIL on 14-06-2018.
 */


//todo : Please note I need to extract url of the image

//Note : After creating adapter class the first thing that you should do is to
//create ViewHolder class


public class RV_Adapter extends RecyclerView.Adapter<RV_Adapter.mViewHolder> {

    List<Photo> mphotos;
    Context mcontext;

    String murl;

    //Constructor

    public RV_Adapter(List<Photo> photos) {
        this.mphotos = photos;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Inflating and returning our view

        LayoutInflater inflater = LayoutInflater.from(mcontext);

        View view = inflater.inflate(R.layout.card_view,null,false);


        return new mViewHolder(view);
    }

    //Note: Bind view holder is the last step
    @Override
    public void onBindViewHolder(mViewHolder holder, int position) {


        Photo photoobject = mphotos.get(position);

        holder.tv.setText(photoobject.getUrl().getLarge());
      //  holder.img

    }

    @Override
    public int getItemCount() {
        return mphotos.size();
    }


    public class mViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView tv;

        public mViewHolder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_view);
            tv = itemView.findViewById(R.id.tvC);

        }
    }
}
