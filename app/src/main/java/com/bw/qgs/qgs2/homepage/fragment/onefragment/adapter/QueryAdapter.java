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
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.QueryUser;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * date:2018/12/9    12:01
 * author:秦广帅(Lenovo)
 * fileName:QueryAdapter
 */
public class QueryAdapter extends RecyclerView.Adapter<QueryAdapter.MyViewHolder> {

    private Context mContext;
    private List<QueryUser.ResultBean> mResultBeans;

    public QueryAdapter(Context context, List<QueryUser.ResultBean> resultBeans) {
        mContext = context;
        mResultBeans = resultBeans;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.query, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        QueryUser.ResultBean bean = mResultBeans.get(i);
        Picasso.with(mContext).load(bean.getMasterPic()).into(myViewHolder.image);
        myViewHolder.text1.setText(bean.getCommodityName());
        myViewHolder.text2.setText("$ "+bean.getPrice());
    }

    @Override
    public int getItemCount() {
        return mResultBeans.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text1,text2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.queryimageView);
            text1 = itemView.findViewById(R.id.querytextView);
            text2 = itemView.findViewById(R.id.querytextView2);
        }
    }
}
