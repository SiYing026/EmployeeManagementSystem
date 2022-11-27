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
import com.google.firebase.database.FirebaseDatabase;

public class ApproveRejectLeaveAdapter extends FirebaseRecyclerAdapter<Leaves, ApproveRejectLeaveAdapter.leavesViewHolder> {
    public ApproveRejectLeaveAdapter(FirebaseRecyclerOptions<Leaves> options2) {
        super(options2);
    }

    @Override
    protected void onBindViewHolder(@NonNull leavesViewHolder holder, int position, @NonNull Leaves model) {
        holder.username.setText(model.getUsername());
        holder.startDate.setText(model.getStartDate());
        holder.endDate.setText(model.getEndDate());
        holder.type.setText(model.getType());
        holder.reason.setText(model.getReason());
        holder.noOfDay.setText(model.getNoOfDay());

        holder.approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference().child("leaves")
                        .child(getRef(holder.getAdapterPosition()).getKey()).child("status").setValue("Approved")
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e)
                            {

                            }
                        });
            }
        });

        holder.reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference().child("leaves")
                        .child(getRef(holder.getAdapterPosition()).getKey()).child("status").setValue("Rejected")
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e)
                            {

                            }
                        });
            }
        });


    }


    @NonNull
    @Override
    public leavesViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_emp_leaves, parent, false);
        return new leavesViewHolder(view);


    }

    class leavesViewHolder extends RecyclerView.ViewHolder {
        ImageView approve, reject;
        TextView username, startDate, endDate, noOfDay, type, reason;

        public leavesViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.tv_leaves_username);
            startDate = itemView.findViewById(R.id.tv_leaves_startDate);
            endDate = itemView.findViewById(R.id.tv_leaves_endDate);
            noOfDay = itemView.findViewById(R.id.tv_leaves_noOfDay);
            type = itemView.findViewById(R.id.tv_leaves_type);
            reason = itemView.findViewById(R.id.tv_leaves_reason);
            approve = itemView.findViewById(R.id.approveicon);
            reject = itemView.findViewById(R.id.rejecticon);
        }

    }
}


