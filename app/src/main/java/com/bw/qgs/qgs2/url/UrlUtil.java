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
    public String CICLE = "http://172.17.8.100/small/circle/v1/findCircleList?page=1&count=99";
    public String WALLET = "http://172.17.8.100/small/user/verify/v1/findUserWallet?page=1&count=0";
    public String BANNER = "http://172.17.8.100/small/commodity/v1/bannerShow";
    public String FOOTER = "http://172.17.8.100/small/commodity/verify/v1/browseList?page=1&count=99";
    public String MYCIRCLE = "http://172.17.8.100/small/circle/verify/v1/findMyCircleById?page=1&count=5";
    //  商品详情
    public String GOODSPARTICU = "http://172.17.8.100/small/commodity/v1/findCommodityDetailsById?commodityId=";
    //查询
    public String QUERY = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?page=1&count=99&keyword=";
    public String ADDRESS = "http://172.17.8.100/small/user/verify/v1/receiveAddressList";
    public String YIJI = "http://172.17.8.100/small/commodity/v1/findFirstCategory";
    public String XINZENG1 = "http://172.17.8.100/small/user/verify/v1/addReceiveAddress?realName=";
    public String XINZENG2 = "&phone=";
    public String XINZENG3 = "&address=";
    public String XINZENG4 = "&zipCode=";
    public String MOREN = "http://172.17.8.100/small/user/verify/v1/setDefaultReceiveAddress?id=";
    //总
    public String ZONG = "http://172.17.8.100/";
    //修改昵称
    public String UPDATANAME = "modifyUserNick?nickName=";
    //点赞
    public String ZAN = "small/circle/verify/v1/addCircleGreat";
    //修改昵称http://172.17.8.100/small/user/verify/v1/modifyUserNick
    public String NAME = "small/user/verify/v1/modifyUserNick";
    //修改收货信息http://172.17.8.100/small/user/verify/v1/changeReceiveAddress
    public String UPDATAADDRESS = "small/user/verify/v1/changeReceiveAddress";
    //修改密码 http://172.17.8.100/small/user/verify/v1/modifyUserPwd
    public String PWD = "small/user/verify/v1/modifyUserPwd";
    //同步购物车 http://172.17.8.100/small/order/verify/v1/syncShoppingCart
    public String SHOPCAR = "small/order/verify/v1/syncShoppingCart";
    //购物车http://172.17.8.100/small/order/verify/v1/findShoppingCart
    public String THREESHOPCAR= "small/order/verify/v1/findShoppingCart";
}
