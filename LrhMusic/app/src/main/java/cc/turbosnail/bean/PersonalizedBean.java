package cc.turbosnail.bean;

import java.util.List;

import io.reactivex.Observable;

/**
 * 推荐歌单
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/24 22:06
 */
public class PersonalizedBean {
    /**
     * hasTaste : false
     * code : 200
     * category : 0
     * result : [{"id":5219028932,"type":0,"name":"复古潮流|文艺青年狂想曲","copywriter":"编辑推荐：霓虹灯光 闪烁在棕榈湾","picUrl":"http://p2.music.126.net/QZFCzJ82EO315TZ3LRcufA==/109951165293682494.jpg","canDislike":false,"trackNumberUpdateTime":1599207958709,"playCount":354008,"trackCount":34,"highQuality":false,"alg":"featured"},{"id":4931392807,"type":0,"name":"华语集 | 200首歌曲循环了整个青春时代","copywriter":"编辑推荐：手中的故事，散落的脚本","picUrl":"http://p2.music.126.net/cvmt4nmLFJfU35VDkxJl0A==/109951164833038560.jpg","canDislike":false,"trackNumberUpdateTime":1600906645561,"playCount":733671,"trackCount":200,"highQuality":false,"alg":"featured"},{"id":4938240728,"type":0,"name":"SPACE酒吧蹦迪必备曲「精选」","copywriter":"热门推荐","picUrl":"http://p2.music.126.net/ADndy2vey5j-2WmKvblQBw==/109951165093202265.jpg","canDislike":true,"trackNumberUpdateTime":1600918555574,"playCount":2140378,"trackCount":307,"highQuality":false,"alg":"cityLevel_unknow"},{"id":5041014031,"type":0,"name":"『孤独的对抗路』","copywriter":"热门推荐","picUrl":"http://p2.music.126.net/SrZvRjTf4YKC2ojQtbhYaw==/109951165041677116.jpg","canDislike":true,"trackNumberUpdateTime":1600949473874,"playCount":455623,"trackCount":79,"highQuality":false,"alg":"cityLevel_unknow"},{"id":4988043536,"type":0,"name":"你的眼里只有星星却没有我","copywriter":"热门推荐","picUrl":"http://p2.music.126.net/83qAY9x_nwAaB8ye0cl5-Q==/109951165340316542.jpg","canDislike":true,"trackNumberUpdateTime":1600953658488,"playCount":1029376,"trackCount":103,"highQuality":false,"alg":"cityLevel_unknow"},{"id":5019795031,"type":0,"name":"老歌越听越经典，旧人越看越无情","copywriter":"热门推荐","picUrl":"http://p2.music.126.net/oR-x5yhVagc1tOgQOWWLhg==/109951165159864749.jpg","canDislike":true,"trackNumberUpdateTime":1600207771655,"playCount":238117,"trackCount":541,"highQuality":false,"alg":"cityLevel_unknow"}]
     */

    private boolean hasTaste;
    private int code;
    private int category;
    private List<ResultBean> result;

    public boolean isHasTaste() {
        return hasTaste;
    }

    public void setHasTaste(boolean hasTaste) {
        this.hasTaste = hasTaste;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 5219028932
         * type : 0
         * name : 复古潮流|文艺青年狂想曲
         * copywriter : 编辑推荐：霓虹灯光 闪烁在棕榈湾
         * picUrl : http://p2.music.126.net/QZFCzJ82EO315TZ3LRcufA==/109951165293682494.jpg
         * canDislike : false
         * trackNumberUpdateTime : 1599207958709
         * playCount : 354008.0
         * trackCount : 34
         * highQuality : false
         * alg : featured
         */

        private long id;
        private int type;
        private String name;
        private String copywriter;
        private String picUrl;
        private boolean canDislike;
        private long trackNumberUpdateTime;
        private double playCount;
        private int trackCount;
        private boolean highQuality;
        private String alg;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCopywriter() {
            return copywriter;
        }

        public void setCopywriter(String copywriter) {
            this.copywriter = copywriter;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public boolean isCanDislike() {
            return canDislike;
        }

        public void setCanDislike(boolean canDislike) {
            this.canDislike = canDislike;
        }

        public long getTrackNumberUpdateTime() {
            return trackNumberUpdateTime;
        }

        public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
            this.trackNumberUpdateTime = trackNumberUpdateTime;
        }

        public double getPlayCount() {
            return playCount;
        }

        public void setPlayCount(double playCount) {
            this.playCount = playCount;
        }

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public boolean isHighQuality() {
            return highQuality;
        }

        public void setHighQuality(boolean highQuality) {
            this.highQuality = highQuality;
        }

        public String getAlg() {
            return alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }
    }
}
