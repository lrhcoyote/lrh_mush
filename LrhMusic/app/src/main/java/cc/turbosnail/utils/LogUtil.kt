@file:JvmName("LogUtil")
package cc.turbosnail.utils

import android.util.Log

/**
 *日志打印
 *
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date  2020/9/1 21:25
 */
//可以直接调用
val DEBUG = true;

fun i(tag: String, msg: String) {
    if (DEBUG) {
        Log.i(tag, msg);
    }
}
fun i(msg: String) {
    if (DEBUG) {
        Log.i("test", msg);
    }
}
fun v(tag: String, msg: String) {
    if (DEBUG) {
        Log.v(tag, msg);
    }
}

fun d(tag: String, msg: String) {
    if (DEBUG) {
        Log.d(tag, msg);
    }
}

fun e(tag: String, msg: String) {
    if (DEBUG) {
        Log.e(tag, msg);
    }
}