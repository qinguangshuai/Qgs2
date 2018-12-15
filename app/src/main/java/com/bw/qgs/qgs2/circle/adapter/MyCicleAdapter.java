package com.bw.qgs.qgs2.circle.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.circle.bean.CicleUser;
import com.bw.qgs.qgs2.footer.adapter.FooterAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

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
        MyViewHolder holder = new MyViewHolder(view,mHttpDelete);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        final CicleUser.ResultBean bean = list.get(i);
        Uri uri = Uri.parse(bean.getHeadPic());
        myViewHolder.image.setImageURI(uri);
        myViewHolder.text.setText(bean.getContent());
        myViewHolder.creatcount.setText(bean.getGreatNum()+"");
        /*myViewHolder.deletecicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bean!=null){
                    list.remove(i);
                    notifyItemRemoved(i);
                    notifyDataSetChanged();
                }else{
                    Toast.makeText(mContext,"11111",Toast.LENGTH_SHORT).show();
                }
            }
        });*/
        myViewHolder.deleterb.clearAnimation();
    }

    public void removeId(int position){
        list.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text,creatcount;
        SimpleDraweeView image;
        ImageView deletecicle;
        RadioButton deleterb;

        public MyViewHolder(@NonNull View itemView, final HttpDelete httpDelete) {
            super(itemView);
            text = itemView.findViewById(R.id.circletextView);
            creatcount = itemView.findViewById(R.id.creatcount);
            image = itemView.findViewById(R.id.circleimageView);
            deletecicle = itemView.findViewById(R.id.deletecicle);
            deleterb = itemView.findViewById(R.id.deleterb);
            deleterb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    httpDelete.getDelete(getAdapterPosition());
                }
            });
        }
    }

    private HttpDelete mHttpDelete;

    public void setHttpDelete(HttpDelete httpDelete) {
        mHttpDelete = httpDelete;
    }

    public interface HttpDelete{
        void getDelete(int position);
    }
}
