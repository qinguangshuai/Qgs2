package com.bw.qgs.qgs2.homepage.fragment.onefragment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.BannerUser;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * date:2018/12/5    10:39
 * author:秦广帅(Lenovo)
 * fileName:ImageAdapter
 */
public class ImageAdapter extends PagerAdapter {

    private Context mContext;
    private List<BannerUser.ResultBean> mBeanList;

    public ImageAdapter(Context context, List<BannerUser.ResultBean> beanList) {
        mContext = context;
        mBeanList = beanList;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        int size = position % mBeanList.size();
        BannerUser.ResultBean bean = mBeanList.get(size);
        ImageView imageView = new ImageView(mContext);
        String img = bean.getImageUrl();
        ImageLoader.getInstance().displayImage(img,imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
