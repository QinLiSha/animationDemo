package com.fshsoft.AnimatorDemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 属性动画
 */
public class PropertyActivity extends Activity implements View.OnClickListener {
    private ImageView imageProperty;
    private Button propertyStartBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        imageProperty = (ImageView) findViewById(R.id.imageProperty);
        propertyStartBtn = (Button) findViewById(R.id.propertyStartBtn);
        imageProperty.setOnClickListener(this);
        propertyStartBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageProperty:
                Toast.makeText(this,"图片点击事件",Toast.LENGTH_SHORT).show();
                break;
            case R.id.propertyStartBtn:
//                //通过ObjectAnimator对象让动画在x轴移动
//                ObjectAnimator.ofFloat(imageProperty,"translationX",0F,400F).setDuration(1000).start();
//                //通过ObjectAnimator对象让动画在Y轴移动
//                ObjectAnimator.ofFloat(imageProperty,"translationY",0F,400F).setDuration(1000).start();
//                //通过ObjectAnimator对象让动画旋转360度
//                ObjectAnimator.ofFloat(imageProperty,"rotation",0F,360F).setDuration(1000).start();

//                PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("translationX",0F,400F);
//                PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationY",0F,400F);
//                PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("rotation",0F,360F);
//                ObjectAnimator.ofPropertyValuesHolder(imageProperty,p1,p2,p3).setDuration(1000).start();

                ObjectAnimator animator1 =  ObjectAnimator.ofFloat(imageProperty,"translationX",0F,400F);
                ObjectAnimator animator2 =  ObjectAnimator.ofFloat(imageProperty,"translationY",0F,400F);
                ObjectAnimator animator3 =  ObjectAnimator.ofFloat(imageProperty,"rotation",0F,360F);
                AnimatorSet set = new AnimatorSet();
//                set.playTogether(animator1,animator2,animator3);
//                set.playSequentially(animator1,animator2,animator3);
                set.play(animator1).with(animator2);
                set.play(animator3).after(animator2);
                set.setDuration(1000);
                set.start();



                break;
            default:
                break;
        }
    }
}
