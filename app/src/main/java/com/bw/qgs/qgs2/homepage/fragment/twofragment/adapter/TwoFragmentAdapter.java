package com.bw.qgs.qgs2.homepage.fragment.twofragment.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.twofragment.CancleZanPresenter;
import com.bw.qgs.qgs2.homepage.fragment.twofragment.ZanPresenter;
import com.bw.qgs.qgs2.homepage.fragment.twofragment.bean.TwoFragmentUser;
import com.bw.qgs.qgs2.homepage.fragment.twofragment.view.TwoFragmentView;
import com.bw.qgs.qgs2.url.UrlUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * date:2018/12/3    20:57
 * author:秦广帅(Lenovo)
 * fileName:TwoFragmentAdapter
 */
public class TwoFragmentAdapter extends RecyclerView.Adapter<TwoFragmentAdapter.TwoViewHolder> {

    private Context mContext;
    private List<TwoFragmentUser.ResultBean> mResult1;
    private boolean flag = false;

    public TwoFragmentAdapter(Context context, List<TwoFragmentUser.ResultBean> result1) {
        mContext = context;
        mResult1 = result1;
    }

    @NonNull
    @Override
    public TwoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.twofragmentadapter, viewGroup, false);
        TwoViewHolder holder = new TwoViewHolder(view, mHttpZan);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TwoViewHolder twoViewHolder, final int i) {
        int whetherGreat = mResult1.get(i).getWhetherGreat();

        if (whetherGreat == 2) {
            twoViewHolder.priseimage.setImageResource(R.drawable.common_btn_prise_n_xhdpi);
        } else  {
            twoViewHolder.priseimage.setImageResource(R.drawable.common_btn_prise_s_xhdpi);
        }
        TwoFragmentUser.ResultBean resultBean = mResult1.get(i);
        Uri uri = Uri.parse(resultBean.getHeadPic());
        twoViewHolder.quanimage1.setImageURI(uri);
        twoViewHolder.quanimage2.setImageURI(uri);
        twoViewHolder.quanimage3.setImageURI(uri);
        twoViewHolder.quantext1.setText(resultBean.getNickName());
        twoViewHolder.quantext2.setText(resultBean.getCreateTime() + "");
        twoViewHolder.quantext3.setText(resultBean.getContent());

        long browseTime = resultBean.getCreateTime();
        GregorianCalendar gc = new GregorianCalendar();
        String s = String.valueOf(browseTime);
        gc.setTimeInMillis(Long.parseLong(s));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        twoViewHolder.timetext.setText(df.format(gc.getTime()));


        twoViewHolder.priseimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //    priseimage.setImageResource(R.drawable.common_btn_prise_s_xhdpi);

                //notifyDataSetChanged();
                if (flag){
                   twoViewHolder. priseimage.setImageResource(R.drawable.common_btn_prise_n_xhdpi);
                    new CancleZanPresenter(new TwoFragmentView() {
                        @Override
                        public void onSuccess(String result) {

                        }

                        @Override
                        public void onZanSuccess(String result) {

                        }

                        @Override
                        public void onCancleZanSuccess(String result) {
                            Toast.makeText(mContext, ""+result, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailer(String msg) {

                        }
                    }).deletezan(UrlUtil.CANCLEZAN,mResult1.get(i).getId());
                  flag=false;
                }else{
                   twoViewHolder. priseimage.setImageResource(R.drawable.common_btn_prise_s_xhdpi);
                    new ZanPresenter(new TwoFragmentView() {
                        @Override
                        public void onSuccess(String result) {

                        }

                        @Override
                        public void onZanSuccess(String result) {
                            Toast.makeText(mContext, ""+result, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancleZanSuccess(String result) {

                        }

                        @Override
                        public void onFailer(String msg) {

                        }
                    }).postZanMethod(UrlUtil.ZAN,mResult1.get(i).getId());

                    flag=true;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mResult1.size();
    }

    class TwoViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView quanimage1, quanimage2, quanimage3;
        TextView quantext1, quantext2, quantext3, timetext;
        ImageView priseimage;

        public TwoViewHolder(@NonNull View itemView, final HttpZan httpZan) {
            super(itemView);
            quanimage1 = itemView.findViewById(R.id.quanimage1);
            quanimage2 = itemView.findViewById(R.id.quanimage2);
            quanimage3 = itemView.findViewById(R.id.quanimage3);
            quantext1 = itemView.findViewById(R.id.quantext1);
            quantext2 = itemView.findViewById(R.id.quantext2);
            quantext3 = itemView.findViewById(R.id.quantext3);
            priseimage = itemView.findViewById(R.id.priseimage);
            timetext = itemView.findViewById(R.id.timetext);


        }
    }

    private HttpZan mHttpZan;

    public void setHttpZan(HttpZan httpZan) {
        mHttpZan = httpZan;
    }

    public interface HttpZan {
        void getZan(View v, int position);
    }
}
