package com.baidu.activitylifecycle.model;

import com.baidu.activitylifecycle.IActivityLifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ActivityLifecycle
 *
 * @author linjunwu
 * @since 2016/5/12
 */
public class ActivityLifecycle implements IActivityLifecycle{
    private Object mTarget;
    private Method mOnCreate;

    public void setOnCreate(Method onCreate) {
        this.mOnCreate = onCreate;
    }

    public void setTarget(Object target) {
        this.mTarget = target;
    }

    @Override
    public void onCreate(){

        if (mTarget != null && mOnCreate !=null ){
            mOnCreate.setAccessible(true);
            try {
                mOnCreate.invoke(mTarget);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }



}
