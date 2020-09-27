package cc.turbosnail.utils
import androidx.fragment.app.Fragment
import java.util.*

/**
 * Fragment栈管理待修改
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date  2020/9/2 15:26
 */
class FragmentManage {
    private val fragmentStack : Stack<Fragment> = Stack()
    companion object{
        val instance : FragmentManage by lazy{FragmentManage()}
    }

    /**
     * 入栈操作
     */
    fun addFragment(fragment:Fragment){
        fragmentStack.add(fragment)
    }

    /**
     * 出栈操作
     */
    fun popFragment(fragment:Fragment){
//        fragment.onDestroy()

        fragmentStack.remove(fragment)
    }

    /**
     * 返回栈顶的Fragment
     */
    fun currentFragment():Fragment{
        return fragmentStack.lastElement()
    }

    /**
     * 清栈
     */
    fun clear(){
        for (fragment in fragmentStack){
            fragment.onDestroy()
        }
        fragmentStack.clear()
    }
}