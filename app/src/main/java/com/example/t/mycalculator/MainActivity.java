package com.example.t.mycalculator;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * Created by T on 2015-11-30.
 */
public class MainActivity extends AppCompatActivity {
    MyPagerAdapter mAdapter;
    ViewPager pager;
    View mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*ImageButton arithmetic = (ImageButton)findViewById(R.id.dailylife_main_b);
        arithmetic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        mv = findViewById(R.id.arithmetic_mainbackground);
        pager = (ViewPager)findViewById(R.id.pager);
        mAdapter = new MyPagerAdapter(this);
        pager.setAdapter(mAdapter);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //메인 배경색깔 변경
            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        mv.setBackgroundResource(R.drawable.arithmetic_bac3);
                        break;
                    case 1:
                        mv.setBackgroundResource(R.drawable.money_bac3);
                        break;
                    case 2:
                        mv.setBackgroundResource(R.drawable.editbac);
                        break;
                    case 3:
                        mv.setBackgroundResource(R.drawable.travel_bac);
                        break;
                    case 4:
                        mv.setBackgroundResource(R.drawable.age_bac);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        pager.setCurrentItem(0, true);

    }


}
