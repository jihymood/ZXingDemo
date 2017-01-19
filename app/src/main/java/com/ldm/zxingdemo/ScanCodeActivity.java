package com.ldm.zxingdemo;

import android.app.Activity;
import android.content.Intent;
import android.hardware.camera2.CaptureRequest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.client.android.CaptureActivity;

/**
 * 扫描二维码示例
 */
public class ScanCodeActivity extends Activity implements View.OnClickListener {
    private Button start_scan;
    private TextView result_tv;
    private final static int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        this.start_scan = (Button) findViewById(R.id.start_scan);
        this.result_tv = (TextView) findViewById(R.id.result_tv);
        this.start_scan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.start_scan) {
            //zxing框架已经帮我们封装好对应的实现类，直接调用startActivityForResult即可
            Intent intent = new Intent(this, CaptureActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    /**
     * 在onActivityResult中处理数据
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            this.result_tv.setText(scanResult);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
