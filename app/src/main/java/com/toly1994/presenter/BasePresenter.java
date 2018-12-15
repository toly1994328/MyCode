package com.toly1994.presenter;

import android.content.Context;

/**
 * 作者：张风捷特烈
 * 时间：2018/4/25:9:40
 * 邮箱：1981462002@qq.com
 * 说明：Presenter基类--为了方便让控制层和Activity生命周期同步
 */
public class BasePresenter {
    private Context mCtx;

    public void attach(Context ctx) {
        mCtx = ctx;

    }

    public void onPause() {

    }

    public void onResume() {

    }

    public void onDestroy() {
        mCtx = null;
    }

    public Context getCtx() {
        return mCtx;
    }
}
