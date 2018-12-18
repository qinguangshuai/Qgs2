package com.bw.qgs.qgs2.homepage.fragment.onefragment.ding;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * date:2018/12/5    16:37
 * author:秦广帅(Lenovo)
 * fileName:ZoomOutPageTransformer
 */
public class ZoomOutPageTransformer implements ViewPager.PageTransformer {

    //自由控制缩放比例
    private static final float MAX_SCALE = 1f;
    private static final float MIN_SCALE = 0.85f;

    @Override
    public void transformPage(@NonNull View page, float position) {
        if (position <= 1) {

            float scaleFactor = MIN_SCALE + (1 - Math.abs(position)) * (MAX_SCALE - MIN_SCALE);

            page.setScaleX(scaleFactor);

            if (position > 0) {
                page.setTranslationX(-scaleFactor * 1);
            } else if (position < 0) {
                page.setTranslationX(scaleFactor * 1);
            }
            page.setScaleY(scaleFactor);
        } else {
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
        }
    }
}
