package cc.turbosnail.network.base

import cc.turbosnail.network.BaseObserver
import cc.turbosnail.network.BaseUrl
import cc.turbosnail.network.TestUrl
import cc.turbosnail.network.error.HttpErrorHandler
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import io.reactivex.ObservableTransformer
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.*

/**
 * 网络请求封装
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/2 21:06
 */
open abstract class BaseNetWork {
    private var mOkHttpClient: OkHttpClient? = null
    private val retrofitHashMap = HashMap<String, Retrofit>()
    private var mBaseUrl: String? = null
    private val okHttpClient: OkHttpClient
        private get() {
            if (mOkHttpClient == null) {
                val okHttpClientBuilder = OkHttpClient.Builder()
//                    .addInterceptor(CommonHeaderIntercentor())
                if(interceptor != null){
                    okHttpClientBuilder.addInterceptor(interceptor!!)
                }
                mOkHttpClient = okHttpClientBuilder
                    .build()
            }
            return mOkHttpClient!!
        }

    /**
     * 创建Retrofit
     */
    protected fun getRetrofit(service: Class<*>): Retrofit {
        if (retrofitHashMap.containsKey(mBaseUrl + service.name)) {
            return retrofitHashMap[mBaseUrl + service.name]!!
        }
//        val moshi  = Moshi.Builder()
//            .add(KotlinJsonAdapterFactory())
//            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(mBaseUrl)
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())   //解析kotlin实体类 json数据
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        retrofitHashMap[mBaseUrl + service.name] = retrofit
        return retrofit
    }

    /**
     * 线程调度
     * @param observer
     * @param <T>
     * @return
    </T> */
     fun <T> applySchedulers(observer: BaseObserver<T>): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(HttpErrorHandler())  //异常处理
                .subscribe(observer)

            upstream
        }
    }

     fun <T> getBaseService(clazz: Class<T>): T {
//         clazz.javaClass.kotlin
         if(clazz.getAnnotation(BaseUrl::class.java)!=null){
             mBaseUrl = clazz.getAnnotation(BaseUrl::class.java)!!.value
         }else if(clazz.getAnnotation(TestUrl::class.java)!=null){
             mBaseUrl = clazz.getAnnotation(TestUrl::class.java)!!.value
         }else{
             throw RuntimeException("BaseUrl is null, the solution is to add @BaseUrl or @TestUrl to the class")
         }
//        if (clazz.isAnnotationPresent(BaseUrl::class.java) || clazz.isAnnotationPresent(TestUrl::class.java)) {
//            for (annotation in clazz.annotations) {
//                i("getBaseService",annotation.toString())
//                parseMothodAnnotation(annotation as Annotation) //解析注解
//            }
//        } else {
//            throw RuntimeException("BaseUrl is null, the solution is to add @BaseUrl or @TestUrl to the class")
//        }
        return getRetrofit(clazz)
            .create(clazz)
    }

//    private fun parseMothodAnnotation(annotation: Annotation) {
//            if(annotation is BaseUrl){
//                mBaseUrl = annotation.value
//            }else if(annotation is TestUrl){
//                mBaseUrl = annotation.value
//            }else{
//                throw RuntimeException()
//            }
//    }
    //模板方法设计模式
    protected abstract val interceptor: Interceptor?
//    protected abstract fun <T> getAppErrorHandler(): Function<T, T>?
}