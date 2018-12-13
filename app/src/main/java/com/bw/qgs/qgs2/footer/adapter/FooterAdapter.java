package com.bw.qgs.qgs2.footer.adapter;

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
import com.bw.qgs.qgs2.footer.bean.FooterUser;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * date:2018/12/6    10:00
 * author:秦广帅(Lenovo)
 * fileName:FooterAdapter
 */
public class FooterAdapter extends RecyclerView.Adapter<FooterAdapter.MyViewHolder> {

    private Context mContext;
    private List<FooterUser.ResultBean> list;

    public FooterAdapter(Context context, List<FooterUser.ResultBean> list) {
        mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.footer, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        FooterUser.ResultBean bean = list.get(i);
        Uri uri = Uri.parse(bean.getMasterPic());
        myViewHolder.image.setImageURI(uri);
        myViewHolder.text.setText(bean.getCommodityName());
        long browseTime = bean.getBrowseTime();
        GregorianCalendar gc = new GregorianCalendar();
        String s = String.valueOf(browseTime);
        gc.setTimeInMillis(Long.parseLong(s));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        myViewHolder.text1.setText(df.format(gc.getTime()));
        if(i!=0){
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(myViewHolder.image.getLayoutParams());
            params.setMargins(0,100,0,0);
            myViewHolder.image.setLayoutParams(params);
        }else{
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(myViewHolder.image.getLayoutParams());
            params.setMargins(0,20,0,0);
            myViewHolder.image.setLayoutParams(params);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView image;
        TextView text,text1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.footerimageView);
            text = itemView.findViewById(R.id.footertextView);
            text1 = itemView.findViewById(R.id.footertextView1);
        }
    }
}
