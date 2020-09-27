package cc.turbosnail.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import cc.turbosnail.R;
import cc.turbosnail.bean.NewMusicItemNavigationBean;

/**
 * 音乐界面导航适配器
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/9 3:49
 */
public class NewMusicItemNavigationAdapter extends BaseQuickAdapter<NewMusicItemNavigationBean, BaseViewHolder> {
    public NewMusicItemNavigationAdapter(int layoutResId, @Nullable List<NewMusicItemNavigationBean> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, NewMusicItemNavigationBean model) {
        baseViewHolder.setBackgroundResource(R.id.ivNewMusicNavigation,model.getAvatar());
        baseViewHolder.setText(R.id.tvNewMusicNavigationTitle,model.getTitle());
    }
}
