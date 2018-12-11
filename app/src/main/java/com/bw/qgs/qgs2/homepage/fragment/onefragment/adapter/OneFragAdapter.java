package com.bw.qgs.qgs2.homepage.fragment.onefragment.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.BannerUser;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.bean.TwoAdapterBean;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.ding.ZoomOutPageTransformer;
import com.bw.qgs.qgs2.homepage.fragment.particulars.GoodsParticularsActivity;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2018/12/2    19:39
 * author:秦广帅(Lenovo)
 * fileName:OneFragAdapter
 */
public class OneFragAdapter extends RecyclerView.Adapter {

    public static final int TYPE_ONE = 0;
    public static final int TYPE_TWO = 1;
    public static final int TYPE_THREE = 2;
    public static final int TYPE_FOUR = 3;

    private Context mContext;
    private TwoAdapterBean.ResultBean list;
    private List<BannerUser.ResultBean> mResultBean;
    private HttpOnClick mHttpOnClick;

    public void setHttpOnClick(HttpOnClick httpOnClick) {
        mHttpOnClick = httpOnClick;
    }

    public OneFragAdapter(Context context, TwoAdapterBean.ResultBean list, List<BannerUser.ResultBean> resultBean) {
        mContext = context;
        this.list = list;
        mResultBean = resultBean;
    }

    public void setList(TwoAdapterBean.ResultBean list) {
        this.list = list;
    }

