package com.example.windows10.login3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Faculty_Registration extends AppCompatActivity {
    EditText name,mobile_no,email,user_name,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty__registration);

        name=(EditText)findViewById(R.id.et_name);
        mobile_no=(EditText)findViewById(R.id.et_mobile);
        email=(EditText)findViewById(R.id.et_email);
        user_name=(EditText)findViewById(R.id.et_user_name);
        password=(EditText)findViewById(R.id.et_password);
    }

    public void OnReg(View view)
    {
        String str_name = name.getText().toString();
        String  str_mobile_no= mobile_no.getText().toString();
        String str_email = email.getText().toString();
        String str_user_name = user_name.getText().toString();
        String str_password = password.getText().toString();
        String type = "Faculty_register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,str_name,str_mobile_no,str_email,str_user_name,str_password);
    }
}
