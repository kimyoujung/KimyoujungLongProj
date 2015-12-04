package com.example.t.mycalculator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.capricorn.ArcMenu;

/**
 * Created by T on 2015-12-01.
 */
public class MyPagerAdapter extends PagerAdapter implements LayoutNumberActivity{
    Context mContext;
    View mainIcon;
    //아크메뉴 속 버튼들 사진을 변수에 담았다.
    int[] ITEM_DRAWABLES;
    public static final int VIEW_COUNT = 5;

    public MyPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return VIEW_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View mainPager = LayoutInflater.from(mContext).inflate(R.layout.pager, null);
        mainIcon = mainPager.findViewById(R.id.control_layout);
        switch (position) {
            case 0:
                mainIcon.setBackgroundResource(R.drawable.dailymainicon);
                ITEM_DRAWABLES = new int[]{R.drawable.arithmetic_icon2, R.drawable.joooulicon,
                        R.drawable.sampleicon5};
                break;
            case 1:
                mainIcon.setBackgroundResource(R.drawable.travelmainicon);
                ITEM_DRAWABLES = new int[]{R.drawable.arithmetic_icon, R.drawable.sampleicon4,
                        R.drawable.sampleicon5};
                break;
            case 2:
                mainIcon.setBackgroundResource(R.drawable.moneymainicon);
                ITEM_DRAWABLES = new int[]{R.drawable.sampleicon3, R.drawable.sampleicon4,
                        R.drawable.sampleicon5};
                break;
            case 3:
                mainIcon.setBackgroundResource(R.drawable.mommymainicon);
                ITEM_DRAWABLES = new int[]{R.drawable.sampleicon3, R.drawable.sampleicon4,
                        R.drawable.sampleicon5, R.drawable.sampleicon6};
                break;
            case 4:
                mainIcon.setBackgroundResource(R.drawable.iconbac5);
                ITEM_DRAWABLES = new int[0];
                break;

        }


        //=============================================================================================================


        //==============================================================================================================

        //Library에 있는 애니메이션이 듬뿍담긴 버튼을 상속받아 만든 App버튼 두개를 가져왔다.
        ArcMenu arcMenu2 = (ArcMenu) mainPager.findViewById(R.id.arc_menu_2);        //내가 써야 할 애니메이션 갖고있는 친구

        //위에서 가져온 App_layout버튼 두개와 버튼사진들을 initArcMenu한테 줬다.
        initArcMenu(arcMenu2, ITEM_DRAWABLES);

        //애니메이션이 다른 ray_menu친구를 가져왔다.


        container.addView(mainPager);
        return mainPager;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View v = (View) object;
        container.removeView(v);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    //==================================================================================================


    //아크메뉴 속 버튼들 사진과 App_layout버튼들(애니메이션 칠한 버튼)을 가져간 놈.
    private void initArcMenu(ArcMenu menu, final int[] itemDrawables) {
        final int itemCount = itemDrawables.length;
        for (int i = 0; i < itemCount; i++) {
            ImageView item = new ImageView(mContext);
            item.setImageResource(itemDrawables[i]);
            final int itemResource = itemDrawables[i];
            menu.addItem(item, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("ㅡㅡ아이템드러오불주의 값ㅡㅡ", "itemDrawbles>>>>>>>>>>" + itemResource);
                    Log.e("ㅡㅡ아이의 값ㅡㅡ", "i>>>>>>>>>>" + R.drawable.sampleicon1);

                    Intent arithmeticAct = new Intent(mContext, ArithmeticActivity.class);


                    switch (itemResource) {

                        case R.drawable.arithmetic_icon:
                            arithmeticAct.putExtra("arithmeticLayout", arithmetic_layout);
                            break;
                        case R.drawable.joooulicon:
                            arithmeticAct.putExtra("arithmeticLayout", unit_layout);
                            break;
                        case R.drawable.sampleicon5:
                            arithmeticAct.putExtra("arithmeticLayout", health_layout);
                            break;
                    }
                    ((Activity) mContext).startActivity(arithmeticAct);
                    Log.e("mContext에 사진과 변수들을 넣은 것들,  잘 이동되었다. >>>>>>>>>>>", itemResource + "");
                }
            });
        }
    }
}


