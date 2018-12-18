package com.bw.qgs.qgs2.homepage.fragment.onefragment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.ErJi;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.YiJi;

import java.util.List;

/**
 * date:2018/12/3    20:57
 * author:秦广帅(Lenovo)
 * fileName:TwoFragmentAdapter
 */
public class ErAdapter extends RecyclerView.Adapter<ErAdapter.TwoViewHolder> {

    private Context mContext;
    private List<ErJi.ResultBean> mJiResult;
    private HttpClick click;

    public void setClick(HttpClick click) {
        this.click = click;
    }

    public ErAdapter(Context context, List<ErJi.ResultBean> jiResult) {
        mContext = context;
        mJiResult = jiResult;
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
        ErJi.ResultBean bean = mJiResult.get(i);
        twoViewHolder.text1.setText(bean.getName());
    }

    @Override
    public int getItemCount() {
        return mJiResult.size();
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
