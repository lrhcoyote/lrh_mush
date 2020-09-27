package cc.turbosnail.model

import android.annotation.SuppressLint
import cc.turbosnail.bean.NewPushContentBean

/**
 * 获取
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date  2020/9/11 14:34
 */
class NewMusicFragmentData {
    /**
     * 获取推荐歌单的数据
     */
    @SuppressLint("CheckResult")
    fun getPushContentModel() {
        //这样就没有使用到协程
        NewPushContentBean
            .getInstance()
            .getNewPushContentData()
    }

}

