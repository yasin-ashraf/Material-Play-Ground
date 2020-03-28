package com.yasin.materialplayground.viewUtils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.ScrollView;

/**
 * Created by im_yasinashraf started on 21/2/19.
 */
public class WindowInsetScrollView extends ScrollView {

    public WindowInsetScrollView(Context context) {
        super(context);
    }

    public WindowInsetScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WindowInsetScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public WindowInsetScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public WindowInsets onApplyWindowInsets(WindowInsets insets) {
        setPadding(insets.getSystemWindowInsetLeft(), 0, insets.getSystemWindowInsetRight(),
                insets.getSystemWindowInsetBottom());
        return insets.replaceSystemWindowInsets(0, insets.getSystemWindowInsetTop(), 0, 40); // 40 : random value
    }
}
