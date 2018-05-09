package com.example.downn.test5;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化
        Button saveData = (Button)findViewById(R.id.save);
        Button getData = (Button)findViewById(R.id.get);
        final EditText name = (EditText)findViewById(R.id.name);
        final EditText id = (EditText)findViewById(R.id.id);
        final EditText age = (EditText)findViewById(R.id.age);
        final TextView info = (TextView)findViewById(R.id.text);

        //存储按钮
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name",name.getText().toString());
                editor.putString("id",id.getText().toString());
                editor.putString("age",age.getText().toString());
                editor.apply();
            }
        });

        //取数按钮
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
                String name = pref.getString("name","没有输入");
                String id = pref.getString("id","没有输入");
                String age = pref.getString("age","没有输入");
                if(name.isEmpty()) name = "没有输入";
                if(id.isEmpty()) id = "没有输入";
                if(age.isEmpty()) age = "没有输入";

                info.setText("姓名："+name+"\n"+"学号："+id+"\n"+"年龄："+age);
            }
        });


    }
}
