package com.example.windows10.login3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Info;
    private int counter=10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//     getSupportActionBar().hide();   //--------------------ActionBar atleke titleBar na show karavu hoy to?
         Name=(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Login=(Button)findViewById(R.id.btnLogin);
        Info=(TextView)findViewById(R.id.tvInfo);
        Button student=(Button)findViewById(R.id.btnStudent);


        //start student Button codding
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj=new Intent(MainActivity.this,StudentActivity.class);
                startActivity(obj);
            }
        });  //end student button codding

        Info.setText("No Of Attempts Remaining :Limited");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }

    void validate(String UserName,String UserPassword)

    {
        if((UserName.equals("admin")) && (UserPassword.equals("123")))
        {
            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
            Intent Intent =new Intent(MainActivity.this,AdminActivity.class);
            startActivity(Intent);

//            Name.setText("");
//            Password.setText("");
        }
        else
        {
            counter--;
            Info.setText("No of attempts remaining"+String.valueOf(counter));

            if(counter==0)
            {
                Login.setEnabled(false);
                Info.setText("Attempts remaining Over Restart Your App");
            }
        }

        if((UserName.equals("faculty")) && (UserPassword.equals("1234")))
        {
            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
            Intent Intent =new Intent(MainActivity.this,FacultyActivity.class);
            startActivity(Intent);

        }
        else
        {
            counter--;
            Info.setText("No of attempts remaining"+String.valueOf(counter));
            if(counter==0)
            {
                Login.setEnabled(false);
                Info.setText("Attempts remaining Over Restart Your App");
            }
        }
      //  Name.setText("");         // not Remanig user name
        Password.setText("");  // not Remanig password
    }

}
