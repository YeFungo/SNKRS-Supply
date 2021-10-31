package com.example.snkrssupply;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Geocoder;
import android.media.Image;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;


public class start_activity extends AppCompatActivity {
    int cnt_m = 0;
    int cnt_s = 0;
    ImageView img1;
    ImageView img2;
    ImageView mars_d;
    ImageView salt_d;
    CharSequence[] page = {"Nike","adidas"};
    CharSequence[] place = {"나이키-홍대(조던)","아디다스-압구정"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity);

    }

    public void Onclick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                //구글 캘린더 오픈하기
                ComponentName cn;
                Intent i = new Intent();
                cn = new ComponentName("com.google.android.calendar", "com.android.calendar.LaunchActivity");
                i.setComponent(cn);
                startActivity(i);
                //캘린더 대화상자로 열기
                /*
                DatePickerDialog dialog1 = new DatePickerDialog(this, listener, 2018, 0, 17);
                dialog1.setTitle("test");
                dialog1.show();*/
                break;
            case R.id.b2:
                AlertDialog.Builder home = new AlertDialog.Builder(this);

                home.setTitle("홈페이지 선택");

                home.setSingleChoiceItems(page, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i){
                        if(i==0) {
                            Intent Intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nike.com/kr/ko_kr/launch"));
                            startActivity(Intent1);
                        }else if(i ==1){
                            Intent Intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://shop.adidas.co.kr/PF021001.action"));
                            startActivity(Intent2);
                        }
                    }
                });
                home.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                home.show();
                break;
            case R.id.b3:
                Intent size = new Intent(this, size_activity.class);
                startActivity(size);
                break;

            case R.id.b4:

                AlertDialog.Builder where = new AlertDialog.Builder(this);

                where.setTitle("매장위치 선택");

                where.setSingleChoiceItems(place, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i){
                        if(i==0) {
                            Uri uri = Uri.parse("google.navigation:q= 서울 마포구 양화로 161");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }else if(i ==1){
                            Uri uri = Uri.parse("google.navigation:q= 서울특별시 강남구 신사동 662-2");
                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                            startActivity(intent);
                        }
                    }
                });
                where.setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                where.show();
                break;
        }

    }
    public void mars (View v){
        cnt_m++;
        img1 =(ImageView) findViewById(R.id.img1);
        mars_d = (ImageView) findViewById(R.id.mars_d);
        img2 = (ImageView) findViewById(R.id.img2);
        salt_d = (ImageView) findViewById(R.id.salt_d);
            if(cnt_m==1) {
                mars_d.setVisibility(View.VISIBLE);
                salt_d.setVisibility(View.INVISIBLE);
                cnt_m = 0;
            }else if(cnt_m==2) {
                mars_d.setVisibility(View.INVISIBLE);
                cnt_m = 0;
            }

    }
    public  void salt (View v){
        cnt_s++;
        img1 =(ImageView) findViewById(R.id.img1);
        mars_d = (ImageView) findViewById(R.id.mars_d);
        img2 = (ImageView) findViewById(R.id.img2);
        salt_d = (ImageView) findViewById(R.id.salt_d);
        if(cnt_s==1) {
            salt_d.setVisibility(View.VISIBLE);
            mars_d.setVisibility(View.INVISIBLE);
            cnt_s = 0;
        }else if(cnt_s==2) {
            salt_d.setVisibility(View.INVISIBLE);
            cnt_s = 0;
        }
    }
}


