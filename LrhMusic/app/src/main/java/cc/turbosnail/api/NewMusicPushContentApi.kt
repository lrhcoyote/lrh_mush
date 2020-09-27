package cc.turbosnail.api

import cc.turbosnail.bean.PersonalizedBean
import cc.turbosnail.bean.PersonalizedMvBean
import cc.turbosnail.bean.PrivatecontentBean
import cc.turbosnail.network.BaseUrl
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 推送歌单的api
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/11 13:36
 */
@BaseUrl("http://musicapi.leanapp.cn")
interface NewMusicPushContentApi {
    //推荐歌单
    @GET("/personalized")
    fun getPersonalized(@Query("limit") limit: Int): Observable<PersonalizedBean> //独家推送
    //独家放送
    @GET("/personalized/privatecontent")
    fun getPrivateContent() : Observable<PrivatecontentBean>

    //最新音乐
    @GET("/personalized/newsong")
    fun getPersonalizedNewsong() : Observable<PrivatecontentBean>
    //推荐mv
    @GET("/personalized/mv")
    fun getPersonalizedMv() : Observable<PersonalizedMvBean>
    //精选专栏
    //主播电台
}