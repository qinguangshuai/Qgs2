package com.bw.qgs.qgs2.homepage.fragment.particulars.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.qgs.qgs2.R;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.adapter.OneFragAdapter;
import com.bw.qgs.qgs2.homepage.fragment.particulars.bean.Particulars;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * date:2018/12/8    14:58
 * author:秦广帅(Lenovo)
 * fileName:GoodsParticularsAdapter
 */
public class GoodsParticularsAdapter extends RecyclerView.Adapter {

    public static final int TYPE_ONE = 0;
    public static final int TYPE_TWO = 1;

    private Context mContext;
    private Particulars.ResultBean resultBean;

    public void setResultBean(Particulars.ResultBean resultBean) {
        this.resultBean = resultBean;
    }

    public GoodsParticularsAdapter(Context context, Particulars.ResultBean resultBean) {
        mContext = context;
        this.resultBean = resultBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (i == TYPE_ONE) {
            view = LayoutInflater.from(mContext).inflate(R.layout.onegoods, viewGroup, false);
            return new MyViewHolder(view);
        }else{
            view = LayoutInflater.from(mContext).inflate(R.layout.twogoods, viewGroup, false);
            return new TwoViewHolder(view,mHttpAdd);
        }
        /*else if (i == TYPE_THREE){
            view = LayoutInflater.from(mContext).inflate(R.layout.threegoods, viewGroup, false);
            return new ThreeViewHolder(view);
        }else{
            view = LayoutInflater.from(mContext).inflate(R.layout.fourgoods, viewGroup, false);
            return new ThreeViewHolder(view);
        }*/
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MyViewHolder) {
            List<String> mBeanList = new ArrayList<>();
            String picture = resultBean.getPicture();
            String[] str = picture.split(",");
            for (int j = 0;j<str.length;j++){
                mBeanList.add(str[j]);
            }
            ((MyViewHolder) viewHolder).banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Picasso.with(context).load((String) path).into(imageView);
                }
            });
            ((MyViewHolder) viewHolder).banner.setImages(mBeanList);
            ((MyViewHolder) viewHolder).banner.setDelayTime(1000);
            ((MyViewHolder) viewHolder).banner.start();
        } else if (viewHolder instanceof TwoViewHolder) {
            ((TwoViewHolder) viewHolder).goodsprice.setText("" + resultBean.getPrice());
            ((TwoViewHolder) viewHolder).goodsxiao.setText(resultBean.getCategoryName());
            ((TwoViewHolder) viewHolder).goodsxiang.setText(resultBean.getCommodityName());
            ((TwoViewHolder) viewHolder).twogoodstext1.setText(resultBean.getCommodityName());
            ((TwoViewHolder) viewHolder).twogoodstext1.setText(resultBean.getDescribe());
            ((TwoViewHolder) viewHolder).twogoodstext2.setText(resultBean.getPrice()+"");
            ((TwoViewHolder) viewHolder).twogoodstext3.setText(resultBean.getCommodityName());
            ((TwoViewHolder) viewHolder).twogoodstext4.setText(resultBean.getCategoryName());
            String picture = resultBean.getPicture();
            String[] str = picture.split(",");
            Uri uri1 = Uri.parse(str[0]);
            Uri uri2 = Uri.parse(str[1]);
            ((TwoViewHolder) viewHolder).twogoodsimage.setImageURI(uri1);
            ((TwoViewHolder) viewHolder).twogoodsimage1.setImageURI(uri2);
        }
        /*else if (viewHolder instanceof ThreeViewHolder){
            String picture = resultBean.getPicture();
            String[] str = picture.split(",");
            Picasso.with(mContext).load(str[0]).into(((ThreeViewHolder) viewHolder).threegoodsimageView);
            ((ThreeViewHolder) viewHolder).threegoodstextView.setText(resultBean.getCommodityName());
        }else if (viewHolder instanceof FourViewHolder){
            String picture = resultBean.getPicture();
            String[] str = picture.split(",");
            Picasso.with(mContext).load(str[0]).into(((FourViewHolder) viewHolder).fourgoodsimageView);
            ((FourViewHolder) viewHolder).fourgoodstextView1.setText(resultBean.getCommodityName());
            ((FourViewHolder) viewHolder).fourgoodstextView2.setText(resultBean.getCategoryName());
            ((FourViewHolder) viewHolder).fourgoodstextView3.setText(resultBean.getDescribe());
            ((FourViewHolder) viewHolder).fourgoodstextView4.setText(resultBean.getPrice()+"");
        }*/
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_ONE;
        } else{
            return TYPE_TWO;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        Banner banner;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.goodsbanner);
        }
    }

    class TwoViewHolder extends RecyclerView.ViewHolder {

        TextView goodsprice, goodsxiao, goodsxiang,twogoodstext1,twogoodstext2,twogoodstext3,twogoodstext4,twogoodstext5;
        SimpleDraweeView twogoodsimage,twogoodsimage1;
        ImageView add,buy;

        public TwoViewHolder(@NonNull View itemView, final HttpAdd httpAdd) {
            super(itemView);
            goodsprice = itemView.findViewById(R.id.goodsprice);
            goodsxiao = itemView.findViewById(R.id.goodsxiao);
            goodsxiang = itemView.findViewById(R.id.goodsxiang);
            twogoodstext1 = itemView.findViewById(R.id.twogoodstext1);
            twogoodstext2 = itemView.findViewById(R.id.twogoodstext2);
            twogoodstext3 = itemView.findViewById(R.id.twogoodstext3);
            twogoodstext4 = itemView.findViewById(R.id.twogoodstext4);
            twogoodstext5 = itemView.findViewById(R.id.twogoodstext5);
            twogoodsimage = itemView.findViewById(R.id.twogoodsimage);
            twogoodsimage1 = itemView.findViewById(R.id.twogoodsimage1);
            add = itemView.findViewById(R.id.add);
            buy = itemView.findViewById(R.id.buy);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    httpAdd.getAdd(v,getAdapterPosition());
                }
            });
        }
    }

    /*class ThreeViewHolder extends RecyclerView.ViewHolder {

        ImageView threegoodsimageView;
        TextView threegoodstextView;

        public ThreeViewHolder(@NonNull View itemView) {
            super(itemView);
            threegoodsimageView = itemView.findViewById(R.id.threegoodsimageView);
            threegoodstextView = itemView.findViewById(R.id.threegoodstextView);
        }
    }

    class FourViewHolder extends RecyclerView.ViewHolder {

        ImageView fourgoodsimageView;
        TextView fourgoodstextView1,fourgoodstextView2,fourgoodstextView3,fourgoodstextView4;

        public FourViewHolder(@NonNull View itemView) {
            super(itemView);
            fourgoodsimageView = itemView.findViewById(R.id.fourgoodsimageView);
            fourgoodstextView1 = itemView.findViewById(R.id.fourgoodstextView1);
            fourgoodstextView2 = itemView.findViewById(R.id.fourgoodstextView2);
            fourgoodstextView3 = itemView.findViewById(R.id.fourgoodstextView3);
            fourgoodstextView4 = itemView.findViewById(R.id.fourgoodstextView4);
        }
    }*/

    private HttpAdd mHttpAdd;

    public void setHttpAdd(HttpAdd httpAdd) {
        mHttpAdd = httpAdd;
    }

    public interface HttpAdd{
        void getAdd(View v,int position);
    }
}
