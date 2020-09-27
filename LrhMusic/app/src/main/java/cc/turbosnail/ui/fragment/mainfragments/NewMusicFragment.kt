package cc.turbosnail.ui.fragment.mainfragments

import android.graphics.Color
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import cc.turbosnail.R
import cc.turbosnail.api.BannerApi
import cc.turbosnail.bean.*
import cc.turbosnail.livedata.bus.LiveDataBus
import cc.turbosnail.model.NewMusicFragmentData
import cc.turbosnail.ui.BaseFragment
import cc.turbosnail.ui.adapter.BannerAdapter
import cc.turbosnail.ui.adapter.NewMusicItemNavigationAdapter
import cc.turbosnail.ui.adapter.NewMusicItemPushContentAdapter
import cc.turbosnail.ui.adapter.PersonalizedMvAdapter
import cc.turbosnail.utils.SpacesItemDecoration
import cc.turbosnail.utils.i
import com.bumptech.glide.Glide
import com.youth.banner.Banner
import com.youth.banner.config.BannerConfig.INDICATOR_NORMAL_WIDTH
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.listener.OnBannerListener
import kotlinx.android.synthetic.main.fragment_new_music.*
import kotlinx.android.synthetic.main.item_new_music_banner.*
import kotlinx.android.synthetic.main.item_new_music_title.view.*
import kotlinx.android.synthetic.main.item_personalized.view.*
import kotlinx.android.synthetic.main.ly_push_music.*

/**
 * 新曲
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/7 17:17
 */
class NewMusicFragment(override val layoutId: Int = R.layout.fragment_new_music) : BaseFragment() {
    private val musicFragmentData = NewMusicFragmentData()

    /**
     * 初始化数据
     */
    override fun initData() {
        initBanner()
        initNavigation()
        initContent()
    }

    /**
     * 添加歌单列表
     */
    private fun initContent() {
        pushMusic.tvItemTitle.text = "推荐歌单"
        exclusivePushMusic.tvItemTitle.text = "独家放送"
        pushPersonalizedMv.tvItemTitle.text="推荐MV"
//        newPushMusic.tvItemTitle.text = "最新音乐"
        getPushContentModel()
    }

    /**
     * 获取数据
     */
    private fun getPushContentModel() {
        musicFragmentData.getPushContentModel()
        LiveDataBus.get()
            .with("pushContent")
            .observe(this, Observer {
                //刷新列表内容
                mLoidView.visibility = View.INVISIBLE
                lyPushMusic.visibility = View.VISIBLE
                addPushContent(it as NewPushContentBean)
            })
    }

    /**
     * 刷洗界面
     */
    private fun addPushContent(data: NewPushContentBean) {
        initPersonalizedBean(data.getmPersonalizedBean())
        initExclusivePush(data.getmPrivatecontentBean())
        initPersonalizedMvBean(data.getmPersonalizedMvBean())
    }

    /**
     * 推荐Mv
     * @param data 数据源
     */
    private fun initPersonalizedMvBean(data: PersonalizedMvBean){
        rlsPushPersonalizedMv.layoutManager = GridLayoutManager(context, 2)
        rlsPushPersonalizedMv.adapter = PersonalizedMvAdapter(
            R.layout.item_personalized,
            data.result
        )
    }
    /**
     * 推荐歌单
     * @param data 数据源
     */
    private fun initPersonalizedBean(data: PersonalizedBean) {
        rlsPushMusic.layoutManager = GridLayoutManager(context, 3)
        rlsPushMusic.adapter = NewMusicItemPushContentAdapter(
            R.layout.item_personalized,
            data.result
        )
    }

    /**
     * 独家放送
     * @param data 数据源
     */
    private fun initExclusivePush(data: PrivatecontentBean) {
        val view = arrayListOf<View>(exclusivePushItem1, exclusivePushItem2, exclusivePushItem3)
        data.result.forEachIndexed { index, item ->
            Glide.with(view[index].ivPicUrl)
                .load(item.getPicUrl())
                .into(view[index].ivPicUrl)
            view[index].tvName.text = item.name
        }
    }

    /**
     * 导航界面初始化
     */
    private fun initNavigation() {
        val newMusicItemNavigationModels = listOf<NewMusicItemNavigationBean>(
            NewMusicItemNavigationBean("私人FM", R.drawable.recommend_fm),
            NewMusicItemNavigationBean("每日推荐", R.drawable.recommend_fm),
            NewMusicItemNavigationBean("歌单", R.drawable.recommend_rank),
            NewMusicItemNavigationBean("排行榜", R.drawable.recommend_rank)
//            NewMusicItemNavigationModel("私人FM",R.drawable.recommend_rank)
        )
        rlvNavigation.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rlvNavigation.adapter = NewMusicItemNavigationAdapter(
            R.layout.item_new_music_navigation,
            newMusicItemNavigationModels
        )
        rlvNavigation.addItemDecoration(SpacesItemDecoration(newMusicItemNavigationModels.size))
    }

    /**
     * 初始化轮播
     */
    private fun initBanner() {
//        val bannerView = View.inflate(context, R.layout.item_new_music_banner, null) as Banner<*, *>
        val indicator = CircleIndicator(context)
        //设置指示器选中颜色  待修改以后使用当前主题颜色
        //resources.getColor(R.color.theme_color_Primary) 无效
        indicator.indicatorConfig.selectedColor = Color.parseColor("#ffce3d3e")
        indicator.indicatorConfig.radius = INDICATOR_NORMAL_WIDTH
        mBanner.addBannerLifecycleObserver(this)
            .setAdapter(BannerAdapter(BannerApi.bannersUrl))
            .setIndicator(indicator)
        bannerOnClickListener(mBanner)
    }

    /**
     * 轮播监听
     * 通过点击事件打开音乐播放界面
     * @param view banner
     */
    private fun bannerOnClickListener(view: Banner<*, *>) {
        //泛型无所谓
        view.setOnBannerListener(object : OnBannerListener<String> {
            override fun OnBannerClick(data: String, position: Int) {
            }
        })
    }
}
