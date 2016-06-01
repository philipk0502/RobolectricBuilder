package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        }

    public void click(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("bye world!");
    }

    public void clickIntent(View view)
    {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }




}
