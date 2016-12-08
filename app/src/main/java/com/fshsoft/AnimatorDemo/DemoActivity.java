package com.fshsoft.AnimatorDemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 * 扇形动画案例
 */
public class DemoActivity extends Activity implements View.OnClickListener {
    private int[] res ={R.id.image_a,R.id.image_b,R.id.image_c,R.id.image_d,R.id.image_e,
            R.id.image_f,R.id.image_g,R.id.image_h};
    private List<ImageView> imageList = new ArrayList<>();
    private boolean flag;//菜单是否打开状态
    private final int r = 400;//扇形半径
    private float angle;//按钮之间的夹角
    private final long intervalTime = 100; //菜单展开的时间间隔

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        //计算按钮之间的夹角
        angle=(float)Math.PI/(2*(res.length-1));

        //通过for循环获取ImageView对象，并添加点击事件，然后放入List集合
        for(int i =0;i<res.length;i++){
            ImageView imageView = (ImageView) findViewById(res[i]);
            imageView.setOnClickListener(this);
            imageList.add(imageView);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_a://红点的按钮
                if(flag){
                    closeAnim();
                    flag =false;
                }else{
                    startAnim();
                    flag=true;
                }
                break;
            case R.id.image_b:
                toast("b");
                break;
            case R.id.image_c:
                toast("c");
                break;
            case R.id.image_d:
                toast("d");
                break;
            case R.id.image_e:
                toast("e");
                break;
            case R.id.image_f:
                toast("f");
                break;
            case R.id.image_g:
                toast("g");
                break;
            case R.id.image_h:
                toast("h");
                break;
            default:
                break;

        }
    }

    /**
     * 在X轴或者Y轴的动画显示
     */
    private void startAnim() {
        for(int i=1;i<res.length;i++){
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageList.get(i),"translationY",0F,i*150F);
           // ObjectAnimator animator = ObjectAnimator.ofFloat(imageList.get(i),"translationX",0F,i*100F);
            animator.setInterpolator(new BounceInterpolator());//动画播放的速度效果，此为自由落体效果
            animator.setStartDelay(i*300);
            animator.start();
        }
    }
    private void closeAnim(){
        for(int i=1;i<res.length;i++){
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageList.get(i),"translationY",i*150F,0F);
           // ObjectAnimator animator = ObjectAnimator.ofFloat(imageList.get(i),"translationX",i*100F,0F);
            animator.setInterpolator(new BounceInterpolator());
            animator.setDuration(1000);
            animator.setStartDelay(i*300);
            animator.start();
        }
    }

    /**
     * 扇形动画显示
     */

//    private void startAnim(){
//        ObjectAnimator animatorX;
//        ObjectAnimator animatorY;
//        float translationX ;//横坐标偏移距离
//        float translationY ;//纵坐标偏移距离
//        for(int i = 1; i < res.length; i++){
//            translationX = (float) (r*Math.sin(i*angle));
//            translationY = (float) (r*Math.cos(i*angle));
//            animatorX = ObjectAnimator.ofFloat(imageList.get(i),"translationX", 0F, translationX);
//            animatorY = ObjectAnimator.ofFloat(imageList.get(i),"translationY", 0F, translationY);
//            AnimatorSet animSet = new AnimatorSet();
//            animSet.playTogether(animatorX, animatorY);
//            animSet.setDuration(i * intervalTime);
//            animSet.start();
//        }
//    }
//
//    private void closeAnim(){
//        ObjectAnimator animatorX;
//        ObjectAnimator animatorY;
//        float translationX ;//横坐标偏移距离
//        float translationY ;//纵坐标偏移距离
//        for(int i = res.length - 1; i > 0; i--){
//            translationX = (float) (r*Math.sin(i*angle));
//            translationY = (float) (r*Math.cos(i*angle));
//            animatorX = ObjectAnimator.ofFloat(imageList.get(i),"translationX", translationX, 0F);
//            animatorY = ObjectAnimator.ofFloat(imageList.get(i),"translationY", translationY, 0F);
//            AnimatorSet animSet = new AnimatorSet();
//            animSet.playTogether(animatorX, animatorY);
//            animSet.setDuration((res.length - i) * intervalTime);
//            animSet.start();
//        }
//    }

    //Toast显示信息
    private void toast(String str){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}
