package com.example.employeemanagementsystem;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class LeavesApplyFragment extends Fragment {

    EditText start, end, day, type, reason;
    Button submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leaves_apply, container, false);

        start = view.findViewById(R.id.editText_start);
        end = view.findViewById(R.id.editText_end);
        day = view.findViewById(R.id.editText_day);
        type = view.findViewById(R.id.editText_type);
        reason = view.findViewById(R.id.editText_reason);
        submit = view.findViewById(R.id.btn_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processinsert();
            }
        });

        return view;
    }

    private void processinsert() {
        Users userEntity = Users.getInstance();
        userEntity.getUserID();
        Map<String,Object> map = new HashMap<>();
        map.put("username", userEntity.getUserID());
        map.put("status", "pending");
        map.put("startDate", start.getText().toString());
        map.put("type", type.getText().toString());
        map.put("endDate", end.getText().toString());
        map.put("noOfDay", day.getText().toString());
        map.put("reason", reason.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("leaves").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getActivity().getApplicationContext(),"Submit Successfully",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity().getApplicationContext(),"Submit Fail",Toast.LENGTH_LONG).show();
                    }
                });
    }
}