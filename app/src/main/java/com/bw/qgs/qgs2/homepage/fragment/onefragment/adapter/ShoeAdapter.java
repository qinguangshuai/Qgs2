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
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.ShoeUser;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * date:2018/12/4    11:39
 * author:秦广帅(Lenovo)
 * fileName:ShoeAdapter
 */
public class ShoeAdapter extends RecyclerView.Adapter<ShoeAdapter.MyViewHolder> {

    private Context mContext;
    private ShoeUser.ResultBean mResult1;

    public ShoeAdapter(Context context, ShoeUser.ResultBean result1) {
        mContext = context;
        mResult1 = result1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.shoe, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Picasso.with(mContext).load(mResult1.getDetails()).into(myViewHolder.image);
        myViewHolder.text1.setText(mResult1.getCommodityName());
        myViewHolder.text1.setText(mResult1.getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text1;
        TextView text2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.shoeimageView);
            text1 = itemView.findViewById(R.id.shoetextView);
            text2 = itemView.findViewById(R.id.shoetextView2);
        }
    }
}
