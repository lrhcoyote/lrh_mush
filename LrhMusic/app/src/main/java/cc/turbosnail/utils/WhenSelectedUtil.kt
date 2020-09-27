package cc.turbosnail.utils

import android.widget.ImageView

/**
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/11 3:07
 */
object WhenSelectedUtil {
    fun whenSelect(datas: List<ImageView>?, position: Int) {
        if (datas == null || datas.size <= 0) {
            return
        }
        datas.forEachIndexed { index, imageView ->
            if (index == position) {
                datas[index].setSelected(true)
            } else {
                datas[index].setSelected(false)
            }
        }
    }
}