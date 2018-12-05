package com.bw.qgs.qgs2.wallet.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

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
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
