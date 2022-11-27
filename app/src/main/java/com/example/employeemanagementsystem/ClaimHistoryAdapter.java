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

public class ClaimHistoryAdapter extends FirebaseRecyclerAdapter<Claims, ClaimHistoryAdapter.claimViewHolder> {


    public ClaimHistoryAdapter(FirebaseRecyclerOptions<Claims> options) {
        super(options);
    }

    private DatabaseReference mDatabase;

    Users userEntity = Users.getInstance();
    String identifier = userEntity.getUserID();

    @Override
    protected void onBindViewHolder(@NonNull claimViewHolder holder, int position, @NonNull Claims model) {
        holder.userid.setText(model.getUserid());
        holder.content.setText(model.getContent());
        holder.title.setText(model.getTitle());
        holder.amount.setText(model.getAmount());
        holder.status.setText(model.getStatus());

        mDatabase = FirebaseDatabase.getInstance().getReference();

        FirebaseRecyclerOptions<Claims> options2 = new FirebaseRecyclerOptions.Builder<Claims>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Claim").orderByChild("userid")
                        .equalTo(identifier), Claims.class)
                .build();
    }

    @NonNull
    @Override
    public claimViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_claim_history, parent, false);
        return new claimViewHolder(view);
    }

    class claimViewHolder extends RecyclerView.ViewHolder {
        TextView userid, content, title, amount,status;

        public claimViewHolder(@NonNull View itemView) {
            super(itemView);
            userid = itemView.findViewById(R.id.tv_claim_username);
            content = itemView.findViewById(R.id.tv_description);
            title = itemView.findViewById(R.id.tv_reason);
            amount = itemView.findViewById(R.id.tv_amount);
            status = itemView.findViewById(R.id.tv_status);
        }


    }
}
