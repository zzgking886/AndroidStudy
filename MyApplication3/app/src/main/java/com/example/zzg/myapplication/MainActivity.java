package com.example.zzg.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }
    private void initview()
    {
        mButton = (Button)findViewById(R.id.loginbutton);
        mButton.setOnClickListener(this);
        Log.v("1111","ss11111ss");
    }

    @Override
    public void onClick(View v)
    {
        Log.v("ssss","ssss");
    }
}
