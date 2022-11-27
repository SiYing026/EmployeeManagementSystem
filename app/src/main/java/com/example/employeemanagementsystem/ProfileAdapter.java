package com.example.employeemanagementsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileAdapter extends FirebaseRecyclerAdapter<Profile, ProfileAdapter.profileViewHolder> {
    public ProfileAdapter(FirebaseRecyclerOptions<Profile> options) {
        super(options);
    }

    private DatabaseReference mDatabase;

    Users userEntity = Users.getInstance();
    String identifier = userEntity.getUserID();

    @Override
    protected void onBindViewHolder(@NonNull ProfileAdapter.profileViewHolder holder, int position, @NonNull Profile model) {
        holder.username.setText(model.getUsername());
        holder.department.setText(model.getDepartment());
        holder.userid.setText(model.getUserid());

        mDatabase = FirebaseDatabase.getInstance().getReference();

        FirebaseRecyclerOptions<Profile> options2 = new FirebaseRecyclerOptions.Builder<Profile>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("users")
                        .orderByChild("userid").equalTo(identifier), Profile.class)
                .build();
    }

    @NonNull
    @Override
    public profileViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_profile, parent, false);
        return new profileViewHolder(view);
    }

    class profileViewHolder extends RecyclerView.ViewHolder {
        TextView username, department, userid;

        public profileViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.tv_username);
            department = itemView.findViewById(R.id.tv_department);
            userid = itemView.findViewById(R.id.tv_userID);
        }
    }
}

