package com.baidu.activitylifecycle;

import com.baidu.activitylifecycle.model.ActivityLifecycle;

import java.lang.reflect.Method;

/**
 * BindLifecycleUtil
 *
 * @author linjunwu
 * @since 2016/5/12
 */
public class BindLifecycleUtil {

    public static IActivityLifecycle bind(BaseActivity baseActivity){
        if (baseActivity == null) {
            throw new NullPointerException("baseActivity must not be null.");
        }
        Class<?> activityClass = baseActivity.getClass();
        ActivityLifecycle activityLifecycle = new ActivityLifecycle();
        activityLifecycle.setTarget(baseActivity);
        for (Method method : activityClass.getDeclaredMethods()) {

            if (method.isAnnotationPresent(OnCreate.class)){
                activityLifecycle.setOnCreate(method);
            }
        }

        return activityLifecycle;
    }
}
