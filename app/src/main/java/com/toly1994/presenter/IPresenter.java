package com.toly1994.presenter;

import java.util.Map;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/14 0014:20:27<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：控制层
 */
public interface IPresenter<T> {
    /**
     * 根据所属区域更新视图
     *
     * @param area 范围
     * @param offset 查询偏移值
     * @param count 查询条数
     */
    void updateByArea(String area, int offset, int count);

    /**
     * 根据查询名称更新视图
     *
     * @param name 范围
     * @param offset 查询偏移值
     * @param count 查询条数
     */
    void updateByName(String name, int offset, int count);

    /**
     * 添加条目
     * @param params 参数
     */
    void addItem(Map<String, String> params);
}
