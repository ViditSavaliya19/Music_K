package com.kee.vlmusic.Fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kee.vlmusic.Adapter.rv_Adapter;
import com.kee.vlmusic.Model.Example;
import com.kee.vlmusic.R;
import com.kee.vlmusic.Utils.Api;
import com.kee.vlmusic.Utils.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {


    private RecyclerView rv_View;
    List<String>list=new ArrayList<String>();
    private ProgressDialog progressDialog;
    private MainViewModel mainViewModel;

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
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.show();
        progressDialog.setMessage("Please Wait...");

        Api api=new Api(getActivity());
        api.Walpaper();

        rv();

    }


//    private void wallpaper() {
//        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//        DatabaseReference databaseReference = firebaseDatabase.getReference("Wallpaper");
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                    Log.e("Wallpaper",dataSnapshot.getValue().toString());
//                    list.add(dataSnapshot.getValue().toString());
//                    progressDialog.dismiss();
//                    rv();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }





    void rv()
    {
        rv_Adapter adapter = new rv_Adapter(getActivity());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        rv_View.setLayoutManager(layoutManager);
        rv_View.setAdapter(adapter);
    }

}