package cc.turbosnail.bean;

import java.util.List;

/**
 * 独家放送
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/24 22:05
 */
public class PrivatecontentBean {

    /**
     * code : 200
     * name : 独家放送
     * result : [{"id":10958212,"url":"","picUrl":"http://p2.music.126.net/zbVtyzxfBSD-w-aOU5wDBA==/109951165334336093.jpg","sPicUrl":"http://p2.music.126.net/2mUlaFM6nnhquMBZy1qxpg==/109951165334327450.jpg","type":5,"copywriter":"乘风飞翔EP7: 钱正昊朗读莎士比亚《我怎么能够把你来比作夏天？》","name":"乘风飞翔EP7: 钱正昊朗读莎士比亚《我怎么能够把你来比作夏天？》","alg":"featured"},{"id":10955576,"url":"","picUrl":"http://p1.music.126.net/BcIVHU0_1iaTC3mmp0k9GA==/109951165325159357.jpg","sPicUrl":"http://p1.music.126.net/8br1im9pwLAd3Iz5omiFYA==/109951165325169038.jpg","type":5,"copywriter":"独家专访毛晓彤：\u201c挖土少年\u201d的华丽冒险","name":"独家专访毛晓彤：\u201c挖土少年\u201d的华丽冒险","alg":"featured"},{"id":10957223,"url":"","picUrl":"http://p1.music.126.net/B__2MT1cE_qr3AWwMEh0yw==/109951165319633711.jpg","sPicUrl":"http://p1.music.126.net/AgnDbZdqJL9EQa5DjBiczQ==/109951165319628383.jpg","type":5,"copywriter":"不曾遗忘的符号EP2痛仰：西湖重又临","name":"不曾遗忘的符号EP2痛仰：西湖重又临","alg":"featured"}]
     */

    private int code;
    private String name;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 10958212
         * url :
         * picUrl : http://p2.music.126.net/zbVtyzxfBSD-w-aOU5wDBA==/109951165334336093.jpg
         * sPicUrl : http://p2.music.126.net/2mUlaFM6nnhquMBZy1qxpg==/109951165334327450.jpg
         * type : 5
         * copywriter : 乘风飞翔EP7: 钱正昊朗读莎士比亚《我怎么能够把你来比作夏天？》
         * name : 乘风飞翔EP7: 钱正昊朗读莎士比亚《我怎么能够把你来比作夏天？》
         * alg : featured
         */

        private int id;
        private String url;
        private String picUrl;
        private String sPicUrl;
        private int type;
        private String copywriter;
        private String name;
        private String alg;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getSPicUrl() {
            return sPicUrl;
        }

        public void setSPicUrl(String sPicUrl) {
            this.sPicUrl = sPicUrl;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getCopywriter() {
            return copywriter;
        }

        public void setCopywriter(String copywriter) {
            this.copywriter = copywriter;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAlg() {
            return alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }
    }
}
