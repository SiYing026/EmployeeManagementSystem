package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void Logout(View view) {
        startActivity(new Intent(this, Login.class));
        this.finishAffinity();
    }

    public void editAnnouncement(View view) {
        startActivity(new Intent(this, EditAnnouncement.class));
    }

    public void employeeLeave(View view) {
        startActivity(new Intent(this, ApproveRejectLeave.class));
    }

    public void employeeClaim(View view) {
        startActivity(new Intent(this, EmployeeClaim.class));
    }

    public void AREmployee(View view) {
        startActivity(new Intent(this, AddRemoveEmployee.class));
    }
}