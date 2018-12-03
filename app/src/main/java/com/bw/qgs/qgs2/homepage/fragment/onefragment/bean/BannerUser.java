package com.bw.qgs.qgs2.homepage.fragment.onefragment.bean;

import java.util.List;

/**
 * date:2018/12/3    10:36
 * author:秦广帅(Lenovo)
 * fileName:BannerUser
 */
public class BannerUser {

    /**
     * result : [{"imageUrl":"http://172.17.8.100/images/tech/banner/20181026151647.png","jumpUrl":"http://172.17.8.100/htm/lottery/index.html","rank":5,"title":"抽奖"},{"imageUrl":"http://172.17.8.100/images/tech/banner/20181026151647.png","jumpUrl":"http://172.17.8.100/htm/lottery/index.html","rank":5,"title":"再抽奖"}]
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
         * imageUrl : http://172.17.8.100/images/tech/banner/20181026151647.png
         * jumpUrl : http://172.17.8.100/htm/lottery/index.html
         * rank : 5
         * title : 抽奖
         */

        private String imageUrl;
        private String jumpUrl;
        private int rank;
        private String title;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
