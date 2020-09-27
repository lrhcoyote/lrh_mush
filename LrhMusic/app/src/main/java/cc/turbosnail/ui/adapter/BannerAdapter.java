package cc.turbosnail.ui.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.util.List;

/**
 * 轮播适配器
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/9 2:28
 */
public class BannerAdapter extends com.youth.banner.adapter.BannerAdapter<String,BannerAdapter.ViewHolder> {

    public BannerAdapter(List<String> datas) {
        super(datas);
    }

    @Override
    public ViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new ViewHolder(imageView);
    }

    @Override
    public void onBindView(ViewHolder holder, String data, int position, int size) {
        //加载图片
        Glide.with(holder.ivBanner)
                .load(getData(position))
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)   //开启磁盘缓存
                .into(holder.ivBanner);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivBanner;
        public ViewHolder(@NonNull ImageView itemView) {
            super(itemView);
            this.ivBanner = itemView;
        }
    }
}
