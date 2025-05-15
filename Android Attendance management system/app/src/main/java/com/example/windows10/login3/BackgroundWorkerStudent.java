package com.example.windows10.login3;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Windows 10 on 1/11/2018.
 */

public class BackgroundWorkerStudent extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    BackgroundWorkerStudent(Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String student_url = "http://192.168.0.102/collegeproject/studentdata/register.php";    //change your localdevice ip


        if(type.equals("Student_java")) {
            try {

                String str_tvstudent1  = params[1];       //comment line read seconf name [params]
                String str_tvstudent2 = params[2];

                URL url = new URL(student_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                //=======================================================================================================
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data =
                        URLEncoder.encode("tvstudent1","UTF-8")+"="+URLEncoder.encode(str_tvstudent1,"UTF-8")+"&" //   <!--  $_POST["je uft ma "starting ma lakhelu hoy 6 te variable""]  -->
                                //|"name"| notepade post name

                                // and socond |name| String [params] name .

                                + URLEncoder.encode("tvstudent2","UTF-8")+"="+URLEncoder.encode(str_tvstudent2,"UTF-8");
                //==================================================user_name  and   password====================
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            }



            catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }        //......try ....close
        }          /// if close.........

        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
