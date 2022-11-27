package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class EmployeeClaim extends AppCompatActivity {

    RecyclerView recview;
    EmployeeClaimAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_claim);

        recview = findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Claims> options = new FirebaseRecyclerOptions.Builder<Claims>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Claim").orderByChild("status").equalTo("pending"), Claims.class)
                .build();

        adapter = new EmployeeClaimAdapter(options);
        recview.setAdapter(adapter);


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