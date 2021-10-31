package com.example.snkrssupply;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean a = false; //불리안값 a (로그인 할때 불리안값 지정한 후 실행할때 확인하기위해)
    Intent i1;
    Intent i2;
    Intent i3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Onclick(View v){
        switch(v.getId()){
            case R.id.play:
                if(a == true) {
                    i1 = new Intent(this, start_activity.class);
                    startActivity(i1);
                    break;
                }
                else {
                    Toast.makeText(getApplicationContext(),"로그인 하신 후 이용해주세요.",Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.login:
                //if(저장되어있는아이디와 비밀번호 비교 연산 후 열고 a =true값)
                i2 = new Intent(this, login_activity.class);
                startActivity(i2);
                break;
            //else아닐시는 false값
            case R.id.signup:
                i3 = new Intent(this, signup_activity.class);
                startActivity(i3);
                break;
        }

    }

}