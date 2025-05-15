package com.example.windows10.login3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

    }

    public void btn_reg_faculty(View view)
    {
      startActivity(new Intent(this,Faculty_Registration.class));

    }

    public void btn_reg_student(View view)
    {
        startActivity(new Intent(this,Student_Registration.class));
    }
}
