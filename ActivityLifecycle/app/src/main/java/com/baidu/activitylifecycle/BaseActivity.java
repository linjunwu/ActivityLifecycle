package com.baidu.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;

/**
 * BaseActivity
 *
 * @author linjunwu
 * @since 2016/5/12
 */
public abstract class BaseActivity extends Activity{

    private static final String TAG = "BaseActivity";

    private IActivityLifecycle mActivityLifecycle;

    protected abstract IActivityLifecycle bindActivityLifecycle();

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLifecycle = bindActivityLifecycle();
        if (mActivityLifecycle != null) {
            mActivityLifecycle.onCreate();
        }
    }

}
