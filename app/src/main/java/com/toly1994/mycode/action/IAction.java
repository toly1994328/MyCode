package com.toly1994.mycode.action;

import java.util.Map;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/15 0015:9:17<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：
 */
public interface IAction {

    void doSearch(String text);

    void doAdd(Map<String, String> params);


}
