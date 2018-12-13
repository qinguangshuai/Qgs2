package com.bw.qgs.qgs2.homepage.fragment.onefragment.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.OneDianBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * date:2018/12/3    20:57
 * author:秦广帅(Lenovo)
 * fileName:TwoFragmentAdapter
 */
public class OneDianAdapter extends RecyclerView.Adapter<OneDianAdapter.TwoViewHolder> {

    private Context mContext;
    private List<OneDianBean.ResultBean> dianlist;
    private HttpClick click;

    public void setClick(HttpClick click) {
        this.click = click;
    }

    public OneDianAdapter(Context context, List<OneDianBean.ResultBean> dianlist) {
        mContext = context;
        this.dianlist = dianlist;
    }

    @NonNull
    @Override
    public TwoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.dian1, viewGroup, false);
        TwoViewHolder holder = new TwoViewHolder(view,click);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TwoViewHolder twoViewHolder, int i) {
        OneDianBean.ResultBean bean = dianlist.get(i);
        Picasso.with(mContext).load(bean.getMasterPic()).into(twoViewHolder.image);
        Uri uri = Uri.parse(bean.getMasterPic());
        twoViewHolder.image.setImageURI(uri);
        twoViewHolder.text1.setText(bean.getCommodityName());
        twoViewHolder.text2.setText("$ "+bean.getPrice());
        if(i!=0){
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(twoViewHolder.image.getLayoutParams());
            params.setMargins(0,100,0,0);
            twoViewHolder.image.setLayoutParams(params);
        }else{
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(twoViewHolder.image.getLayoutParams());
            params.setMargins(0,40,0,0);
            twoViewHolder.image.setLayoutParams(params);
        }
    }

    @Override
    public int getItemCount() {
        return dianlist.size();
    }

    class TwoViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView image;
        TextView text1,text2;

        public TwoViewHolder(@NonNull View itemView, final HttpClick click) {
            super(itemView);
            image = itemView.findViewById(R.id.dian1imageView);
            text1 = itemView.findViewById(R.id.dian1textView);
            text2 = itemView.findViewById(R.id.dian1textView2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click.click(v,getAdapterPosition());
                }
            });
        }
    }

    public interface HttpClick{
        void click(View view,int position);
    }
}
