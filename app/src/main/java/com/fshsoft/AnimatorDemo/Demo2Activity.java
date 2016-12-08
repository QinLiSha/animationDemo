package com.fshsoft.AnimatorDemo;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 倒计时60秒动画效果
 */
public class Demo2Activity extends Activity implements View.OnClickListener {
    private Button demo2StartBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
        demo2StartBtn = (Button) findViewById(R.id.demo2StartBtn);
        demo2StartBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //倒计时60秒动画效果
        ValueAnimator animator = ValueAnimator.ofInt(0,60);
        animator.setDuration(60000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                demo2StartBtn.setText(value+"秒");
            }
        });
        animator.start();

    }
}
