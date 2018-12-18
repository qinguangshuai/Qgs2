package com.bw.qgs.qgs2.homepage.fragment.threefragment.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.custom.AddSub;
import com.bw.qgs.qgs2.homepage.fragment.threefragment.user.ThreeFragmentUser;
import com.daimajia.swipe.SwipeLayout;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2018/12/13    19:17
 * author:秦广帅(Lenovo)
 * fileName:ThreeFragmentAdapter
 */
public class ThreeFragmentAdapter extends RecyclerView.Adapter<ThreeFragmentAdapter.MyViewHolder> {

    private Context mContext;
    private List<ThreeFragmentUser.ResultBean> mResult1;
    private AddSub.OnNumChangedListener mOnNumChangedListener;

    public List<ThreeFragmentUser.ResultBean> getResult1() {
        return mResult1;
    }

    public void setOnNumChangedListener(AddSub.OnNumChangedListener onNumChangedListener) {
        mOnNumChangedListener = onNumChangedListener;
    }

    public ThreeFragmentAdapter(Context context, List<ThreeFragmentUser.ResultBean> result1) {
        mContext = context;
        mResult1 = result1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.threeshop, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view,mCheckDan);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        final ThreeFragmentUser.ResultBean bean = mResult1.get(i);
        Uri uri = Uri.parse(bean.getPic());
        myViewHolder.threesimple.setImageURI(uri);
        myViewHolder.threett1.setText(bean.getCommodityName());
        myViewHolder.threett2.setText(bean.getPrice() + "");
        myViewHolder.allcheckbox.setChecked(bean.isChecked());
        myViewHolder.addsub.setOnNumChangedListener(new AddSub.OnNumChangedListener() {
            @Override
            public void onNumChange(View view, int curNum) {
                bean.setCount(curNum);
                if (mOnNumChangedListener != null) {
                    mOnNumChangedListener.onNumChange(view, curNum);
                }
            }
        });
        myViewHolder.swipe.setShowMode(SwipeLayout.ShowMode.LayDown);
        myViewHolder.swipe.addDrag(SwipeLayout.DragEdge.Left, myViewHolder.bottom_wrapper);
        myViewHolder.swipe.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onStartOpen(SwipeLayout layout) {

            }

            @Override
            public void onOpen(SwipeLayout layout) {

            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onClose(SwipeLayout layout) {

            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mResult1.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView threesimple;
        TextView threett1, threett2;
        AddSub addsub;
        CheckBox allcheckbox;
        SwipeLayout swipe;
        LinearLayout bottom_wrapper;

        public MyViewHolder(@NonNull View itemView, final checkDan checkDan) {
            super(itemView);
            threesimple = itemView.findViewById(R.id.threesimple);
            swipe = itemView.findViewById(R.id.swipe);
            bottom_wrapper = itemView.findViewById(R.id.bottom_wrapper);
            threett1 = itemView.findViewById(R.id.threett1);
            threett2 = itemView.findViewById(R.id.threett2);
            addsub = itemView.findViewById(R.id.addsub);
            allcheckbox = itemView.findViewById(R.id.allcheckbox);
            allcheckbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkDan.getId(getAdapterPosition());
                }
            });
        }
    }

    private checkDan mCheckDan;

    public void setCheckDan(checkDan checkDan) {
        mCheckDan = checkDan;
    }

    public interface checkDan{
        void getId(int position);
    }
}
