package com.toly1994.mycode.bean;

/**
 * 作者：张风捷特烈<br/>
 * 时间：2018/12/14 0014:7:58<br/>
 * 邮箱：1981462002@qq.com<br/>
 * 说明：错误类型
 */
public enum ErrorEnum {
    EXCEPTION(500, "服务器"),
    NOT_FOUND(102, "未知id"),
    IO(1, "IO异常"),
    NO_NET(2, "无网络"),
    NET_LINK(3, "网络连接异常");

    private int code;
    private String msg;

    ErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
