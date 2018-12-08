package com.bw.qgs.qgs2.homepage.fragment.particulars.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.adapter.OneFragAdapter;
import com.bw.qgs.qgs2.homepage.fragment.particulars.bean.Particulars;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2018/12/8    14:58
 * author:秦广帅(Lenovo)
 * fileName:GoodsParticularsAdapter
 */
public class GoodsParticularsAdapter extends RecyclerView.Adapter {

    public static final int TYPE_ONE = 0;
    public static final int TYPE_TWO = 1;

    private Context mContext;
    private Particulars.ResultBean resultBean;

    public void setResultBean(Particulars.ResultBean resultBean) {
        this.resultBean = resultBean;
    }

    public GoodsParticularsAdapter(Context context, Particulars.ResultBean resultBean) {
        mContext = context;
        this.resultBean = resultBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (i == TYPE_ONE) {
            view = LayoutInflater.from(mContext).inflate(R.layout.onegoods, viewGroup, false);
            return new MyViewHolder(view);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.twogoods, viewGroup, false);
            return new TwoViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MyViewHolder) {
            List<String> mBeanList = new ArrayList<>();
            String picture = resultBean.getPicture();
            String[] str = picture.split(",");
            mBeanList.add(str[0]);
            mBeanList.add(str[1]);
            mBeanList.add(str[2]);
            mBeanList.add(str[3]);
            mBeanList.add(str[4]);
            ((MyViewHolder) viewHolder).banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Picasso.with(context).load((String) path).into(imageView);
                }
            });
            ((MyViewHolder) viewHolder).banner.setImages(mBeanList);
            ((MyViewHolder) viewHolder).banner.setDelayTime(1000);
            ((MyViewHolder) viewHolder).banner.start();
        } else if (viewHolder instanceof TwoViewHolder) {
            ((TwoViewHolder) viewHolder).goodsprice.setText("" + resultBean.getPrice());
            ((TwoViewHolder) viewHolder).goodsxiao.setText(resultBean.getCategoryName());
            ((TwoViewHolder) viewHolder).goodsxiang.setText(resultBean.getCommodityName());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_ONE;
        } else {
            return TYPE_TWO;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        Banner banner;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.goodsbanner);
        }
    }

    class TwoViewHolder extends RecyclerView.ViewHolder {

        TextView goodsprice, goodsxiao, goodsxiang;

        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            goodsprice = itemView.findViewById(R.id.goodsprice);
            goodsxiao = itemView.findViewById(R.id.goodsxiao);
            goodsxiang = itemView.findViewById(R.id.goodsxiang);
        }
    }
}
