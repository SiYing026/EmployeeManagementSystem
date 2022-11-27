package com.example.employeemanagementsystem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ApproveRejectLeave extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    RecyclerView leaves_recview;
    ApproveRejectLeaveAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve_reject_leave);

        leaves_recview = findViewById(R.id.leaves_recview);
        leaves_recview.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Leaves> options2 = new FirebaseRecyclerOptions.Builder<Leaves>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("leaves").orderByChild("status").equalTo("pending"), Leaves.class)
                .build();

        adapter = new ApproveRejectLeaveAdapter(options2);
        leaves_recview.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        //To begin listening for data
        adapter.startListening();
    }
}



