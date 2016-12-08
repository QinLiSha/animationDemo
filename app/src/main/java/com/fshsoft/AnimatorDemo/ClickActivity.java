package com.fshsoft.AnimatorDemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 属性动画的点击事件
 */
public class ClickActivity extends Activity implements View.OnClickListener {
    private Button clickBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);
        clickBtn = (Button) findViewById(R.id.clickBtn);
        clickBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //设置透明度动画效果
        ObjectAnimator animator = ObjectAnimator.ofFloat(clickBtn,"alpha",0F,1F);
        animator.setDuration(1000);
//        animator.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                Toast.makeText(ClickActivity.this,"动画结束显示信息",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(ClickActivity.this,"动画结束显示信息",Toast.LENGTH_SHORT).show();
            }
        });
        animator.start();
    }
}
