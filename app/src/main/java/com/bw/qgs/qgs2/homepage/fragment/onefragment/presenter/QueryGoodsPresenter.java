package com.bw.qgs.qgs2.homepage.fragment.onefragment.presenter;

import com.bw.qgs.qgs2.homepage.fragment.onefragment.model.QueryGoodsModel;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.view.OneFragmentOneView;

/**
 * date:2018/12/5    19:43
 * author:秦广帅(Lenovo)
 * fileName:QueryGoodsPresenter
 */
public class QueryGoodsPresenter {

    private OneFragmentOneView mOneFragmentOneView;
    private QueryGoodsModel mQueryGoodsModel;

    public QueryGoodsPresenter(OneFragmentOneView oneFragmentOneView) {
        mOneFragmentOneView = oneFragmentOneView;
        mQueryGoodsModel = new QueryGoodsModel();
    }

    public void goods(String url){
        mQueryGoodsModel.goods(url, new QueryGoodsModel.HttpCallBa() {
            @Override
            public void getGoods(String s) {
                if(s!=null){
                    mOneFragmentOneView.onQueryGoodsSuccess(s);
                }else{
                    mOneFragmentOneView.onFailer("失败");
                }
            }
        });
    }
}
