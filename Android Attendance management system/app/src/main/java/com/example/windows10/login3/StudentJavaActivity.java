package com.example.windows10.login3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class StudentJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_java);
        final TextView etstudent1=(TextView)findViewById(R.id.etstudent1);
        final TextView etstudent2=(TextView)findViewById(R.id.etstudent2);
        Button btn_conform=(Button)findViewById(R.id.btn_conform);
        btn_conform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_etstudent1 = etstudent1.getText().toString();
                String str_etstudent2=etstudent2.getText().toString();
                String type = "Student_java";
                BackgroundWorkerStudent backgroundWorkerStudent = new BackgroundWorkerStudent(StudentJavaActivity.this);
                backgroundWorkerStudent.execute(type,str_etstudent1,str_etstudent2);

            }
        });
    }


//    public void Conform(View view) {
//        String str_etstudent1 = etstudent1.getText().toString();
//        String str_etstudent2=etstudent2.getText().toString();
//        String type = "Student_java";
//        BackgroundWorkerStudent backgroundWorker = new BackgroundWorkerStudent(this);
//        backgroundWorker.execute(type,str_etstudent1,str_etstudent2);
//    }

    public void student(View view) {
        RadioGroup rgstudent1 = (RadioGroup) findViewById(R.id.rgstudent1);
        int sel = rgstudent1.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton) findViewById(sel);

        TextView etstudent1=(TextView) findViewById(R.id.etstudent1);
        etstudent1.setText(rb.getText().toString());
    }

    public void attendance(View view) {
        RadioGroup rgstudent2 = (RadioGroup) findViewById(R.id.rgstudent2);
        int sel = rgstudent2.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton) findViewById(sel);

        TextView etstudent2=(TextView) findViewById(R.id.etstudent2);
        etstudent2.setText(rb.getText().toString());
    }

//    public void clicknow(View view) {
//        String str_etstudent1 = etstudent1.getText().toString();
//        String str_etstudent2=etstudent2.getText().toString();
//        String type = "Student_java";
//        BackgroundWorkerStudent backgroundWorker = new BackgroundWorkerStudent(this);
//        backgroundWorker.execute(type,str_etstudent1,str_etstudent2);
//
//    }
}
