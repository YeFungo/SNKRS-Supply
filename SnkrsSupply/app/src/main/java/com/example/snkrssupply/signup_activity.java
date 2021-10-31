package com.example.snkrssupply;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signup_activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_activity);
    }
    public void s_save(View v){
        Intent signup = new Intent(getApplicationContext(),login_activity.class);
        EditText sign_id = (EditText)findViewById(R.id.s_id);
        EditText sign_pw = (EditText)findViewById(R.id.s_pw);
        signup.putExtra("ID",sign_id.getText().toString());
        signup.putExtra("PW",sign_pw.getText().toString());
        Toast.makeText(getApplicationContext(),"회원가입이 완료되었습니다.",Toast.LENGTH_LONG).show();
        startActivity(signup);
        finish();
    }
}
