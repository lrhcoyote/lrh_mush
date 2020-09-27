package cc.turbosnail.ui.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import cc.turbosnail.R
import cc.turbosnail.bean.MyMusicBean
import cc.turbosnail.ui.BaseFragment
import cc.turbosnail.ui.adapter.MyMusicAdapter
import kotlinx.android.synthetic.main.fragment_my_music.*

/**
 * 本地音乐，最近播放列表
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/4 15:23
 */
class MyMusicFragment(override val layoutId: Int = R.layout.fragment_my_music) : BaseFragment() {
    private val TAG = "MainMusicFragment"
    override fun initData() {
        val models = listOf(
            MyMusicBean("本地音乐", 0, R.drawable.music_icn_local),
            MyMusicBean("最近播放", 0, R.drawable.music_icn_recent),
            MyMusicBean("下载管理", 0, R.drawable.music_icn_dld),
            MyMusicBean("我的歌手", 0, R.drawable.music_icn_artist)
        )

        //加载Item数据
        rlsMainMusic.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = MyMusicAdapter(context, R.layout.item_fragment_my_music)
        adapter.setData(models)
        rlsMainMusic.adapter = adapter
    }
}