package com.example.snkrssupply;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login_activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

    }

    public void login_Click (View v){
        Intent start = new Intent(getApplicationContext(),start_activity.class);

        Intent signup = getIntent();
        String id = signup.getStringExtra("ID");
        String pw = signup.getStringExtra("PW");

        EditText L_id = (EditText) findViewById(R.id.log_id);
        EditText L_pw = (EditText) findViewById(R.id.log_pw);

        String Log_ID=  L_id.getText().toString();
        String Log_PW=  L_pw.getText().toString();

        if(Log_ID.equals(id) && Log_PW.equals(pw)){
            Toast.makeText(this,"로그인이 되었습니다.",Toast.LENGTH_SHORT).show();
            startActivity(start);
            finish();
        }
        else {
            Toast.makeText(this, "아이디나 패스워드가 다릅니다.", Toast.LENGTH_SHORT).show();
            finish();
        }

    }

}