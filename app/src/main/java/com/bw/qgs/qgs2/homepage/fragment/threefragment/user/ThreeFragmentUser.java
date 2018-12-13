package com.bw.qgs.qgs2.homepage.fragment.threefragment.user;

import java.util.List;

/**
 * date:2018/12/13    19:09
 * author:秦广帅(Lenovo)
 * fileName:ThreeFragmentUser
 */
public class ThreeFragmentUser {

    /**
     * result : [{"commodityId":24,"commodityName":"百搭小白鞋 女款 时尚舒适板鞋","count":5,"pic":"http://172.17.8.100/images/small/commodity/nx/bx/7/1.jpg","price":149}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commodityId : 24
         * commodityName : 百搭小白鞋 女款 时尚舒适板鞋
         * count : 5
         * pic : http://172.17.8.100/images/small/commodity/nx/bx/7/1.jpg
         * price : 149
         */

        private int commodityId;
        private String commodityName;
        private int count;
        private String pic;
        private int price;

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityName() {
            return commodityName;
        }

        public void setCommodityName(String commodityName) {
            this.commodityName = commodityName;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
