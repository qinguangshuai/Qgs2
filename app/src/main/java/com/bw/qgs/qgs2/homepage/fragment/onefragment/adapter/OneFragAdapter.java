package com.bw.qgs.qgs2.homepage.fragment.onefragment.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.BannerUser;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.TwoAdapterBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2018/12/2    19:39
 * author:秦广帅(Lenovo)
 * fileName:OneFragAdapter
 */
public class OneFragAdapter extends RecyclerView.Adapter {

    public static final int TYPE_ONE = 0;
    public static final int TYPE_TWO = 1;
    public static final int TYPE_THREE = 2;
    public static final int TYPE_FOUR = 3;

    private Context mContext;
    private TwoAdapterBean.ResultBean list;

    public OneFragAdapter(Context context, TwoAdapterBean.ResultBean list) {
        mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (i == TYPE_ONE) {
            view = LayoutInflater.from(mContext).inflate(R.layout.one, viewGroup, false);
            return new OneViewHolder(view);
        } else if (i == TYPE_TWO) {
            view = LayoutInflater.from(mContext).inflate(R.layout.two, viewGroup, false);
            return new TwoViewHolder(view);
        } else if (i == TYPE_THREE) {
            view = LayoutInflater.from(mContext).inflate(R.layout.three, viewGroup, false);
            return new ThreeViewHolder(view);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.four, viewGroup, false);
            return new FourViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof OneViewHolder) {
            ArrayList<String> list1 = new ArrayList<>();
            list1.add("http://172.17.8.100/images/tech/banner/20181026151647.png");
            list1.add("http://172.17.8.100/images/tech/banner/20181026151647.png");
            ((OneViewHolder) viewHolder).text1.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Picasso.with(mContext).load((String) path).into(imageView);
                }
            });
            ((OneViewHolder) viewHolder).text1.setImages(list1);
            ((OneViewHolder) viewHolder).text1.setDelayTime(1000);
            ((OneViewHolder) viewHolder).text1.start();
        }
        if (viewHolder instanceof TwoViewHolder) {
            ((TwoViewHolder) viewHolder).text2.setText(list.getRxxp().get(0).getName());
            GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3);
            ((TwoViewHolder) viewHolder).tworecycle.setLayoutManager(gridLayoutManager);
            List<TwoAdapterBean.ResultBean.RxxpBean> rxxp = list.getRxxp();
            TwoAdapterBean.ResultBean.RxxpBean rxxpBean = rxxp.get(0);
            List<TwoAdapterBean.ResultBean.RxxpBean.CommodityListBean> commodityList = rxxpBean.getCommodityList();
            TwoAdapter twoAdapter = new TwoAdapter(mContext, commodityList);
            ((TwoViewHolder) viewHolder).tworecycle.setAdapter(twoAdapter);
        }
        if (viewHolder instanceof ThreeViewHolder) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
            ((ThreeViewHolder) viewHolder).recycle3.setLayoutManager(linearLayoutManager);
            List<TwoAdapterBean.ResultBean.MlssBean> mlss = list.getMlss();
            TwoAdapterBean.ResultBean.MlssBean mlssBean = mlss.get(0);
            List<TwoAdapterBean.ResultBean.MlssBean.CommodityListBeanXX> commodityList = mlssBean.getCommodityList();
            ThreeAdapter threeAdapter = new ThreeAdapter(mContext, commodityList);
            ((ThreeViewHolder) viewHolder).recycle3.setAdapter(threeAdapter);
        }
        if (viewHolder instanceof FourViewHolder) {
            GridLayoutManager linearLayoutManager = new GridLayoutManager(mContext,2);
            ((FourViewHolder) viewHolder).recycle4.setLayoutManager(linearLayoutManager);
            List<TwoAdapterBean.ResultBean.PzshBean> pzsh = list.getPzsh();
            TwoAdapterBean.ResultBean.PzshBean pzshBean = pzsh.get(0);
            List<TwoAdapterBean.ResultBean.PzshBean.CommodityListBeanX> commodityList = pzshBean.getCommodityList();
            FourAdapter fourAdapter = new FourAdapter(mContext, commodityList);
            ((FourViewHolder) viewHolder).recycle4.setAdapter(fourAdapter);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_ONE;
        } else if (position == 1) {
            return TYPE_TWO;
        } else if (position == 2) {
            return TYPE_THREE;
        } else {
            return TYPE_FOUR;
        }
    }

    @Override
    public long getItemId(int position) {
        return getItemId(position);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public void setdata(TwoAdapterBean.ResultBean resultBeans) {
        this.list = resultBeans;
    }


    class OneViewHolder extends RecyclerView.ViewHolder {

        Banner text1;

        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.onetextView);
        }
    }

    class TwoViewHolder extends RecyclerView.ViewHolder {

        TextView text2;
        RecyclerView tworecycle;

        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            text2 = itemView.findViewById(R.id.twotextView);
            tworecycle = itemView.findViewById(R.id.tworecycle);
        }
    }

    class ThreeViewHolder extends RecyclerView.ViewHolder {

        TextView text3;
        RecyclerView recycle3;

        public ThreeViewHolder(@NonNull View itemView) {
            super(itemView);
            text3 = itemView.findViewById(R.id.threetextView);
            recycle3 = itemView.findViewById(R.id.threerecycle);
        }
    }

    class FourViewHolder extends RecyclerView.ViewHolder {

        TextView text4;
        RecyclerView recycle4;

        public FourViewHolder(@NonNull View itemView) {
            super(itemView);
            text4 = itemView.findViewById(R.id.fourtextView);
            recycle4 = itemView.findViewById(R.id.threerecycle);
        }
    }
}
