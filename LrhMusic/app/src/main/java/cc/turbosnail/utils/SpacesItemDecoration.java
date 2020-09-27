package cc.turbosnail.utils;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cc.turbosnail.MainApplication;

import static cc.turbosnail.utils.LogUtil.e;
import static cc.turbosnail.utils.LogUtil.i;
import static cc.turbosnail.utils.LogUtil.v;

/**
 * 根据列数平分屏幕
 *
 * @author 李儒浩
 * @version V0.1.0
 * @editor 修改人
 * @team TurboSnail
 * @date 2020/9/9 16:00
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = "SpacesItemDecoration";
    private int marginLeft = 10;
    private int marginRight = 10;
    private int maxChild = 0;   //最大5个控件
    private int parentWidth;  //屏幕宽度
    private int childCount;     //控件子个数
    private int childWidth = 0;
    private int spacing = 0;        //需要设置的左边距以及右间距

    public SpacesItemDecoration(int childCount) {
        //1、拿到屏幕宽度
        Context context = MainApplication.Companion.getInstance();
        DisplayMetrics mDisplayMetrics = context.getResources().getDisplayMetrics();
        parentWidth = mDisplayMetrics.widthPixels;
        this.maxChild = this.childCount = childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public void setChildWidth(int childWidth) {
        this.childWidth = childWidth;
    }

    public void setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
    }

    public void setMarginRight(int marginRight) {
        this.marginRight = marginRight;
    }

    //每一个Item都会调用一次
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        /**
         * 实现多控件平分屏幕
         * 最多5个
         */
        if (spacing == 0) {    //只需要计算一次
//            if (childWidth == 0) {
            childWidth = view.getLayoutParams().width;  //获取控件高度
//            }
            i(TAG, view.getLayoutParams().width + "");
            if (childCount <= 0 || maxChild <= 0 || parent.getChildCount() <= 0 || childWidth <= 0) {
                return;
            }
            //3、算出之间的关系
            if (childCount >= 5) {
                maxChild = 5;
            }
            int leftoverWidth = parentWidth - (childWidth * maxChild);  //除去控件宽度剩下的宽度
            if(marginLeft != 10 && marginRight != 10){
                spacing = leftoverWidth / ((maxChild - 1) * 2);
            }else {
                spacing = leftoverWidth / (maxChild * 2);
            }
            i(TAG, "\ngetChildAdapterPosition" + parent.getChildAdapterPosition(view) +
                    "\nparentWidth" + parentWidth +
                    "\nchildWidth" + childWidth +
                    "\nmaxChild:" + maxChild +
                    "\nspacing:" + spacing +
                    "\nleftoverWidth:" + leftoverWidth);
        }
        //4、设置间距
        if(parent.getChildAdapterPosition(view) == 0 && marginLeft != 10 && marginRight != 10){
            outRect.left = marginLeft;
            outRect.right = spacing;
        }if(parent.getChildAdapterPosition(view) == maxChild && marginLeft != 10 && marginRight != 10){
            outRect.left = spacing;
            outRect.right = marginRight;
        }else {
            outRect.left = spacing;
            outRect.right = spacing;
        }
    }

}
