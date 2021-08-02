package com.kee.vlmusic.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kee.vlmusic.Adapter.rv_Adapter;
import com.kee.vlmusic.R;

public class CategoryFragment extends Fragment {


    private RecyclerView rv_View;
    String[] imglink={"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2022-chevrolet-corvette-z06-1607016574.jpg?crop=0.737xw:0.738xh;0.181xw,0.218xh&resize=640:*","https://ichef.bbci.co.uk/news/976/cpsprodpb/118A0/production/_118604817__116721094_mustang.jpg","https://cdn.motor1.com/images/mgl/8e8Mo/s1/most-expensive-new-cars-ever.webp","https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2019-honda-civic-sedan-1558453497.jpg?crop=1xw:0.9997727789138833xh;center,top&resize=480:*"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);

        intiView(view);

        return view;
    }

    private void intiView(View view) {
        rv_View = view.findViewById(R.id.rv_View);
        rv_Adapter adapter=new rv_Adapter(getActivity(),imglink);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getActivity(),2);
        rv_View.setLayoutManager(layoutManager);
        rv_View.setAdapter(adapter);

    }


}