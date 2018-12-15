package com.toly1994.mycode.app;

import android.app.Application;
import android.content.Context;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/14 0014:17:04<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：
 */
public class MyApplication extends Application {

    public static Context appContext;
    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }

}
