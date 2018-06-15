package com.example.nikhil.glide_gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by NIKHIL on 15-06-2018.
 */

public class RV_Adapter extends RecyclerView.Adapter<RV_Adapter.myViewHolder> {

    Context mcontext;
    List<Photo> mphotos;

    public RV_Adapter(Context mcontext, List<Photo> mphotos) {
        this.mcontext = mcontext;
        this.mphotos = mphotos;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Here we the context
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        View view = inflater.inflate(R.layout.card_view,null,false);

        return new myViewHolder(view);


    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {


        Photo listPhotos = mphotos.get(position);
        holder.tv.setText(listPhotos.getName());
        holder.url.setText(listPhotos.getUrl().getSmall());
        //String urll = holder.url.getText(listPhotos.getUrl().getSmall());
        String urll = listPhotos.getUrl().getLarge();
        Glide.with(mcontext).load(urll)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.img);


    }

    @Override
    public int getItemCount() {
        return mphotos.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv,url;
        ImageView img;

        public myViewHolder(View itemView) {
            super(itemView);


             tv = itemView.findViewById(R.id.ctv_id);
             url = itemView.findViewById(R.id.c_tv_url);
             img = itemView.findViewById(R.id.c_img_id);
        }
    }
}
