package com.kee.vlmusic.Utils;

import static com.kee.vlmusic.Home.jcPlayerView;
import static com.kee.vlmusic.Utils.Constant.music_url;

import android.app.Activity;
import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;

import com.example.jean.jcplayer.model.JcAudio;
import com.kee.vlmusic.Model.Example;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Api {
    public static List<Example> exampleList = new ArrayList<Example>();
    Example searchList = new Example();
    Activity activity;
    public static List<JcAudio> jcAudios = new ArrayList<>();



    private ArrayList<Example> movies = new ArrayList<>();
    private MutableLiveData<List<Example>> mutableLiveData = new MutableLiveData<>();
    private Application application;
    public static List<Example> musicList=new ArrayList<Example>();

    public Api(FragmentActivity application) {
        this.activity = application;
    }

    public Api(Application application) {
        this.application=application;
    }

    public MutableLiveData<List<Example>>  Retro() {
        Apiinetface apiinetface = ApiClient.getApiclient().create(Apiinetface.class);

        Call<List<Example>> call = apiinetface.getUser();

        call.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                if (response.isSuccessful()) {
                    Log.e("Tag", "============= " + response.body());

                    exampleList = response.body();
                    mutableLiveData.setValue(exampleList);
//                    getData();

                }
            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {
                Toast.makeText(activity, "Fail  " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("TAG", "====" + t.getMessage());
            }
        });
        return mutableLiveData;

    }

    public List<Example> Walpaper() {
        Apiinetface apiinetface = ApiClient.getApiclient().create(Apiinetface.class);

        Call<List<Example>> call = apiinetface.getUser();

        call.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                if (response.isSuccessful()) {
                    Log.e("Tag", "============= " + response.body());

                    exampleList = response.body();
//                    getData();

                }
            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {
                Toast.makeText(activity, "Fail  " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("TAG", "====" + t.getMessage());
            }
        });
        return exampleList;

    }

    public List<Example> Music() {
        Apiinetface apiinetface = ApiClient.getApiclient().create(Apiinetface.class);
        Call<List<Example>> call = apiinetface.getMusic();
        call.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                if (response.isSuccessful()) {
                    Log.e("Tag", "============= " + response.body());

                    musicList = response.body();
                    getData();
                }
            }
            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {
                Toast.makeText(activity, "Fail  " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("TAG", "====" + t.getMessage());
            }
        });
        return exampleList;
    }




    public void getData() {
        for (int i = 0; i < musicList.size(); i++) {
            Log.e("TAG", "" + musicList.get(i).getId());
            Log.e("TAG", "" + musicList.get(i).getsName());
            Log.e("TAG", "" + musicList.get(i).getaName());
            Log.e("TAG", "" + musicList.get(i).getMusicName());
            jcAudios.add(JcAudio.createFromURL(musicList.get(i).getsName(), music_url+musicList.get(i).getMusicName()));
        }
        jcPlayerView.initPlaylist(jcAudios, null);
    }
//    public void Retro_search() {
//        Apiinetface apiinetface = ApiClient.getApiclient().create(Apiinetface.class);
//
//        Call<Example> call = apiinetface.getSerachUser("4");
//
//        call.enqueue(new Callback<Example>() {
//            @Override
//            public void onResponse(Call<Example> call, Response<Example> response) {
//                if (response.isSuccessful()) {
//                    Toast.makeText(activity, "ssucess", Toast.LENGTH_SHORT).show();
//                    Log.e("Tag", "============= " + response.body());
//
//                    searchList = response.body();
//                    getDataSearch();
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Example> call, Throwable t) {
//                Toast.makeText(activity, "Fail  " + t.getMessage(), Toast.LENGTH_SHORT).show();
//                Log.e("TAG", "====" + t.getMessage());
//            }
//        });
//
//    }
//
//    public void getDataSearch() {
//
//        Toast.makeText(activity, "" + searchList.getsName(), Toast.LENGTH_SHORT).show();
//        Log.e("sTAG", "" + searchList.getId());
//        Log.e("sTAG", "" + searchList.getsName());
//        Log.e("sTAG", "" + searchList.getaName());
//        Log.e("sTAG", "" + searchList.getsName());
//
//
//    }
}
