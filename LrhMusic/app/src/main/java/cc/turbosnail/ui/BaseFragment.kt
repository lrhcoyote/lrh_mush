package cc.turbosnail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/4 17:43
 */
abstract class BaseFragment : Fragment() {
    protected var mView: View? = null
    private var isFirst = false   //标记是否已经加载过了
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(layoutId, container, false)
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()   //必须在View创建完成调用在onCreateView调用空指针异常
    }
    @get:LayoutRes
    protected abstract val layoutId: Int
    open protected fun initData() {}
    open protected fun load(){}  //加载数据
    override fun onResume() {
        super.onResume()
        if(!isFirst){
            load()
            isFirst = true
        }
    }
}