package cc.turbosnail.ui.activity

import android.view.Gravity
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import cc.turbosnail.R
import cc.turbosnail.livedata.bus.LiveDataBus
import cc.turbosnail.ui.BaseActivity
import cc.turbosnail.ui.adapter.CustomViewViewPageAdapter
import cc.turbosnail.ui.fragment.FriendsFragment
import cc.turbosnail.ui.fragment.MainMusicFragment
import cc.turbosnail.ui.fragment.MyMusicFragment
import cc.turbosnail.utils.ActivityManage
import cc.turbosnail.utils.FragmentManage
import cc.turbosnail.utils.WhenSelectedUtil
import cc.turbosnail.utils.i
import kotlinx.android.synthetic.main.activity.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.toast

class MainActivity(override val layoutId: Int = R.layout.activity_main) : BaseActivity() {

    private var preessTime: Long = 0
    private lateinit var tabs: ArrayList<ImageView>
    override fun initData() {
        window.setBackgroundDrawableResource(R.color.background_material_light_1)
        tabs = ArrayList(listOf(ivActionbarMusic, ivActionbarDisco, ivActionbarFriends))
        setToolBar()
        /**
         * 设置ViewPage适配器
         */
        mCustomViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                WhenSelectedUtil.whenSelect(tabs, position)
            }
        })
        val adapter = CustomViewViewPageAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        //添加需要展示的Fragment
        adapter.addFragment(MyMusicFragment())
        adapter.addFragment(MainMusicFragment())
        adapter.addFragment(FriendsFragment())
        mCustomViewPager.adapter = adapter
        mCustomViewPager.currentItem = 1
        /**
         * 设置Toolbar监听
         */
        ivActionbarMusic.setOnClickListener { mCustomViewPager.currentItem = 0 }
        ivActionbarDisco.setOnClickListener { mCustomViewPager.currentItem = 1 }
        ivActionbarFriends.setOnClickListener { mCustomViewPager.currentItem = 2 }
        //搜索监听
        ivActionSearch.setOnClickListener {}
//        /**
//         * 退栈管理
//         */
       val ft = supportFragmentManager.beginTransaction();
        ft.add(R.id.mDrawerLayout,MainMusicFragment())
        ft.addToBackStack(null)
        ft.commit()
        i("${supportFragmentManager.backStackEntryCount}")
        supportFragmentManager.popBackStack()
//
    }

    /**
     * 打开侧滑菜单
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> return openLeftDrawer()
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun openLeftDrawer(): Boolean {
        mDrawerLayout.openDrawer(Gravity.LEFT)
        return true
    }

    /**
     * 设置actionbar
     */
    private fun setToolBar() {
        //设置menu图标
        setSupportActionBar(toolbar as Toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)   //使左上角图标显示
        supportActionBar?.setHomeAsUpIndicator(R.mipmap.ic_menu)

    }

    /**
     * 返回按钮处理
     */
    override fun onBackPressed() {
        val nowTime = System.currentTimeMillis()
        if (nowTime - preessTime > 2000) {
            toast("在按一次退出应用程序")
            preessTime = nowTime
        } else {
            ActivityManage.instance.exitApp(this)
        }
    }
}
