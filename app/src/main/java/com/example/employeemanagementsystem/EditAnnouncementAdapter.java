package com.example.employeemanagementsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class EditAnnouncementAdapter extends FirebaseRecyclerAdapter<Announcements, EditAnnouncementAdapter.editAnnouncementViewHolder> {
    public EditAnnouncementAdapter(FirebaseRecyclerOptions<Announcements> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull editAnnouncementViewHolder holder, int position, @NonNull Announcements model) {
        holder.title.setText(model.getTitle());
        holder.content.setText(model.getContent());


        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.title.getContext())
                        .setContentHolder(new ViewHolder(R.layout.dialog_announcement))
                        .setExpanded(true,1100)
                        .create();

                View editAnnouncement=dialogPlus.getHolderView();
                final EditText title = editAnnouncement.findViewById(R.id.edit_title);
                final EditText content = editAnnouncement.findViewById(R.id.edit_content);
                Button submit = editAnnouncement.findViewById(R.id.edit_btn);

                title.setText(model.getTitle());
                content.setText(model.getContent());

                dialogPlus.show();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("title", title.getText().toString());
                        map.put("content", content.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("announcements")
                                .child(getRef(holder.getAdapterPosition()).getKey()).setValue(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e)
                                    {
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });

            }
        });

    }

    @NonNull
    @Override
    public editAnnouncementViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_announcement, parent, false);
        return new editAnnouncementViewHolder(view);
    }

    class editAnnouncementViewHolder extends RecyclerView.ViewHolder {
        ImageView edit;
        TextView title, content;

        public editAnnouncementViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_announcementTitle);
            content = itemView.findViewById(R.id.tv_announcementContent);
            edit = itemView.findViewById(R.id.iv_editIcon);
        }
    }
}
