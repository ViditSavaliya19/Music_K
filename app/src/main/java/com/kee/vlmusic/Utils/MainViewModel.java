package com.kee.vlmusic.Utils;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.kee.vlmusic.Model.Example;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private Api movieRepository;
    public MainViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new Api(application);
    }
    public LiveData<List<Example>> getAllBlog() {
        return movieRepository.Retro();
    }
}