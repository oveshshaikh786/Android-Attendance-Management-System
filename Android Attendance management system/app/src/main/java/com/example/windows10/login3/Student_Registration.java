package com.example.windows10.login3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Student_Registration extends AppCompatActivity {
    EditText name,email,classs,enrollment_no,mobile_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__registration);
        name=(EditText)findViewById(R.id.et_name);
        email=(EditText)findViewById(R.id.et_email);
        classs=(EditText)findViewById(R.id.et_classs);
        enrollment_no=(EditText)findViewById(R.id.et_en);
        mobile_no=(EditText)findViewById(R.id.et_mobile);

    }

    public void OnReg(View view)
    {
        String str_name = name.getText().toString();
        String  str_email= email.getText().toString();
        String str_classs = classs.getText().toString();
        String str_enrollment_no = enrollment_no.getText().toString();
        String str_mobile_no = mobile_no.getText().toString();
        String type = "Student_register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,str_name,str_email,str_classs,str_enrollment_no,str_mobile_no);
//        name.setText("");
//        email.setText("");
    }
}
