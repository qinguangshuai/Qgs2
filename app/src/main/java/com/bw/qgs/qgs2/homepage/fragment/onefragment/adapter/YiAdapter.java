package com.bw.qgs.qgs2.homepage.fragment.onefragment.adapter;

import android.content.Context;
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
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.YiJi;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * date:2018/12/3    20:57
 * author:秦广帅(Lenovo)
 * fileName:TwoFragmentAdapter
 */
public class YiAdapter extends RecyclerView.Adapter<YiAdapter.TwoViewHolder> {

    private Context mContext;
    private List<YiJi.ResultBean> mResult1;
    private HttpClick click;

    public void setClick(HttpClick click) {
        this.click = click;
    }

    public YiAdapter(Context context, List<YiJi.ResultBean> result1) {
        mContext = context;
        mResult1 = result1;
    }

    @NonNull
    @Override
    public TwoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.yi, viewGroup, false);
        TwoViewHolder holder = new TwoViewHolder(view,click);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TwoViewHolder twoViewHolder, int i) {
        YiJi.ResultBean bean = mResult1.get(i);
        twoViewHolder.text1.setText(bean.getName());
    }

    @Override
    public int getItemCount() {
        return mResult1.size();
    }

    class TwoViewHolder extends RecyclerView.ViewHolder{

        TextView text1;

        public TwoViewHolder(@NonNull View itemView, final HttpClick click) {
            super(itemView);
            text1 = itemView.findViewById(R.id.yitextView);
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
