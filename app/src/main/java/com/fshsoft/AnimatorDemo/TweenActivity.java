package com.fshsoft.AnimatorDemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 补间动画
 */
public class TweenActivity extends Activity implements View.OnClickListener {

    private ImageView imageTween;
    private Button tweenStartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        imageTween = (ImageView) findViewById(R.id.imageTween);
        tweenStartBtn = (Button) findViewById(R.id.tweenStartBtn);
        imageTween.setOnClickListener(this);
        tweenStartBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageTween:
                Toast.makeText(this,"图片点击事件",Toast.LENGTH_SHORT).show();

                break;
            case R.id.tweenStartBtn:
                TranslateAnimation animation = new TranslateAnimation(0,400,0,0);//创建动画对象
                animation.setDuration(1000);//显示时长
                animation.setFillAfter(true);//动画停留在移动后的位置
                imageTween.startAnimation(animation);
                animation.start();//启动动画
                break;
            default:
                break;
        }
    }
}
