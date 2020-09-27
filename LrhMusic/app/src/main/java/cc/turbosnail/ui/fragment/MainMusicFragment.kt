package cc.turbosnail.ui.fragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import cc.turbosnail.R
import cc.turbosnail.ui.BaseFragment
import cc.turbosnail.ui.adapter.MainMusicAdapter
import cc.turbosnail.ui.fragment.mainfragments.LeaderboardFragment
import cc.turbosnail.ui.fragment.mainfragments.NewMusicFragment
import cc.turbosnail.ui.fragment.mainfragments.SongListFragment
import kotlinx.android.synthetic.main.fragment_main_music.*

/**
 * 发现音乐Fragment
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/7 17:17
 */
class MainMusicFragment(override val layoutId: Int = R.layout.fragment_main_music) :
    BaseFragment() {
    private val titles = arrayOf("音乐", "视频", "电台")
    private val fragments =
        listOf<Fragment>(NewMusicFragment(), SongListFragment(), LeaderboardFragment())
    private val TAG = "MainMusicFragment"
    override fun initData() {
        //设置ViewPage适配器
        cvpMainMusic.adapter = MainMusicAdapter(
            childFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
            titles,
            fragments
        )
        //设置tablayout样式  不能直接使用R.color.text_color
        tblMainTabs.setTabTextColors(resources.getColor(R.color.text_color), resources.getColor(R.color.theme_color_Primary))
        tblMainTabs.setSelectedTabIndicatorColor(resources.getColor(R.color.theme_color_Primary))
        tblMainTabs.setupWithViewPager(cvpMainMusic)
    }
}