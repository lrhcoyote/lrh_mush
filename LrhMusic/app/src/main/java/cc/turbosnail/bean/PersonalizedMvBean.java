package cc.turbosnail.bean;

import java.util.List;

/**
 * 推荐 mv
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/25 16:44
 */
public class PersonalizedMvBean {

    /**
     * code : 200
     * category : 3
     * result : [{"id":10959773,"type":5,"name":"当你说","copywriter":"编辑推荐：想说的没说的，都将在日后记忆里发酵~","picUrl":"http://p2.music.126.net/hGdUvOFmoPNb_quD6-J2og==/109951165342849136.jpg","canDislike":false,"trackNumberUpdateTime":null,"duration":228000,"playCount":1547,"subed":false,"artists":[{"id":13699074,"name":"黄智毅"}],"artistName":"黄智毅","artistId":13699074,"alg":"featured"},{"id":10959674,"type":5,"name":"平妖往事","copywriter":"编辑推荐：复古港风，一道一僧，快意恩仇","picUrl":"http://p2.music.126.net/NoDgOkiOjceMJ1CpYKE2uA==/109951165339199941.jpg","canDislike":false,"trackNumberUpdateTime":null,"duration":167000,"playCount":12557,"subed":false,"artists":[{"id":36026361,"name":"刘畅"}],"artistName":"刘畅","artistId":36026361,"alg":"featured"},{"id":10960717,"type":5,"name":"If Only","copywriter":"最新热门MV推荐","picUrl":"http://p1.music.126.net/m0yTpd62_NJ4wQS-nEY2og==/109951165341348194.jpg","canDislike":true,"trackNumberUpdateTime":null,"duration":209000,"playCount":2485,"subed":false,"artists":[{"id":27875991,"name":"LayFullStop"}],"artistName":"LayFullStop","artistId":27875991,"alg":"hot_server"},{"id":10960725,"type":5,"name":"记号","copywriter":"最新热门MV推荐","picUrl":"http://p1.music.126.net/cxgG50e-vVKYJjoXSWk_CA==/109951165341392122.jpg","canDislike":true,"trackNumberUpdateTime":null,"duration":0,"playCount":456,"subed":false,"artists":[{"id":29821356,"name":"邓泽鸣"}],"artistName":"邓泽鸣","artistId":29821356,"alg":"hot_server"}]
     */

    private int code;
    private int category;
    private List<ResultBean> result;

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
         * id : 10959773
         * type : 5
         * name : 当你说
         * copywriter : 编辑推荐：想说的没说的，都将在日后记忆里发酵~
         * picUrl : http://p2.music.126.net/hGdUvOFmoPNb_quD6-J2og==/109951165342849136.jpg
         * canDislike : false
         * trackNumberUpdateTime : null
         * duration : 228000
         * playCount : 1547
         * subed : false
         * artists : [{"id":13699074,"name":"黄智毅"}]
         * artistName : 黄智毅
         * artistId : 13699074
         * alg : featured
         */

        private int id;
        private int type;
        private String name;
        private String copywriter;
        private String picUrl;
        private boolean canDislike;
        private Object trackNumberUpdateTime;
        private int duration;
        private int playCount;
        private boolean subed;
        private String artistName;
        private int artistId;
        private String alg;
        private List<ArtistsBean> artists;

        public int getId() {
            return id;
        }

        public void setId(int id) {
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

        public Object getTrackNumberUpdateTime() {
            return trackNumberUpdateTime;
        }

        public void setTrackNumberUpdateTime(Object trackNumberUpdateTime) {
            this.trackNumberUpdateTime = trackNumberUpdateTime;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public boolean isSubed() {
            return subed;
        }

        public void setSubed(boolean subed) {
            this.subed = subed;
        }

        public String getArtistName() {
            return artistName;
        }

        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public int getArtistId() {
            return artistId;
        }

        public void setArtistId(int artistId) {
            this.artistId = artistId;
        }

        public String getAlg() {
            return alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }

        public List<ArtistsBean> getArtists() {
            return artists;
        }

        public void setArtists(List<ArtistsBean> artists) {
            this.artists = artists;
        }

        public static class ArtistsBean {
            /**
             * id : 13699074
             * name : 黄智毅
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
