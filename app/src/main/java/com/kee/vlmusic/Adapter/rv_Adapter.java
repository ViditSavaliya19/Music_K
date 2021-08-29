package com.kee.vlmusic.Adapter;

import static com.kee.vlmusic.Utils.Constant.image_url;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kee.vlmusic.Model.Example;
import com.kee.vlmusic.R;
import com.kee.vlmusic.Utils.Api;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class rv_Adapter extends RecyclerView.Adapter<rv_Adapter.Dataholder> {

    Activity activity;
    List<Example> imagelink;
    private ImageView wall_image;
    private Button set_wallpaper;
    private Bitmap photoBmp;

    public rv_Adapter(FragmentActivity activity) {
        this.activity = activity;
        this.imagelink = Api.exampleList;
    }

    @NonNull
    @Override
    public Dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_image, parent, false);
        return new Dataholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Dataholder holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(activity).load(image_url+""+imagelink.get(position).getMusicName()).into(holder.image);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("TAG",""+imagelink.get(position).getMusicName());

                dialoge(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imagelink.size();
    }

    class Dataholder extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final CardView card;

        public Dataholder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            card=itemView.findViewById(R.id.card);

        }
    }


    void dialoge(int position)
    {
        Dialog dialog=new Dialog(activity,R.style.AppBaseTheme);
        dialog.setContentView(R.layout.full_dialoge_wallpaper);
        dialog.show();
        final WallpaperManager wallpaperManager = WallpaperManager.getInstance(activity);

        wall_image=dialog.findViewById(R.id.wall_image);
        new GetImageFromUrl(wall_image).execute(image_url+""+imagelink.get(position).getMusicName());
        set_wallpaper=dialog.findViewById(R.id.set_wallpaper);
        set_wallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    wallpaperManager.setBitmap(photoBmp);
                    dialog.dismiss();
                } catch (IOException e) {

                    e.printStackTrace();
                }

            }
        });

    }

    public class GetImageFromUrl extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public GetImageFromUrl(ImageView img){
            this.imageView = img;
        }

        @Override
        public Bitmap doInBackground(String... url) {
            String stringUrl = url[0];
            photoBmp = null;
            InputStream inputStream;
            try {
                inputStream = new java.net.URL(stringUrl).openStream();
                photoBmp = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return photoBmp;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap){
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
        }
    }

}
