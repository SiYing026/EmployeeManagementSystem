package com.example.employeemanagementsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LeavesAdapter extends FirebaseRecyclerAdapter<Leaves, LeavesAdapter.leavesViewHolder> {


    public LeavesAdapter(FirebaseRecyclerOptions<Leaves> options) {
        super(options);
    }

    private DatabaseReference mDatabase;

    Users userEntity = Users.getInstance();
    String identifier = userEntity.getUserID();

    @Override

    protected void onBindViewHolder(@NonNull leavesViewHolder holder, int position, @NonNull Leaves model) {
        holder.username.setText(model.getUsername());
        holder.startDate.setText(model.getStartDate());
        holder.endDate.setText(model.getEndDate());
        holder.noOfDay.setText(model.getNoOfDay());
        holder.type.setText(model.getType());
        holder.reason.setText(model.getReason());
        holder.status.setText(model.getStatus());

        mDatabase = FirebaseDatabase.getInstance().getReference();

        FirebaseRecyclerOptions<Leaves> options2 = new FirebaseRecyclerOptions.Builder<Leaves>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("leaves")
                        .orderByChild("username").equalTo(identifier), Leaves.class)
                .build();

    }

    @NonNull
    @Override
    public leavesViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaves_single_row, parent, false);
        return new leavesViewHolder(view);
    }

    class leavesViewHolder extends RecyclerView.ViewHolder {
        TextView username, startDate, endDate, noOfDay, type, reason, status;

        public leavesViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.tv_leaves_username);
            startDate = itemView.findViewById(R.id.tv_leaves_startDate);
            endDate = itemView.findViewById(R.id.tv_leaves_endDate);
            noOfDay = itemView.findViewById(R.id.tv_leaves_noOfDay);
            type = itemView.findViewById(R.id.tv_leaves_type);
            reason = itemView.findViewById(R.id.tv_leaves_reason);
            status = itemView.findViewById(R.id.tv_status);
        }


    }
}
