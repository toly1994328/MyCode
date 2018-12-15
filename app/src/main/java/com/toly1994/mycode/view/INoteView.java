package com.toly1994.mycode.view;

import com.toly1994.mycode.bean.ErrorEnum;

import java.util.List;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/14 0014:7:48<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：视图层核心
 */
public interface INoteView<T> extends ILoadingView {

    /**
     * 页面渲染数据
     * @param dataList
     */
    void reader(List<T> dataList);

    /**
     * 页面处理错误
     * @param e
     */
    void error(ErrorEnum e);
}
