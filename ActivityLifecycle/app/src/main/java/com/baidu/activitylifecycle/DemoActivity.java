package com.baidu.activitylifecycle;

import android.util.Log;

public class DemoActivity extends BaseActivity {

    private static final String TAG = "DemoActivity";


    @OnCreate
    private void init(){
        setContentView(R.layout.activity_demo);
        Log.i(TAG, "onCreate");
    }

    @Override
    protected IActivityLifecycle bindActivityLifecycle() {
        // 可以自定义ActivityLifecycle对象的生成。
        return BindLifecycleUtil.bind(this);
    }
}
