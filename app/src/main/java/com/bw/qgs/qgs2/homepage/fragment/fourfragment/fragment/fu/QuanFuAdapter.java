package com.bw.qgs.qgs2.homepage.fragment.fourfragment.fragment.fu;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.custom.AddSub;
import com.bw.qgs.qgs2.homepage.fragment.fourfragment.fragment.ding.QuanUser;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2018/12/15    17:49
 * author:秦广帅(Lenovo)
 * fileName:QuanAdapter
 */
public class QuanFuAdapter extends RecyclerView.Adapter {

    public static final int TYPE_ONE = 0;
    public static final int TYPE_TWO = 1;
    public static final int TYPE_THREE = 2;
    private Context mContext;
    private List<QuanUser.OrderListBean> mOrderList;

    public QuanFuAdapter(Context context, List<QuanUser.OrderListBean> orderList) {
        mContext = context;
        mOrderList = orderList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (i == TYPE_ONE) {
            view = LayoutInflater.from(mContext).inflate(R.layout.quan2, viewGroup, false);
            return new MyViewHolder(view);
        } else if (i == TYPE_TWO) {
            view = LayoutInflater.from(mContext).inflate(R.layout.quan, viewGroup, false);
            return new TwoViewHolder(view);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.quan3, viewGroup, false);
            return new ThreeViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        QuanUser.OrderListBean bean = mOrderList.get(i);
        if (viewHolder instanceof MyViewHolder) {
            ((MyViewHolder)viewHolder).dingtext1.setText(bean.getOrderId());
        }else if (viewHolder instanceof TwoViewHolder){
            List<QuanUser.OrderListBean.DetailListBean> list = bean.getDetailList();
            String commodityPic = list.get(0).getCommodityPic();
            String[] str = commodityPic.split(",");
            Uri uri = Uri.parse(str[0]);
            ((TwoViewHolder)viewHolder).quansimple.setImageURI(uri);
            ((TwoViewHolder)viewHolder).quantext1.setText(list.get(0).getCommodityName());
            ((TwoViewHolder)viewHolder).quantext2.setText(list.get(0).getCommodityPrice()+"");
        }else{

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_ONE;
        } else if (position == 1) {
            return TYPE_TWO;
        } else {
            return TYPE_THREE;
        }
    }

    @Override
    public long getItemId(int position) {
        return getItemId(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView dingtext1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            dingtext1 = itemView.findViewById(R.id.dingtext);
        }
    }

    class TwoViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView quansimple;
        TextView quantext1,quantext2;
        AddSub quanadd;

        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            quansimple = itemView.findViewById(R.id.quansimple);
            quantext1 = itemView.findViewById(R.id.quandingtext1);
            quantext2 = itemView.findViewById(R.id.quandingtext2);
            quanadd = itemView.findViewById(R.id.quanadd);
        }
    }

    class ThreeViewHolder extends RecyclerView.ViewHolder{

        Button dingbtn;

        public ThreeViewHolder(@NonNull View itemView) {
            super(itemView);
            dingbtn = itemView.findViewById(R.id.dingbtn);
        }
    }
}
