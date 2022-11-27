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

public class DisplayAnnouncementAdapter extends FirebaseRecyclerAdapter<Announcements, DisplayAnnouncementAdapter.displayAnnouncementViewHolder> {
    public DisplayAnnouncementAdapter(FirebaseRecyclerOptions<Announcements> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull DisplayAnnouncementAdapter.displayAnnouncementViewHolder holder, int position, @NonNull Announcements model) {
        holder.title.setText(model.getTitle());
        holder.content.setText(model.getContent());
    }

    @NonNull
    @Override
    public displayAnnouncementViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_show_announcement, parent, false);
        return new displayAnnouncementViewHolder(view);
    }

    class displayAnnouncementViewHolder extends RecyclerView.ViewHolder {
        TextView title, content;

        public displayAnnouncementViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_announcementTitle);
            content = itemView.findViewById(R.id.tv_announcementContent);
        }
    }
}
