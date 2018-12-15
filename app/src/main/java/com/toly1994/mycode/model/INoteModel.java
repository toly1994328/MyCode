package com.toly1994.mycode.model;

import java.util.Map;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/14 0014:13:43<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：数据模型层
 */
public interface INoteModel<T> {
    /**
     * 查询所有
     * @param callback 回调
     * @param offset 查询偏移值
     * @param page 查询条数
     */
    void getData(Callback<T> callback, int offset, int page);

    /**
     * 根据所属区域查询数据
     * @param callback 回调
     * @param area 范围
     * @param offset 查询偏移值
     * @param page 查询条数
     */
    void getDataByArea(Callback<T> callback, String area, int offset, int page);

    /**
     * 根据名称查询数据(搜索)
     * @param callback 回调
     * @param name 范围
     * @param offset 查询偏移值
     * @param page 查询条数
     */
    void getDataByName(Callback<T> callback, String name, int offset, int page);

    /**
     * 插入模型
     * @param params
     */
    void insertModel(Map<String, String> params);
}
