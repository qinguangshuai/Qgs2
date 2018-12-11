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
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.TwoAdapterBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**+
 * date:2018/12/3    10:33
 * author:秦广帅(Lenovo)
 * fileName:TwoAdapter
 */
public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.MyViewHolder> {

    private Context mContext;
    private List<TwoAdapterBean.ResultBean.RxxpBean.CommodityListBean> list ;
    private HttpOnClick mHttpOnClick;

    public void setHttpOnClick(HttpOnClick httpOnClick) {
        mHttpOnClick = httpOnClick;
    }

    public TwoAdapter(Context context, List<TwoAdapterBean.ResultBean.RxxpBean.CommodityListBean> list ) {
        mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.twoadapter, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view,mHttpOnClick);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        TwoAdapterBean.ResultBean.RxxpBean.CommodityListBean commodityListBean = list.get(i);
        Picasso.with(mContext).load(commodityListBean.getMasterPic()).into(myViewHolder.image);
        myViewHolder.text.setText(commodityListBean.getCommodityName());
        myViewHolder.text1.setText("$ "+commodityListBean.getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text,text1;
        ImageView image;

        public MyViewHolder(@NonNull View itemView, final HttpOnClick httpOnClick) {
            super(itemView);
            image = itemView.findViewById(R.id.twoadapterimageView);
            text = itemView.findViewById(R.id.twoadaptertextView);
            text1 = itemView.findViewById(R.id.twoadaptertextView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    httpOnClick.click(v,getAdapterPosition());
                }
            });
        }
    }
    public interface HttpOnClick{
        void click(View view,int position);
    }
}
