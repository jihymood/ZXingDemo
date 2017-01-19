package com.ldm.zxingdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button scan_btn;
    private Button made_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.scan_btn = (Button) findViewById(R.id.scan_btn);
        this.made_btn = (Button) findViewById(R.id.made_btn);
        this.scan_btn.setOnClickListener(this);
        this.made_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.scan_btn) {
            startActivity(new Intent(this, ScanCodeActivity.class));
        } else if (v.getId() == R.id.made_btn) {
            startActivity(new Intent(this, MadeCodeActivity.class));
        }
    }
}
