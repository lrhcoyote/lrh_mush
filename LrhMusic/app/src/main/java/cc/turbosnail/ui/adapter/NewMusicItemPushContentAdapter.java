package cc.turbosnail.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import cc.turbosnail.R;
import cc.turbosnail.bean.PersonalizedBean;

/**
 * 音乐主体推送内容适配器
 *
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/18 10:39
 */
public class NewMusicItemPushContentAdapter extends BaseQuickAdapter<PersonalizedBean.ResultBean, BaseViewHolder> {
    public NewMusicItemPushContentAdapter(int layoutResId, @Nullable List<PersonalizedBean.ResultBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, PersonalizedBean.ResultBean result) {
        ImageView view = holder.getView(R.id.ivPicUrl);
        Glide.with(view)
                .load(result.getPicUrl())
                .into(view);
        holder.setText(R.id.tvName,result.getName());
        holder.setText(R.id.tvPlayCount,result.getPlayCount()+"");
    }
}
