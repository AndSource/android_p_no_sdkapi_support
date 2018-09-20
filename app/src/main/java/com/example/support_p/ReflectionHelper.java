package com.example.support_p;

import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionHelper {

    private static final String TAG = ReflectionHelper.class.getSimpleName();

    public static void testMethod() {
        try {
            Class clz = Class.forName("android.app.ActivityThread");
            Method method = clz.getDeclaredMethod("getIntentBeingBroadcast");
            method.setAccessible(true);
            method.invoke(null);

            Log.i("xxx", "ReflectionHelper.testMethod----success");
        } catch (Throwable e) {
            Log.e("xxx", "ReflectionHelper.testMethod----failed\n" + Log.getStackTraceString(e));
        }
    }

    public static void testField() {
        try {
            Class clz = Class.forName("android.app.ActivityThread");
            Field field = clz.getDeclaredField("TAG");
            field.setAccessible(true);
            field.get(null);
            Log.i("xxx", "ReflectionHelper.testField----success");
        } catch (Throwable e) {
            Log.e("xxx", "ReflectionHelper.testField----failed\n" + Log.getStackTraceString(e));
        }

    }
}
