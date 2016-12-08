package com.fshsoft.AnimatorDemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button frameBtn;
    private Button tweenBtn;
    private Button propertyBtn;
    private Button clickBtn;
    private Button demoBtn;
    private Button demo2Btn;
    private Button animBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameBtn = (Button) findViewById(R.id.frameBtn);
        tweenBtn = (Button) findViewById(R.id.tweenBtn);
        propertyBtn = (Button) findViewById(R.id.propertyBtn);
        clickBtn = (Button) findViewById(R.id.clickBtn);
        demoBtn = (Button) findViewById(R.id.demoBtn);
        demo2Btn = (Button) findViewById(R.id.demo2Btn);
        animBtn = (Button) findViewById(R.id.animBtn);

        frameBtn.setOnClickListener(this);
        tweenBtn.setOnClickListener(this);
        propertyBtn.setOnClickListener(this);
        clickBtn.setOnClickListener(this);
        demoBtn.setOnClickListener(this);
        demo2Btn.setOnClickListener(this);
        animBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.frameBtn:
                startActivity(new Intent(MainActivity.this,FrameActivity.class));
                break;
            case R.id.tweenBtn:
                startActivity(new Intent(MainActivity.this,TweenActivity.class));
                break;
            case R.id.propertyBtn:
                startActivity(new Intent(MainActivity.this,PropertyActivity.class));
                break;
            case R.id.clickBtn:
                startActivity(new Intent(MainActivity.this,ClickActivity.class));
                break;
            case R.id.demoBtn:
                startActivity(new Intent(MainActivity.this,DemoActivity.class));
                break;
            case R.id.demo2Btn:
                startActivity(new Intent(MainActivity.this,Demo2Activity.class));
                break;
            case R.id.animBtn:
                startActivity(new Intent(MainActivity.this,AnimActivity.class));
            default:
                break;
        }
    }
}
