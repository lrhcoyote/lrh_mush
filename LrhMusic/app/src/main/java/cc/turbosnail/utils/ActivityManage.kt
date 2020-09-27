package cc.turbosnail.utils

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * Activity栈管理
 *
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date  2020/9/2 15:41
 */
class ActivityManage private constructor(){
    private val activityStack : Stack<Activity> = Stack()

    companion object{
        val instance : ActivityManage by lazy{ActivityManage()}
    }

    /**
     * 入栈操作
     */
    fun addActivity(activity: Activity){
        activityStack.add(activity)
    }

    /**
     * 出栈操作
     */
    fun popActivity(activity: Activity){
        activity.finish()
        activityStack.remove(activity)
    }

    /**
     * 返回栈顶的Activity
     */
    fun currentActivity(): Activity {
        return activityStack.lastElement()
    }

    /**
     * 清栈
     */
    fun clearActivity(){
        for (activity in activityStack){
            activity.finish()
        }
        activityStack.clear()
    }

    /**
     * 退出应用程序
     */
    fun exitApp(context: Context){
        clearActivity()
        val activityManage = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManage.killBackgroundProcesses(context.packageName)
        System.exit(0)  //程序退出
    }
}