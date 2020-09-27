package cc.turbosnail.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import cc.turbosnail.ui.BaseFragment

/**
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/7 17:39
 */
class MainMusicAdapter(fm: FragmentManager, behavior: Int, private val titles: Array<String>, private val fragments: List<Fragment>) :
    FragmentPagerAdapter(fm, behavior) {

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}