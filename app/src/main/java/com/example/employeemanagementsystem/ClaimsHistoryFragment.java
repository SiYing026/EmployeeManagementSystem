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

public class ClaimsHistoryFragment extends Fragment {

    RecyclerView claims_recview;
    ClaimHistoryAdapter adapter;

    Users userEntity = Users.getInstance();
    String identifier = userEntity.getUserID();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_claims_history, container, false);

        claims_recview = view.findViewById(R.id.claims_recview);
        claims_recview.setLayoutManager(new LinearLayoutManager(getActivity()));
        FirebaseRecyclerOptions<Claims> options2 = new FirebaseRecyclerOptions.Builder<Claims>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Claim").orderByChild("userid").equalTo(identifier), Claims.class)
                .build();

        adapter = new ClaimHistoryAdapter(options2);
        claims_recview.setAdapter(adapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        //To begin listening for data
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        //Removes the event listener and all data in the adapter
        adapter.stopListening();
    }
}