package cc.turbosnail.utils;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * 切换颜色的ImageView
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/9 3:27
 */
public class PeelingImageView extends AppCompatImageView {
    public PeelingImageView(Context context) {
        super(context);
    }

    public PeelingImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PeelingImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
