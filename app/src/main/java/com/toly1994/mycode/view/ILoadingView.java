package com.toly1994.mycode.view;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/14 0014:7:49<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：加载和加载完毕的视图
 */
public interface ILoadingView {
    /**
     * 正在加载
     */
    void loading();

    /**
     * 加载完毕
     */
    void loaded();
}
