package com.bw.qgs.qgs2.homepage.fragment.onefragment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.QueryGoods;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * date:2018/12/4    11:39
 * author:秦广帅(Lenovo)
 * fileName:ShoeAdapter
 */
public class QueryGoodsAdapter extends RecyclerView.Adapter<QueryGoodsAdapter.MyViewHolder> {

    private Context mContext;
    private List<QueryGoods.ResultBean> mGoodsResult;

    public QueryGoodsAdapter(Context context, List<QueryGoods.ResultBean> goodsResult) {
        mContext = context;
        mGoodsResult = goodsResult;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.goods, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        QueryGoods.ResultBean resultBean = mGoodsResult.get(i);
        Picasso.with(mContext).load(resultBean.getMasterPic()).into(myViewHolder.image);
        myViewHolder.text1.setText(resultBean.getCommodityName());
        myViewHolder.text2.setText(resultBean.getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return mGoodsResult.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text1;
        TextView text2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.goodsimageView);
            text1 = itemView.findViewById(R.id.goodstextView);
            text2 = itemView.findViewById(R.id.goodstextView2);
        }
    }
}
