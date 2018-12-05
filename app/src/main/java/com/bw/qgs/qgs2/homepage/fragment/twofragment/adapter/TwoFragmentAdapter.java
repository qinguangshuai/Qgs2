package com.bw.qgs.qgs2.homepage.fragment.twofragment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.twofragment.bean.TwoFragmentUser;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * date:2018/12/3    20:57
 * author:秦广帅(Lenovo)
 * fileName:TwoFragmentAdapter
 */
public class TwoFragmentAdapter extends RecyclerView.Adapter<TwoFragmentAdapter.TwoViewHolder> {

    private Context mContext;
    private List<TwoFragmentUser.ResultBean> mResult1;

    public TwoFragmentAdapter(Context context, List<TwoFragmentUser.ResultBean> result1) {
        mContext = context;
        mResult1 = result1;
    }

    @NonNull
    @Override
    public TwoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.twofragmentadapter, viewGroup, false);
        TwoViewHolder holder = new TwoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TwoViewHolder twoViewHolder, int i) {
        TwoFragmentUser.ResultBean resultBean = mResult1.get(i);
        Picasso.with(mContext).load(resultBean.getHeadPic()).into(twoViewHolder.quanimage1);
        Picasso.with(mContext).load(resultBean.getHeadPic()).into(twoViewHolder.quanimage2);
        Picasso.with(mContext).load(resultBean.getHeadPic()).into(twoViewHolder.quanimage3);
        twoViewHolder.quantext1.setText(resultBean.getNickName());
        twoViewHolder.quantext2.setText(resultBean.getCreateTime()+"");
        twoViewHolder.quantext3.setText(resultBean.getContent());
    }

    @Override
    public int getItemCount() {
        return mResult1.size();
    }

    class TwoViewHolder extends RecyclerView.ViewHolder{

        ImageView quanimage1,quanimage2,quanimage3;
        TextView quantext1,quantext2,quantext3;

        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            quanimage1 = itemView.findViewById(R.id.quanimage1);
            quanimage2 = itemView.findViewById(R.id.quanimage2);
            quanimage3 = itemView.findViewById(R.id.quanimage3);
            quantext1 = itemView.findViewById(R.id.quantext1);
            quantext2 = itemView.findViewById(R.id.quantext2);
            quantext3 = itemView.findViewById(R.id.quantext3);
        }
    }
}
