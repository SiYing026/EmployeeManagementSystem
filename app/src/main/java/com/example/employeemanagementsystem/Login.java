package com.example.employeemanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    Button m_btnlogin;
    EditText m_etUsername;
    EditText m_etPassword;
    private DatabaseReference mDatabase;
    String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        m_etUsername = findViewById(R.id.et_username);
        m_etPassword = findViewById(R.id.et_password);
        m_btnlogin = findViewById(R.id.btn_login);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        m_btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(m_etUsername.getText().toString().equals("Admin"))){
                    if(!m_etUsername.getText().toString().equals("") || !(m_etPassword.getText().toString().equals(""))) {
                        if (m_etUsername.getText().toString().equals("sy0206") && m_etPassword.getText().toString().equals("sy12345")) {
                            Users userEntity = Users.getInstance();
                            userEntity.setUserID(m_etUsername.getText().toString());

                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        } else if (m_etUsername.getText().toString().equals("kz723") && m_etPassword.getText().toString().equals("kz12345")){
                            Users userEntity = Users.getInstance();
                            userEntity.setUserID(m_etUsername.getText().toString());

                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        }
                        else{
                            Toast.makeText(Login.this, "Credentials Incorrect!", Toast.LENGTH_SHORT).show();

                        }
                    }
                    else{
                        Toast.makeText(Login.this, "Credentials Empty!", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(m_etUsername.getText().toString().equals("Admin") && m_etPassword.getText().toString().equals("Admin")){
                    Intent i = new Intent(getApplicationContext(), Dashboard.class);
                    startActivity(i);
                }

            }
        });

    }
}