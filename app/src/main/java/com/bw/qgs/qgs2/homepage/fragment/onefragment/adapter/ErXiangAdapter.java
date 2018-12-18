package com.bw.qgs.qgs2.homepage.fragment.onefragment.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.ErJi;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.ErXiangUser;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2018/12/3    20:57
 * author:秦广帅(Lenovo)
 * fileName:TwoFragmentAdapter
 */
public class ErXiangAdapter extends RecyclerView.Adapter<ErXiangAdapter.TwoViewHolder> {

    private Context mContext;
    private List<ErXiangUser.ResultBean> mResult1;
    private HttpClick click;

    public void setClick(HttpClick click) {
        this.click = click;
    }

    public ErXiangAdapter(Context context, List<ErXiangUser.ResultBean> result1) {
        mContext = context;
        mResult1 = result1;
    }

    @NonNull
    @Override
    public TwoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.goods, viewGroup, false);
        TwoViewHolder holder = new TwoViewHolder(view,click);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TwoViewHolder twoViewHolder, int i) {
        ErXiangUser.ResultBean bean = mResult1.get(i);
        twoViewHolder.text1.setText(bean.getCommodityName());
        twoViewHolder.text2.setText(bean.getPrice()+"");
        Uri uri = Uri.parse(bean.getMasterPic());
        twoViewHolder.image.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return mResult1.size();
    }

    class TwoViewHolder extends RecyclerView.ViewHolder{

        TextView text1,text2;
        SimpleDraweeView image;

        public TwoViewHolder(@NonNull View itemView, final HttpClick click) {
            super(itemView);
            text1 = itemView.findViewById(R.id.goodstextView);
            text2 = itemView.findViewById(R.id.goodstextView2);
            image = itemView.findViewById(R.id.goodsimageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click.click(v,getAdapterPosition());
                }
            });
        }
    }

    public interface HttpClick{
        void click(View view, int position);
    }
}
