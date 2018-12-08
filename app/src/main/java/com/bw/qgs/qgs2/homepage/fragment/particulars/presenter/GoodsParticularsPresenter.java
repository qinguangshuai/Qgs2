package com.bw.qgs.qgs2.homepage.fragment.particulars.presenter;

import com.bw.qgs.qgs2.homepage.fragment.particulars.bean.Particulars;
import com.bw.qgs.qgs2.homepage.fragment.particulars.model.GoodsParticularModel;
import com.bw.qgs.qgs2.homepage.fragment.particulars.view.GoodsParticularView;

/**
 * date:2018/12/8    14:53
 * author:秦广帅(Lenovo)
 * fileName:GoodsParticularsPresenter
 */
public class GoodsParticularsPresenter {

    private GoodsParticularView mGoodsParticularView;
    private GoodsParticularModel mGoodsParticularModel;

    public GoodsParticularsPresenter(GoodsParticularView goodsParticularView) {
        mGoodsParticularView = goodsParticularView;
        mGoodsParticularModel = new GoodsParticularModel();
    }

    public void par(String url){
        mGoodsParticularModel.par(url, new GoodsParticularModel.HttpGoodsBack() {
            @Override
            public void getGoodsData(Particulars.ResultBean resultBean) {
                if (resultBean!=null){
                    mGoodsParticularView.onGoodsParticuSuccess(resultBean);
                }else{
                    mGoodsParticularView.onGoodsParticuFailer("失败");
                }
            }
        });
    }
}
