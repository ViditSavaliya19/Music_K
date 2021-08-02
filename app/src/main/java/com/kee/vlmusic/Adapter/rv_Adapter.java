package com.kee.vlmusic.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kee.vlmusic.R;

public class rv_Adapter extends RecyclerView.Adapter<rv_Adapter.Dataholder> {

    Activity activity;
    String[] imagelink;

    public rv_Adapter(FragmentActivity activity, String[] imglink) {
        this.activity = activity;
        this.imagelink = imglink;
    }

    @NonNull
    @Override
    public Dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_image, parent, false);
        return new Dataholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Dataholder holder, int position) {
        Glide.with(activity).load(imagelink[position]).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return imagelink.length;
    }

    class Dataholder extends RecyclerView.ViewHolder {
        private final ImageView image;

        public Dataholder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
        }
    }

}