    public void setResultBean(List<BannerUser.ResultBean> resultBean) {
        this.mResultBean = resultBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (i == TYPE_ONE) {
            view = LayoutInflater.from(mContext).inflate(R.layout.one, viewGroup, false);
            return new OneViewHolder(view);
        } else if (i == TYPE_TWO) {
            view = LayoutInflater.from(mContext).inflate(R.layout.two, viewGroup, false);
            return new TwoViewHolder(view,mHttpOnClick);
        } else if (i == TYPE_THREE) {
            view = LayoutInflater.from(mContext).inflate(R.layout.three, viewGroup, false);
            return new ThreeViewHolder(view,mHttpOnClick);
        } else {
            view = LayoutInflater.from(mContext).inflate(R.layout.four, viewGroup, false);
            return new FourViewHolder(view,mHttpOnClick);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof OneViewHolder) {
            ImageAdapter imageAdapter = new ImageAdapter(mContext,mResultBean);
            ((OneViewHolder) viewHolder).text1.setPageMargin(10);
            ((OneViewHolder) viewHolder).text1.setOffscreenPageLimit(10);
            ((OneViewHolder) viewHolder).text1.setAdapter(imageAdapter);
            ((OneViewHolder) viewHolder).mHandler.sendEmptyMessage(0);
            ((OneViewHolder) viewHolder).text1.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()){
                        //按下状态
                        case MotionEvent.ACTION_DOWN:
                            //销毁
                            ((OneViewHolder) viewHolder).mHandler.removeMessages(0);
                            break;
                        //移动状态
                        case MotionEvent.ACTION_MOVE:
                            //销毁
                            ((OneViewHolder) viewHolder).mHandler.removeMessages(0);
                            break;
                        //抬起状态
                        case MotionEvent.ACTION_UP:
                            //换界面
                            ((OneViewHolder) viewHolder).mHandler.sendEmptyMessageDelayed(0,2000);
                            break;
                    }
                    return false;
                }
            });
            ((OneViewHolder) viewHolder).text1.setPageTransformer(true,new ZoomOutPageTransformer());
            ((OneViewHolder) viewHolder).text1.setCurrentItem(Integer.MAX_VALUE/2-4);
            /*List<String> mBeanList = new ArrayList<>();

            for (int j=0;j<mResultBean.size();j++){
                mBeanList.add(mResultBean.get(j).getImageUrl());
            }
            ((OneViewHolder) viewHolder).text1.setOffscreenPageLimit(1);
            *//*mBeanList.add("http://172.17.8.100/htm/lottery/index.html");
            mBeanList.add("http://172.17.8.100/images/small/banner/hzp.png");
            mBeanList.add("http://172.17.8.100/images/small/banner/lyq.png");
            mBeanList.add("http://172.17.8.100/images/small/banner/px.png");
            mBeanList.add("http://172.17.8.100/images/small/banner/wy.png");*//*
            //((OneViewHolder) viewHolder).text1.setOffscreenPageLimit(3);
            ((OneViewHolder) viewHolder).text1.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Picasso.with(mContext).load((String) path).into(imageView);
                }
            });
            ((OneViewHolder) viewHolder).text1.setImages(mBeanList);
            ((OneViewHolder) viewHolder).text1.setDelayTime(1000);
            ((OneViewHolder) viewHolder).text1.start();*/
        }
        if (viewHolder instanceof TwoViewHolder) {
            ((TwoViewHolder) viewHolder).text2.setText(list.getRxxp().get(0).getName());
            GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3);
            ((TwoViewHolder) viewHolder).tworecycle.setLayoutManager(gridLayoutManager);
            List<TwoAdapterBean.ResultBean.RxxpBean> rxxp = list.getRxxp();
            final TwoAdapterBean.ResultBean.RxxpBean rxxpBean = rxxp.get(0);
            ((TwoViewHolder) viewHolder).text2.setText(rxxpBean.getName());
            List<TwoAdapterBean.ResultBean.RxxpBean.CommodityListBean> commodityList = rxxpBean.getCommodityList();
            TwoAdapter twoAdapter = new TwoAdapter(mContext, commodityList);
            twoAdapter.setHttpOnClick(new TwoAdapter.HttpOnClick() {
                @Override
                public void click(View view, int position) {
                    Toast.makeText(mContext,"111",Toast.LENGTH_SHORT).show();
                }
            });
            ((TwoViewHolder) viewHolder).tworecycle.setAdapter(twoAdapter);
        }
        if (viewHolder instanceof ThreeViewHolder) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
            ((ThreeViewHolder) viewHolder).recycle3.setLayoutManager(linearLayoutManager);
            List<TwoAdapterBean.ResultBean.MlssBean> mlss = list.getMlss();
            TwoAdapterBean.ResultBean.MlssBean mlssBean = mlss.get(0);
            ((ThreeViewHolder) viewHolder).text3.setText(mlssBean.getName());
            List<TwoAdapterBean.ResultBean.MlssBean.CommodityListBeanXX> commodityList = mlssBean.getCommodityList();
            ThreeAdapter threeAdapter = new ThreeAdapter(mContext, commodityList);
            threeAdapter.setHttpOnClick(new ThreeAdapter.HttpOnClick() {
                @Override
                public void click(View view, int position) {
                    Toast.makeText(mContext,"111",Toast.LENGTH_SHORT).show();
                    mContext.startActivity(new Intent(mContext,GoodsParticularsActivity.class));
                }
            });
            ((ThreeViewHolder) viewHolder).recycle3.setAdapter(threeAdapter);
        }
        if (viewHolder instanceof FourViewHolder) {
            GridLayoutManager linearLayoutManager = new GridLayoutManager(mContext,2);
            ((FourViewHolder) viewHolder).recycle4.setLayoutManager(linearLayoutManager);
            List<TwoAdapterBean.ResultBean.PzshBean> pzsh = list.getPzsh();
            TwoAdapterBean.ResultBean.PzshBean pzshBean = pzsh.get(0);
            ((FourViewHolder) viewHolder).text4.setText(pzshBean.getName());
            List<TwoAdapterBean.ResultBean.PzshBean.CommodityListBeanX> commodityList = pzshBean.getCommodityList();
            FourAdapter fourAdapter = new FourAdapter(mContext, commodityList);
            fourAdapter.setHttpOnClick(new FourAdapter.HttpOnClick() {
                @Override
                public void click(View view, int position) {
                    Toast.makeText(mContext,"111",Toast.LENGTH_SHORT).show();
                    mContext.startActivity(new Intent(mContext,GoodsParticularsActivity.class));
                }
            });
            ((FourViewHolder) viewHolder).recycle4.setAdapter(fourAdapter);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_ONE;
        } else if (position == 1) {
            return TYPE_TWO;
        } else if (position == 2) {
            return TYPE_THREE;
        } else {
            return TYPE_FOUR;
        }
    }

    @Override
    public long getItemId(int position) {
        return getItemId(position);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public void setdata(TwoAdapterBean.ResultBean resultBeans) {
        this.list = resultBeans;
    }


    class OneViewHolder extends RecyclerView.ViewHolder {

        ViewPager text1;

        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.onetextView);
        }
        Handler mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                text1.setCurrentItem(text1.getCurrentItem()+1);
                mHandler.sendEmptyMessageDelayed(0,2000);
            }
        };
    }

    class TwoViewHolder extends RecyclerView.ViewHolder {

        TextView text2;
        RecyclerView tworecycle;

        public TwoViewHolder(@NonNull View itemView, final HttpOnClick httpOnClick) {
            super(itemView);
            text2 = itemView.findViewById(R.id.twotextView);
            tworecycle = itemView.findViewById(R.id.tworecycle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    httpOnClick.click(v,list.getRxxp().get(0).getId());
                }
            });
        }
    }

    class ThreeViewHolder extends RecyclerView.ViewHolder {

        TextView text3;
        RecyclerView recycle3;

        public ThreeViewHolder(@NonNull View itemView, final HttpOnClick httpOnClick) {
            super(itemView);
            text3 = itemView.findViewById(R.id.threetextView);
            recycle3 = itemView.findViewById(R.id.threerecycle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    httpOnClick.click(v,getAdapterPosition());
                }
            });
        }
    }

    class FourViewHolder extends RecyclerView.ViewHolder {

        TextView text4;
        RecyclerView recycle4;

        public FourViewHolder(@NonNull View itemView, final HttpOnClick httpOnClick) {
            super(itemView);
            text4 = itemView.findViewById(R.id.fourtextView);
            recycle4 = itemView.findViewById(R.id.threerecycle);
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
