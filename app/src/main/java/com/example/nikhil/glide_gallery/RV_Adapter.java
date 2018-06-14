package com.example.nikhil.glide_gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    }

    @Override
    public int getItemCount() {
        return mphotos.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv;

        public myViewHolder(View itemView) {
            super(itemView);


             tv = itemView.findViewById(R.id.ctv_id);
        }
    }
}
