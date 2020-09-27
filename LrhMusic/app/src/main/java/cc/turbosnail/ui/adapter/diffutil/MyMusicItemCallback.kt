package cc.turbosnail.ui.adapter.diffutil

import android.os.Bundle
import android.text.TextUtils
import androidx.recyclerview.widget.DiffUtil
import cc.turbosnail.bean.MyMusicBean

/**
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/4 23:28
 */
class MyMusicItemCallback : DiffUtil.ItemCallback<MyMusicBean>() {
    /**
     * 判读Item是否相同
     *
     * @param oldItem
     * @param newItem
     * @return
     */
    override fun areItemsTheSame(oldItem: MyMusicBean, newItem: MyMusicBean): Boolean {
        return oldItem.avatar == newItem.avatar
    }

    /**
     * 判断内容是否相同
     *
     * @param oldItem
     * @param newItem
     * @return
     */
    override fun areContentsTheSame(oldItem: MyMusicBean, newItem: MyMusicBean): Boolean {
        return if (oldItem.avatar == newItem.avatar && oldItem.musicCount == newItem.musicCount &&
            TextUtils.equals(oldItem.title, newItem.title)
        ) {
            true
        } else false
    }

    /**
     * 实现控件级别刷新
     * @param oldItem
     * @param newItem
     * @return
     */
    override fun getChangePayload(oldItem: MyMusicBean, newItem: MyMusicBean): Any? {
        val bundle = Bundle()
        if (!TextUtils.equals(oldItem.title, newItem.title)) {
            bundle.putString("title", newItem.title)
        }
        if (oldItem.avatar != newItem.avatar) {
            bundle.putInt("avatar", newItem.avatar)
        }
        if (oldItem.musicCount != newItem.musicCount) {
            bundle.putInt("musicCount", newItem.musicCount)
        }
        return bundle
    }
}