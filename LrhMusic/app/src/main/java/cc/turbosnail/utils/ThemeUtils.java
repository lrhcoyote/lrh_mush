package cc.turbosnail.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;

/**
 * 主题工具类
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/7 20:04
 */
public class ThemeUtils {

    public static ColorStateList getThemeColorStateList(Context context, @ColorRes int colorId) {
        return ColorStateListUtils.createColorStateList(context, colorId);
    }
    public static switchColor mSwitchColor;
    public static void setSwitchColor(switchColor switchColor) {
        mSwitchColor = switchColor;
    }
    static
    @ColorInt
    int replaceColorById(Context context, @ColorRes int colorId) {
        return mSwitchColor == null ? Color.TRANSPARENT : mSwitchColor.replaceColorById(context, colorId);
    }
    static
    @ColorInt
    int replaceColor(Context context, @ColorInt int color) {
        return mSwitchColor == null ? Color.TRANSPARENT : mSwitchColor.replaceColor(context, color);
    }
    public interface switchColor {
        @ColorInt
        int replaceColorById(Context context, @ColorRes int colorId);

        @ColorInt
        int replaceColor(Context context, @ColorInt int color);
    }
}
