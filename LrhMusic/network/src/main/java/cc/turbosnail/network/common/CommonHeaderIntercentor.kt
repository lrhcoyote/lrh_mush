package cc.turbosnail.network.common

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * 添加请求头
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date  2020/9/2 16:28
 */
class CommonHeaderIntercentor : Interceptor {

    @Suppress("UNREACHABLE_CODE")
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val requestBuilder = request.newBuilder()
        requestBuilder.addHeader("user-agent","Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:0.9.4)")
        request = requestBuilder.build()
        return chain.proceed(request)
    }
}