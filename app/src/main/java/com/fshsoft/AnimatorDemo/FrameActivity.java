package com.fshsoft.AnimatorDemo;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * 逐帧动画
 */
public class FrameActivity extends Activity implements View.OnClickListener {

    private AnimationDrawable animation;
    private ImageView imageFrame;
    private Button startBtn;
    private Button stopBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        imageFrame = (ImageView) findViewById(R.id.imageFrame);
        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);
        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);

        imageFrame.setImageResource(R.drawable.frame);
        animation = (AnimationDrawable) imageFrame.getDrawable();//获取播放动画对象
       // animation.setOneShot(true);//设置动画只播放一次

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.startBtn:
                animation.start();//播放动画
                break;
            case R.id.stopBtn:
                animation.stop();//停止动画
                break;
            default:
                break;
        }
    }
}
