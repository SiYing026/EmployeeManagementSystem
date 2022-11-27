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

public class EmployeeClaimAdapter extends FirebaseRecyclerAdapter<Claims, EmployeeClaimAdapter.claimViewHolder> {


    public EmployeeClaimAdapter(FirebaseRecyclerOptions<Claims> options) {
        super(options);
    }

    private DatabaseReference mDatabase;

    @Override

    protected void onBindViewHolder(@NonNull claimViewHolder holder, int position, @NonNull Claims model) {
        holder.userid.setText(model.getUserid());
        holder.content.setText(model.getContent());
        holder.title.setText(model.getTitle());
        holder.amount.setText(model.getAmount());

        mDatabase = FirebaseDatabase.getInstance().getReference();

        FirebaseRecyclerOptions<Claims> options2 = new FirebaseRecyclerOptions.Builder<Claims>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Claim")
                        .orderByChild("status").equalTo("pending"), Claims.class)
                .build();

        holder.approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if approve...

                FirebaseDatabase.getInstance().getReference().child("Claim")
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
            public void onClick(View v) {
                //if reject...
                FirebaseDatabase.getInstance().getReference().child("Claim")
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
    public claimViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_emp_claim, parent, false);
        return new claimViewHolder(view);
    }

    class claimViewHolder extends RecyclerView.ViewHolder {
        ImageView approve, reject;
        TextView userid, title, content, amount;

        public claimViewHolder(@NonNull View itemView) {
            super(itemView);
            userid = itemView.findViewById(R.id.tv_username);
            title = itemView.findViewById(R.id.tv_title);
            content = itemView.findViewById(R.id.tv_content);
            amount = itemView.findViewById(R.id.tv_amount);
            approve = itemView.findViewById(R.id.approveicon);
            reject = itemView.findViewById(R.id.rejecticon);
        }


    }



}

