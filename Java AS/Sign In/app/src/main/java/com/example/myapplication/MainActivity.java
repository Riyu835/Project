package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "com.example.myapplication.NAME.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toMenu(View view){
        Intent intent = new Intent(this, DisplayMenuActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String name = editText.getText().toString();
        intent.putExtra(EXTRA_NAME, name);
        startActivity(intent);
        }
    }
