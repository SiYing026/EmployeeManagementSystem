package com.example.employeemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;


public class EditAnnouncement extends AppCompatActivity {

    RecyclerView recview;
    EditAnnouncementAdapter adapter;
    FloatingActionButton fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_announcement);

        recview = findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Announcements> options = new FirebaseRecyclerOptions.Builder<Announcements>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("announcements"), Announcements.class)
                .build();

        adapter = new EditAnnouncementAdapter(options);
        recview.setAdapter(adapter);

        fb = findViewById(R.id.floatingBtn_Add);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddAnnouncement.class));
            }
        });
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