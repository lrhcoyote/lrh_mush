package cc.turbosnail.ui

import android.app.ActionBar
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import cc.turbosnail.R
import cc.turbosnail.utils.ActivityManage

/**
 * 父类Activity
 *
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date  2020/9/2 15:51
 */
abstract class BaseActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initData()
        ActivityManage.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityManage.instance.popActivity(this)
    }

    @get:LayoutRes
    protected abstract val layoutId: Int
    open protected fun initData() {}
}