package cc.turbosnail.bean

import android.icu.text.CaseMap

/**
 * 本地音乐和最近播放列表Item
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/4 20:27
 */
class MyMusicBean(
    var title //标题
    : String = "", var musicCount: Int//有多少条音乐
    ,var avatar: Int //图片资源
)