package cc.turbosnail.ui.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import cc.turbosnail.bean.MyMusicBean
import cc.turbosnail.ui.adapter.diffutil.MyMusicItemCallback
import cc.turbosnail.utils.d
import cc.turbosnail.utils.i
import kotlinx.android.synthetic.main.item_fragment_my_music.view.*
import org.jetbrains.anko.backgroundResource

/**
 * 适配器实现控件级别精准刷新
 * 遇到问题 Kotlin不是想Activity那样使用 kotlinx.android.synthetic.main
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/4 23:01
 */
class MyMusicAdapter(private val context: Context?, @LayoutRes private val layoutId: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TAG = "MainMusicAdapter"
    private val beanAsyncListDiffer: AsyncListDiffer<MyMusicBean> =
        AsyncListDiffer(this, MyMusicItemCallback())
    fun setData(myMusicBeans: List<MyMusicBean>){
        d(TAG,"${myMusicBeans.size}")
        beanAsyncListDiffer.submitList(myMusicBeans)
    }

    private fun getItem(position: Int): MyMusicBean {
        return beanAsyncListDiffer.currentList.get(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: List<Any>
    ) {
        /**
         * 实现控件级别精准刷新
         */
        if (!payloads.isEmpty()) {
            val bundle = payloads.get(0) as Bundle
            if (bundle.containsKey("title")) {
                holder.itemView.tvTitle.text = bundle.getString("title")
                i(TAG,"title$position")
            }
            if (bundle.containsKey("avatar")) {
                holder.itemView.tvTitle.text = bundle.getString("avatar")
                i(TAG,"avatar$position")
            }
            if (bundle.containsKey("musicCount")) {
                holder.itemView.tvTitle.text = bundle.getString("musicCount")
                i(TAG,"musicCount$position")
            }
        }else{
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = this.getItem(position)
        holder.itemView.tvTitle.text = model.title
        holder.itemView.ivMainNMusic.backgroundResource = model.avatar
        holder.itemView.tvMusicCount.text = "(${model.musicCount})"
    }

    override fun getItemCount(): Int {
        return beanAsyncListDiffer.currentList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}