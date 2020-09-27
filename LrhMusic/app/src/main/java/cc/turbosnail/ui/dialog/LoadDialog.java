package cc.turbosnail.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import cc.turbosnail.R;

/**
 * 加载动画
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/3 16:35
 */
public class LoadDialog extends Dialog {

    public LoadDialog(@NonNull Context context) {
        super(context);
        Window window = getWindow();
        window.setGravity(Gravity.FILL_HORIZONTAL);
        window.setContentView(R.layout.loading_view);
    }
}
