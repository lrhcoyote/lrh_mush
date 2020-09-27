package cc.turbosnail.network;

import org.jetbrains.annotations.Nullable;

import cc.turbosnail.network.base.BaseNetWork;
import okhttp3.Interceptor;

/**
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/2 21:24
 */
public class DefaultNetWork extends BaseNetWork {
    private static volatile DefaultNetWork defaultNetWork;
    private DefaultNetWork(){}
    public static DefaultNetWork getInstance(){
        if(defaultNetWork == null){
            synchronized (DefaultNetWork.class){
                if(defaultNetWork == null){
                    defaultNetWork = new DefaultNetWork();
                }
            }
        }
        return defaultNetWork;
    }

    public <T> T getService(Class<T> tClass){
        return getInstance().getBaseService(tClass);
    }

    @Nullable
    @Override
    protected Interceptor getInterceptor() {
        return null;
    }
}
