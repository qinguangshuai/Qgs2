package com.bw.qgs.qgs2.footer.presenter;

import com.bw.qgs.qgs2.footer.model.FooterModel;
import com.bw.qgs.qgs2.footer.view.FooterView;

/**
 * date:2018/12/6    9:53
 * author:秦广帅(Lenovo)
 * fileName:FooterPresenter
 */
public class FooterPresenter {

    private FooterView mFooterView;
    private FooterModel mFooterModel;

    public FooterPresenter(FooterView footerView) {
        mFooterView = footerView;
        mFooterModel = new FooterModel();
    }

    public void shoe(String url){
        mFooterModel.footer(url, new FooterModel.HttpFooterCallBack() {
            @Override
            public void getFooterData(String s) {
                if(s!=null){
                    mFooterView.onFooterSuccess(s);
                }else{
                    mFooterView.onFooterFailer("失败");
                }
            }
        });
    }

    public void onDestory(){
        if(mFooterView!=null){
            mFooterView=null;
        }
        mFooterModel.onDestory();
    }
}
