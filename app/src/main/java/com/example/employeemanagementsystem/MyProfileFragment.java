package com.example.employeemanagementsystem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MyProfileFragment extends Fragment {

    RecyclerView displayrecview;
    ProfileAdapter displayAdapter;
    Users userEntity = Users.getInstance();
    String identifier = userEntity.getUserID();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        displayrecview = view.findViewById(R.id.recview);

        displayrecview.setLayoutManager(new LinearLayoutManager(getActivity()));
        FirebaseRecyclerOptions<Profile> options2 = new FirebaseRecyclerOptions.Builder<Profile>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("users")
                        .orderByChild("userid").equalTo(identifier), Profile.class)
                .build();

        displayAdapter = new ProfileAdapter(options2);
        displayrecview.setAdapter(displayAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        //To begin listening for data
        displayAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        //Removes the event listener and all data in the adapter
        displayAdapter.stopListening();
    }
}