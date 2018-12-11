package com.bw.qgs.qgs2.homepage.fragment.onefragment.presenter;

import com.bw.qgs.qgs2.homepage.fragment.onefragment.model.QueryModel;
import com.bw.qgs.qgs2.homepage.fragment.onefragment.view.OneFragmentOneView;

/**
 * date:2018/12/9    12:06
 * author:秦广帅(Lenovo)
 * fileName:QueryPresenter
 */
public class QueryPresenter {

    private OneFragmentOneView mOneFragmentOneView;
    private QueryModel mQueryModel;

    public QueryPresenter(OneFragmentOneView oneFragmentOneView) {
        mOneFragmentOneView = oneFragmentOneView;
        mQueryModel = new QueryModel();
    }

    public void query1(String url){
        mQueryModel.query1(url, new QueryModel.HttpQueryCallBa() {
            @Override
            public void getQueryGoods(String s) {
                if(s!=null){
                    mOneFragmentOneView.onQuerySuccess(s);
                }else{
                    mOneFragmentOneView.onFailer("失败");
                }
            }
        });
    }
}
