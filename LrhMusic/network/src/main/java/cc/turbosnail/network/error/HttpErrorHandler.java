package cc.turbosnail.network.error;


import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * 文件名/类名
 * HttpResponseFunc 处理以下两类错误：
 * 网络请求错误：404，500等
 * 应用数据错误抛RunTimeException 最后统一走到这个函数处理
 *
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 */
public class HttpErrorHandler<T> implements Function<Throwable, Observable<T>> {
    @Override
    public Observable<T> apply(Throwable throwable) throws Exception {
        return Observable.error(ExceptionHandle.handleException(throwable));
    }
}
