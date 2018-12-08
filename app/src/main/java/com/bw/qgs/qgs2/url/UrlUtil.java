package com.bw.qgs.qgs2.url;

/**
 * date:2018/12/1    11:46
 * author:秦广帅(Lenovo)
 * fileName:UrlUtil
 */
public interface UrlUtil {
    //登录
    public String LOGIN1 = "http://172.17.8.100/small/user/v1/login?phone=";
    public String LOGIN2 = "&&pwd=";
    //注册
    public String REGIN1 = "http://172.17.8.100/small/user/v1/register?phone=";
    public String REGIN2 = "&&pwd=";
    public String ONE = "http://172.17.8.100/small/commodity/v1/commodityList";
    public String ONETIAO = "http://172.17.8.100/small/commodity/v1/findCommodityListByLabel?page=1&count=8&labelId=";
    public String CICLE = "http://172.17.8.100/small/circle/v1/findCircleList?page=1&count=5";
    public String WALLET = "http://172.17.8.100/small/user/verify/v1/findUserWallet?page=1&count=0";
    public String BANNER = "http://172.17.8.100/small/commodity/v1/bannerShow";
    public String FOOTER = "http://172.17.8.100/small/commodity/verify/v1/browseList?page=1&count=5";
    public String MYCIRCLE = "http://172.17.8.100/small/circle/verify/v1/findMyCircleById?page=1&count=5";
    //  商品详情
    public String GOODSPARTICU = "http://172.17.8.100/small/commodity/v1/findCommodityDetailsById?commodityId=6";
}
