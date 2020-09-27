package cc.turbosnail

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 全局Context
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date  2020/9/2 14:07
 */
class MainApplication : Application() {
    companion object {
//        private var application: MainApplication by NotNullSingleValueVar()
        private var application: MainApplication by Delegates.notNull()//Delegates委托属性单例化

//        @Synchronized
        fun getInstance() = application
    }

    override fun onCreate() {
        super.onCreate()
        application = this;
        //项目貌似有点大，已经超过65k个方法。一个dex已经装不下了，需要个多个dex，也就是multidex ，
        // 因为Android系统定义总方法数是一个short int，short int 最大值为65536。
        //参考连接 https://www.jianshu.com/p/320eb1ef3510
        MultiDex.install(this);
    }
//    //定义一个属性管理类，进行非空和重复赋值的判断
//    private class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?, T> {
//        private var value: T? = null
//        override fun getValue(thisRef: Any?, property: KProperty<*>): T {
//            return value ?: throw IllegalStateException("application not initialized")
//        }
//
//        override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
//            this.value = if (this.value == null) value
//            else throw IllegalStateException("application already initialized")
//        }
//    }

}