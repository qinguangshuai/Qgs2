package com.bw.qgs.qgs2.circle.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.circle.bean.CicleUser;
import com.bw.qgs.qgs2.footer.adapter.FooterAdapter;

import java.util.List;

/**
 * date:2018/12/7    13:52
 * author:秦广帅(Lenovo)
 * fileName:MyCicleAdapter
 */
public class MyCicleAdapter extends RecyclerView.Adapter<MyCicleAdapter.MyViewHolder> {

    private Context mContext;
    private List<CicleUser.ResultBean> list;

    public MyCicleAdapter(Context context, List<CicleUser.ResultBean> list) {
        mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.circle, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        CicleUser.ResultBean bean = list.get(i);
        myViewHolder.text.setText(bean.getNickName());
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.circletextView);
            image = itemView.findViewById(R.id.circleimageView);
        }
    }
}
