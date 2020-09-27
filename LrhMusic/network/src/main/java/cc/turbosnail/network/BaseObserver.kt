package cc.turbosnail.network

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * 封装ObServer
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/2 21:55
 */
abstract class BaseObserver<T> : Observer<T> {
    override fun onSubscribe(d: Disposable) {}
    override fun onNext(t: T) {
        onSuccess(t)
    }
    override fun onError(e: Throwable) {
        onFailure(e)
    }
    override fun onComplete() {}
    abstract fun onSuccess(t:T) //成功
    abstract fun onFailure(e: Throwable) //失败
}