package com.bw.qgs.qgs2.myaddress.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.myaddress.bean.AddressUser;
import com.bw.qgs.qgs2.wallet.bean.WalletUser;

import java.util.List;

/**
 * date:2018/12/5    8:18
 * author:秦广帅(Lenovo)
 * fileName:WalletAdapter
 */
public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.MyViewHolder> {

    private Context mContext;
    private List<AddressUser.ResultBean> mResult1;
    private HttpOnClick mHttpOnClick;
    private HttpXiuOnClick mHttpXiuOnClick;

    public void setHttpXiuOnClick(HttpXiuOnClick httpXiuOnClick) {
        mHttpXiuOnClick = httpXiuOnClick;
    }

    public void setHttpOnClick(HttpOnClick httpOnClick) {
        mHttpOnClick = httpOnClick;
    }

    public AddressAdapter(Context context, List<AddressUser.ResultBean> result1) {
        mContext = context;
        mResult1 = result1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.address, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view,mHttpOnClick,mHttpXiuOnClick);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        final AddressUser.ResultBean bean = mResult1.get(i);
        myViewHolder.addresstext1.setText(bean.getRealName());
        myViewHolder.addresstext2.setText(bean.getPhone());
        myViewHolder.addressbtext3.setText(bean.getAddress());
        myViewHolder.addressbtext4.setText(bean.getZipCode());
        myViewHolder.addressbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bean!=null){
                    mResult1.remove(i);
                    notifyItemRemoved(i);
                    notifyDataSetChanged();
                }else{
                    Toast.makeText(mContext,"11111",Toast.LENGTH_SHORT).show();
                }
            }
        });
        /*myViewHolder.addressbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mContext.startActivity(new Intent(mContext,Upda));
                mHttpOnClick.click(v,bean.getId());
            }
        });*/
        myViewHolder.addressbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void removeId(int position){
        mResult1.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mResult1.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView addresstext1,addresstext2,addressbtext3,addressbtext4;
        Button addressbtn2,addressbtn1;
        CheckBox addressbox;

        public MyViewHolder(@NonNull View itemView, final HttpOnClick httpOnClick, final HttpXiuOnClick httpXiuOnClick) {
            super(itemView);
            addresstext1 = itemView.findViewById(R.id.addresstext1);
            addresstext2 = itemView.findViewById(R.id.addresstext2);
            addressbtext3 = itemView.findViewById(R.id.addressbtext3);
            addressbtext4 = itemView.findViewById(R.id.addressbtext4);
            addressbtn2 = itemView.findViewById(R.id.addressbtn2);
            addressbtn1 = itemView.findViewById(R.id.addressbtn1);
            addressbox = itemView.findViewById(R.id.addressbox);
            addressbtn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    httpOnClick.click(v,getAdapterPosition());
                }
            });
            addressbtn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    httpXiuOnClick.click(v,getAdapterPosition());
                }
            });
        }
    }

    public interface HttpOnClick{
        void click(View view,int position);
    }

    public interface HttpXiuOnClick{
        void click(View view,int position);
    }
}
