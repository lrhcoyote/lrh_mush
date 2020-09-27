package cc.turbosnail.bean

/**
 * 音乐导航资源
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/9 3:52
 */
class NewMusicItemNavigationBean {
    var title: String = ""
    var avatar = 0

    constructor(title: String, avatar: Int) {
        this.title = title
        this.avatar = avatar
    }

    constructor() {}
}