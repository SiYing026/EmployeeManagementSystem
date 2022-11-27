package com.example.employeemanagementsystem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;


public class AnnouncementFragment extends Fragment {

    RecyclerView displayrecview;
    DisplayAnnouncementAdapter displayAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_announcement, container, false);

        displayrecview = view.findViewById(R.id.recview);

        displayrecview.setLayoutManager(new LinearLayoutManager(getActivity()));
        FirebaseRecyclerOptions<Announcements> options = new FirebaseRecyclerOptions.Builder<Announcements>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("announcements"), Announcements.class)
                .build();

        displayAdapter = new DisplayAnnouncementAdapter(options);
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