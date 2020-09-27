package cc.turbosnail.bean;

import android.annotation.SuppressLint;

import org.jetbrains.annotations.NotNull;

import cc.turbosnail.api.NewMusicPushContentApi;
import cc.turbosnail.livedata.bus.LiveDataBus;
import cc.turbosnail.network.BaseObserver;
import cc.turbosnail.network.DefaultNetWork;
import kotlinx.coroutines.Deferred;

/**
 * 整合音乐界面的所有数据
 *
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/27 10:30
 */
public class NewPushContentBean {
    private static NewPushContentBean mInstance;
    private PersonalizedBean mPersonalizedBean;  //推荐歌单
    private PersonalizedMvBean mPersonalizedMvBean; //推荐 mv
    private PrivatecontentBean mPrivatecontentBean; //独家放送

    public PersonalizedBean getmPersonalizedBean() {
        return mPersonalizedBean;
    }

    public void setmPersonalizedBean(PersonalizedBean mPersonalizedBean) {
        this.mPersonalizedBean = mPersonalizedBean;
    }

    public PersonalizedMvBean getmPersonalizedMvBean() {
        return mPersonalizedMvBean;
    }

    public void setmPersonalizedMvBean(PersonalizedMvBean mPersonalizedMvBean) {
        this.mPersonalizedMvBean = mPersonalizedMvBean;
    }

    public PrivatecontentBean getmPrivatecontentBean() {
        return mPrivatecontentBean;
    }

    public void setmPrivatecontentBean(PrivatecontentBean mPrivatecontentBean) {
        this.mPrivatecontentBean = mPrivatecontentBean;
    }

    private NewPushContentBean() {
    }

    //单例模式
    public static NewPushContentBean getInstance() {
        if (mInstance == null) {
            synchronized (NewPushContentBean.class) {
                mInstance = new NewPushContentBean();
            }
        }
        return mInstance;
    }

    /**
     * 获取音乐内容
     */
    @SuppressLint("CheckResult")
    public void getNewPushContentData() {
        //推荐歌单
        getService()
                .getPersonalized(6)
                .compose(DefaultNetWork.getInstance().applySchedulers(new BaseObserver<PersonalizedBean>() {
                    @Override
                    public void onSuccess(PersonalizedBean personalizedBean) {
                        mInstance.mPersonalizedBean = personalizedBean;
                        notifyView();
                    }

                    @Override
                    public void onFailure(@NotNull Throwable e) {

                    }
                }));
        getService()
                .getPrivateContent()
                .compose(DefaultNetWork.getInstance().applySchedulers(new BaseObserver<PrivatecontentBean>() {
                    @Override
                    public void onSuccess(PrivatecontentBean privatecontentBean) {
                        mInstance.mPrivatecontentBean = privatecontentBean;
                        notifyView();
                    }

                    @Override
                    public void onFailure(@NotNull Throwable e) {

                    }
                }));
        getService()
                .getPersonalizedMv()
                .compose(DefaultNetWork.getInstance().applySchedulers(new BaseObserver<PersonalizedMvBean>() {
                    @Override
                    public void onSuccess(PersonalizedMvBean personalizedMvBean) {
                        mInstance.mPersonalizedMvBean = personalizedMvBean;
                        notifyView();
                    }

                    @Override
                    public void onFailure(@NotNull Throwable e) {

                    }
                }));
    }

    private NewMusicPushContentApi getService() {
        return DefaultNetWork.getInstance()
                .getService(NewMusicPushContentApi.class);
    }

    /**
     * 通知View层刷新数据
     */
    private synchronized void notifyView() {
        if (mInstance.mPersonalizedBean != null
                && mInstance.mPersonalizedMvBean != null
                && mInstance.mPrivatecontentBean != null) {
            //所有的数据都请求完成才发送一个消息
            LiveDataBus.get()
                    .with("pushContent")
                    .postValue(mInstance);
        }
    }
}
