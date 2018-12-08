package com.bw.qgs.qgs2.wallet.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.wallet.bean.WalletUser;

import java.util.List;

/**
 * date:2018/12/5    8:18
 * author:秦广帅(Lenovo)
 * fileName:WalletAdapter
 */
public class WalletAdapter extends RecyclerView.Adapter<WalletAdapter.MyViewHolder> {

    private Context mContext;
    private List<WalletUser.ResultBean.DetailListBean> mDetailList;

    public WalletAdapter(Context context, List<WalletUser.ResultBean.DetailListBean> detailList) {
        mContext = context;
        mDetailList = detailList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.wallet, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        WalletUser.ResultBean.DetailListBean listBean = mDetailList.get(i);
        myViewHolder.leftwallet.setText(listBean.getAmount()+"");
        myViewHolder.rightwallet.setText(listBean.getCreateTime()+"");
    }

    @Override
    public int getItemCount() {
        return mDetailList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView leftwallet,centerwallet,rightwallet;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            leftwallet = itemView.findViewById(R.id.leftwallet);
            centerwallet = itemView.findViewById(R.id.centerwallet);
            rightwallet = itemView.findViewById(R.id.rightwallet);
        }
    }
}
