package cc.turbosnail.ui;

import android.os.Bundle;
import android.view.View;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Fragment 栈管理
 * 不管理MainActivity里面的Fragment
 *  先不处理
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/4 15:29
 */
public abstract class BaseManageFragment extends BaseFragment {

    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
