package com.example.cho.test_12_02;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

/**
 * Created by cho on 2016-12-21.
 */

public class Instructor01 extends AppCompatActivity{
    ImageSwitcher myImageSwitcher;
    int imageSwitcherImages[] = {R.drawable.seoulinstructorday_01, R.drawable.seoulinstructorday_02, R.drawable.seoulinstructorday_03, R.drawable.seoulinstructorday_04, R.drawable.seoulinstructorday_05,R.drawable.seoulinstructorday_06};

    int switcherImage = imageSwitcherImages.length;
    int counter = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor01);

        myImageSwitcher = (ImageSwitcher)findViewById(R.id.switcher);
        Button btn_next = (Button) findViewById(R.id.btn_next);
        Button btn_previous = (Button) findViewById(R.id.btn_previous);

        myImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView switcherImageView = new ImageView(getApplicationContext());
                switcherImageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT
                ));

                switcherImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                switcherImageView.setImageResource(R.drawable.seoulinstructorday_01);
                //switcherImageView.setMaxHeight(100);
                return switcherImageView;
            }
        });

    }

    public void btn_next(View view) {
        counter++;
        if (counter == switcherImage)
            counter = 0;
        myImageSwitcher.setImageResource(imageSwitcherImages[counter]);

        Animation animationOut = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        Animation animationIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);

        myImageSwitcher.setOutAnimation(animationOut);
        myImageSwitcher.setInAnimation(animationIn);
    }
    public void btn_previous(View view) {

        counter--;
        if (counter == -1 || counter==-2)
            counter = switcherImage-1;

        myImageSwitcher.setImageResource(imageSwitcherImages[counter]);

        Animation animationOut_b = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        Animation animationIn_b = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);

        myImageSwitcher.setOutAnimation(animationOut_b);
        myImageSwitcher.setInAnimation(animationIn_b);
    }
}